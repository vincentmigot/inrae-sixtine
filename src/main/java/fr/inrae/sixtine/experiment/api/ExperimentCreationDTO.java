//******************************************************************************
//                          ExperimentCreationDTO.java
// OpenSILEX - Licence AGPL V3.0 - https://www.gnu.org/licenses/agpl-3.0.en.html
// Copyright © INRAE 2020
// Contact: vincent.migot@inra.fr, anne.tireau@inra.fr, pascal.neveu@inra.fr
//******************************************************************************
package fr.inrae.sixtine.experiment.api;

import fr.inrae.sixtine.experiment.dal.ExperimentModel;
import org.opensilex.core.project.dal.ProjectModel;

import java.net.URI;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.opensilex.sparql.model.SPARQLModelRelation;

/**
 * @author Vincent MIGOT
 */
public class ExperimentCreationDTO extends ExperimentDTO {

    protected List<PropertyDTO> properties;

    public List<PropertyDTO> getProperties() {
        return properties;
    }

    public void setProperties(List<PropertyDTO> properties) {
        this.properties = properties;
    }

    public ExperimentModel newModel() {

        ExperimentModel model = new ExperimentModel();
        model.setUri(getUri());
        model.setType(getType());

        model.setLabel(getLabel());
        model.setStartDate(LocalDate.parse(startDate));
        if (endDate != null) {
            model.setEndDate(LocalDate.parse(endDate));
        }

        model.setObjective(getObjective());
        model.setComment(getComment());
        model.setKeywords(keywords);
        model.setIsPublic(isPublic);

        List<ProjectModel> projectList = new ArrayList<>(projects.size());
        projects.forEach((URI u) -> {
            ProjectModel project = new ProjectModel();
            project.setUri(u);
            projectList.add(project);
        });
        model.setProjects(projectList);

        List<SPARQLModelRelation> relations = new ArrayList<>();
        // TODO set all generic relations from properties
        model.setRelations(relations);
        return model;
    }

}
