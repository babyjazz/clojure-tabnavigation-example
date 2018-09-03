(ns clojurescript.core
    (:require [reagent.core :as r :refer [atom]]
              [re-frame.core :refer [subscribe dispatch dispatch-sync]]
              [oops.core :refer [ocall]]
              [clojurescript.handlers]
              [clojurescript.subs]
              [clojurescript.react-requires :refer [Expo View Text]]
              [clojurescript.state :as state]
              [clojurescript.navigation :refer [Nav]]))


(defn app-root []
    (let [greeting (subscribe [:get-greeting])]
        (fn []
            [Nav])))

;(def state (atom {:view [view]}))
;(swap! state assoc :view [view])
;if use state as component
;(:view [@state])


(defn init []
        (aset js/console "disableYellowBox" true)
    (dispatch-sync [:initialize-db])
    (ocall Expo "registerRootComponent" (r/reactify-component app-root)))
