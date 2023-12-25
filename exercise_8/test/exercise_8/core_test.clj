(ns exercise-8.core-test
  (:require [clojure.test :refer :all]
            [exercise-8.core :refer :all]))

(deftest a-test
  (testing "FIXME, I fail."
    (is (= (str 
             "8 people with 2 pizzas\n"
             "Each person gets 2 pieces of pizza.\n"
             "There are 0 leftover pieces.") 
           (pizza-party 8 2 8)))
  (is (= (str 
             "7 people with 2 pizzas\n"
             "Each person gets 2 pieces of pizza.\n"
             "There are 2 leftover pieces.") 
           (pizza-party 7 2 8)))))

