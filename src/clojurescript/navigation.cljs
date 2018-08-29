(ns clojurescript.navigation
  (:require [reagent.core :as r]
            [clojurescript.home :refer [Home]]
            [clojurescript.aboutme :refer [Aboutme]]
            [clojurescript.react-requires :refer [Ic CreateStackNavigator CreateBottomTabNavigator Text]]))



(defn title-bar []
    (clj->js {:title "WTF IT'S WORKS"}))

(def routes #js {:HomeScreen #js {:screen (r/reactify-component Home)
                                  :navigationOptions title-bar}
                 :AboutScreen #js {:screen (r/reactify-component Aboutme)}})

(def HomeStack (CreateStackNavigator.
                  routes
                  #js {:initialRouteName "HomeScreen"}))

(def home-tabBar #js {:tabBarLabel "Home"})
                      ; :tabBarIcon (fn []
                                      ; [Ic {:name "ios-home"
                                           ; :color "red"
                                           ; :size 26}])})

(def Tabs (CreateBottomTabNavigator #js {:FirstTab (r/reactify-component HomeStack)}
                                    #js {:navigationOptions home-tabBar
                                         :tabBarOptions #js {:activeTintColor "red"
                                                             :inactiveTintColor "gray"}}))

(def routing (r/adapt-react-class Tabs))

(defn Nav []
    [routing {:persistenceKey "NavigationState"}])
