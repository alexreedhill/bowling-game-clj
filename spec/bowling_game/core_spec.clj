(ns bowling-game.core_spec
  (:require [bowling-game.core :refer :all])
  (:require [speclj.core :refer :all]))

(describe "bowling-game"
  (it "scores zero game"
      (should= 0 (score [[0 0] [0 0] [0 0] [0 0] [0 0] [0 0] [0 0] [0 0] [0 0] [0 0 0]])))

  (it "scores game with single successful roll"
      (should= 9 (score [[9 0] [0 0] [0 0] [0 0] [0 0] [0 0] [0 0] [0 0] [0 0] [0 0 0]])))

  (it "scores game with two successful rolls in a frame"
      (should= 7 (score [[4 3] [0 0] [0 0] [0 0] [0 0] [0 0] [0 0] [0 0] [0 0] [0 0 0]])))

  (it "scores game without any spares or strikes"
      (should= 73 (score [[4 3] [4 4] [5 4] [1 2] [3 4] [8 1] [9 0] [2 6] [7 1] [2 3 0]])))

  (it "scores game with a single spare"
      (should= 76 (score [[4 3] [4 4] [5 4] [1 2] [3 4] [8 1] [9 1] [2 6] [7 1] [2 3 0]])))

  (it "scores game with back to back spares"
      (should= 85 (score [[4 3] [4 4] [5 4] [1 2] [3 4] [8 1] [9 1] [2 8] [7 1] [2 3 0]])))

  (it "scores game with a strike"
      (should= 96 (score [[10 0] [4 4] [5 4] [1 2] [3 4] [8 1] [9 1] [2 8] [7 1] [2 3 0]])))

  (it "scores game with two consecutive strikes"
      (should= 114 (score [[10 0] [10 0] [5 4] [1 2] [3 4] [8 1] [9 1] [2 8] [7 1] [2 3 0]])))

  (it "scores game with alternating strikes and spares"
      (should= 127 (score [[10 0] [9 1] [10 0] [8 2] [1 2] [3 4] [8 1] [9 1] [2 8] [7 1 0]])))

  (it "scores game with spare in last frame"
      (should= 142 (score [[10 0] [9 1] [10 0] [8 2] [1 2] [3 4] [8 1] [9 1] [2 8] [10 8 2]])))

  (it "scores perfect game"
      (should= 300 (score [[10 0] [10 0] [10 0] [10 0] [10 0] [10 0] [10 0] [10 0] [10 0] [10 10 10]]))))

