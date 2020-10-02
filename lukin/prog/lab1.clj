(ns lukin.prog.lab1)

(defn permutations-reducer [permutations next_arr](->
  (fn [acc cur_perm]
    (let [is-correct-char(fn [next_char] (not= (last cur_perm) (last next_char)))]
    (let [append-char (fn [next_char] (apply str cur_perm next_char))]
    (->>
      next_arr
      (filter is-correct-char)
      (map append-char)
      (concat acc)))))
  (reduce [] permutations)))

(defn permutations [arr n]
  (->> 
    (range 0 n 1)
    (map (constantly arr))
    (reduce permutations-reducer)))


(println (permutations ["a" "b" "c" "d"] 3))
