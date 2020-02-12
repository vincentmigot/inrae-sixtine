/// <reference path="../../../opensilex-rest/front/types/opensilex-rest.d.ts" />
import SixtineLoginComponent from "./components/layout/SixtineLoginComponent.vue";
import SixtineFooterComponent from "./components/layout/SixtineFooterComponent.vue";
import SixtineMenuComponent from "./components/layout/SixtineMenuComponent.vue";
import SixtineHeaderComponent from "./components/layout/SixtineHeaderComponent.vue";
import SixtineHomeComponent from "./components/layout/SixtineHomeComponent.vue";

export default {
    install(Vue, options) {
    },
    components: {
        "inrae-sixtine-SixtineHomeComponent": SixtineHomeComponent,
        "inrae-sixtine-SixtineLoginComponent": SixtineLoginComponent,
        "inrae-sixtine-SixtineFooterComponent": SixtineFooterComponent,
        "inrae-sixtine-SixtineMenuComponent": SixtineMenuComponent,
        "inrae-sixtine-SixtineHeaderComponent": SixtineHeaderComponent
    },
    lang: {
        "fr": require("./lang/sixtine-fr.json"),
        "en-US": require("./lang/sixtine-en-US.json"),
    }
};