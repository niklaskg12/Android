package nl.pvanassen.highchart.api;

import nl.pvanassen.highchart.api.plotoption.PlotOptionsSeries;
import nl.pvanassen.highchart.api.shared.SeriesType;
import nl.pvanassen.highchart.api.utils.JsonArray;
import nl.pvanassen.highchart.api.utils.Utils;

public class Series 
    extends     PlotOptionsSeries {
    
    private JsonArray<Point> data;
    
    private String id;
    
    private String name;
    
    private String stack;
    
    private String type;
    
    private Integer xAxis;

    private Integer yAxis;
    
    private Integer zIndex;
    
    public Series style(
            final Series src) {
        super.style(src);
        
        if(src == null) {
            return this;
        }
        
        this.id = src.id;
        this.name = src.name;
        this.stack = src.stack;
        this.type = src.type;
        this.xAxis = src.xAxis;
        this.yAxis = src.yAxis;
        Utils.styleArray(this.data, src.data);
        this.zIndex = src.zIndex;
        return this;
    }

    public JsonArray<Point> getData() {
        if (data == null) {
            data = new JsonArray<Point>();
        }
        return data;
    }

    /**
     * An id for the series. This can be used after render time to get a 
     * pointer to the series object through chart.get().
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * An id for the series. This can be used after render time to get a 
     * pointer to the series object through chart.get().
     * @param id the id to set
     * @return 
     */
    public Series setId(String id) {
        this.id = id;
        return this;
    }

    /**
     * The name of the series as shown in the legend, tooltip etc.
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * The name of the series as shown in the legend, tooltip etc.
     * @param name the name to set
     * @return 
     */
    public Series setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * This option allows grouping series in a stacked chart. The stack option 
     * can be a string or a number or anything else, as long as the grouped 
     * series' stack options match each other.
     * @return the stack
     */
    public String getStack() {
        return stack;
    }

    /**
     * This option allows grouping series in a stacked chart. The stack option 
     * can be a string or a number or anything else, as long as the grouped 
     * series' stack options match each other.
     * @param stack the stack to set
     * @return 
     */
    public Series setStack(String stack) {
        this.stack = stack;
        return this;
    }

    /**
     * The type of series
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * The type of series
     * @param type the type to set
     * @return 
     */
    public Series setType(SeriesType type) {
        if(type != null) {
            this.type = type.name().toLowerCase();
        } else {
            this.type = null;
        }
        return this;
    }

    /**
     * When using dual or multiple x axes, this number defines which xAxis the 
     * particular series is connected to. It refers to either the axis id or 
     * the index of the axis in the xAxis array, with 0 being the first. 
     * Defaults to 0.
     * @return the xAxis
     */
    public Integer getXAxis() {
        return xAxis;
    }

    /**
     * When using dual or multiple x axes, this number defines which xAxis the 
     * particular series is connected to. It refers to either the axis id or 
     * the index of the axis in the xAxis array, with 0 being the first. 
     * Defaults to 0.
     * @param xAxis the xAxis to set
     * @return 
     */
    public Series setXAxis(Integer xAxis) {
        this.xAxis = xAxis;
        return this;
    }

    /**
     * When using dual or multiple y axes, this number defines which yAxis the 
     * particular series is connected to. It refers to either the axis id or 
     * the index of the axis in the yAxis array, with 0 being the first. 
     * Defaults to 0.
     * @return the yAxis
     */
    public Integer getYAxis() {
        return yAxis;
    }

    /**
     * When using dual or multiple y axes, this number defines which yAxis the 
     * particular series is connected to. It refers to either the axis id or 
     * the index of the axis in the yAxis array, with 0 being the first. 
     * Defaults to 0.
     * @param yAxis the yAxis to set
     * @return 
     */
    public Series setYAxis(Integer yAxis) {
        this.yAxis = yAxis;
        return this;
    }

    /**
     * Define the visual z index of the series.
     * @return the zIndex
     */
    public Integer getZIndex() {
        return zIndex;
    }

    /**
     * Define the visual z index of the series.
     * @param zIndex the zIndex to set
     * @return 
     */
    public Series setZIndex(Integer zIndex) {
        this.zIndex = zIndex;
        return this;
    }
}
