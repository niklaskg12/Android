package nl.pvanassen.highchart.api.serializer;

import java.util.Map;

import nl.pvanassen.highchart.api.shared.Style;

public class StyleSerializer extends Serializer<Style> {

    @Override
    public Map<String, String> getProperties(Style instance) {
        return instance.getProperties();
    }

}
