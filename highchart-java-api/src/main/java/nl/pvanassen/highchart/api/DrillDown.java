

package nl.pvanassen.highchart.api;

import nl.pvanassen.highchart.api.base.BaseObject;
import nl.pvanassen.highchart.api.drilldown.DrillUpButton;
import nl.pvanassen.highchart.api.utils.JsonArray;

public class DrillDown extends BaseObject {

    private JsonArray<Series> series;

    private DrillUpButton drillUpButton;

    public JsonArray<Series> getSeries() {
        if (series == null) {
            series = new JsonArray<Series>();
        }
        return series;
    }

    public DrillUpButton getDrillUpButton() {
        if (drillUpButton == null) {
            drillUpButton = new DrillUpButton();
        }
        return drillUpButton;
    }

}
