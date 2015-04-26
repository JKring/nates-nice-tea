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
          " is brewed with tea leaves and spring water. The leaves come from around the world as different regions produce their own uniquely nuanced tea. A buttery white tea from China melts in your mouth while a brisk black tea from India tingles your tongue. The tea plant’s origin as well as the oxidation and processing of the picked leaf influence the flavors in each bottle of Nate’s Nice Tea."]]])
(defn green []
  [:div {:class "row tea-color green-tea"}
    [:div {:class "col-md-6 col-md-offset-1"}
      [:h1 "Green Tea"]

      [:h3 "Lung Ching, China"]
      [:p "Roasted chestnuts and spring grass blend beautifully as the sweet vegetal finish ices the cake."]

      [:h3 "Sencha, Japan"]
      [:p "Vibrant, meaty body of steamed greens with a subtle, sweet lemony finish."]]

    [:div {:class "col-md-3 text-center"}
      [:img {:class "photo" :src "../green-tea.jpg"}]]])

(defn white []
  [:div {:class "row tea-color white-tea"}
    [:div {:class "col-md-3 col-md-offset-1 text-center hidden-sm hidden-xs"}
        [:img {:class "photo" :src "../white-tea.jpg"}]]
    [:div {:class "col-md-6"}
      [:h1 {:class "text-right"} "White Tea"]
      [:h3 "Pai Mutan, China"]
      [:p "Light, refreshing body of roasted summer squash with a mildly sweet honey finish."]]
    [:div {:class "col-md-3 col-md-offset-1 text-center hidden-md hidden-lg"}
        [:img {:class "photo" :src "../white-tea.jpg"}]]])

(defn black []
  [:div {:class "row tea-color black-tea"}
    [:div {:class "col-md-6 col-md-offset-1"}
      [:h1 "Black Tea"]

      [:h3 "Assam, India"]
      [:p "Brisk, malted body with a dry finish of molasses and a hint of dark chocolate."]

      [:h3 "Ceylon, Sri Lanka"]
      [:p "Fruity, floral body that moves towards a roasted bittersweet finish."]

      [:h3 "Keemun, China"]
      [:p "Smooth, smoky body finishing with hints of cocoa and a touch of tobacco."]]

    [:div {:class "col-md-3 col-md-offset-1 text-center"}
      [:img {:class "photo" :src "../black-tea.jpg"}]]])

(defn call-to-action []
  [:div {:class "row"}
    [:div {:class "col-md-12 text-center call-to-action"}
      [:a {:class "btn btn-lg" :role "button" :href "/learn" }
        "Learn More"
        [:span {:class "glyphicon glyphicon-play" :aria-hidden "true" }]]]])

(defn home []
  (common "Nate's Nice Tea"
    (logo)
    (call-to-action)
    (green)
    (white)
    (black)))

(defn tips []
  [:div {:class "row"}
    [:div {:class "col-md-3 col-md-offset-1 logo text-center" }
      [:a { :href "/" } [:img {:src "../logo.png"}]]
      [:div {:class "get-in-touch"}
        [:h2 "Get in Touch!"]
        [:p "Nathan Gemberling-Johnson"]
        [:p "(215) 896-7783"]
        [:p [:a { :href "mailto:nathangemjo@gmail.com" } "nathangemjo@gmail.com" ]]]]
    [:div {:class "col-md-6 tips"}
      [:h2 "Nate's Nice Tips"]
      [:ul
        [:li "Each tea is unique and may contain subtle differences in flavor that change depending on the origin of the tea plant. The processing of the picked leaf will also affect the flavor profile."]
        [:li "Nice Tea is brewed to be drank at room temperature but can be served on ice.  Think whisky on the rocks.  The tea can also be served hot but will be much stronger than a traditional cup of tea. Nice Teas contain caffeine and serving size will depend upon method of preparation."]
        [:li "Tea sediment is natural, especially with Assam tea and white tea.  Before opening, invert the jar a few times to mix up the tea particles."]
        [:li "Traditionally these teas are enjoyed unadulterated, with the exception of the Assam which can stand up to both milk and sugar. That being said, “Drink it how you like.”"]
        [:li "Nice Tea should be consumed within 7 days of opening. Flavor profiles may change over time as the tea settles once it’s been opened."]
        [:li "Nice Teas should not be refrigerated as green and white teas lose their flavors after refrigeration. If refrigerated, the tea may appear cloudy; this is natural as some of the tea particles are not soluble at lower temperatures)"]]]])

(defn learn []
  (common "Nate's Nice Tea | Learn"
    (tips)))

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
