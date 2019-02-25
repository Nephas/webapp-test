(ns hexworld.state
  (:require [hexworld.gen :as g]
            [hexworld.color :as c]
            [quil.core :as q]))

(defn init-state [] (let [size 20
                          shape-prob 0.45
                          shape-steps 4
                          height-steps 8
                          noise-range 0.2
                          sea-level (q/random 0.3 0.5)
                          base-heat (q/random 0.0 0.2)
                          freeze-temp 0.5]
                      {:map     (g/cellular-map size shape-prob shape-steps height-steps noise-range sea-level base-heat freeze-temp)
                       :globals {:draw-method c/true-colors
                                 :scale       7
                                 :size        size
                                 :sea-level   sea-level
                                 :base-heat   base-heat
                                 :freeze-temp freeze-temp
                                 :ocean-area  0}}))
