//******************************************************************************
//                          ExperimentModel.java
// OpenSILEX - Licence AGPL V3.0 - https://www.gnu.org/licenses/agpl-3.0.en.html
// Copyright © INRAE 2020
// Contact: vincent.migot@inrae.fr, anne.tireau@inrae.fr, pascal.neveu@inrae.fr
//******************************************************************************
package fr.inrae.sixtine.experiment.dal;

import org.apache.jena.vocabulary.RDFS;
import org.opensilex.core.ontology.Oeso;
import org.opensilex.core.project.dal.ProjectModel;
import org.opensilex.sparql.annotations.SPARQLProperty;
import org.opensilex.sparql.annotations.SPARQLResource;
import org.opensilex.sparql.model.SPARQLResourceModel;
import org.opensilex.sparql.utils.ClassURIGenerator;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Vincent MIGOT
 */
@SPARQLResource(
        ontology = Oeso.class,
        resource = "Experiment",
        graph = "set/experiments",
        prefix = "expe"
)
public class ExperimentModel extends SPARQLResourceModel implements ClassURIGenerator<ExperimentModel> {

    @SPARQLProperty(
            ontology = RDFS.class,
            property = "label",
            required = true
    )
    String label;
    public static final String LABEL_VAR = "label";

    @SPARQLProperty(
            ontology = Oeso.class,
            property = "hasProject"
    )
    List<ProjectModel> projects = new LinkedList<>();
    public static final String PROJECT_URI_SPARQL_VAR = "project";

    @SPARQLProperty(
            ontology = Oeso.class,
            property = "startDate",
            required = true
    )
    LocalDate startDate;
    public static final String START_DATE_SPARQL_VAR = "startDate";

    @SPARQLProperty(
            ontology = Oeso.class,
            property = "endDate"
    )
    LocalDate endDate;
    public static final String END_DATE_SPARQL_VAR = "endDate";

    @SPARQLProperty(
            ontology = Oeso.class,
            property = "hasObjective"
    )
    String objective;
    public static final String OBJECTIVE_SPARQL_VAR = "objective";

    @SPARQLProperty(
            ontology = Oeso.class,
            property = "hasKeyword"
    )
    List<String> keywords = new LinkedList<>();
    public static final String KEYWORD_SPARQL_VAR = "keyword";

    @SPARQLProperty(
            ontology = RDFS.class,
            property = "comment"
    )
    String comment;
    public static final String COMMENT_SPARQL_VAR = "comment";

    @SPARQLProperty(
            ontology = Oeso.class,
            property = "isPublic"
    )
    protected Boolean isPublic;
    public static final String IS_PUBLIC_SPARQL_VAR = "isPublic";

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<ProjectModel> getProjects() {
        return projects;
    }

    public void setProjects(List<ProjectModel> projects) {
        this.projects = projects;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Boolean getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(Boolean isPublic) {
        this.isPublic = isPublic;
    }

    @Override
    public String[] getUriSegments(ExperimentModel instance) {
        return new String[]{
            instance.getLabel()
        };
    }
}
