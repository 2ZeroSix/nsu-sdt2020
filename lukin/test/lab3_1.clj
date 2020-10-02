(ns lukin.test.lab3-1
  (:require [clojure.test :refer :all])
  (:require [lukin.prog.lab2 :refer :all])
  (:require [lukin.prog.lab3-1 :refer :all]))
(defn abs [n] (max n (- n)))

(defn time-test [f1 f2 n] (println  (time (f1 n)) (time (f2 n))))
(defn plain [x] (integrate (fn [x] (Math/sin x)) x (* x 1000)))
(let [sequence (integrate-seq (fn [x] (Math/sin x)) 1 1000)]
(let [nth-item (fn [n] (nth sequence n))]
  (time-test plain nth-item 0)
  (time-test plain nth-item 1)
  (time-test plain nth-item 10)
  (time-test plain nth-item 100)
  (time-test plain nth-item 10)
  (time-test plain nth-item 110)
  ))

(testing "stream tests"
  (is (<
    (abs (-
      (integrate (constantly 0.0) 10 10)
      (nth (integrate-seq (constantly 0.0) 1 1) 10))))
    0.001)
  (is (<
    (abs (-
      (integrate (constantly 1.0) 10 10)
      (nth (integrate-seq (constantly 1.0) 1 1) 10))))
    0.001)
  (is (<
    (abs (-
      (integrate (constantly 10.0) 10 10)
      (nth (integrate-seq (constantly 10.0) 1 1) 10))))
    0.001)
  (is (<
    (abs (-
      (integrate (fn [x] x) 10 10)
      (nth (integrate-seq (fn [x] x) 1 1) 10))))
    0.001)
  (is (<
    (abs (-
      (integrate (fn [x] (* x x)) 10 1000)
      (nth (integrate-seq (fn [x] (* x x)) 1 100) 10))))
    0.001)
  (is (<
    (abs (-
      (integrate (fn [x] (Math/sin x)) 10 1000)
      (nth (integrate-seq (fn [x] (Math/sin x)) 1 100) 10))))
    0.001)
  )