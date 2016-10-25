package nl.pvanassen.highchart.api;

import nl.pvanassen.highchart.api.base.BaseObject;
import nl.pvanassen.highchart.api.plotoption.PlotOptionsSeries;

public class PlotOptions extends BaseObject {

    private PlotOptionsSeries area;
    
    private PlotOptionsSeries arearange;

    private PlotOptionsSeries areaspline;
    
    private PlotOptionsSeries areasplinerange;
    
    private PlotOptionsSeries bar;
    
    private PlotOptionsSeries boxplot;
    
    private PlotOptionsSeries bubble;
    
    private PlotOptionsSeries column;
    
    private PlotOptionsSeries columnrange;
    
    private PlotOptionsSeries errorbar;
    
    private PlotOptionsSeries funnel;
    
    private PlotOptionsSeries gauge;
    
    private PlotOptionsSeries heatmap;

    private PlotOptionsSeries line;

    private PlotOptionsSeries pie;
    
    private PlotOptionsSeries pyramid;
    
    private PlotOptionsSeries scatter;

    private PlotOptionsSeries series;
    
    private PlotOptionsSeries solidgauge;

    private PlotOptionsSeries spline;

    private PlotOptionsSeries waterfall;

    public PlotOptions() {
        super();
    }

    public PlotOptionsSeries getArea() {
        if (area == null) {
            area = new PlotOptionsSeries();
        }
        return area;
    }

    public PlotOptionsSeries getAreaSpline() {
        if (areaspline == null) {
            areaspline = new PlotOptionsSeries();
        }
        return areaspline;
    }

    public PlotOptionsSeries getBar() {
        if (bar == null) {
            bar = new PlotOptionsSeries();
        }
        return bar;
    }

    public PlotOptionsSeries getColumn() {
        if (column == null) {
            column = new PlotOptionsSeries();
        }
        return column;
    }

    public PlotOptionsSeries getLine() {
        if (line == null) {
            line = new PlotOptionsSeries();
        }
        return line;
    }

    public PlotOptionsSeries getPie() {
        if (pie == null) {
            pie = new PlotOptionsSeries();
        }
        return pie;
    }

    public PlotOptionsSeries getSeries() {
        if (series == null) {
            series = new PlotOptionsSeries();
        }
        return series;
    }

    public PlotOptionsSeries getSpline() {
        if (spline == null) {
            spline = new PlotOptionsSeries();
        }
        return spline;
    }

    /**
     * @return the arearange
     */
    public PlotOptionsSeries getAreaRange() {
        if (arearange == null) {
            arearange = new PlotOptionsSeries();
        }
        return arearange;
    }

    /**
     * @return the areasplinerange
     */
    public PlotOptionsSeries getAreaSplineRange() {
        if (areasplinerange == null) {
            areasplinerange = new PlotOptionsSeries();
        }
        return areasplinerange;
    }

    /**
     * @return the boxplot
     */
    public PlotOptionsSeries getBoxPlot() {
        if (boxplot == null) {
            boxplot = new PlotOptionsSeries();
        }
        return boxplot;
    }

    /**
     * @return the bubble
     */
    public PlotOptionsSeries getBubble() {
        if (bubble == null) {
            bubble = new PlotOptionsSeries();
        }
        return bubble;
    }

    /**
     * @return the columnrange
     */
    public PlotOptionsSeries getColumnRange() {
        if (columnrange == null) {
            columnrange = new PlotOptionsSeries();
        }
        return columnrange;
    }

    /**
     * @return the errorbar
     */
    public PlotOptionsSeries getErrorBar() {
        if (errorbar == null) {
            errorbar = new PlotOptionsSeries();
        }
        return errorbar;
    }

    /**
     * @return the funnel
     */
    public PlotOptionsSeries getFunnel() {
        if (funnel == null) {
            funnel = new PlotOptionsSeries();
        }
        return funnel;
    }

    /**
     * @return the gauge
     */
    public PlotOptionsSeries getGauge() {
        if (gauge == null) {
            gauge = new PlotOptionsSeries();
        }
        return gauge;
    }

    /**
     * @return the heatmap
     */
    public PlotOptionsSeries getHeatmap() {
        if (heatmap == null) {
            heatmap = new PlotOptionsSeries();
        }
        return heatmap;
    }

    /**
     * @return the pyramid
     */
    public PlotOptionsSeries getPyramid() {
        if (pyramid == null) {
            pyramid = new PlotOptionsSeries();
        }
        return pyramid;
    }

    /**
     * @return the scatter
     */
    public PlotOptionsSeries getScatter() {
        if (scatter == null) {
            scatter = new PlotOptionsSeries();
        }
        return scatter;
    }

    /**
     * @return the solidgauge
     */
    public PlotOptionsSeries getSolidGauge() {
        if (solidgauge == null) {
            solidgauge = new PlotOptionsSeries();
        }
        return solidgauge;
    }

    /**
     * @return the waterfall
     */
    public PlotOptionsSeries getWaterfall() {
        if (waterfall == null) {
            waterfall = new PlotOptionsSeries();
        }
        return waterfall;
    }
}
