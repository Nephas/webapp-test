(ns server.core
  (:require [compojure.core :refer [defroutes GET PUT POST DELETE ANY]]
            [compojure.handler :refer [site]]
            [compojure.route :as route]
            [clojure.java.io :as io]
            [ring.adapter.jetty :as jetty]))

(defroutes app
           (GET "/" [] (slurp (io/resource "index.html")))
           (route/resources "/")
           (route/not-found (slurp (io/resource "404.html"))))

(defn -main [& [port]]
  (jetty/run-jetty (site #'app) {:port 5000}))
