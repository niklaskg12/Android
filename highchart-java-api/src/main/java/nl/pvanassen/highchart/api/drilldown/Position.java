package nl.pvanassen.highchart.api.drilldown;

import nl.pvanassen.highchart.api.base.BaseObject;

public class Position extends BaseObject {

    private Integer x;

    private Integer y;

    /**
     * Returns the x position value.
     *
     * @return the x
     */
    public Integer getX() {
        return x;
    }

    /**
     * Sets the x position value.
     *
     * @param x the x to set
     */
    public Position setX(Integer x) {
        this.x = x;
        return this;
    }

    /**
     * Returns the y position value.
     *
     * @return the y
     */
    public Integer getY() {
        return y;
    }

    /**
     * Sets the y position value.
     *
     * @param y the y to set
     */
    public Position setY(Integer y) {
        this.y = y;
        return this;
    }
}