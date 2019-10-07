package HHS_PROJGR6.Entities;

import HHS_PROJGR6.Interfaces.IEntity;
import HHS_PROJGR6.Interfaces.IStressable;
import HHS_PROJGR6.Utils.Node;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static HHS_PROJGR6.Settings.getPixelResolution;

/*
* Guest class
* Inherits from Entity
*/

public class EntityGuest extends Entity implements IEntity, IStressable {
    /**
     * Guest number
     */
    private int guestId;

    /**
     * The preference for a room
     */
    private int preference;

    /**
     * Set of instructions the guest has to follow
     */
    private List<Node> instructions;

    // Constructor
    public EntityGuest(String entityImage) {
        super(entityImage);
        this.instructions = new ArrayList<Node>();
    }

    public void goToRestaurant() {
        // TODO: get path to restaurant
    }

    public void goToCinema() {
        // TODO: get path to cinema
    }

    public void goToFitness() {
        // TODO: get path to fittness
    }

    public void checkout() {
        this.guestId = 0;
        // TODO: get path to exit
    }

    public void panic() {
        // Gast sterft, verander image van gast naar dode gast? || Stop tekenen van
        // guest?
    }

    public void drawEntity(Graphics g) {
        super.drawEntity(g);
    }

    public int getPreference() {
        return preference;
    }

    public void setPreference(String preference) {
        this.preference = EntityGuest.parseInt(preference);
    }

    public void setID(String id) {
        this.guestId = EntityGuest.parseInt(id);
    }

    public Integer getID() {
        return this.guestId;
    }

    public boolean getActive() {
        return this.guestId != 0 && this.instructions.size() > 0;
    }

    public void setInstructions(List<Node> instructions) {
        this.instructions = instructions;
    }

    /**
     * 
     */
    public void frame() {
        // if has instructions do them
        if (instructions.size() > 0) {
            Node instruction = instructions.get(0);
            setPosition(instruction.getY(), instruction.getX());
            instructions.remove(0);
        }

        // TODO: if on room
        // make dirty

        // TODO: if no instructions and no movie playing
        // Go back to room
    }

    public static Integer parseInt(String someText) {
        return Integer.parseInt(someText.replaceAll("[^0-9]+", ""));
    }
}
