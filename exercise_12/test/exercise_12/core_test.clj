(ns exercise-12.core-test
  (:require [clojure.test :refer :all]
            [exercise-12.core :refer :all]))

(deftest simple-interest
  (testing "Calculating interest"
    (is (= 1758.0 (interest :principal 1500 :rate 4.3 :years 4)))
    (is (= 4800.01 (interest :principal 2000 :rate 20.0 :years 7)))
    (is (= 1763.44 (interest :principal 1503 :rate 4.332 :years 4))))
  (testing "Formatting"
    (is (= 
          "After 4 years at 4.3%, the investment will be worth $1758.00."
          (format-interest 
            :amount 1758.0 
            :principal 1500 
            :rate 4.3 
            :years 4.0)))))
 
