package nl.pvanassen.highchart.api;

import java.awt.Color;
import nl.pvanassen.highchart.api.base.BaseObject;
import nl.pvanassen.highchart.api.plotoption.PlotOptionsDataLabels;
import nl.pvanassen.highchart.api.plotoption.PlotOptionsMarker;
import nl.pvanassen.highchart.api.shared.HexColor;
import nl.pvanassen.highchart.api.shared.Styleable;
import nl.pvanassen.highchart.api.utils.Utils;

public class Point 
    extends     BaseObject
    implements  Styleable<Point> {
    
    private String color;
    
    private PlotOptionsDataLabels dataLabels;
    
    private String drilldown;
    
    private String id;
    
    private Boolean isIntermediateSum;
    
    private Boolean isSum;
    
    private PlotOptionsMarker marker;
    
    private String name;
    
    private Boolean sliced;
    
    private NullableDouble x;

    private NullableDouble y;
    
    private NullableDouble z;
    
    @Override
    public Point style(
            final Point src) {
        if(src == null) {
            return this;
        }
        this.color = src.color;
        Utils.style(this.dataLabels, src.dataLabels);
        this.drilldown = src.drilldown;
        this.id = src.id;
        this.isIntermediateSum = src.isIntermediateSum;
        this.isSum = src.isSum;
        Utils.style(this.marker, src.marker);
        this.name = src.name;
        this.sliced = src.sliced;
        return this;
    }
 

    public String getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public Double getX() {
        return x.getValue();
    }

    public Double getY() {
        return y.getValue();
    }

    /**
     * @return the z
     */
    public Double getZ() {
        return z.getValue();
    }
    
    public Point setZ(double z) {
        this.z = NullableDouble.of(z);
        return this;
    }

    /**
     * @param z the z to set
     */
    public Point setZ(Double z) {
        this.z = NullableDouble.of(z);
        return this;
    }

    public Point setColor(String color) {
        this.color = color;
        return this;
    }
    
    public Point setColor(Color color) {
        this.color = HexColor.toString(color);
        return this;
    }

    public Point setName(String name) {
        this.name = name;
        return this;
    }
    
    public Point setX(double x) {
        this.x = NullableDouble.of(x);
        return this;
    }

    public Point setX(Double x) {
        this.x = NullableDouble.of(x);
        return this;
    }
    
    public Point setY(double y) {
        this.y = NullableDouble.of(y);
        return this;
    }

    public Point setY(Double y) {
        this.y = NullableDouble.of(y);
        return this;
    }

    /**
     * Individual data label for each point. The options are the same as 
     * the ones for plotOptions.series.dataLabels
     * @return the dataLabels
     */
    public PlotOptionsDataLabels getDataLabels() {
        if(this.dataLabels == null) {
            this.dataLabels = new PlotOptionsDataLabels();
        }
        return dataLabels;
    }

    /**
     * The id of a series in the drilldown.series array to use for a 
     * drilldown for this point.
     * @return the drilldown
     */
    public String getDrilldown() {
        return drilldown;
    }

    /**
     * The id of a series in the drilldown.series array to use for a 
     * drilldown for this point.
     * @param drilldown the drilldown to set
     * @return 
     */
    public Point setDrilldown(String drilldown) {
        this.drilldown = drilldown;
        return this;
    }

    /**
     * An id for the point. This can be used after render time to get a 
     * pointer to the point object through chart.get().
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * An id for the point. This can be used after render time to get a 
     * pointer to the point object through chart.get().
     * @param id the id to set
     * @return 
     */
    public Point setId(String id) {
        this.id = id;
        return this;
    }

    /**
     * Waterfall series only. When this property is true, the points acts 
     * as a summary column for the values added or subtracted since the 
     * last intermediate sum, or since the start of the series. 
     * The y value is ignored. Defaults to false.
     * @return the isIntermediateSum
     */
    public Boolean getIsIntermediateSum() {
        return isIntermediateSum;
    }

    /**
     * Waterfall series only. When this property is true, the points acts 
     * as a summary column for the values added or subtracted since the 
     * last intermediate sum, or since the start of the series. 
     * The y value is ignored. Defaults to false.
     * @param isIntermediateSum the isIntermediateSum to set
     * @return 
     */
    public Point setIsIntermediateSum(Boolean isIntermediateSum) {
        this.isIntermediateSum = isIntermediateSum;
        return this;
    }

    /**
     * Waterfall series only. When this property is true, the point display 
     * the total sum across the entire series. 
     * The y value is ignored. Defaults to false.
     * @return the isSum
     */
    public Boolean getIsSum() {
        return isSum;
    }

    /**
     * Waterfall series only. When this property is true, the point display 
     * the total sum across the entire series. 
     * The y value is ignored. Defaults to false.
     * @param isSum the isSum to set
     * @return 
     */
    public Point setIsSum(Boolean isSum) {
        this.isSum = isSum;
        return this;
    }

    /**
     * @return the marker
     */
    public PlotOptionsMarker getMarker() {
        if(this.marker == null) {
            this.marker = new PlotOptionsMarker();
        }
        return marker;
    }

    /**
     * Pie series only. Whether to display a slice offset from the center. 
     * Defaults to false.
     * @return the sliced
     */
    public Boolean getSliced() {
        return sliced;
    }

    /**
     * Pie series only. Whether to display a slice offset from the center. 
     * Defaults to false.
     * @param sliced the sliced to set
     * @return 
     */
    public Point setSliced(Boolean sliced) {
        this.sliced = sliced;
        return this;
    }
}
