/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.inrae.sixtine.experiment.api;

import java.net.URI;

/**
 *
 * @author vince
 */
public class PropertyDTO {

    protected URI rdfProperty;

    protected Object value;

    public URI getRdfProperty() {
        return rdfProperty;
    }

    public void setRdfProperty(URI rdfProperty) {
        this.rdfProperty = rdfProperty;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    
}
