package HHS_PROJGR6.Entities;

import HHS_PROJGR6.Interfaces.IEntity;

import java.awt.*;
import java.util.ArrayList;

/*
* Room class
* Inherits from Entity
*/

public class EntityRoom extends Entity implements IEntity {


    private int classification;

    public EntityRoom(Color entityColor) {
        super(entityColor);

        this.classification = 0;
    }

    @Override
    public void drawEntity(Graphics g) {

        g.setColor(entityColor);
        switch (this.classification) {

        case 1:
            g.setColor(new Color(0, 191, 255));
            break;
        case 2:
            g.setColor(new Color(255, 255, 0));
            break;
        case 3:
            g.setColor(new Color(0, 129, 0));
            break;
        case 4:
            g.setColor(new Color(0, 255, 0));
            break;
            case 5:
                g.setColor(new Color(0, 64, 255));
                break;

        default:
           // g.setColor(new Color(255, 255, 255));
            break;
        }
        g.fillRect(x * 60, (y - (height - 1)) * 60, width * 60, height * 60);
        super.drawEntity(g);
    }

    // Action to execute when triggered
    public void Notify(ArrayList<IEntity> entities) {
        // Logic for Room entity.
        // Make sure to implement features by OOSE principles
    }

    public void setClassification(String classification) {
        this.classification = Integer.parseInt(classification.replaceAll("[^0-9]+", ""));
    }

    public boolean getClassification(int classification) {
        return this.classification == classification;
    }
}
