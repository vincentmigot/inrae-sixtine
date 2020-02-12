<template>
  <div id="header">
    <div class="app-logo">
      <router-link to="/">
        <img v-bind:src="$opensilex.getResourceURI('images/logo-sixtine.png')" />
        <div class="app-title">Sixtine</div>
      </router-link>
    </div>
    <div class="app-logout">
      <a href="#" @click.prevent="logout()">
        <span>{{$t('component.common.logout')}}</span>&nbsp;
        <font-awesome-icon icon="power-off" size="lg" />
      </a>
    </div>
  </div>
</template>

<script lang="ts">
import { Component } from "vue-property-decorator";
import Vue from "vue";
import DefaultHeaderComponent from "../../../../../opensilex-front/front/src/components/layout/DefaultHeaderComponent.vue";

@Component
export default class SixtineHeaderComponent extends DefaultHeaderComponent {}
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

.app-logout {
  text-align: right;
}

.app-logout > a {
  font-size: 24px;
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

@media (max-width: 480px) {
  .app-logout > a > span {
    display: none;
  }
}
</style>