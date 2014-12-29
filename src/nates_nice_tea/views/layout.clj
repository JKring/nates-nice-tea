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
      [:meta {:name "description" :content "Nate’s Nice Tea is brewed with tea leaves and spring water."}]
      [:meta {:name "keywords"
        :content (str title ",Nates Nice Tea,Subscription Tea,Monthly Tea,Tea,Green Tea,Black Tea,White Tea")}]
      [:meta {:name "author" :content "Jake Kring"}]
      [:title title]
      (include-css "/base.css")
      (include-css "/bootstrap.min.css")
      (include-css "http://fonts.googleapis.com/css?family=Roboto:300")]
    [:body
      [:div {:id "content" :class "container-fluid"} body]
      [:div {:class "footer"}
        [:p
          [:a {:href "https://github.com/jkring/nates-nice-tea"}
            [:span "⚒  "] " in Philly"]]]]))

(defn logo []
  [:div {:class "row"}
      [:div {:class "col-md-3 col-md-offset-1 text-center logo" }
        [:img {:src "../logo.png"}]]
      [:div {:class "col-md-6"}
        [:p
          [:b "Nate’s Nice Tea"]
          " is brewed with tea leaves and spring water. The leaves come from around the world as different regions produce their own uniquely nuanced tea. A buttery white tea from China melts in your mouth while a brisk black tea from India tingles your tongue. The tea plant’s origin as well as the oxidation and processing of the picked leaf influence the flavors in each jar of Nate’s Nice Tea."]]])

(defn green []
  [:div {:class "row tea-color green-tea"}
    [:div {:class "col-md-6 col-md-offset-1"}
      [:h1 "Green Tea"]
      [:p "Lebowski ipsum yeah man, it really tied the room together. Dolor sit amet, consectetur adipiscing elit praesent ac. Life does not stop and start at your convenience, you miserable piece of shit. Magna justo pellentesque ac lectus. They're nihilists. Quis elit blandit fringilla a. They finally did it. They killed my fucking car. Ut turpis praesent felis ligula, malesuada suscipit malesuada non. Vee vant zat money, Lebowski. Ultrices non urna sed orci ipsum, placerat id condimentum rutrum, rhoncus ac lorem."]]
    [:div {:class "col-md-3 text-center"}
      [:img {:class "photo" :src "../green-tea.jpg"}]]])

(defn white []
  [:div {:class "row tea-color white-tea"}
    [:div {:class "col-md-3 col-md-offset-1 text-center hidden-sm hidden-xs"}
        [:img {:class "photo" :src "../white-tea.jpg"}]]
    [:div {:class "col-md-6"}
      [:h1 {:class "text-right"} "White Tea"]
      [:p "Lebowski ipsum yeah man, it really tied the room together. Dolor sit amet, consectetur adipiscing elit praesent ac. Life does not stop and start at your convenience, you miserable piece of shit. Magna justo pellentesque ac lectus. They're nihilists. Quis elit blandit fringilla a. They finally did it. They killed my fucking car. Ut turpis praesent felis ligula, malesuada suscipit malesuada non. Vee vant zat money, Lebowski. Ultrices non urna sed orci ipsum, placerat id condimentum rutrum, rhoncus ac lorem."]]
    [:div {:class "col-md-3 col-md-offset-1 text-center hidden-md hidden-lg"}
        [:img {:class "photo" :src "../white-tea.jpg"}]]])

(defn black []
  [:div {:class "row tea-color black-tea"}
    [:div {:class "col-md-6 col-md-offset-1"}
      [:h1 "Black Tea"]
      [:p "Lebowski ipsum yeah man, it really tied the room together. Dolor sit amet, consectetur adipiscing elit praesent ac. Life does not stop and start at your convenience, you miserable piece of shit. Magna justo pellentesque ac lectus. They're nihilists. Quis elit blandit fringilla a. They finally did it. They killed my fucking car. Ut turpis praesent felis ligula, malesuada suscipit malesuada non. Vee vant zat money, Lebowski. Ultrices non urna sed orci ipsum, placerat id condimentum rutrum, rhoncus ac lorem."]]
    [:div {:class "col-md-3 col-md-offset-1 text-center"}
      [:img {:class "photo" :src "../black-tea.jpg"}]]])

(defn call-to-action []
  [:div {:class "row"}
    [:div {:class "col-md-12 text-center call-to-action"}
      [:a {:class "btn btn-lg" :role "button" :href "/order" }
        "Order Nate's Nice Tea"
        [:span {:class "glyphicon glyphicon-play" :aria-hidden "true" }]]]])

(defn home []
  (common "Nate's Nice Tea"
    (logo)
    (call-to-action)
    (green)
    (white)
    (black)))

(defn subscription []
  [:div {:class "row"}
    [:div {:class "col-md-3 col-md-offset-1 text-center"}
      [:img {:src "../subscription.png" }]]
    [:div {:class "col-md-6 text-right call-to-action"}
      [:h1 "Get 3 Nice Teas per Month"]
      [:p [:span {:class "description"}
        "A "
        [:b {:class "green-text"} "Green Tea"]
        ", a "
        [:b "Black Tea"]
        " and a "
        [:b {:class "white-text"} "White Tea"]
        " every month for "
        [:b "$20"]]]
      [:a {:class "btn btn-md" :role "button" :href "/order" }
        "Subscribe"
        [:span {:class "glyphicon glyphicon-play" :aria-hidden "true" }]]]])

(defn custom-case []
  [:div {:class "row"}
    [:div {:class "col-md-6 col-md-offset-1 call-to-action"}
      [:h1 "Buy a Case of Nice Tea"]
      [:p [:span {:class "description"}
        "4 "
        [:b {:class "green-text"} "Green Teas"]
        ", 4 "
        [:b "Black Teas"]
        " and 4 "
        [:b {:class "white-text"} "White Teas"]
        " for "
        [:b "$75"]]]
      [:a {:class "btn btn-md" :role "button" :href "/order" }
          "Order"
          [:span {:class "glyphicon glyphicon-play" :aria-hidden "true" }]]]
    [:div {:class "col-md-3 text-center"}
      [:img {:src "../case.png" }]]])

(defn order []
  (common "Order Nate's Nice Tea"
    (subscription)
    [:hr]
    [:br]
    [:br]
    (custom-case)))

(defn four-oh-four []
  (common "Page Not Found"
    [:div {:class "row"}
      [:div {:class "col-md-6"}
        [:div {:class "jumbotron"}
          [:h1 "Ruh-Roh..."]
          [:p "The page you requested could not be found!"]]]]))
