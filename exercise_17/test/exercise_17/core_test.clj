(ns exercise-17.core-test
  (:require [clojure.test :refer :all]
            [exercise-17.core :refer :all]))

(deftest a-test
  (testing "Blood alcohol calculator"
    (is (= 
          "Your BAC is 0.96, it's not legal for you to drive" 
          (bac 21 130 :female 2)))
    (is (= 
          "Your BAC is 0.84, it's not legal for you to drive" 
          (bac 21 130 :male 2)))
    (is (= 
          "Your BAC is 0.07, it's legal for you to drive" 
          (bac 9 135 :female 3)))))

