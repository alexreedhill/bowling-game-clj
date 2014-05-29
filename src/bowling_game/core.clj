(ns bowling-game.core)

(defn next-rolls [frames]
  (cond
    (= (count frames) 1) (vector (second (first frames)) (nth (first frames) 2))
    (= (second (second frames)) 0) (vector (first (second frames)) (first (nth frames 2)))
    :else (vector (first (second frames)) (second (second frames)))))

(defn strike? [roll]
  (= 10 roll))

(defn spare? [roll-1 roll-2]
  (= (+ roll-1 roll-2) 10))

(defn score-each-frame [frames acc]
  (let [[roll-1 roll-2] (first frames)]
    (cond
      (strike? roll-1) (+ acc roll-1 (first (next-rolls frames)) (second (next-rolls frames)))
      (spare? roll-1 roll-2) (+ acc roll-1 roll-2 (first (next-rolls frames)))
      :else (+ acc roll-1 roll-2))))

(defn score [frames]
  (loop [acc   0
         frames frames]
    (if (= 0 (count frames))
      acc
      (recur (score-each-frame frames acc)
             (rest frames)))))

