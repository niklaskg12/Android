package nl.pvanassen.highchart.api.base;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import nl.pvanassen.highchart.api.shared.Jsonify;

@XmlAccessorType(XmlAccessType.NONE)
public class BaseObject implements Jsonify {

    public BaseObject() {
        super();
    }

    @Override
    public String toJson() {
        return GsonHelper.toJson(this);
    }

}