//******************************************************************************
//                          ExperimentGetDTO.java
// OpenSILEX - Licence AGPL V3.0 - https://www.gnu.org/licenses/agpl-3.0.en.html
// Copyright © INRAE 2020
// Contact: renaud.colin@inra.fr, anne.tireau@inra.fr, pascal.neveu@inra.fr
//******************************************************************************
package fr.inrae.sixtine.experiment.api;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import fr.inrae.sixtine.experiment.dal.ExperimentModel;
import org.opensilex.sparql.model.SPARQLResourceModel;

/**
 *
 * A basic GetDTO which extends the {@link ExperimentDTO} and which add the conversion from
 * an {@link ExperimentModel} to a {@link ExperimentGetDTO}
 *
 *  @author Vincent MIGOT
 *  @author Renaud COLIN
 */
public class ExperimentGetDTO extends ExperimentDTO {

    protected static List<URI> getUriList(List<? extends SPARQLResourceModel> models) {

        if (models == null || models.isEmpty()) {
            return Collections.emptyList();
        }
        return models.stream().map(SPARQLResourceModel::getUri)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public static ExperimentGetDTO fromModel(ExperimentModel model) {

        ExperimentGetDTO dto = new ExperimentGetDTO();

        dto.setUri(model.getUri())
                .setLabel(model.getLabel())
                .setStartDate(model.getStartDate().toString())
                .setObjective(model.getObjective())
                .setComment(model.getComment())
                .setKeywords(model.getKeywords())
                .setIsPublic(model.getIsPublic());

        if (model.getEndDate() != null) {
            dto.setEndDate(model.getEndDate().toString());
        }

        return dto;
    }
}
