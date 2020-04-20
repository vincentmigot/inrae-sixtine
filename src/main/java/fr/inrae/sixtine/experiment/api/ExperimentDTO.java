//******************************************************************************
//                          ExperimentDTO.java
// OpenSILEX - Licence AGPL V3.0 - https://www.gnu.org/licenses/agpl-3.0.en.html
// Copyright © INRAE 2020
// Contact: renaud.colin@inrae.fr, anne.tireau@inrae.fr, pascal.neveu@inrae.fr
//******************************************************************************
package fr.inrae.sixtine.experiment.api;

import io.swagger.annotations.ApiModelProperty;
import fr.inrae.sixtine.experiment.dal.ExperimentModel;

import java.net.URI;
import java.util.LinkedList;
import java.util.List;
import org.opensilex.server.rest.validation.Required;
import org.opensilex.server.rest.validation.DateConstraint;

/**
 * @author Renaud COLIN A basic DTO class about an {@link ExperimentModel}
 */
public abstract class ExperimentDTO {

    protected URI uri;

    protected String label;

    protected URI type;

    protected String typeLabel;

    protected List<URI> infrastructures = new LinkedList<>();

    protected List<URI> projects = new LinkedList<>();

    protected String startDate;

    protected String endDate;

    protected String objective;

    protected String comment;

    protected List<String> keywords = new LinkedList<>();

    protected Boolean isPublic;

    public URI getUri() {
        return uri;
    }

    public ExperimentDTO setUri(URI uri) {
        this.uri = uri;
        return this;
    }

    public URI getType() {
        return type;
    }

    public void setType(URI type) {
        this.type = type;
    }

    public String getTypeLabel() {
        return typeLabel;
    }

    public void setTypeLabel(String typeLabel) {
        this.typeLabel = typeLabel;
    }

    @Required
    @ApiModelProperty(example = "ZA17")
    public String getLabel() {
        return label;
    }

    public ExperimentDTO setLabel(String label) {
        this.label = label;
        return this;
    }

    public List<URI> getInfrastructures() {
        return infrastructures;
    }

    public void setInfrastructures(List<URI> infrastructures) {
        this.infrastructures = infrastructures;
    }

    @ApiModelProperty(example = "http://www.phenome-fppn.fr/id/species/zeamays")
    public List<URI> getProjects() {
        return projects;
    }

    public ExperimentDTO setProjects(List<URI> projects) {
        this.projects = projects;
        return this;
    }

    @Required
    @ApiModelProperty(example = "2020-02-20")
    @DateConstraint
    public String getStartDate() {
        return startDate;
    }

    public ExperimentDTO setStartDate(String startDate) {
        this.startDate = startDate;
        return this;
    }

    @ApiModelProperty(example = "2020-02-20")
    @DateConstraint
    public String getEndDate() {
        return endDate;
    }

    public ExperimentDTO setEndDate(String endDate) {
        this.endDate = endDate;
        return this;
    }

    @ApiModelProperty(example = "objective")
    public String getObjective() {
        return objective;
    }

    public ExperimentDTO setObjective(String objective) {
        this.objective = objective;
        return this;
    }

    @ApiModelProperty(example = "comment")
    public String getComment() {
        return comment;
    }

    public ExperimentDTO setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public ExperimentDTO setKeywords(List<String> keywords) {
        this.keywords = keywords;
        return this;
    }

    @ApiModelProperty(example = "true")
    public Boolean getIsPublic() {
        return isPublic;
    }

    public ExperimentDTO setIsPublic(Boolean isPublic) {
        this.isPublic = isPublic;
        return this;
    }

}
