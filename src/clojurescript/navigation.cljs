(ns clojurescript.navigation
    (:require [reagent.core :as r]
              [clojurescript.home :refer [Home]]
              [clojurescript.aboutme :refer [Aboutme]]
              [clojurescript.screen.profile.profile :refer [Profile]]
              [clojurescript.screen.notification.notification :refer [Notification]]
              [clojurescript.screen.signin.signin :refer [Signin]]
              [clojurescript.react-requires :refer [Ic CreateStackNavigator CreateBottomTabNavigator Text AsyncStorage]]))



; HomeStack case refragtor
(def routes #js {:HomeScreen #js {:screen (r/reactify-component Home)
                                  :navigationOptions #js {:title "HOME"}}
                 :AboutScreen #js {:screen (r/reactify-component Aboutme)
                                   :navigationOptions #js {:title "ABOUT ME"}}})
(def HomeStack (CreateStackNavigator.
                   routes
                   #js {:initialRouteName "HomeScreen"}))
(def home-tabBar #js {:tabBarLabel "HOME"
                      :tabBarIcon (fn [props]
                                      (r/as-element
                                          [Ic {:name (if props.focused "ios-home" "ios-home-outline")
                                               :color (if props.focused "red" "gray")
                                               :size 26}]))})

; ProfileStack case set object
(def ProfileStack (CreateStackNavigator #js {:ProfileScreen #js {:screen (r/reactify-component Profile)
                                                                 :navigationOptions #js {:title "PROFILE"}}}))
(set! (.-navigationOptions ProfileStack) #js {:tabBarLabel "PROFILE"  ; ProfileStack.navigationOptions = {tabBarLabel: "PROFILE", tabBarIcon: () => {}}
                                              :tabBarIcon (fn [props]
                                                            (r/as-element
                                                                [Ic {:name (if props.focused "ios-person" "ios-person-outline")
                                                                     :color (if props.focused "red" "gray")
                                                                     :size 26}]))})

; NotificationStack case set object
(def NotificationStack (CreateStackNavigator #js {:NotificationScreen #js {:screen (r/reactify-component Notification)
                                                                           :navigationOptions #js {:title "NOTIFICATION"}}}))
(set! (.-navigationOptions NotificationStack) #js {:tabBarLabel "NOTIFICATION"
                                                   :tabBarIcon (fn [props]
                                                                (r/as-element
                                                                    [Ic {:name (if props.focused "ios-notifications" "ios-notifications-outline")
                                                                         :color (if props.focused "red" "gray")
                                                                         :size 26}]))})

; SigninStack case set object
(def SigninStack (CreateStackNavigator #js {:SigninScreen #js {:screen (r/reactify-component Signin)
                                                               :navigationOptions #js {:header nil}}}))


(def Tabs (CreateBottomTabNavigator #js {:HomeTab (r/reactify-component HomeStack)
                                         :ProfileTab (r/reactify-component ProfileStack)
                                         :NotificationTab (r/reactify-component NotificationStack)}
                                    #js {:navigationOptions home-tabBar
                                         :tabBarOptions #js {:activeTintColor "orange"
                                                             :inactiveTintColor "gray"}}))

(def AppNavigator (CreateStackNavigator #js {:TabNavigation #js {:screen (r/reactify-component Tabs)
                                                                 :navigationOptions #js {:header nil}}
                                             :AuthStack #js {:screen (r/reactify-component SigninStack)
                                                             :navigationOptions #js {:header nil}}}))

(def routing (r/adapt-react-class AppNavigator))

(defn Nav []
    [routing {:persistenceKey "NavigationState"}])
    ; [routing])
