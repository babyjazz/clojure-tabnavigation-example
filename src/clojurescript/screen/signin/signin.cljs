(ns clojurescript.screen.signin.signin
    (:require [reagent.core :as r]
              [clojurescript.react-requires :refer [View Text Ic TouchableOpacity]]))


(defn Signin []
    (fn [{:keys [navigation]} props]
        [View {:style {:flex 1
                       :justify-content "center"
                       :align-items "center"
                       :margin-top 24}}
            [TouchableOpacity {:on-press #(.goBack navigation "")
                                 :style {:position "absolute"
                                         :top 10
                                         :right 10}}
                [Ic {:name "ios-close"
                     :size 28
                     :color "gray"}]]
            [Text "SIGN IN"]]))
