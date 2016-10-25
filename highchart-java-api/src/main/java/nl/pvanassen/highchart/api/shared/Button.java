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
public class Button extends BaseObject {
    public enum RelativeToType {
        plotBox, spacingBox
    }
    
    private Position position;
    
    private String relativeTo;
    
    private Theme theme;
    
    /**
     * @return the position
     */
    public Position getPosition() {
        if(this.position == null) {
            this.position = new Position();
        }
        return position;
    }

    /**
     * @return the relativeTo
     */
    public String getRelativeTo() {
        return relativeTo;
    }

    /**
     * @param relativeTo the relativeTo to set
     */
    public void setRelativeTo(RelativeToType relativeTo) {
        this.relativeTo = EnumString.toString(relativeTo);
    }

    /**
     * @return the theme
     */
    public Theme getTheme() {
        if(this.theme == null) {
            this.theme = new Theme();
        }
        return theme;
    }    
}
