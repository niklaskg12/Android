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
package nl.pvanassen.highchart.api.utils;

import java.util.Map;
import nl.pvanassen.highchart.api.shared.Styleable;

/**
 *
 * @author shaun.lefeuvre
 */
public class Utils {
    public static boolean isAnyNull(
            final Object...objects) {
        for(final Object t:objects) {
            if(t == null) {
                return true;
            }
        }
        return false;
    }
    
    public static <T extends Styleable> void style(
            final T target, 
            final T src) {
        if(!isAnyNull(target, src)) {
            target.style(src);
        }
    }
    
    public static <T extends Styleable> void styleArray(
            final JsonArray<T> target,
            final JsonArray<T> src) {
        if(!isAnyNull(target, src)) {
            for(int i = 0; i < Math.min(
                    target.size(), src.size()); i++) {
                style(target.get(i), src.get(i));
            } 
        }
    }
    
    public static <T> void stylePrimitiveArray(
            final JsonArray<T> target, 
            final JsonArray<T> src) {
        if(!isAnyNull(target, src)) {
            for(int i = 0; i < Math.min(
                    target.size(), src.size()); i++) {
                target.set(i, src.get(i));
            }
        }
    }
    
    public static <K,V> void stylePrimitiveMap(
            final Map<K, V> target, 
            final Map<K, V> src) {
        if(!isAnyNull(target, src)) {
            target.putAll(src);
        }
    }
}
