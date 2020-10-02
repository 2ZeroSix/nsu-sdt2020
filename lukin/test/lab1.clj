(ns lukin.test.lab1
  (:require [clojure.test :refer :all])
  (:require [lukin.prog.lab1 :refer :all]))

(testing "easy tests"
  (is (= (permutations ["a" "a"] 1) ["a" "a"]))

  (is (= (permutations ["a" "a"] 2) []))

  (is (= (permutations ["a" "b"] 1) ["a" "b"]))

  (is (= (permutations ["a" "b"] 2) ["ab" "ba"]))

  (is (= (permutations ["a" "b" "c"] 2) ["ab" "ac" "ba" "bc" "ca" "cb"]))

  (is (= (permutations ["a" "b" "c"] 3) ["aba" "abc" "aca" "acb" "bab" "bac" "bca" "bcb" "cab" "cac" "cba" "cbc"]))
  )