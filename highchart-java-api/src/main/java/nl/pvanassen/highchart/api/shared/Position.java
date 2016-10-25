/*
 * Copyright 2015 Gamma Associates Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package nl.pvanassen.highchart.api.shared;

import nl.pvanassen.highchart.api.base.BaseObject;

/**
 *
 * @author shaun.lefeuvre
 */
public class Position extends BaseObject {
    
    private Integer x;
    
    private Integer y;
    
    private String align;
    
    private String verticalAlign;

    /**
     * @return the x
     */
    public Integer getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public Position setX(Integer x) {
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
     */
    public Position setY(Integer y) {
        this.y = y;
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
    public Position setAlign(AlignType align) {
        this.align = EnumString.toString(align);
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
    public Position setVerticalAlign(VerticalAlignType verticalAlign) {
        this.verticalAlign = EnumString.toString(verticalAlign);
        return this;
    }
    
    
}
