//******************************************************************************
// OpenSILEX - Licence AGPL V3.0 - https://www.gnu.org/licenses/agpl-3.0.en.html
// Copyright © INRA 2019
// Contact: vincent.migot@inra.fr, anne.tireau@inra.fr, pascal.neveu@inra.fr
//******************************************************************************
package fr.inrae.sixtine;

import java.net.URI;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import org.apache.jena.riot.Lang;
import org.opensilex.OpenSilexModule;
import org.opensilex.core.experiment.dal.ExperimentDAO;
import org.opensilex.core.experiment.dal.ExperimentModel;
import org.opensilex.core.infrastructure.dal.InfrastructureDAO;
import org.opensilex.core.infrastructure.dal.InfrastructureFacilityModel;
import org.opensilex.core.infrastructure.dal.InfrastructureModel;
import org.opensilex.sparql.SPARQLConfig;
import org.opensilex.sparql.SPARQLModule;
import org.opensilex.sparql.extensions.OntologyFileDefinition;
import org.opensilex.sparql.extensions.SPARQLExtension;
import org.opensilex.sparql.service.SPARQLService;

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
        
        SPARQLConfig sparqlConfig = getOpenSilex().getModuleConfig(SPARQLModule.class, SPARQLConfig.class);
        list.add(new OntologyFileDefinition(
                sparqlConfig.baseURI() + "germplasm",
                "ontologies/species.ttl",
                Lang.TTL,
                sparqlConfig.baseURIAlias() + "-species"
        ));
        
//        list.add(new OntologyFileDefinition(
//                "https://sixtine.inrae.fr/experiment/testxp",
//                "ontologies/testxp.ttl",
//                Lang.TTL,
//                "testxp"
//        ));
        
        return list;
    }
    
    @Override
    public void installOntologies(SPARQLService sparql, boolean reset) throws Exception {
//        URI xpURI = new URI("https://sixtine.inrae.fr/experiment/testxp");
//        URI infraURI = new URI("https://sixtine.inrae.fr/infrastructures/test-infra");
//        URI facilityURI = new URI("https://sixtine.inrae.fr/infrastructures/test-infra.test-facility");
//        
//        if (reset) {
//            sparql.deleteIfExists(ExperimentModel.class, xpURI);
//            sparql.deleteIfExists(InfrastructureModel.class, infraURI);
//            sparql.deleteIfExists(InfrastructureFacilityModel.class, facilityURI);
//        }
//        
//        ExperimentDAO xpDAO = new ExperimentDAO(sparql);
//        ExperimentModel xp = new ExperimentModel();
//        xp.setUri(xpURI);
//        xp.setCampaign(2020);
//        xp.setComment("Test experiment");
//        xp.setStartDate(LocalDate.of(2020, Month.JUNE, 30));
//        xp.setLabel("Text XP");
//        xp = xpDAO.create(xp);
//        
//        InfrastructureDAO infraDAO = new InfrastructureDAO(sparql);
//        InfrastructureModel infrastructure = new InfrastructureModel();
//        infrastructure.setUri(infraURI);
//        infrastructure.setName("Test infra");
//        infrastructure.setType(new URI("https://sixtine.inrae.fr/ontology#ExperimentalUnit"));
//        infrastructure = infraDAO.create(infrastructure);
//        
//        InfrastructureFacilityModel facility = new InfrastructureFacilityModel();
//        facility.setUri(facilityURI);
//        facility.setName("Test facility");
//        facility.setType(new URI("https://sixtine.inrae.fr/ontology#Greenhouse"));
//        facility.setInfrastructure(infrastructure);
//        facility = infraDAO.createFacility(facility, null);
        
        SPARQLExtension.super.installOntologies(sparql, reset);
    }
    
}
