<template>
  <div>
    <ValidationObserver ref="validatorRef">
      <b-form>
        <b-form-group
          :label="$t('component.menu.infrastructures') + ':'"
          label-for="infrastructures"
        >
          <treeselect
            id="infrastructures"
            :multiple="true"
            :options="infraOptions"
            :placeholder="$t('component.experiment.form-infrastructure-placeholder')"
            value-consists-of="LEAF_PRIORITY"
            v-model="form.infrastructures"
          />
        </b-form-group>
        <b-form-group :label="$t('component.menu.projects') + ':'" label-for="projects">
          <multiselect
            id="projects"
            v-model="form.projects"
            @search-change="searchProject"
            :options="projectOptions"
            :internal-search="false"
            :hide-selected="true"
            :loading="isProjectLoading"
          ></multiselect>
        </b-form-group>
        <b-form-group :label="$t('component.infrastructure.teams') + ':'" label-for="teams">
          <treeselect
            id="teams"
            :multiple="true"
            :options="infraOptions"
            :placeholder="$t('component.experiment.form-team-placeholder')"
            value-consists-of="LEAF_PRIORITY"
            v-model="form.groups"
          />
        </b-form-group>
      </b-form>
    </ValidationObserver>
  </div>
</template>

<script lang="ts">
import { Component, Prop } from "vue-property-decorator";
import Vue from "vue";
import VueRouter from "vue-router";

import {
  SpeciesService,
  SpeciesDTO,
  ResourceTreeDTO,
  InfrastructuresService,
  ProjectGetDTO,
  ProjectsService
} from "opensilex-core/index";
import HttpResponse, { OpenSilexResponse } from "opensilex-core/HttpResponse";
import Oeso from "../../../../../opensilex-front/front/src/ontologies/Oeso";
import { ExperimentCreationDTO } from "../../lib";

@Component
export default class ExperimentFormAccess extends Vue {
  $opensilex: any;
  $store: any;
  $router: VueRouter;
  $i18n: any;

  infraService: InfrastructuresService;

  projectService: ProjectsService;

  infraOptions = [];

  projectOptions = [];

  isProjectLoading = false;

  public created() {
    this.infraService = this.$opensilex.getService(
      "opensilex-core.InfrastructuresService"
    );
    this.projectService = this.$opensilex.getService(
      "opensilex-core.ProjectsService"
    );
    this.refresh();
  }

  private refresh() {
    this.infraService
      .searchInfrastructuresTree()
      .then((http: HttpResponse<OpenSilexResponse<Array<ResourceTreeDTO>>>) => {
        let infrastructures = http.response.result;
        this.infraOptions = this.$opensilex.buildTreeListOptions(
          infrastructures
        );
      })
      .catch(this.$opensilex.errorHandler);
  }

  @Prop()
  form: ExperimentCreationDTO;

  get user() {
    return this.$store.state.user;
  }

  searchProject(query) {
    console.error(query);
    this.isProjectLoading = true;
    this.projectService
      .searchProjects()
      .then((http: HttpResponse<OpenSilexResponse<Array<ProjectGetDTO>>>) => {
        this.projectOptions = http.response.result;
        this.isProjectLoading = false;
      })
      .catch(this.$opensilex.errorHandler);
  }
}
</script>

<style scoped lang="scss">
</style>
