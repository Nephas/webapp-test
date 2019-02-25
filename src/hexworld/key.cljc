(ns hexworld.key
  (:require [hexworld.color :as c]
            [hexworld.state :as s]))

(defn handle-key [state event]
  (case (:key event)
    (:1) (assoc-in state [:globals :draw-method] c/true-colors)
    (:2) (assoc-in state [:globals :draw-method] c/temp-colors)
    (:3) (assoc-in state [:globals :draw-method] c/height-colors)
    (:4) (assoc-in state [:globals :draw-method] c/seed-colors)
    (:+) (update-in state [:globals :scale] inc)
    (:-) (update-in state [:globals :scale] dec)
    (:r) (s/init-state)
    (:a :left) state
    (:d :right) state
    state))