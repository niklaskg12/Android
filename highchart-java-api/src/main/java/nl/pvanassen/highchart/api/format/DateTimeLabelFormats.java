package nl.pvanassen.highchart.api.format;

import java.util.HashMap;
import java.util.Map;

import nl.pvanassen.highchart.api.base.BaseObject;
import nl.pvanassen.highchart.api.shared.Styleable;
import nl.pvanassen.highchart.api.utils.Utils;

public class DateTimeLabelFormats 
    extends     BaseObject
    implements  Styleable<DateTimeLabelFormats> {

    public enum TimeUnit {
        SECOND, MINUTE, HOUR, DAY, WEEK, MONTH, YEAR;
    }

    private Map<TimeUnit, String> formats;

    public DateTimeLabelFormats() {
        formats = null;
    }
    
    @Override
    public DateTimeLabelFormats style(
            final DateTimeLabelFormats src) {
        if(src == null) {
            return this;
        }
        Utils.stylePrimitiveMap(this.formats, src.formats);
        return this;
    }

    public String getFormat(TimeUnit unit) {
        return formats != null ? formats.get(unit) : null;
    }

    public Map<TimeUnit, String> getFormats() {
        return formats;
    }

    public DateTimeLabelFormats set(TimeUnit unit, String format) {
        if (formats == null) {
            formats = new HashMap<TimeUnit, String>();
        }
        formats.put(unit, format);
        return this;
    }

}
