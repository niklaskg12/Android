package nl.pvanassen.highchart.api;

import nl.pvanassen.highchart.api.base.BaseObject;
import nl.pvanassen.highchart.api.label.LabelsItems;
import nl.pvanassen.highchart.api.shared.Style;
import nl.pvanassen.highchart.api.utils.JsonArray;

public class Labels extends BaseObject {

    private JsonArray<LabelsItems> items;
    
    private Style style;

    public Labels() {
    }

    public JsonArray<LabelsItems> getItems() {
        if (items == null) {
            items = new JsonArray<LabelsItems>();
        }

        return items;
    }
    
    public Style getStyle() {
        if(this.style == null) {
            this.style = new Style();
        }
        return this.style;
    }

}
