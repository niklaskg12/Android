/*
 * Copyright 2014 Gamma Associates Ltd.
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

import java.awt.Color;

/**
 *
 * @author shaun.lefeuvre
 */
public class HexColor {
    
    private HexColor() {}
    
    public static String toString(
            final Color src) {
        if(src != null) {
            return String.format(
                    "#%02x%02x%02x", 
                    src.getRed(), 
                    src.getGreen(), 
                    src.getBlue());
        }
        return null;
    }
}
