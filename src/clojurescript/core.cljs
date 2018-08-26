(ns clojurescript.core
    (:require [reagent.core :as r :refer [atom]]
              [re-frame.core :refer [subscribe dispatch dispatch-sync]]
              [oops.core :refer [ocall]]
              [clojurescript.handlers]
              [clojurescript.subs]
              [clojurescript.state :as state]
              [clojurescript.navigation :refer [Nav]]))

(def ReactNative (js/require "react-native"))
(def expo (js/require "expo"))
(def AtExpo (js/require "@expo/vector-icons"))
(def ionicons (.-Ionicons AtExpo))
(def ic (r/adapt-react-class ionicons))

(def text (r/adapt-react-class (.-Text ReactNative)))
(def view (r/adapt-react-class (.-View ReactNative)))
(def image (r/adapt-react-class (.-Image ReactNative)))
(def touchable-highlight (r/adapt-react-class (.-TouchableHighlight ReactNative)))
(def Alert (.-Alert ReactNative))

(defn alert [title]
    (.alert Alert title))

(defn app-root []
    (let [greeting (subscribe [:get-greeting])]
        (fn []
            [Nav])))



(defn init []
    (dispatch-sync [:initialize-db])
    (ocall expo "registerRootComponent" (r/reactify-component app-root)))
