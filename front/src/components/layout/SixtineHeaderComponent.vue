<template>
  <div id="header">
    <div class="app-logo">
      <router-link to="/">
        <img v-bind:src="$opensilex.getResourceURI('images/logo-sixtine.png')" />
        <div class="app-title">Sixtine</div>
      </router-link>
    </div>

    <div class="app-actions">
      <div class="language-selector">
        <b-dropdown variant="link" size="lg" right>
          <template v-slot:button-content>
            <div class="language-selector-button">
              <span class="action-label">{{ $t('component.header.language.' + language) }}</span>&nbsp;
              <i class="icon ik ik-globe"></i>
            </div>
          </template>

          <b-dropdown-item
            v-for="item in languages"
            :key="`language-${item}`"
            href="#"
            @click.prevent="setLanguage(item)"
          >{{ $t('component.header.language.' + item) }}</b-dropdown-item>
        </b-dropdown>
      </div>
      <b-button class="app-header-btn" variant="link" size="lg" @click.prevent="logout()">
        <span class="action-label">{{$t('component.common.logout')}}</span>&nbsp;
        <font-awesome-icon icon="power-off" />
      </b-button>
    </div>
  </div>
</template>

<script lang="ts">
import { Component } from "vue-property-decorator";
import Vue from "vue";

@Component
export default class SixtineHeaderComponent extends Vue {
  $i18n: any;
  $store: any;
  
  /**
   * Return the current i18n language
   */
  get language() {
    return this.$i18n.locale;
  }

  /**
   * Return all available languages
   */
  get languages() {
    return Object.keys(this.$i18n.messages);
  }

  /**
   * Set the current i18n language
   */
  setLanguage(lang: string) {
    this.$i18n.locale = lang;
    this.$store.commit("lang", lang);
  }

  /**
   * Logout the current connected user -> have to redirected to the login page
   */
  logout() {
    this.$store.commit("logout");
  }
}
</script>

<style scoped lang="scss">
@import "../../../theme/sixtine/variables.scss";

#header {
  background-color: var(--highlightBackgroundColorLight);
  color: var(--defaultColorDark);
  padding: 0px 70px;
  padding-right: 30px;
  text-align: center;
  font-size: 35px;
  display: flex;
  width: 100%;
}

#header > div {
  flex: auto;
  align-items: center;
}

.app-logo {
  text-align: left;
}

.app-actions {
  text-align: right;
  display: flex;
  flex: 1;
}

.action-label {
  font-size: 20x;
}

.app-logo > a > img {
  height: 50px;
}

.app-title {
  font-family: "Eras Light ITC", Arial, Helvetica, sans-serif;
  margin-left: 10px;
  height: 50px;
  display: inline-block;
}

.language-selector {
  flex: 1;
  margin-right: 10px;
}

.language-selector-button {
  display: inline;
}

.logout {
  font-size: 20px;
}

.action-logout-icon,
.action-logout-label {
  vertical-align: middle;
}

.action-logout-icon {
  height: 21px;
}

@media (max-width: 768px) {
  .app-actions span.action-label {
    display: none;
  }
}
</style>