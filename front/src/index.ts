/// <reference path="../../../opensilex-security/front/types/opensilex-security.d.ts" />
/// <reference path="../../../opensilex-core/front/types/opensilex-core.d.ts" />
import { ApiServiceBinder } from './lib';
import SixtineLoginComponent from "./components/layout/SixtineLoginComponent.vue";
import SixtineFooterComponent from "./components/layout/SixtineFooterComponent.vue";
import SixtineMenuComponent from "./components/layout/SixtineMenuComponent.vue";
import SixtineHeaderComponent from "./components/layout/SixtineHeaderComponent.vue";
import SixtineHomeComponent from "./components/layout/SixtineHomeComponent.vue";
import ExperimentView from "./components/experiments/ExperimentView.vue";
import ExperimentCreate from "./components/experiments/ExperimentCreate.vue";
import ExperimentFormGeneral from "./components/experiments/ExperimentFormGeneral.vue";
import ExperimentFormDetail from "./components/experiments/ExperimentFormDetail.vue";
import ExperimentFormAccess from "./components/experiments/ExperimentFormAccess.vue";

export default {
    install(Vue, options) {
        ApiServiceBinder.with(Vue.$opensilex.getServiceContainer());
    },
    components: {
        "inrae-sixtine-SixtineHomeComponent": SixtineHomeComponent,
        "inrae-sixtine-SixtineLoginComponent": SixtineLoginComponent,
        "inrae-sixtine-SixtineFooterComponent": SixtineFooterComponent,
        "inrae-sixtine-SixtineMenuComponent": SixtineMenuComponent,
        "inrae-sixtine-SixtineHeaderComponent": SixtineHeaderComponent,
        "inrae-sixtine-ExperimentView": ExperimentView,
        "inrae-sixtine-ExperimentCreate": ExperimentCreate,
        "inrae-sixtine-ExperimentFormGeneral": ExperimentFormGeneral,
        "inrae-sixtine-ExperimentFormDetail": ExperimentFormDetail,
        "inrae-sixtine-ExperimentFormAccess": ExperimentFormAccess,
    },
    lang: {
        "fr": require("./lang/sixtine-fr.json"),
        "en": require("./lang/sixtine-en.json"),
    }
};