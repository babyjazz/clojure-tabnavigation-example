(ns clojurescript.state
  (:require [reagent.core :as r :refer [atom]]))

(defonce app-state
    (atom {:foo 0 :bar {:zoo 0}}))

; defonce will not reset state after saved
(defonce home
    (atom {:number "initial number" :str-in {:sub-str "init nested str"}}))

(defonce aboutme
    (atom {:number 1}))

(comment
    (swap! app-state update-in [:foo] inc))
