(ns nates-nice-tea.views.layout
  (:use [hiccup.core :only (html)]
        [hiccup.element :only (javascript-tag)]
        [hiccup.page :only (html5 include-css)]))

(defn common [title & body]
  (html5
    [:head
      [:meta {:charset "utf-8"}]
      [:meta {:http-equiv "X-UA-Compatible" :content "IE=edge,chrome=1"}]
      [:meta {:name "viewport" :content "width=device-width, initial-scale=1, maximum-scale=1"}]
      [:meta {:name "description" :content "Nate’s Nice Tea is brewed with tea leaves and spring water. The leaves come from around the world as different regions produce their own uniquely nuanced tea."}]
      [:meta {:name "keywords"
        :content (str title ",Nates Nice Tea,Subscription Tea,Monthly Tea,Tea,Green Tea,Black Tea,White Tea")}]
      [:meta {:name "author" :content "Jake Kring"}]
      [:title title]
      (include-css "/base.css")
      (include-css "/bootstrap.min.css")
      (include-css "http://fonts.googleapis.com/css?family=Arvo")]
    [:body
      [:div {:id "content" :class "container"} body]
      [:div {:class "footer"}
        [:p
          [:a {:href "https://github.com/jkring/nates-nice-tea"}
            [:span "⚒  "] " in Oakland"]]]]))

(defn home []
  (common "Nate's Nice Tea"
    [:div {:class "row"}
      [:div {:class "col-md-3 col-md-offset-1 text-center" }
        [:img {:src "../logo.png"}]]
      [:div {:class "col-md-6"}
        [:p "Nate’s Nice Tea is brewed with tea leaves and spring water. The leaves come from around the world as different regions produce their own uniquely nuanced tea. A buttery white tea from China melts in your mouth while a brisk black tea from India tingles your tongue. The tea plant’s origin as well as the oxidation and processing of the picked leaf influence the flavors in each jar of Nate’s Nice Tea."]]]))

(defn four-oh-four []
  (common "Page Not Found"
    [:div {:class "row"}
      [:div {:class "col-md-6"}
        [:div {:class "jumbotron"}
          [:h1 "Ruh-Roh..."]
          [:p "The page you requested could not be found!"]]]]))
