(ns hexworld.map
  (:require [hexworld.util :as u]
            [hexworld.trafo :as t]))

(defrecord Tile [pos seed height elevation temperature ocean glacier pressure])

(defn empty-tile [pos radius]
  (let [z (last pos)
        ;elevation (float (- 1 (/ (t/cube-dist pos [0 0 0]) radius)))
        elevation (float (/ (- z) radius))]
    (->Tile pos false 0 elevation 0 false false 0)))

(defn in-map? [pos tile-map]
  (not (nil? (get tile-map pos))))

(defn init-tiles [radius]
  (let [radius-range (range (- radius) (inc radius))
        positions (map (fn [x] (map (fn [y] [x y (- (+ x y))]) radius-range)) radius-range)]
    (map (fn [pos] (empty-tile pos radius))
         (filter #(< (t/cube-dist % [0 0 0]) radius) (apply concat positions)))))

(defn init-map [tile-list]
  (into {} (map #(vector (:pos %1) %1) tile-list)))

(defn get-tiles [state]
  (vals (state :map)))

(defn wrap-neighbors [neighbors tile-map]
  (let [wrap (fn [[x y z]] [(u/abs-dec y) (u/abs-dec x) z])
        this-side (filter #(in-map? % tile-map) neighbors)
        other-side (filter #(not (in-map? % tile-map)) neighbors)]
    (concat this-side (map wrap other-side))))

(defn get-neighbors
  ([[x y z]] (let [idt identity
                   move (fn [dir] (mapv #(%1 %2) dir [x y z]))]
               (map move (list [inc dec idt]
                               [dec inc idt]
                               [idt inc dec]
                               [idt dec inc]
                               [inc idt dec]
                               [dec idt inc]))))
  ([tile-map pos] (vals (select-keys tile-map (wrap-neighbors (get-neighbors pos) tile-map)))))