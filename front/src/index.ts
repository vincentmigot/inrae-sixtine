/// <reference path="../../../opensilex-rest/front/types/opensilex-rest.d.ts" />
import SixtineLoginComponent from "./components/layout/SixtineLoginComponent.vue";
import SixtineFooterComponent from "./components/layout/SixtineFooterComponent.vue";
import SixtineMenuComponent from "./components/layout/SixtineMenuComponent.vue";
import SixtineHeaderComponent from "./components/layout/SixtineHeaderComponent.vue";

export default {
    install(Vue, options) {
    },
    components: {
        "inrae-sixtine-SixtineLoginComponent": SixtineLoginComponent,
        "inrae-sixtine-SixtineFooterComponent": SixtineFooterComponent,
        "inrae-sixtine-SixtineMenuComponent": SixtineMenuComponent,
        "inrae-sixtine-SixtineHeaderComponent": SixtineHeaderComponent
    }
};