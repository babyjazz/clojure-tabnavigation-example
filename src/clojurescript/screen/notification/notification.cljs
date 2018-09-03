(ns clojurescript.screen.notification.notification
    (:require [reagent.core :as r]
              [clojurescript.react-requires :refer [View Text]]))


(defn Notification []
    [View {:style {:flex 1
                   :justify-content "center"
                   :align-items "center"}}
        [Text "HELLO NOTIFICATION"]])
