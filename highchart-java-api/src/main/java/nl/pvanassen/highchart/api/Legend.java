package nl.pvanassen.highchart.api;

import java.awt.Color;
import nl.pvanassen.highchart.api.base.BaseObject;
import nl.pvanassen.highchart.api.shared.Style;
import nl.pvanassen.highchart.api.shared.AlignType;
import nl.pvanassen.highchart.api.shared.EnumString;
import nl.pvanassen.highchart.api.shared.HexColor;
import nl.pvanassen.highchart.api.shared.VerticalAlignType;

public class Legend extends BaseObject {
    
    public enum LegendLayoutType {
        horizontal,
        vertical
    }

    private String align;

    private String backgroundColor;
    
    private String borderColor;
    
    private Integer borderRadius;
    
    private Integer borderWidth;
    
    private Boolean enabled;
    
    private Boolean floating;
    
    private Integer itemDistance;
    
    private Style itemStyle;
    
    private String labelFormat;
    
    private String layout;
    
    private Integer maxHeight;
    
    private Boolean reversed;
    
    private Boolean useHTML;

    private String verticalAlign;
    
    private Integer width;
    
    private Integer x;

    private Integer y;

    public String getAlign() {
        return align;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public String getLayout() {
        return layout;
    }

    public String getVerticalAlign() {
        return verticalAlign;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public Boolean getReversed() {
        return reversed;
    }

    public Legend setAlign(AlignType align) {
        this.align = EnumString.toString(align);
        return this;
    }

    public Legend setEnabled(Boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public Legend setLayout(LegendLayoutType layout) {
        this.layout = EnumString.toString(layout);
        return this;
    }

    public Legend setReversed(Boolean reversed) {
        this.reversed = reversed;
        return this;
    }

    public Legend setVerticalAlign(VerticalAlignType verticalAlign) {
        this.verticalAlign = EnumString.toString(verticalAlign);
        return this;
    }

    public Legend setX(int x) {
        this.x = x;
        return this;
    }

    public Legend setY(int y) {
        this.y = y;
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
    public Legend setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }
    
    /**
     * @param backgroundColor the b
     * @return ackgroundColor to set
     */
    public Legend setBackgroundColor(Color backgroundColor) {
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
    public Legend setBorderColor(Color borderColor) {
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
    public Legend setBorderRadius(Integer borderRadius) {
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
    public Legend setBorderWidth(Integer borderWidth) {
        this.borderWidth = borderWidth;
        return this;
    }

    /**
     * @return the floating
     */
    public Boolean getFloating() {
        return floating;
    }

    /**
     * @param floating the floating to set
     * @return 
     */
    public Legend setFloating(Boolean floating) {
        this.floating = floating;
        return this;
    }

    /**
     * @return the itemDistance
     */
    public Integer getItemDistance() {
        return itemDistance;
    }

    /**
     * @param itemDistance the itemDistance to set
     * @return 
     */
    public Legend setItemDistance(Integer itemDistance) {
        this.itemDistance = itemDistance;
        return this;
    }

    /**
     * @return the itemStyle
     */
    public Style getItemStyle() {
        if(this.itemStyle == null) {
            this.itemStyle = new Style();
        }
        return itemStyle;
    }

    /**
     * @return the labelFormat
     */
    public String getLabelFormat() {
        return labelFormat;
    }

    /**
     * @param labelFormat the labelFormat to set
     * @return 
     */
    public Legend setLabelFormat(String labelFormat) {
        this.labelFormat = labelFormat;
        return this;
    }

    /**
     * @return the maxHeight
     */
    public Integer getMaxHeight() {
        return maxHeight;
    }

    /**
     * @param maxHeight the maxHeight to set
     * @return 
     */
    public Legend setMaxHeight(Integer maxHeight) {
        this.maxHeight = maxHeight;
        return this;
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
    public Legend setUseHTML(Boolean useHTML) {
        this.useHTML = useHTML;
        return this;
    }

    /**
     * @return the width
     */
    public Integer getWidth() {
        return width;
    }

    /**
     * @param width the width to set
     * @return 
     */
    public Legend setWidth(Integer width) {
        this.width = width;
        return this;
    }
}
