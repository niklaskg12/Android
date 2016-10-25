package nl.pvanassen.highchart.api.plotoption;

import nl.pvanassen.highchart.api.base.BaseObject;

public class PlotMarkerStates extends BaseObject {

    private final PlotMarkerSelect select;

    private final PlotMarkerHover hover;

    public PlotMarkerStates() {
        select = new PlotMarkerSelect();
        hover = new PlotMarkerHover();
    }

    public PlotMarkerHover getHover() {
        return hover;
    }

    public PlotMarkerSelect getSelect() {
        return select;
    }
}