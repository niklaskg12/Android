package nl.pvanassen.highchart.api;

import java.awt.Color;
import nl.pvanassen.highchart.api.base.BaseObject;
import nl.pvanassen.highchart.api.shared.Style;
import nl.pvanassen.highchart.api.shared.HexColor;

public class Tooltip extends BaseObject {
    
    private Boolean animation;
    
    private String backgroundColor;
    
    private String borderColor;
    
    private Integer borderRadius;
    
    private Integer borderWidth;

    private Boolean crosshairs;
    
    private Boolean enabled;
    
    private String footerFormat;
    
    private String headerFormat;
    
    private String pointFormat;
    
    private Boolean shadow;
    
    private String shape;

    private Boolean shared;
    
    private Integer snap;
    
    private Style style;
    
    private Boolean useHTML;
    
    private Integer valueDecimals;
    
    private String valuePrefix;
    
    private String valueSuffix;
    
    private String xDateFormat;

    /**
     * @return the animation
     */
    public Boolean getAnimation() {
        return animation;
    }

    /**
     * @param animation the animation to set
     * @return 
     */
    public Tooltip setAnimation(Boolean animation) {
        this.animation = animation;
        return this;
    }

    /**
     * @return the backgroundColor
     */
    public String getBackgroundColor() {
        return backgroundColor;
    }

    /**
     * @param backgroundColor the backgroundColor to set
     * @return 
     */
    public Tooltip setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }
    
    /**
     * @param backgroundColor the backgroundColor to set
     * @return 
     */
    public Tooltip setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = HexColor.toString(backgroundColor);
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
    public Tooltip setBorderColor(Color borderColor) {
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
    public Tooltip setBorderRadius(Integer borderRadius) {
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
    public Tooltip setBorderWidth(Integer borderWidth) {
        this.borderWidth = borderWidth;
        return this;
    }

    /**
     * @return the crosshairs
     */
    public Boolean getCrosshairs() {
        return crosshairs;
    }

    /**
     * @param crosshairs the crosshairs to set
     * @return 
     */
    public Tooltip setCrosshairs(Boolean crosshairs) {
        this.crosshairs = crosshairs;
        return this;
    }

    /**
     * @return the enabled
     */
    public Boolean getEnabled() {
        return enabled;
    }

    /**
     * @param enabled the enabled to set
     * @return 
     */
    public Tooltip setEnabled(Boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    /**
     * @return the footerFormat
     */
    public String getFooterFormat() {
        return footerFormat;
    }

    /**
     * @param footerFormat the footerFormat to set
     * @return 
     */
    public Tooltip setFooterFormat(String footerFormat) {
        this.footerFormat = footerFormat;
        return this;
    }

    /**
     * @return the headerFormat
     */
    public String getHeaderFormat() {
        return headerFormat;
    }

    /**
     * @param headerFormat the headerFormat to set
     * @return 
     */
    public Tooltip setHeaderFormat(String headerFormat) {
        this.headerFormat = headerFormat;
        return this;
    }

    /**
     * @return the pointFormat
     */
    public String getPointFormat() {
        return pointFormat;
    }

    /**
     * @param pointFormat the pointFormat to set
     * @return 
     */
    public Tooltip setPointFormat(String pointFormat) {
        this.pointFormat = pointFormat;
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
    public Tooltip setShadow(Boolean shadow) {
        this.shadow = shadow;
        return this;
    }

    /**
     * @return the shape
     */
    public String getShape() {
        return shape;
    }

    /**
     * @param shape the shape to set
     * @return 
     */
    public Tooltip setShape(String shape) {
        this.shape = shape;
        return this;
    }

    /**
     * @return the shared
     */
    public Boolean getShared() {
        return shared;
    }

    /**
     * @param shared the shared to set
     * @return 
     */
    public Tooltip setShared(Boolean shared) {
        this.shared = shared;
        return this;
    }

    /**
     * @return the snap
     */
    public Integer getSnap() {
        return snap;
    }

    /**
     * @param snap the snap to set
     * @return 
     */
    public Tooltip setSnap(Integer snap) {
        this.snap = snap;
        return this;
    }

    /**
     * @return the style
     */
    public Style getStyle() {
        if(this.style == null) {
            this.style = new Style();
        }
        return style;
    }

    /**
     * @return the useHTML
     */
    public Boolean getUseHTML() {
        return useHTML;
    }

    /**
     * @param useHTML the useHTML to set
     * @return 
     */
    public Tooltip setUseHTML(Boolean useHTML) {
        this.useHTML = useHTML;
        return this;
    }

    /**
     * @return the valueDecimals
     */
    public Integer getValueDecimals() {
        return valueDecimals;
    }

    /**
     * @param valueDecimals the valueDecimals to set
     * @return 
     */
    public Tooltip setValueDecimals(Integer valueDecimals) {
        this.valueDecimals = valueDecimals;
        return this;
    }

    /**
     * @return the valuePrefix
     */
    public String getValuePrefix() {
        return valuePrefix;
    }

    /**
     * @param valuePrefix the valuePrefix to set
     * @return 
     */
    public Tooltip setValuePrefix(String valuePrefix) {
        this.valuePrefix = valuePrefix;
        return this;
    }

    /**
     * @return the valueSuffix
     */
    public String getValueSuffix() {
        return valueSuffix;
    }

    /**
     * @param valueSuffix the valueSuffix to set
     * @return 
     */
    public Tooltip setValueSuffix(String valueSuffix) {
        this.valueSuffix = valueSuffix;
        return this;
    }

    /**
     * @return the xDateFormat
     */
    public String getXDateFormat() {
        return xDateFormat;
    }

    /**
     * @param xDateFormat the xDateFormat to set
     * @return 
     */
    public Tooltip setXDateFormat(String xDateFormat) {
        this.xDateFormat = xDateFormat;
        return this;
    }
}
