(ns clojurescript.screen.notification.notification
    (:require [reagent.core :as r :refer [atom]]
              [clojurescript.react-requires :refer [Alert TouchableHighlight View Text]]))

(def string-url "http://www.mocky.io/v2/5b8d3fcf3300005400c1592d")
(def date-url "http://date.jsontest.com/")
(def ip-url "http://ip.jsontest.com/")
(def simple-url "http://echo.jsontest.com/key/value/one/two")

(def endpoint-value (atom {:ip "NO IP"}))

(defn get-date []
    (-> (js/fetch ip-url)
        (.then #(.json %))
        (.then (fn [r]
                 (swap! endpoint-value assoc :ip r.ip)))))

(defn Notification []
    [View {:style {:flex 1
                   :justify-content "center"
                   :align-items "center"}}
        [Text {:style {:font-size 26}} "Example of fetching API"]
        [TouchableHighlight {:on-press #(get-date)
                             :style {:padding 10
                                     :background-color "green"}}
            [Text {:style {:color "white" }} "FETCH DATA"]]
        [Text {:style {:margin-top 20
                       :font-size 24}} (@endpoint-value :ip)]])
