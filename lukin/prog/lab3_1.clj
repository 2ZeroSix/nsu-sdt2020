(ns lukin.prog.lab3-1
  (:require [lukin.prog.lab2 :refer :all]))

(defn integrate-seq
  ([f arg-step steps-per-arg-step]
    (cons 0 (integrate-seq 0.0 f 0 steps-per-arg-step arg-step)))
  ([a f x steps-per-arg-step arg-step]
    (lazy-seq
      (let [new-a (+ a (integrate f x (+ arg-step x) steps-per-arg-step))]
        (cons
          new-a
          (integrate-seq new-a f (+ arg-step x) steps-per-arg-step arg-step))))))
