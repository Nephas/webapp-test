(ns hexworld.util)

(defn update-values [m f & args]
  (into {} (for [[k v] m] [k (apply f v args)])))

(defn times [n f]
  (apply comp (repeat n f)))

(defn mean [vals]
  (/ (apply + vals) (count vals)))

(defn abs-dec [x]
  (cond (pos? x) (dec x)
        (neg? x) (inc x)
        true 0))