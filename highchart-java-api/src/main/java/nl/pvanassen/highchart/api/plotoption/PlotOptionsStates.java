package nl.pvanassen.highchart.api.plotoption;


import nl.pvanassen.highchart.api.base.BaseObject;

public class PlotOptionsStates extends BaseObject {

    private PlotStatesSelect select;
    
    private PlotStatesSelect hover;

    public PlotStatesSelect getSelect() {
        if (select == null) {
            select = new PlotStatesSelect();
        }
        return select;
    }
    
    public PlotStatesSelect getHover() {
        if (hover == null) {
            hover = new PlotStatesSelect();
        }
        return hover;
    }
}