package nl.pvanassen.highchart.api;

import nl.pvanassen.highchart.api.base.BaseObject;
import nl.pvanassen.highchart.api.shared.Style;
import nl.pvanassen.highchart.api.shared.AlignType;
import nl.pvanassen.highchart.api.shared.EnumString;
import nl.pvanassen.highchart.api.shared.Styleable;
import nl.pvanassen.highchart.api.shared.VerticalAlignType;
import nl.pvanassen.highchart.api.utils.Utils;

public class Title 
    extends     BaseObject
    implements  Styleable<Title> {
    
    private String align;
    
    private Boolean floating;
    
    private Integer margin;
    
    private Style style;

    private String text;

    private Boolean useHTML;
    
    private String verticalAlign;
    
    private Integer x;
    
    private Integer y;

    public Title() {
        this.text = "";
    }
    
    @Override
    public Title style(
            final Title src) {
        if(src == null) {
            return this;
        }
        this.align = src.align;
        this.floating = src.floating;
        this.margin = src.margin;
        Utils.style(this.style, src.style);
        this.text = src.text;
        this.useHTML = src.useHTML;
        this.verticalAlign = src.verticalAlign;
        this.x = src.x;
        this.y = src.y;
        return this;
    }

    public Style getStyle() {
        if (style == null) {
            style = new Style();
        }
        return style;
    }

    public String getText() {
        return text;
    }

    public Title setText(String text) {
        this.text = text;
        return this;
    }

    /**
     * @return the align
     */
    public String getAlign() {
        return align;
    }

    /**
     * @param align the align to set
     * @return 
     */
    public Title setAlign(AlignType align) {
        this.align = EnumString.toString(align);
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
    public Title setFloating(Boolean floating) {
        this.floating = floating;
        return this;
    }

    /**
     * @return the margin
     */
    public Integer getMargin() {
        return margin;
    }

    /**
     * @param margin the margin to set
     * @return 
     */
    public Title setMargin(Integer margin) {
        this.margin = margin;
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
    public Title setUseHTML(Boolean useHTML) {
        this.useHTML = useHTML;
        return this;
    }

    /**
     * @return the verticalAlign
     */
    public String getVerticalAlign() {
        return verticalAlign;
    }

    /**
     * @param verticalAlign the verticalAlign to set
     * @return 
     */
    public Title setVerticalAlign(VerticalAlignType verticalAlign) {
        this.verticalAlign = EnumString.toString(verticalAlign);
        return this;
    }

    /**
     * @return the x
     */
    public Integer getX() {
        return x;
    }

    /**
     * @param x the x to set
     * @return 
     */
    public Title setX(Integer x) {
        this.x = x;
        return this;
    }

    /**
     * @return the y
     */
    public Integer getY() {
        return y;
    }

    /**
     * @param y the y to set
     * @return 
     */
    public Title setY(Integer y) {
        this.y = y;
        return this;
    }
}
