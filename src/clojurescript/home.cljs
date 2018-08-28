(ns clojurescript.home
    (:require [reagent.core :as r :refer [atom]]
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

; def will reset after save
(def local-state (atom 0))


(defn Home [props]
    (fn [{:keys [navigation]} props]
        [view {:style {:flex 1
                       :align-items "center"
                       :justify-content "center"}}
         [text ":foo " (@state/app-state :foo)]
         [text ":bar :zoo " (get-in @state/app-state [:bar :zoo])]
         [text "home string ==>> " (get-in @state/home [:number])]
         [text "nested string ==>> " (get-in @state/home [:str-in :sub-str])]
         [ic {:name "ios-home"
              :color "black"}]
         [text "tt " @local-state]
         [touchable-highlight {:style {:padding 20
                                       :background-color "purple"}
                               :on-press #(swap! local-state inc)}
          [text {:style {:color "white"}} "INCRE"]]
         [touchable-highlight {:style {:padding 20
                                       :background-color "purple"}
                               :on-press #(swap! state/home assoc-in [:str-in :sub-str] "new nested str")}
          [text {:style {:color "white"}} "ADD HOME NESTED STR"]]
         [touchable-highlight {:style {:padding 20
                                       :background-color "blue"}
                               :on-press #(swap! state/home assoc :number "HELOLOLOL")}
          [text {:style {:color "white"}} "ADD HOME NUMBER"]]
         [touchable-highlight {:style {:padding 20
                                       :background-color "gray"}
                               :on-press #(swap! state/app-state update-in [:foo] inc)}
          [text {:style {:color "white"}} "ADD FOO"]]
         [touchable-highlight {:style {:padding 20
                                       :background-color "green"}
                               :on-press #(swap! state/app-state update-in [:bar :zoo] inc)}
          [text {:style {:color "white"}} "ADD BAR"]]
         [touchable-highlight {:style {:padding 20
                                       :background-color "orange"}
                               :on-press #(.navigate navigation "AboutScreen")}
          [text {:style {:color "white"}} "GO TO ABOUTME"]]]))
