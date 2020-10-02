(ns lukin.prog.lab2)

(defn integrate 
  ([f x steps] (integrate f 0 x steps))
  ([f bot top steps]
    (reduce
      (fn [acc i]
        (+ acc (/ 
          (*
            (+
              (f (+ bot (/ (* (- top bot) i      ) steps)))
              (f (+ bot (/ (* (- top bot) (+ i 1)) steps))))
            (- top bot))
          (* 2 steps))))
      0
      (range steps))))

(def integrate-m (memoize integrate))
