<template>
  <b-modal ref="modalRef" size="xl" :static="true">
    <template v-slot:modal-title>
      <i>
        <font-awesome-icon icon="vials" />
        {{ $t('component.experiment.form-wizard.label') }}
      </i>
    </template>
    <form-wizard title subtitle ref="experimentCreateFormWizard" shape="square" color="#00a38d">
      <tab-content v-bind:title="$t('component.experiment.form-wizard.general-informations')">
        <inrae-sixtine-ExperimentFormGeneral :form="form" ref="experimentForm"></inrae-sixtine-ExperimentFormGeneral>
      </tab-content>

      <tab-content v-bind:title="$t('component.experiment.form-wizard.infra-groups-projects')">
        <inrae-sixtine-ExperimentFormAccess :form="form" ref="experimentForm"></inrae-sixtine-ExperimentFormAccess>
      </tab-content>

      <template slot="footer" slot-scope="props">
        <footer class="modal-footer modal-footer-replacement">
          <div class="wizard-footer-left">
            <b-button
              variant="secondary"
              @click="hideForm"
            >{{$t('component.common.form-wizard.cancel')}}</b-button>
          </div>

          <div class="wizard-footer-right">
            <b-button-group>
              <b-button
                variant="success"
                v-if="props.activeTabIndex > 0"
                @click="props.prevTab()"
              >{{$t('component.common.form-wizard.previous')}}</b-button>
              <b-button
                v-if="!props.isLastStep"
                variant="primary"
                @click="props.nextTab()"
              >{{$t('component.common.form-wizard.next')}}</b-button>
              <b-button
                v-if="props.isLastStep"
                @click="hideForm"
                variant="primary"
              >{{$t('component.common.form-wizard.done')}}</b-button>
            </b-button-group>
          </div>
        </footer>
      </template>
    </form-wizard>
  </b-modal>
</template>

<script lang="ts">
import { Component, Ref, Prop } from "vue-property-decorator";
import Vue from "vue";

import { ExperimentCreationDTO, GenericExperimentsService } from "../../lib";
import HttpResponse, { OpenSilexResponse } from "../../lib/HttpResponse";

@Component
export default class ExperimentCreate extends Vue {
  $opensilex: any;
  $store: any;
  $i18n: any;
  service: GenericExperimentsService;

  editMode = false;

  form: ExperimentCreationDTO = {
    uri: null,
    label: null,
    type: null,
    typeLabel: null,
    infrastructures: [],
    projects: [],
    startDate: null,
    endDate: null,
    objective: "",
    comment: "",
    keywords: [],
    isPublic: false,
    properties: []
  };

  get user() {
    return this.$store.state.user;
  }

  get credentials() {
    return this.$store.state.credentials;
  }

  created() {
    this.service = this.$opensilex.getService(
      "opensilex.GenericExperimentsService"
    );
  }

  @Ref("modalRef") readonly modalRef!: any;

  public showCreateForm() {
    this.modalRef.show();
  }

  public hideForm() {
    this.modalRef.hide();
  }

  onComplete() {
    if (this.editMode) {
      this.callUpdateExperimentService(this.form);
    } else {
      this.callCreateExperimentService(this.form);
    }
  }

  callCreateExperimentService(form: ExperimentCreationDTO) {
    this.service
      .createExperiment(form)
      .then((http: HttpResponse<OpenSilexResponse<any>>) => {
        let uri = http.response.result;
        console.debug("experiment created", uri);
        this.$router.push({ path: "/experiments" });
      })
      .catch(this.$opensilex.errorHandler);
  }

  callUpdateExperimentService(form: ExperimentCreationDTO) {
    this.service
      .updateExperiment(form)
      .then((http: HttpResponse<OpenSilexResponse<any>>) => {
        let uri = http.response.result;
        console.debug("experiment updated", uri);
        this.$router.push({ path: "/experiments" });
      })
      .catch(this.$opensilex.errorHandler);
  }
}
</script>

<style scoped lang="scss">
::v-deep .modal-body {
  padding-top: 0;
  padding-bottom: 0;
}

::v-deep .modal-footer {
  display: none;
}

::v-deep .wizard-header {
  display: none;
}

::v-deep .wizard-tab-content {
  padding-top: 5px;
}

.modal-footer-replacement {
  position: absolute;
  display: block;
  width: 100%;
  left: 0;
  bottom: 0;
}

::v-deep .vue-form-wizard {
  padding-bottom: 50px;
}
</style>

