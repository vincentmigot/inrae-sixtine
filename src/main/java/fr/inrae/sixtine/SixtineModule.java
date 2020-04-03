//******************************************************************************
// OpenSILEX - Licence AGPL V3.0 - https://www.gnu.org/licenses/agpl-3.0.en.html
// Copyright © INRA 2019
// Contact: vincent.migot@inra.fr, anne.tireau@inra.fr, pascal.neveu@inra.fr
//******************************************************************************
package fr.inrae.sixtine;

import java.net.URI;
import java.util.List;
import org.apache.jena.riot.Lang;
import org.opensilex.OpenSilexModule;
import org.opensilex.sparql.extensions.OntologyFileDefinition;
import org.opensilex.sparql.extensions.SPARQLExtension;

/**
 * Sixtine module implementation
 */
public class SixtineModule extends OpenSilexModule implements SPARQLExtension {

    @Override
    public List<OntologyFileDefinition> getOntologiesFiles() throws Exception {
        List<OntologyFileDefinition> list = SPARQLExtension.super.getOntologiesFiles();
        list.add(new OntologyFileDefinition(
                "https://sixtine.inrae.fr/ontology#",
                "ontologies/inrae-sixtine.owl",
                Lang.RDFXML,
                "inrae-sixtine"
        ));
        return list;
    }

}
