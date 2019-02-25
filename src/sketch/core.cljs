(ns sketch.core
  (:require [quil.core :as q :include-macros true]
            [quil.middleware :as mw]
            [hexworld.draw :as d]
            [hexworld.key :as k]
            [hexworld.map :as m]
            [hexworld.state :as s]))

(def store (atom {}))

(defn setup []
  (q/frame-rate 2)
  (q/color-mode :hsb 1.0 1.0 1.0)
  (s/init-state))

(defn get-ocean-area [tiles sea-level]
  (count (filter #(< (:height %) sea-level) tiles)))

(defn update-state [state]
  (let [sea-level (get-in state [:globals :sea-level])
        new-state (-> state
                      (assoc-in [:globals :ocean-area] (get-ocean-area (m/get-tiles state) sea-level)))]
    (do (swap! store (fn [_] new-state))
        new-state)))

(defn draw-state [state]
  (q/background 240)
  (d/draw-map (m/get-tiles state)
              (get-in state [:globals :draw-method])
              (get-in state [:globals :scale])))

(q/defsketch -main
             :host "canvas"
             :title "hexworld"
             :size [640 640]
             :setup setup
             :update update-state
             :key-pressed k/handle-key
             :draw draw-state
             :middleware [mw/fun-mode])
