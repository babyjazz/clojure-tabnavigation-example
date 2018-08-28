(ns clojurescript.react-requires
    (:require [reagent.core :as r]))

(defonce ReactNative (js/require "react-native"))
(defonce Expo (js/require "expo"))
(defonce AtExpo (js/require "@expo/vector-icons"))
(defonce Ionicons (.-Ionicons AtExpo))
(defonce Ic (r/adapt-react-class Ionicons))

(defonce Text (r/adapt-react-class (.-Text ReactNative)))
(defonce View (r/adapt-react-class (.-View ReactNative)))
(defonce Image (r/adapt-react-class (.-Image ReactNative)))
(defonce TouchableHighlight (r/adapt-react-class (.-TouchableHighlight ReactNative)))
(defonce Alert (.-Alert ReactNative))


(defonce ReactNavigation (js/require "react-navigation"))
(defonce CreateStackNavigator (.-createStackNavigator ReactNavigation))
(defonce CreateBottomTabNavigator (.-createBottomTabNavigator ReactNavigation))
