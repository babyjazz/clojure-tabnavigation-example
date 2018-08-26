(ns clojurescript.navigation
  (:require [reagent.core :as r]
            [clojurescript.home :refer [Home]]
            [clojurescript.aboutme :refer [Aboutme]]))

(def react-navigation (js/require "react-navigation"))
(def createStackNavigator (.-createStackNavigator react-navigation))


(defn title-bar []
    (clj->js {:title "WTF IT'S WORKS"}))

(def routes #js {:HomeScreen #js {:screen (r/reactify-component Home)
                                  :navigationOptions title-bar}
                 :AboutScreen #js {:screen (r/reactify-component Aboutme)}})

(def Routing (createStackNavigator.
                  routes
                  #js {:initialRouteName "HomeScreen"}))


(def routing (r/adapt-react-class Routing))

(defn Nav []
        [routing])
