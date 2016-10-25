package nl.pvanassen.highchart.api.drilldown;

import nl.pvanassen.highchart.api.base.BaseObject;

public class DrillUpButton extends BaseObject {

    private String relativeTo;

    private Position position;

    /**
     * Returns the relativeTo option.
     *
     * @return the relativeTo
     */
    public String getRelativeTo() {
        return relativeTo;
    }

    /**
     * Sets the relative to option.
     *
     * @param relativeTo the relativeTo to set
     */
    public DrillUpButton setRelativeTo(String relativeTo) {
        this.relativeTo = relativeTo;
        return this;
    }

    /**
     * Returns the position.
     *
     * @return the position.
     */
    public Position getPosition() {
        if (position == null) {
            position = new Position();
        }
        return position;
    }

}