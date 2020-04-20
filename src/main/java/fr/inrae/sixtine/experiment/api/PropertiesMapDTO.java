/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.inrae.sixtine.experiment.api;

import java.util.List;
import java.util.Map;

/**
 *
 * @author vince
 */
public class PropertiesMapDTO {

    Map<String, List<PropertyDTO>> properties;

    public Map<String, List<PropertyDTO>> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, List<PropertyDTO>> properties) {
        this.properties = properties;
    }

}
