(ns clojurescript.aboutme
  (:require [reagent.core :as r]
            [clojurescript.state :as state]))

(def ReactNative (js/require "react-native"))
(def expo (js/require "expo"))
(def AtExpo (js/require "@expo/vector-icons"))
(def ionicons (.-Ionicons AtExpo))
(def ic (r/adapt-react-class ionicons))

(def text (r/adapt-react-class (.-Text ReactNative)))
(def view (r/adapt-react-class (.-View ReactNative)))
(def image (r/adapt-react-class (.-Image ReactNative)))
(def touchable-highlight (r/adapt-react-class (.-TouchableHighlight ReactNative)))

(defn Aboutme []
  [view {:style {:flex 1
                 :align-items "center"
                 :justify-content "center"}}
    [text "ABOUT ME"]
    [text (@state/home :number)]])
