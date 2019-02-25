(defproject webapp-test "1.0.0-SNAPSHOT"
  :description "Demo Clojure web app"
  :url "http://clojure-getting-started.herokuapp.com"
  :license {:name "Eclipse Public License v1.0"
            :url  "http://www.eclipse.org/legal/epl-v10.html"}
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [org.clojure/clojurescript "1.10.439"]
                 [compojure "1.4.0"]
                 [ring/ring-jetty-adapter "1.4.0"]
                 [environ "1.0.0"]
                 [quil "2.8.0"]]
  :plugins [[environ/environ.lein "0.3.1"]
            [lein-cljsbuild "1.1.7"]
            [lein-figwheel "0.5.15"]]
  :hooks [leiningen.cljsbuild]

  :uberjar-name "server-standalone.jar"
  :profiles {:production {:env {:production true}}}

  :clean-targets ^{:protect false} ["resources/public/js"]
  :cljsbuild {:builds [; development build with figwheel hot swap
                       {:id           "development"
                        :source-paths ["src"]
                        :compiler
                                      {:main       "sketch.core"
                                       :optimizations :advanced
                                       :output-to  "resources/public/js/main.js"
                                       :output-dir "resources/public/js/development"
                                       :asset-path "js/development"}}
                       ; minified and bundled build for deployment
                       {:id           "optimized"
                        :source-paths ["src"]
                        :compiler
                                      {:main          "sketch.core"
                                       :output-to     "resources/public/js/main.js"
                                       :output-dir    "resources/public/js/optimized"
                                       :asset-path    "js/optimized"
                                       :optimizations :advanced
                                       }}]})
