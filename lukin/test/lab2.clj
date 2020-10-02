(ns lukin.test.lab2
  (:require [clojure.test :refer :all])
  (:require [lukin.prog.lab2 :refer :all]))

(let [fun (fn [x] (Math/sin x))]
  (println (time (integrate-m fun 10 100000)))
  (println (time (integrate-m fun 10 100000)))
  (println (time (integrate-m fun 100 100000)))
  (println (time (integrate-m fun 100 100000)))
  (println (time (integrate-m fun 1000 100000)))
  (println (time (integrate-m fun 1000 100000)))
)

(defn abs [n] (max n (- n)))

(testing "unit tests"
  (is (= (integrate (constantly 0.0) 10 10) 0.0))
  (is (= (integrate (constantly 1.0) 10 10) (* 10.0)))
  (is (= (integrate (constantly 10.0) 10 10) (* 100.0)))
  (is (< (abs (-(integrate (fn [x] x) 10 10) 50.0)) 0.0001))
  (is (< (abs (- (integrate (fn [x] (* x x)) 10 1000) 333.33)) 0.01))
  (is (< (abs (- (integrate (fn [x] (Math/sin x)) 10 1000) 1.8391)) 0.01))
  )

(testing "memoize tests"
  (is (= (integrate (constantly 0.0) 10 10) (integrate-m (constantly 0.0) 10 10)))
  (is (= (integrate (constantly 1.0) 10 10) (integrate-m (constantly 1.0) 10 10)))
  (is (= (integrate (constantly 10.0) 10 10) (integrate-m (constantly 10.0) 10 10)))
  (is (= (integrate (fn [x] x) 10 10) (integrate-m (fn [x] x) 10 10)))
  (is (= (integrate (fn [x] (* x x)) 10 1000) (integrate-m (fn [x] (* x x)) 10 1000)))
  (is (= (integrate (fn [x] (Math/sin x)) 10 1000) (integrate-m (fn [x] (Math/sin x)) 10 1000)))
  )

(testing "non zero bottom"
  (is 
    (< 
      (abs
        (-
          (+
            (integrate (constantly 1) 0 1 10)
            (integrate (constantly 1) 1 2 10)
          )
          (integrate (constantly 1) 2 20)))
      0.01))
  (is
    (< 
      (abs
        (-
          (+
            (integrate (fn [x] (* x x)) 0 1 100)
            (integrate (fn [x] (* x x)) 1 2 100)
            )
            (integrate (fn [x] (* x x)) 2 200)
          ))
      0.01))
  (is
    (< 
      (abs
        (-
          (+
            (integrate (fn [x] (Math/sin x)) 0 1 100)
            (integrate (fn [x] (Math/sin x)) 1 2 100)
            )
          (integrate (fn [x] (Math/sin x)) 2 200)
          ))
      0.01))
  )