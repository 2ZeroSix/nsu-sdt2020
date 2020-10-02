(ns lukin.prog.lab3-2)

(defn future-filter [sequence items-per-future threads] (->> 
  (range)
  (map
  
  )))

  ;; (for [x sequence
  ;;       :let [y (* x 3)]
  ;;       :when (even? y)]
  ;;   (fn [item])
  ;;   (reduce
  ;;     (fn [_] (future (take items-per-future (drop sequence))))
  ;;     (range threads))
  ;;   ))

