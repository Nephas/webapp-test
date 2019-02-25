(ns hexworld.state
  (:require [hexworld.gen :as g]
            [hexworld.color :as c]))

(defn init-state [] {:map     (g/cellular-map 24 0.45 4 8 0.2 0.4 0 0.4)
                     :globals {:draw-method c/true-colors
                               :scale 7
                               :sea-level   0.4
                               :base-heat   0
                               :freeze-temp 0.4
                               :ocean-area  0}})
