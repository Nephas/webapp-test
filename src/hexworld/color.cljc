(ns hexworld.color)

(defn true-colors [tile]
  (let [height (:height tile)
        temp (:temperature tile)
        frozen (:glacier tile)
        land (not (:ocean tile))]
    (cond frozen [(+ 0.2 temp) 0.1 (+ 0.8 height)]
          land [0.1 0.6 (+ 0.25 height)]
          true [0.6 0.6 (max 0.5 (+ 0.4 height))])))

(defn temp-colors [tile]
  (let [temp (:temperature tile)]
    [(+ 0.2 temp) temp 0.8]))

(defn height-colors [tile]
  (let [height (:height tile)]
    [0.1 0.3 height]))

(defn seed-colors [tile]
  (let [seed (:seed tile)]
    [0.1 0.3 (if seed 0.8 0.2)]))