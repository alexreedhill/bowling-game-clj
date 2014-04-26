(ns bowling-game.core)

(defn next-rolls [frames]
  (cond
    (= (count frames) 1) (vector (second (first frames)) (nth (first frames) 2))
    (= (second (second frames)) 0) (vector (first (second frames)) (first (nth frames 2)))
    :else (vector (first (second frames)) (second (second frames)))))

(defn score-each-frame [frames acc]
  (let [roll-1 (first (first frames))
        roll-2 (second (first frames))]
    (cond
      (= 10 roll-1) (+ acc roll-1 (first (next-rolls frames)) (second (next-rolls frames)))
      (= (+ roll-1 roll-2) 10) (+ acc roll-1 roll-2 (first (next-rolls frames)))
      :else (+ acc roll-1 roll-2))))

(defn score [frames]
  (loop [acc   0
         frames frames]
    (if (= 0 (count frames))
      acc
      (recur (score-each-frame frames acc)
             (rest frames)))))

