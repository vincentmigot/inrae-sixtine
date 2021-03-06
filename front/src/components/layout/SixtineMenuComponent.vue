<template>
  <div class="app-sidebar">
    <div class="hamburger-container">
      <button
        class="hamburger hamburger--collapse"
        v-bind:class="{ 'is-active': menuVisible }"
        type="button"
        @click="toggleMenu()"
      >
        <span class="hamburger-box">
          <span class="hamburger-inner"></span>
        </span>
      </button>
    </div>

    <div class="sidebar-content" v-bind:class="{ 'invisible': !menuVisible }">
      <nav id="main-menu-navigation" class="navigation-main">
        <div li v-for="item in menu" v-bind:key="item.id" class="nav-item">
          <span v-if="!item.route">
            <i class="ik" v-bind:class="getIcon(item)"></i>&nbsp;
            <span>{{ $t(item.label) }}</span>
          </span>
          <router-link v-else :to="item.route.path">
            <i class="ik" v-bind:class="getIcon(item)"></i>&nbsp;
            <span>{{ $t(item.label) }}</span>
          </router-link>
          <div v-for="itemChild in item.children" v-bind:key="itemChild.id" class="submenu-content">
            <span v-if="!itemChild.route">
              <i class="ik" v-bind:class="getIcon(itemChild)"></i>&nbsp;
              <span>{{ $t(itemChild.label) }}</span>
            </span>
            <router-link v-else :to="itemChild.route.path">
              <i class="ik" v-bind:class="getIcon(itemChild)"></i>&nbsp;
              <span>{{ $t(itemChild.label) }}</span>
            </router-link>
          </div>
        </div>
      </nav>
    </div>
  </div>
</template>

<script lang="ts">
import { Component } from "vue-property-decorator";
import Vue from "vue";

@Component
export default class SixtineMenuComponent extends Vue {
  $store: any;
  $t: any;

  width;

  created() {
    window.addEventListener("resize", this.handleResize);
    this.handleResize();
  }

  beforeDestroy() {
    window.removeEventListener("resize", this.handleResize);
  }

  handleResize() {
    const minSize = 768;
    if (
      document.body.clientWidth <= minSize &&
      (this.width == null || this.width > minSize)
    ) {
      this.width = document.body.clientWidth;
      this.$store.commit("hideMenu");
    } else if (
      document.body.clientWidth > minSize &&
      (this.width == null || this.width <= minSize)
    ) {
      this.width = document.body.clientWidth;
      this.$store.commit("showMenu");
    }
  }

  $route: any;

  get menu(): Array<any> {
    return this.$store.state.menu;
  }

  get user() {
    return this.$store.state.user;
  }

  get menuVisible(): boolean {
    return this.$store.state.menuVisible;
  }

  toggleMenu(): void {
    this.$store.commit("toggleMenu");
  }

  toogle(item: any, event: MouseEvent): void {
    if (item.hasChildren()) {
      console.info("toogle menu, old value = " + item.showChildren);
      item.showChildren = !item.showChildren;
    }
  }

  getIcon(item: any): string {
    var code = "icon." + item.label;
    var result = this.$t(code);
    if (code != result) {
      return result.toString();
    }
    return "ik-folder";
  }

  isActive(item: any): boolean {
    return item.route && this.$route.path.indexOf(item.route.path) === 0;
  }
}
</script>

<style scoped lang="scss">
@import "../../../theme/sixtine/variables.scss";

.sidebar-content {
  height: 100%;
  padding: 15px;
  background-color: getVar(--highlightBackgroundColorDark);
  color: getVar(--defaultColorLight);
}

.sidebar-content.invisible {
  display: none;
}

.nav-item a,
.nav-item > span,
.nav-item > i {
  white-space: nowrap;
  color: getVar(--defaultColorLight);
}

.nav-item a,
.nav-item > span {
  font-size: 14px;
}

.nav-item a:hover,
.nav-item a:hover i {
  color: getVar(--highlightColorLight);
  transition: color 0.1s ease;
}

.nav-item > span {
  padding-top: 6px;
  display: inline-block;
  cursor: default;
}

.nav-item .submenu-content {
  margin-left: 10px;
}

nav > .nav-item > span {
  color: getVar(--highlightColorLight);
}

.hamburger-container {
  position: absolute;
  top: 0;
  left: 0;
  z-index: 1;
  -webkit-user-select: none;
  user-select: none;
  background: getVar(--highlightBackgroundColorLight);
  height: 54px;
  width: 70px;
}

.hamburger {
  position: relative;
  height: 55px;
  top: 1px;
}

.hamburger {
  outline: none;
}

.hamburger .hamburger-inner,
.hamburger .hamburger-inner::after,
.hamburger .hamburger-inner::before,
.hamburger.is-active .hamburger-inner,
.hamburger.is-active .hamburger-inner::after,
.hamburger.is-active .hamburger-inner::before {
  background-color: getVar(--linkColor);
}

.hamburger:hover .hamburger-inner,
.hamburger:hover .hamburger-inner::after,
.hamburger:hover .hamburger-inner::before,
.hamburger.is-active:hover .hamburger-inner,
.hamburger.is-active:hover .hamburger-inner::after,
.hamburger.is-active:hover .hamburger-inner::before {
  background-color: getVar(--linkHighlightColor);
}

.hamburger.is-active:hover,
.hamburger:hover {
  opacity: 1;
}

.hamburger-box {
  width: 35px;
}

.hamburger-inner,
.hamburger-inner:after,
.hamburger-inner:before {
  width: 35px;
}
</style>
