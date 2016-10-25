package nl.pvanassen.highchart.api;

import nl.pvanassen.highchart.api.axis.AxisLabels;
import nl.pvanassen.highchart.api.axis.AxisPlotLines;
import nl.pvanassen.highchart.api.base.BaseObject;
import nl.pvanassen.highchart.api.format.DateTimeLabelFormats;
import nl.pvanassen.highchart.api.shared.DashStyleType;
import nl.pvanassen.highchart.api.shared.EnumString;
import nl.pvanassen.highchart.api.shared.HexColor;
import nl.pvanassen.highchart.api.shared.Styleable;
import nl.pvanassen.highchart.api.utils.ArrayString;
import nl.pvanassen.highchart.api.utils.JsonArray;
import nl.pvanassen.highchart.api.utils.Utils;

import java.awt.Color;

public class Axis 
    extends     BaseObject
    implements  Styleable<Axis> {

    public enum Type {
        LINEAR,
        LOGARITHMIC,
        DATETIME,
        CATEGORY
    }
    
    private ArrayString categories;

    private DateTimeLabelFormats dateTimeLabelFormats;
    
    private String gridLineColor;
    
    private String gridLineDashStyle;
    
    private Integer gridLineWidth;
    
    private AxisLabels labels;
    
    private String lineColor;
    
    private Integer lineWidth;
    
    private Double max;
    
    private Double min;
    
    private String minorGridLineColor;
    
    private String minorGridLineDashStyle;
    
    private Integer minorGridLineWidth;
    
    private Boolean opposite;
    
    private JsonArray<AxisPlotLines> plotLines;
    
    private Boolean reversed;
    
    private Boolean showEmpty;
    
    private Boolean showFirstLabel;

    private Boolean showLastLabel;

    private Boolean startOnTick;

    private Double tickInterval;

    private Double minTickInterval;

    private Title title;
    
    private String type;

    private String id;

    public Axis() { }
    
    @Override
    public Axis style(
            final Axis src) {
        if(src == null) {
            return this;
        }
        Utils.stylePrimitiveArray(this.categories, src.categories);
        Utils.style(this.dateTimeLabelFormats, src.dateTimeLabelFormats);
        this.gridLineColor = src.gridLineColor;
        this.gridLineDashStyle = src.gridLineDashStyle;
        this.gridLineWidth = src.gridLineWidth;
        Utils.style(this.labels, src.labels);
        this.lineColor = src.lineColor;
        this.lineWidth = src.lineWidth;
        this.max = src.max;
        this.min = src.min;
        this.minorGridLineColor = src.minorGridLineColor;
        this.minorGridLineDashStyle = src.minorGridLineDashStyle;
        this.minorGridLineWidth = src.minorGridLineWidth;
        this.opposite = src.opposite;
        this.plotLines = src.plotLines;
        this.reversed = src.reversed;
        this.showEmpty = src.showEmpty;
        this.showFirstLabel = src.showFirstLabel;
        this.showLastLabel = src.showLastLabel;
        this.startOnTick = src.startOnTick;
        this.tickInterval = src.tickInterval;
        this.minTickInterval = src.minTickInterval;
        Utils.style(this.title, src.title);
        this.type = src.type;
        this.id = src.id;
        return this;
    }

    public ArrayString getCategories() {
        if (categories == null) {
            categories = new ArrayString();
        }
        return categories;
    }

    public int getCategoriesLength() {
        return categories != null ? categories.size() : 0;
    }

    public DateTimeLabelFormats getDateTimeLabelFormats() {
        if (dateTimeLabelFormats == null) {
            dateTimeLabelFormats = new DateTimeLabelFormats();
        }
        return dateTimeLabelFormats;
    }

    public AxisLabels getLabels() {
        if (labels == null) {
            labels = new AxisLabels();
        }
        return labels;
    }

    public Double getMax() {
        return max;
    }

    public Double getMin() {
        return min;
    }

    public JsonArray<AxisPlotLines> getPlotLines() {
        if(this.plotLines == null) {
            this.plotLines = new JsonArray<AxisPlotLines>();
        }
        return plotLines;
    }

    public Double getTickInterval() {
        return tickInterval;
    }

    public Double getMinTickInterval() {
        return minTickInterval;
    }

    public Title getTitle() {
        if (title == null) {
            title = new Title();
        }
        return title;
    }

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public Axis setMax(Double max) {
        this.max = max;
        return this;
    }

    public Axis setMin(Double min) {
        this.min = min;
        return this;
    }

    public Axis setTickInterval(Double tickInterval) {
        this.tickInterval = tickInterval;
        return this;
    }

    public Axis setMinTickInterval(double minTickInterval) {
        this.minTickInterval = minTickInterval;
        return this;
    }

    public Axis setType(Type type) {
        this.type = EnumString.toString(type).toLowerCase();
        return this;
    }

    public Axis setId(String id) {
        this.id = id;
        return this;
    }
    
    /**
     * @return the gridLineColor
     */
    public String getGridLineColor() {
        return gridLineColor;
    }

    /**
     * @param gridLineColor the gridLineColor to set
     * @return 
     */
    public Axis setGridLineColor(Color gridLineColor) {
        this.gridLineColor = HexColor.toString(gridLineColor);
        return this;
    }

    /**
     * @return the gridLineDashStyle
     */
    public String getGridLineDashStyle() {
        return gridLineDashStyle;
    }

    /**
     * @param gridLineDashStyle the gridLineDashStyle to set
     * @return 
     */
    public Axis setGridLineDashStyle(DashStyleType gridLineDashStyle) {
        this.gridLineDashStyle = EnumString.toString(gridLineDashStyle);
        return this;
    }

    /**
     * @return the gridLineWidth
     */
    public Integer getGridLineWidth() {
        return gridLineWidth;
    }

    /**
     * @param gridLineWidth the gridLineWidth to set
     * @return 
     */
    public Axis setGridLineWidth(Integer gridLineWidth) {
        this.gridLineWidth = gridLineWidth;
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
    public Axis setLineColor(Color lineColor) {
        this.lineColor = HexColor.toString(lineColor);
        return this;
    }

    /**
     * @return the lineWidth
     */
    public Integer getLineWidth() {
        return lineWidth;
    }

    /**
     * @param lineWidth the lineWidth to set
     * @return 
     */
    public Axis setLineWidth(Integer lineWidth) {
        this.lineWidth = lineWidth;
        return this;
    }

    /**
     * @return the minorGridLineColor
     */
    public String getMinorGridLineColor() {
        return minorGridLineColor;
    }

    /**
     * @param minorGridLineColor the minorGridLineColor to set
     * @return 
     */
    public Axis setMinorGridLineColor(Color minorGridLineColor) {
        this.minorGridLineColor = HexColor.toString(minorGridLineColor);
        return this;
    }

    /**
     * @return the minorGridLineDashStyle
     */
    public String getMinorGridLineDashStyle() {
        return minorGridLineDashStyle;
    }

    /**
     * @param minorGridLineDashStyle the minorGridLineDashStyle to set
     * @return 
     */
    public Axis setMinorGridLineDashStyle(
            final DashStyleType minorGridLineDashStyle) {
        this.minorGridLineDashStyle = 
                EnumString.toString(
                        minorGridLineDashStyle);
        return this;
    }

    /**
     * @return the minorGridLineWidth
     */
    public Integer getMinorGridLineWidth() {
        return minorGridLineWidth;
    }

    /**
     * @param minorGridLineWidth the minorGridLineWidth to set
     * @return 
     */
    public Axis setMinorGridLineWidth(Integer minorGridLineWidth) {
        this.minorGridLineWidth = minorGridLineWidth;
        return this;
    }

    /**
     * @return the opposite
     */
    public Boolean getOpposite() {
        return opposite;
    }

    /**
     * @param opposite the opposite to set
     * @return 
     */
    public Axis setOpposite(Boolean opposite) {
        this.opposite = opposite;
        return this;
    }

    /**
     * @return the reversed
     */
    public Boolean getReversed() {
        return reversed;
    }

    /**
     * @param reversed the reversed to set
     * @return 
     */
    public Axis setReversed(Boolean reversed) {
        this.reversed = reversed;
        return this;
    }

    /**
     * @return the showEmpty
     */
    public Boolean getShowEmpty() {
        return showEmpty;
    }

    /**
     * @param showEmpty the showEmpty to set
     * @return 
     */
    public Axis setShowEmpty(Boolean showEmpty) {
        this.showEmpty = showEmpty;
        return this;
    }

    /**
     * @return the showFirstLabel
     */
    public Boolean getShowFirstLabel() {
        return showFirstLabel;
    }

    /**
     * @param showFirstLabel the showFirstLabel to set
     * @return 
     */
    public Axis setShowFirstLabel(Boolean showFirstLabel) {
        this.showFirstLabel = showFirstLabel;
        return this;
    }

    /**
     * @return the showLastLabel
     */
    public Boolean getShowLastLabel() {
        return showLastLabel;
    }

    /**
     * @param showLastLabel the showLastLabel to set
     * @return 
     */
    public Axis setShowLastLabel(Boolean showLastLabel) {
        this.showLastLabel = showLastLabel;
        return this;
    }

    /**
     * @return the startOnTick
     */
    public Boolean getStartOnTick() {
        return startOnTick;
    }

    /**
     * @param startOnTick the startOnTick to set
     * @return 
     */
    public Axis setStartOnTick(Boolean startOnTick) {
        this.startOnTick = startOnTick;
        return this;
    }

}
