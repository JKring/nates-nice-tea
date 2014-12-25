(ns nates-nice-tea.web
  (:use [compojure.core :only (defroutes GET)]
        [ring.adapter.jetty :as ring])
  (:require [compojure.route :as route]
            [compojure.handler :as handler]
            [nates-nice-tea.views.layout :as layout])
  (:gen-class))

(defroutes routes
  (route/resources "/")
  (GET  "/" [] (layout/home))
  (route/not-found (layout/four-oh-four)))

(def application (handler/site routes))

(defn start [port]
  (run-jetty application {:port port
                          :join? false}))

(defn -main []
  ; (schema/migrate)
  (let [port (Integer/parseInt (or (System/getenv "PORT") "8080"))]
    (start port)))
