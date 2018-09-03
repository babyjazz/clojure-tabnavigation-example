(ns clojurescript.screen.profile.profile
    (:require [reagent.core :as r]
              [clojurescript.react-requires :refer [View Text TouchableHighlight]]))


(defn Profile []
    (fn [{:keys [navigation]} props]
        [View {:style {:flex 1
                       :justify-content "center"
                       :align-items "center"}}
         [Text "HELLO PROFILE"]
         [TouchableHighlight {:style {:padding 10
                                      :background-color "green"}
                              :on-press #(.navigate navigation "SigninScreen")}
          [Text {:style {:color "white"}} "Sign In"]]]))
