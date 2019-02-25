(ns hexworld.draw
  (:require [quil.core :as q]
            [hexworld.trafo :as t]
            [hexworld.color :as c]))

(defn draw-hex-wedge [base]
  (let [height (* 0.5 (Math/sqrt 3) base)]
    (q/quad 0 0 height (* 0.5 base) height (* -0.5 base) 0 (- base))))

(defn draw-hex [radius color]
  (do (apply q/fill color)
      (let [rad #(* Math/PI %)
            wedge #(q/with-rotation [%] (draw-hex-wedge radius))]
        (doall (map wedge (list 0 (rad (/ 2 3)) (rad (/ 4 3))))))))

(defn draw-map
  ([tiles method scale]
   (q/no-stroke)
   (let [colors (mapv #(method %) tiles)
         positions (mapv #(t/cube-to-center-pix (:pos %) scale) tiles)]
     (doall (map (fn [pos col] (q/with-translation pos (draw-hex scale col))) positions colors)))))