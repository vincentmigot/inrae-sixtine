<template>
  <div>
    <ValidationObserver ref="validatorRef">
      <b-form>
        <div :key="index" v-for="(propertyMapping, index) in propertiesMapping">
          <component v-bind:is="propertyMapping.editComponent" :value="objectRelations[index]"></component>
        </div>
      </b-form>
    </ValidationObserver>
  </div>
</template>

<script lang="ts">
import { Component, Prop } from "vue-property-decorator";
import Vue from "vue";
import VueRouter from "vue-router";

import { PropertyMappingDTO } from "opensilex-core/index";
import { PropertiesMapDTO } from "../../lib/model/propertiesMapDTO";

@Component
export default class ExperimentFormDetail extends Vue {
  $opensilex: any;
  $store: any;
  $router: VueRouter;
  $i18n: any;

  @Prop()
  propertiesMapping: Array<PropertyMappingDTO>;

  @Prop()
  objectRelations: PropertiesMapDTO;
}
</script>

<style scoped lang="scss">
</style>
