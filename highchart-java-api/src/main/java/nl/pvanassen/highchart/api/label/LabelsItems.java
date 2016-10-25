package nl.pvanassen.highchart.api.label;

import nl.pvanassen.highchart.api.shared.Style;

public class LabelsItems {

    private String html;

    private Style style;

    public LabelsItems center(int centerPosition, double top) {
        getStyle().setProperty("left", centerPosition - getHtml().length() * 6 / 2 + "px");
        getStyle().setProperty("top", top + "px");
        return this;
    }

    public String getHtml() {
        return html;
    }

    public Style getStyle() {
        if(this.style == null) {
            this.style = new Style();
        }
        return style;
    }

    public LabelsItems setHtml(String html) {
        this.html = html;
        return this;
    }

}