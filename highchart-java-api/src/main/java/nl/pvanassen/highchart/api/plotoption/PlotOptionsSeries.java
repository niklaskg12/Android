package nl.pvanassen.highchart.api.plotoption;

import java.awt.Color;
import nl.pvanassen.highchart.api.base.BaseObject;
import nl.pvanassen.highchart.api.shared.DashStyleType;
import nl.pvanassen.highchart.api.shared.EnumString;
import nl.pvanassen.highchart.api.shared.HexColor;
import nl.pvanassen.highchart.api.shared.StackingType;
import nl.pvanassen.highchart.api.shared.Styleable;
import nl.pvanassen.highchart.api.utils.JsonArray;
import nl.pvanassen.highchart.api.utils.Utils;

public class PlotOptionsSeries 
    extends     BaseObject
    implements  Styleable<PlotOptionsSeries> {
    
    private Boolean allowPointSelect;
    
    private String animation;
    
    private String borderColor;
    
    private Integer borderRadius;
    
    private Integer borderWidth;
    
    private String color;
    
    private Boolean colorByPoint;
    
    private JsonArray<String> colors;
    
    private Boolean connectEnds;
    
    private Boolean connectNulls;
    
    private Integer cropThreshold;
    
    private String cursor;
    
    private String dashStyle;
    
    private PlotOptionsDataLabels dataLabels;
    
    private Integer depth;
    
    private String edgeColor;
    
    private Integer edgeWidth;
    
    private Boolean enableMouseTracking;
    
    private String fillColor;
    
    private Float fillOpacity;
    
    private Float groupPadding;
    
    private Integer groupZPadding;
    
    private Boolean grouping;
    
    private String innerSize;
    
    private String lineColor;
    
    private Integer lineWidth;
    
    private String linkedTo;
    
    private PlotOptionsMarker marker;
    
    private Integer minPointLength;
    
    private Integer minSize;
    
    private String negativeColor;
    
    private String negativeFillColor;
    
    private Float pointPadding;
    
    private Boolean shadow;
    
    private Integer slicedOffset;
    
    private String stacking;
    
    private Integer startAngle;
    
    private PlotOptionsStates states;
    
    private String step;
    
    private Double threshold;
    
    private Boolean trackByArea;

    private Boolean visible;

    private Integer turboThreshold;
    
    @Override
    public PlotOptionsSeries style(
            final PlotOptionsSeries src) {
        if(src == null) {
            return this;
        }
        
        this.allowPointSelect = src.allowPointSelect;
        this.animation = src.animation;
        this.borderColor = src.borderColor;
        this.borderRadius = src.borderRadius;
        this.borderWidth = src.borderWidth;
        this.color = src.color;
        this.colorByPoint = src.colorByPoint;
        Utils.stylePrimitiveArray(this.colors, src.colors);
        this.connectEnds = src.connectEnds;
        this.connectNulls = src.connectNulls;
        this.cropThreshold = src.cropThreshold;
        this.cursor = src.cursor;
        this.dashStyle = src.dashStyle;
        Utils.style(this.dataLabels, src.dataLabels);
        this.depth = src.depth;
        this.edgeColor = src.edgeColor;
        this.edgeWidth = src.edgeWidth;
        this.enableMouseTracking = src.enableMouseTracking;
        this.fillColor = src.fillColor;
        this.fillOpacity = src.fillOpacity;
        this.groupPadding = src.groupPadding;
        this.groupZPadding = src.groupZPadding;
        this.grouping = src.grouping;
        this.innerSize = src.innerSize;
        this.lineColor = src.lineColor;
        this.lineWidth = src.lineWidth;
        this.linkedTo = src.linkedTo;
        Utils.style(this.marker, src.marker);
        this.minPointLength = src.minPointLength;
        this.minSize = src.minSize;
        this.negativeColor = src.negativeColor;
        this.negativeFillColor = src.negativeFillColor;
        this.pointPadding = src.pointPadding;
        this.shadow = src.shadow;
        this.slicedOffset = src.slicedOffset;
        this.stacking = src.stacking;
        this.startAngle = src.startAngle;
        this.step = src.step;
        this.threshold = src.threshold;
        this.trackByArea = src.trackByArea;
        this.visible = src.visible;
        this.turboThreshold = src.turboThreshold;
        return this;
    }

    public PlotOptionsDataLabels getDataLabels() {
        if (dataLabels == null) {
            dataLabels = new PlotOptionsDataLabels();
        }
        return dataLabels;
    }

    public Integer getLineWidth() {
        return lineWidth;
    }

    public PlotOptionsMarker getMarker() {
        if (marker == null) {
            marker = new PlotOptionsMarker();
        }
        return marker;
    }

    public String getStacking() {
        return stacking;
    }

    public PlotOptionsStates getStates() {
        if (states == null) {
            states = new PlotOptionsStates();
        }
        return states;
    }

    public PlotOptionsSeries setStacking(StackingType stacking) {
        this.stacking = EnumString.toString(stacking);
        return this;
    }

    /**
     * @return the allowPointSelect
     */
    public Boolean getAllowPointSelect() {
        return allowPointSelect;
    }

    /**
     * @param allowPointSelect the allowPointSelect to set
     * @return 
     */
    public PlotOptionsSeries setAllowPointSelect(Boolean allowPointSelect) {
        this.allowPointSelect = allowPointSelect;
        return this;
    }

    /**
     * @return the animation
     */
    public String getAnimation() {
        return animation;
    }

    /**
     * @param animation the animation to set
     * @return 
     */
    public PlotOptionsSeries setAnimation(Boolean animation) {
        if(animation != null) {
            this.animation = Boolean.toString(animation);
        } else {
            this.animation = null;
        }
        return this;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     * @return 
     */
    public PlotOptionsSeries setColor(String color) {
        this.color = color;
        return this;
    }
    
    /**
     * @param color the color to set
     * @return 
     */
    public PlotOptionsSeries setColor(Color color) {
        this.color = HexColor.toString(color);
        return this;
    }

    /**
     * @return the connectEnds
     */
    public Boolean getConnectEnds() {
        return connectEnds;
    }

    /**
     * @param connectEnds the connectEnds to set
     * @return 
     */
    public PlotOptionsSeries setConnectEnds(Boolean connectEnds) {
        this.connectEnds = connectEnds;
        return this;
    }

    /**
     * @return the connectNulls
     */
    public Boolean getConnectNulls() {
        return connectNulls;
    }

    /**
     * @param connectNulls the connectNulls to set
     * @return 
     */
    public PlotOptionsSeries setConnectNulls(Boolean connectNulls) {
        this.connectNulls = connectNulls;
        return this;
    }

    /**
     * @return the cropThreshold
     */
    public Integer getCropThreshold() {
        return cropThreshold;
    }

    /**
     * @param cropThreshold the cropThreshold to set
     * @return 
     */
    public PlotOptionsSeries setCropThreshold(Integer cropThreshold) {
        this.cropThreshold = cropThreshold;
        return this;
    }

    /**
     * @return the dashStyle
     */
    public String getDashStyle() {
        return dashStyle;
    }

    /**
     * @param dashStyle the dashStyle to set
     * @return 
     */
    public PlotOptionsSeries setDashStyle(DashStyleType dashStyle) {
        this.dashStyle = EnumString.toString(dashStyle);
        return this;
    }

    /**
     * @param lineWidth the lineWidth to set
     * @return 
     */
    public PlotOptionsSeries setLineWidth(Integer lineWidth) {
        this.lineWidth = lineWidth;
        return this;
    }

    /**
     * @return the linkedTo
     */
    public String getLinkedTo() {
        return linkedTo;
    }

    /**
     * @param linkedTo the linkedTo to set
     * @return 
     */
    public PlotOptionsSeries setLinkedTo(String linkedTo) {
        this.linkedTo = linkedTo;
        return this;
    }

    /**
     * @return the negativeColor
     */
    public String getNegativeColor() {
        return negativeColor;
    }

    /**
     * @param negativeColor the negativeColor to set
     * @return 
     */
    public PlotOptionsSeries setNegativeColor(String negativeColor) {
        this.negativeColor = negativeColor;
        return this;
    }
    
    /**
     * @param negativeColor the negativeColor to set
     * @return 
     */
    public PlotOptionsSeries setNegativeColor(Color negativeColor) {
        this.negativeColor = HexColor.toString(negativeColor);
        return this;
    }

    /**
     * @return the visible
     */
    public Boolean getVisible() {
        return visible;
    }

    /**
     * @param visible the visible to set
     * @return 
     */
    public PlotOptionsSeries setVisible(Boolean visible) {
        this.visible = visible;
        return this;
    }

    /**
     * @return the borderColor
     */
    public String getBorderColor() {
        return borderColor;
    }

    /**
     * @param borderColor the borderColor to set
     * @return 
     */
    public PlotOptionsSeries setBorderColor(Color borderColor) {
        this.borderColor = HexColor.toString(borderColor);
        return this;
    }

    /**
     * @return the borderRadius
     */
    public Integer getBorderRadius() {
        return borderRadius;
    }

    /**
     * @param borderRadius the borderRadius to set
     * @return 
     */
    public PlotOptionsSeries setBorderRadius(Integer borderRadius) {
        this.borderRadius = borderRadius;
        return this;
    }

    /**
     * @return the borderWidth
     */
    public Integer getBorderWidth() {
        return borderWidth;
    }

    /**
     * @param borderWidth the borderWidth to set
     * @return 
     */
    public PlotOptionsSeries setBorderWidth(Integer borderWidth) {
        this.borderWidth = borderWidth;
        return this;
    }

    /**
     * @return the colorByPoint
     */
    public Boolean getColorByPoint() {
        return colorByPoint;
    }

    /**
     * @param colorByPoint the colorByPoint to set
     * @return 
     */
    public PlotOptionsSeries setColorByPoint(Boolean colorByPoint) {
        this.colorByPoint = colorByPoint;
        return this;
    }

    /**
     * @return the colors
     */
    public JsonArray<String> getColors() {
        if(this.colors == null) {
            this.colors = new JsonArray<String>();
        }
        return colors;
    }

    /**
     * @return the cursor
     */
    public String getCursor() {
        return cursor;
    }

    /**
     * @param cursor the cursor to set
     * @return 
     */
    public PlotOptionsSeries setCursor(String cursor) {
        this.cursor = cursor;
        return this;
    }

    /**
     * @return the depth
     */
    public Integer getDepth() {
        return depth;
    }

    /**
     * @param depth the depth to set
     * @return 
     */
    public PlotOptionsSeries setDepth(Integer depth) {
        this.depth = depth;
        return this;
    }

    /**
     * @return the edgeColor
     */
    public String getEdgeColor() {
        return edgeColor;
    }

    /**
     * @param edgeColor the edgeColor to set
     * @return 
     */
    public PlotOptionsSeries setEdgeColor(Color edgeColor) {
        this.edgeColor = HexColor.toString(edgeColor);
        return this;
    }

    /**
     * @return the edgeWidth
     */
    public Integer getEdgeWidth() {
        return edgeWidth;
    }

    /**
     * @param edgeWidth the edgeWidth to set
     * @return 
     */
    public PlotOptionsSeries setEdgeWidth(Integer edgeWidth) {
        this.edgeWidth = edgeWidth;
        return this;
    }

    /**
     * @return the enableMouseTracking
     */
    public Boolean getEnableMouseTracking() {
        return enableMouseTracking;
    }

    /**
     * @param enableMouseTracking the enableMouseTracking to set
     * @return 
     */
    public PlotOptionsSeries setEnableMouseTracking(
            final Boolean enableMouseTracking) {
        this.enableMouseTracking = enableMouseTracking;
        return this;
    }

    /**
     * @return the fillColor
     */
    public String getFillColor() {
        return fillColor;
    }

    /**
     * @param fillColor the fillColor to set
     * @return 
     */
    public PlotOptionsSeries setFillColor(String fillColor) {
        this.fillColor = fillColor;
        return this;
    }
    
    /**
     * @param fillColor the fillColor to set
     * @return 
     */
    public PlotOptionsSeries setFillColor(Color fillColor) {
        this.fillColor = HexColor.toString(fillColor);
        return this;
    }

    /**
     * @return the fillOpacity
     */
    public Float getFillOpacity() {
        return fillOpacity;
    }

    /**
     * @param fillOpacity the fillOpacity to set
     * @return 
     */
    public PlotOptionsSeries setFillOpacity(Float fillOpacity) {
        this.fillOpacity = fillOpacity;
        return this;
    }

    /**
     * @return the groupPadding
     */
    public Float getGroupPadding() {
        return groupPadding;
    }

    /**
     * @param groupPadding the groupPadding to set
     * @return 
     */
    public PlotOptionsSeries setGroupPadding(Float groupPadding) {
        this.groupPadding = groupPadding;
        return this;
    }

    /**
     * @return the groupZPadding
     */
    public Integer getGroupZPadding() {
        return groupZPadding;
    }

    /**
     * @param groupZPadding the groupZPadding to set
     * @return 
     */
    public PlotOptionsSeries setGroupZPadding(Integer groupZPadding) {
        this.groupZPadding = groupZPadding;
        return this;
    }

    /**
     * @return the grouping
     */
    public Boolean getGrouping() {
        return grouping;
    }

    /**
     * @param grouping the grouping to set
     * @return 
     */
    public PlotOptionsSeries setGrouping(Boolean grouping) {
        this.grouping = grouping;
        return this;
    }

    /**
     * @return the innserSize
     */
    public String getInnerSize() {
        return innerSize;
    }

    /**
     * @param innserSize the innserSize to set
     * @return 
     */
    public PlotOptionsSeries setInnerSize(String innerSize) {
        this.innerSize = innerSize;
        return this;
    }

    /**
     * @return the lineColor
     */
    public String getLineColor() {
        return lineColor;
    }

    /**
     * @param lineColor the lineColor to set
     * @return 
     */
    public PlotOptionsSeries setLineColor(Color lineColor) {
        this.lineColor = HexColor.toString(lineColor);
        return this;
    }

    /**
     * @return the minPointLength
     */
    public Integer getMinPointLength() {
        return minPointLength;
    }

    /**
     * @param minPointLength the minPointLength to set
     * @return 
     */
    public PlotOptionsSeries setMinPointLength(Integer minPointLength) {
        this.minPointLength = minPointLength;
        return this;
    }

    /**
     * @return the minSize
     */
    public Integer getMinSize() {
        return minSize;
    }

    /**
     * @param minSize the minSize to set
     * @return 
     */
    public PlotOptionsSeries setMinSize(Integer minSize) {
        this.minSize = minSize;
        return this;
    }

    /**
     * @return the negativeFillColor
     */
    public String getNegativeFillColor() {
        return negativeFillColor;
    }

    /**
     * @param negativeFillColor the negativeFillColor to set
     * @return 
     */
    public PlotOptionsSeries setNegativeFillColor(String negativeFillColor) {
        this.negativeFillColor = negativeFillColor;
        return this;
    }
    
    /**
     * @param negativeFillColor the negativeFillColor to set
     * @return 
     */
    public PlotOptionsSeries setNegativeFillColor(Color negativeFillColor) {
        this.negativeFillColor = HexColor.toString(negativeFillColor);
        return this;
    }

    /**
     * @return the pointPadding
     */
    public Float getPointPadding() {
        return pointPadding;
    }

    /**
     * @param pointPadding the pointPadding to set
     * @return 
     */
    public PlotOptionsSeries setPointPadding(Float pointPadding) {
        this.pointPadding = pointPadding;
        return this;
    }

    /**
     * @return the shadow
     */
    public Boolean getShadow() {
        return shadow;
    }

    /**
     * @param shadow the shadow to set
     * @return 
     */
    public PlotOptionsSeries setShadow(Boolean shadow) {
        this.shadow = shadow;
        return this;
    }

    /**
     * @return the slicedOffset
     */
    public Integer getSlicedOffset() {
        return slicedOffset;
    }

    /**
     * @param slicedOffset the slicedOffset to set
     * @return 
     */
    public PlotOptionsSeries setSlicedOffset(Integer slicedOffset) {
        this.slicedOffset = slicedOffset;
        return this;
    }

    /**
     * @return the startAngle
     */
    public Integer getStartAngle() {
        return startAngle;
    }

    /**
     * @param startAngle the startAngle to set
     * @return 
     */
    public PlotOptionsSeries setStartAngle(Integer startAngle) {
        this.startAngle = startAngle;
        return this;
    }

    /**
     * @return the step
     */
    public String getStep() {
        return step;
    }

    /**
     * @param step the step to set
     * @return 
     */
    public PlotOptionsSeries setStep(String step) {
        this.step = step;
        return this;
    }

    /**
     * @return the threshold
     */
    public Double getThreshold() {
        return threshold;
    }

    /**.
     * @param threshold the threshold to set
     * @return 
     */
    public PlotOptionsSeries setThreshold(Double threshold) {
        this.threshold = threshold;
        return this;
    }

    /**
     * @return the trackByArea
     */
    public Boolean getTrackByArea() {
        return trackByArea;
    }

    /**
     * Whether the whole area or just the line should respond to mouseover 
     * tooltips and other mouse or touch events. Defaults to false.
     * @param trackByArea the trackByArea to set
     * @return 
     */
    public PlotOptionsSeries setTrackByArea(Boolean trackByArea) {
        this.trackByArea = trackByArea;
        return this;
    }

    /**
     * @return the turboThreshold
     */
    public Integer getTurboThreshold() {
        return turboThreshold;
    }

    /**.
     * @param turboThreshold the turboThreshold to set
     * @return
     */
    public PlotOptionsSeries setTurboThreshold(Integer turboThreshold) {
        this.turboThreshold = turboThreshold;
        return this;
    }
}