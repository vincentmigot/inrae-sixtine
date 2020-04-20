<template>
  <div class="container-fluid">
    <opensilex-PageHeader
      icon="ik-layers"
      title="component.menu.experiments"
      description="component.experiment.search.description"
    ></opensilex-PageHeader>
    <div class="card">
      <div class="card-header row clearfix">
        <div class="col col-sm-3">
          <div class="card-options d-inline-block">
            <b-button
              @click="showCreateForm"
              variant="primary"
              v-if="user.hasCredential(credentials.CREDENTIAL_EXPERIMENT_MODIFICATION_ID)"
            >
              <i class="ik ik-plus"></i>
              {{$t('component.experiment.search.buttons.create-experiment')}}
            </b-button>
          </div>
        </div>
      </div>
    </div>
    <div class="card-body p-0">
      <div class="table-responsive">
        TODO LIST EXPE
      </div>
    </div>
    <inrae-sixtine-ExperimentCreate
      ref="experimentCreateForm"
      v-if="user.hasCredential(credentials.CREDENTIAL_EXPERIMENT_MODIFICATION_ID)"
    ></inrae-sixtine-ExperimentCreate>
  </div>
</template>

<script lang="ts">
import { Component, Ref } from "vue-property-decorator";
import Vue from "vue";

@Component
export default class ExperimentView extends Vue {
  get user() {
    return this.$store.state.user;
  }

  get credentials() {
    return this.$store.state.credentials;
  }

  @Ref("experimentCreateForm") readonly experimentCreateForm!: any;

  showCreateForm() {
    this.experimentCreateForm.showCreateForm();
  }
}
</script>

<style scoped lang="scss">
</style>
