<template>
  <div id="footer">
    <span class="text-center">© OpenSILEX - Sixtine v.1.0.0</span>
  </div>
</template>

<script lang="ts">
import { Component } from "vue-property-decorator";
import Vue from "vue";

@Component
export default class SixtineFooterComponent extends Vue {}
</script>

<style scoped lang="scss">
@import "../../../theme/sixtine/variables.scss";

#footer {
  background-color: var(--highlightBackgroundColorLight);
  color: var(--defaultColorDark);
}

#footer {
  padding: 15px;
  text-align: center;
}
</style>
