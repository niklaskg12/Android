package nl.pvanassen.highchart.api;


import nl.pvanassen.highchart.api.base.BaseObject;
import nl.pvanassen.highchart.api.utils.JsonArray;

public class ChartOptions extends BaseObject {

    private Chart chart;
    
    private JsonArray<String> colors;

    private Credits credits;

    private Labels labels;

    private Legend legend;

    private PlotOptions plotOptions;

    private JsonArray<Series> series;

    private Title title;

    private Title subtitle;

    private Tooltip tooltip;

    private JsonArray<Axis> xAxis;

    private JsonArray<Axis> yAxis;

    private DrillDown drilldown;

    public Chart getChart() {
        if (chart == null) {
            chart = new Chart();
        }
        return chart;
    }
    
    public JsonArray<String> getColors() {
        if(this.colors == null) {
            this.colors = new JsonArray<String>();
        }
        return this.colors;
    }

    public Credits getCredits() {
        if (credits == null) {
            credits = new Credits();
        }
        return credits;
    }

    public Labels getLabels() {
        if (labels == null) {
            labels = new Labels();
        }
        return labels;
    }

    public Legend getLegend() {
        if (legend == null) {
            legend = new Legend();
        }
        return legend;
    }

    public PlotOptions getPlotOptions() {
        if (plotOptions == null) {
            plotOptions = new PlotOptions();
        }
        return plotOptions;
    }

    public JsonArray<Series> getSeries() {
        if (series == null) {
            series = new JsonArray<Series>();
        }
        return series;
    }

    public Title getSubtitle() {
        if (subtitle == null) {
            subtitle = new Title();
        }
        return subtitle;
    }

    public Title getTitle() {
        if (title == null) {
            title = new Title();
        }
        return title;
    }

    public Tooltip getTooltip() {
        if (tooltip == null) {
            tooltip = new Tooltip();
        }
        return tooltip;
    }
    
    public Axis getXAxis(int index) {
        if(index < this.getXAxis().size()) {
            return this.getXAxis().get(index);
        } else {
            this.getXAxis().add(new Axis());
            return this.getXAxis(index);
        }
    }

    public JsonArray<Axis> getXAxis() {
        if (xAxis == null) {
            xAxis = new JsonArray<Axis>();
        }
        return xAxis;
    }
    
    public Axis getYAxis(int index) {
        if(index < this.getYAxis().size()) {
            return this.getYAxis().get(index);
        } else {
            this.getYAxis().add(new Axis());
            return this.getYAxis(index);
        }
    }

    public JsonArray<Axis> getYAxis() {
        if (yAxis == null) {
            yAxis = new JsonArray<Axis>();
        }
        return yAxis;
    }

    public DrillDown getDrilldown() {
        if (drilldown == null) {
            drilldown = new DrillDown();
        }
        return drilldown;
    }


}
