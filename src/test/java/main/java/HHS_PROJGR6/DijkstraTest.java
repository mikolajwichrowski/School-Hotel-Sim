/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package HHS_PROJGR6;

import org.junit.Test;

import HHS_PROJGR6.Entities.Entity;
import HHS_PROJGR6.Factories.EntityFactory;
import HHS_PROJGR6.Interfaces.ISquare;
import HHS_PROJGR6.Utils.DijkstraAlgorithm;
import HHS_PROJGR6.Utils.Node;

import static org.junit.Assert.*;

import java.util.ArrayList;

public class DijkstraTest {
    @Test
    public void testGraph() {
        // Entites are nessecary for the graph
        ArrayList<Entity> entities = new ArrayList<>();

        // Entity that covers whole field
        Entity entity = (Entity) EntityFactory.createEntity("default", null);
        entity.setPosition(4, 1);
        entity.setDimensions(4, 4);
        entities.add(entity);

        // Generate graph
        ArrayList<Node> graph = DijkstraAlgorithm.getGraph(4, 4, entities);

        // check if size = 16
        assertEquals(graph.size(), 16);

        // Top left corner should have 2 neighbouring nodes
        assertEquals(graph.get(0).neighbours.size(), 2);

        // Middle nodes should have only neighbours left and right
        assertEquals(graph.get(3).neighbours.size(), 2);
        assertEquals(graph.get(4).neighbours.size(), 2);

        // Stair/Elevator nodes should have 3 possible routes from them (neighbours)
        assertEquals(graph.get(1).neighbours.size(), 3);
        assertEquals(graph.get(2).neighbours.size(), 3);
    }

    @Test
    public void testRouteUp() {
        // Entites are nessecary for the graph
        ArrayList<Entity> entities = new ArrayList<>();

        // Entity that covers whole field
        Entity entity = (Entity) EntityFactory.createEntity("default", null);
        entity.setPosition(4, 1);
        entity.setDimensions(4, 4);
        entities.add(entity);

        // Generate graph
        ArrayList<Node> graph = DijkstraAlgorithm.getGraph(4, 4, entities);

        // Left bottom corner
        Node from = DijkstraAlgorithm.createLocationNode(1, 4);

        // Right top
        Node to = DijkstraAlgorithm.createLocationNode(4, 1);

        // Generate path
        ArrayList<Node> path = DijkstraAlgorithm.findPath(from, to, graph);

        // Step one
        assertEquals((int) path.get(0).getX(), 1);
        assertEquals((int) path.get(0).getY(), 4);

        // Step two
        assertEquals((int) path.get(1).getX(), 2);
        assertEquals((int) path.get(1).getY(), 4);

        // Step three
        assertEquals((int) path.get(2).getX(), 3);
        assertEquals((int) path.get(2).getY(), 4);

        // Step three
        assertEquals((int) path.get(3).getX(), 4);
        assertEquals((int) path.get(3).getY(), 4);

        // Step five
        assertEquals((int) path.get(4).getX(), 4);
        assertEquals((int) path.get(4).getY(), 3);

        // Step five
        assertEquals((int) path.get(5).getX(), 4);
        assertEquals((int) path.get(5).getY(), 2);

        // Destination
        assertEquals((int) path.get(6).getX(), 4);
        assertEquals((int) path.get(6).getY(), 1);
    }

    @Test
    public void testRouteDown() {
        // Entites are nessecary for the graph
        ArrayList<Entity> entities = new ArrayList<>();

        // Entity that covers whole field
        Entity entity = (Entity) EntityFactory.createEntity("default", null);
        entity.setPosition(4, 1);
        entity.setDimensions(4, 4);
        entities.add(entity);

        // Generate graph
        ArrayList<Node> graph = DijkstraAlgorithm.getGraph(4, 4, entities);

        // Right top
        Node from = DijkstraAlgorithm.createLocationNode(4, 1);

        // Left bottom
        Node to = DijkstraAlgorithm.createLocationNode(1, 4);

        // Generate path
        ArrayList<Node> path = DijkstraAlgorithm.findPath(from, to, graph);

        // Step one
        assertEquals((int) path.get(0).getX(), 4);
        assertEquals((int) path.get(0).getY(), 1);

        // Step two
        assertEquals((int) path.get(1).getX(), 4);
        assertEquals((int) path.get(1).getY(), 2);

        // Step three
        assertEquals((int) path.get(2).getX(), 3);
        assertEquals((int) path.get(2).getY(), 2);

        // Step three
        assertEquals((int) path.get(3).getX(), 2);
        assertEquals((int) path.get(3).getY(), 2);

        // Step four
        assertEquals((int) path.get(4).getX(), 1);
        assertEquals((int) path.get(4).getY(), 2);

        // Step five
        assertEquals((int) path.get(5).getX(), 1);
        assertEquals((int) path.get(5).getY(), 3);

        // Destination
        assertEquals((int) path.get(6).getX(), 1);
        assertEquals((int) path.get(6).getY(), 4);
    }
}
