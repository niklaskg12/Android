package nl.pvanassen.highchart.api.plotoption;

import nl.pvanassen.highchart.api.base.BaseObject;
import nl.pvanassen.highchart.api.shared.Styleable;

public class PlotOptionsMarker 
    extends     BaseObject
    implements  Styleable<PlotOptionsMarker> {

    private Boolean enabled;
    
    private String  fillColor;
    
    private String lineColor;
    
    private Integer lineWidth;
    
    private Float radius;
    
    private PlotMarkerStates states;

    private String symbol;
    
    @Override
    public PlotOptionsMarker style(
            final PlotOptionsMarker src) {
        if(src == null) {
            return this;
        }
        this.enabled = src.enabled;
        this.fillColor = src.fillColor;
        this.lineColor = src.lineColor;
        this.lineWidth = src.lineWidth;
        this.radius = src.radius;
        this.symbol = src.symbol;
        return this;
    }

    public PlotMarkerStates getStates() {
        if (states == null) {
            states = new PlotMarkerStates();
        }
        return states;
    }

    /**
     * Enable or disable the point marker. Defaults to true.
     * @return the enabled
     */
    public Boolean getEnabled() {
        return enabled;
    }

    /**
     * Enable or disable the point marker. Defaults to true.
     * @param enabled the enabled to set
     * @return 
     */
    public PlotOptionsMarker setEnabled(Boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    /**
     * The fill color of the point marker. When null, the series' 
     * or point's color is used.
     * @return the fillColor
     */
    public String getFillColor() {
        return fillColor;
    }

    /**
     * The fill color of the point marker. When null, the series' 
     * or point's color is used.
     * @param fillColor the fillColor to set
     * @return 
     */
    public PlotOptionsMarker setFillColor(String fillColor) {
        this.fillColor = fillColor;
        return this;
    }

    /**
     * The color of the point marker's outline. When null, the series' 
     * or point's color is used. Defaults to #FFFFFF.
     * @return the lineColor
     */
    public String getLineColor() {
        return lineColor;
    }

    /**
     * The color of the point marker's outline. When null, the series' 
     * or point's color is used. Defaults to #FFFFFF.
     * @param lineColor the lineColor to set
     * @return 
     */
    public PlotOptionsMarker setLineColor(String lineColor) {
        this.lineColor = lineColor;
        return this;
    }

    /**
     * The width of the point marker's outline. Defaults to 0.
     * @return the lineWidth
     */
    public Integer getLineWidth() {
        return lineWidth;
    }

    /**
     * The width of the point marker's outline. Defaults to 0.
     * @param lineWidth the lineWidth to set
     * @return 
     */
    public PlotOptionsMarker setLineWidth(Integer lineWidth) {
        this.lineWidth = lineWidth;
        return this;
    }

    /**
     * The radius of the point marker. Defaults to 4.
     * @return the radius
     */
    public Float getRadius() {
        return radius;
    }

    /**
     * The radius of the point marker. Defaults to 4.
     * @param radius the radius to set
     * @return 
     */
    public PlotOptionsMarker setRadius(Float radius) {
        this.radius = radius;
        return this;
    }

    /**
     * A predefined shape or symbol for the marker. When null, the symbol is 
     * pulled from options.symbols. Other possible values are "circle", 
     * "square", "diamond", "triangle" and "triangle-down".Additionally, 
     * the URL to a graphic can be given on this form: "url(graphic.png)".
     * @return the symbol
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * A predefined shape or symbol for the marker. When null, the symbol is 
     * pulled from options.symbols. Other possible values are "circle", 
     * "square", "diamond", "triangle" and "triangle-down".Additionally, 
     * the URL to a graphic can be given on this form: "url(graphic.png)".
     * @param symbol the symbol to set
     * @return 
     */
    public PlotOptionsMarker setSymbol(String symbol) {
        this.symbol = symbol;
        return this;
    }
}