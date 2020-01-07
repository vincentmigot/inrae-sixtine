<template>
  <div class="fullmodal" v-if="!user.isLoggedIn() || forceRefresh">
    <div class="authentication-form">
      <b-form @submit.prevent="onLogin" class="fullmodal-form">
        <b-form-group id="login-group" required>
          <b-form-input
            id="email"
            type="email"
            v-model="form.email"
            required
            :placeholder="$t('component.login.input.email')"
          ></b-form-input>
          <i class="ik ik-user"></i>
        </b-form-group>

        <b-form-group id="password-group" required>
          <b-form-input
            id="password"
            type="password"
            v-model="form.password"
            required
            :placeholder="$t('component.login.input.password')"
          ></b-form-input>
          <i class="ik ik-lock"></i>
        </b-form-group>
        <div class="sign-btn text-center">
          <b-button type="submit" variant="primary" v-text="$t('component.login.button.login')"></b-button>
        </div>
      </b-form>
    </div>
  </div>
</template>

<script lang="ts">
import { Component } from "vue-property-decorator";
import Vue from "vue";
import { SecurityService, TokenGetDTO } from "opensilex-rest/index";
import HttpResponse, { OpenSilexResponse } from "opensilex-rest/HttpResponse";
import OpenSilexVuePlugin from "../../../../../opensilex-front/front/src/models/OpenSilexVuePlugin";
import { User } from "../../../../../opensilex-front/front/src/models/User";
import DefaultLoginComponent from "../../../../../opensilex-front/front/src/components/layout/DefaultLoginComponent.vue";

@Component
export default class SixtineLoginComponent extends DefaultLoginComponent {
}
</script>

<style scoped lang="scss">
.fullmodal {
  display: block;
  position: absolute;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  height: 100%;
  width: 100%;
  z-index: 9999;
}
</style>
