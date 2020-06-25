<template>
  <div class="fullmodal" v-if="!user.isLoggedIn() || forceRefresh">
    <ValidationObserver ref="validatorRef">
      <b-form @submit.prevent="onLogin" class="fullmodal-form">
        <div class="login-header">
          <img v-bind:src="$opensilex.getResourceURI('images/logo-sixtine.png')" alt="sixtine-logo" />
          <h2>{{$t('sixtine.title')}}</h2>
        </div>

        <div class="login-form-content">
          <p>{{$t('sixtine.login.info')}}:</p>
          <b-form-group id="login-group" required>
            <ValidationProvider
              :name="$t('component.login.validation.email')"
              rules="required|emailOrUrl"
              v-slot="{ errors }"
            >
              <b-form-input
                id="email"
                type="email"
                v-model="form.email"
                required
                :placeholder="$t('component.login.input.email')"
              ></b-form-input>
              <i class="ik ik-user"></i>
              <div class="error-message alert alert-danger">{{ errors[0] }}</div>
            </ValidationProvider>
          </b-form-group>

          <b-form-group id="password-group" required>
            <ValidationProvider
              :name="$t('component.login.validation.password')"
              rules="required"
              v-slot="{ errors }"
            >
              <b-form-input
                id="password"
                type="password"
                v-model="form.password"
                required
                :placeholder="$t('component.login.input.password')"
              ></b-form-input>
              <i class="ik ik-lock"></i>
              <div class="error-message alert alert-danger">{{ errors[0] }}</div>
            </ValidationProvider>
          </b-form-group>
          <div class="sign-btn text-center">
            <b-button type="submit" variant="primary" v-text="$t('component.login.button.login')"></b-button>
          </div>
        </div>
      </b-form>
    </ValidationObserver>
  </div>
</template>

<script lang="ts">
import { Component, Ref } from "vue-property-decorator";
import { TokenGetDTO } from "opensilex-security/index";
import HttpResponse, {
  OpenSilexResponse
} from "opensilex-security/HttpResponse";
import Vue from "vue";

@Component
export default class SixtineLoginComponent extends Vue {
  get form() {
    return {
      email: "",
      password: ""
    };
  }

  $store: any;
  $t: any;
  $router: any;

  get user() {
    return this.$store.state.user;
  }

  $opensilex: any;

  static async asyncInit($opensilex) {
    await $opensilex.loadService("opensilex-security.AuthenticationService");
  }

  @Ref("validatorRef") readonly validatorRef!: any;

  forceRefresh = false;
  onLogin() {
    let validatorRef: any = this.validatorRef;
    validatorRef.validate().then(isValid => {
      if (isValid) {
        this.$opensilex.showLoader();
        this.$opensilex
          .getService("opensilex-security.AuthenticationService")
          .authenticate({
            identifier: this.form.email,
            password: this.form.password
          })
          .then((http: HttpResponse<OpenSilexResponse<TokenGetDTO>>) => {
            let user = this.$opensilex.fromToken(http.response.result.token);
            this.$opensilex.setCookieValue(user);
            this.forceRefresh = true;
            this.$store.commit("login", user);
            this.$store.commit("refresh");
          })
          .catch(error => {
            if (error.status == 403) {
              console.error("Invalid credentials", error);
              this.$opensilex.errorHandler(
                error,
                this.$t("component.login.errors.invalid-credentials")
              );
            } else {
              this.$opensilex.errorHandler(error);
            }
            this.$opensilex.hideLoader();
          });
      }
    });
  }
}
</script>

<style scoped lang="scss">
@import "../../../theme/sixtine/variables.scss";

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
  background-color: getVar("--backgroundColor");
}

.fullmodal-form {
  position: relative;
  margin: auto;
  padding: 15px;
}

h2 {
  font-family: "Eras Light ITC", Arial, Helvetica, sans-serif;
  font-size: 40px;
  font-weight: bold;
}

.login-form-content {
  max-width: 500px;
  margin-left: auto;
  margin-right: auto;
  margin-top: 20px;
}

i {
  position: absolute;
  top: 11px;
  left: 11px;
}

input {
  padding-left: 35px;
}

fieldset {
  position: relative;
}

.login-header {
  text-align: center;
}

.login-header > img {
  height: 140px;
}

.login-form-content .error-message {
  top: 37px;
}

.login-form-content fieldset {
  margin-bottom: 25px;
}

</style>
