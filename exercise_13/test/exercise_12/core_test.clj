(ns exercise-12.core-test
  (:require [clojure.test :refer :all]
            [exercise-12.core :refer :all]))

(deftest simple-interest
  (testing "Calculating interest"
    (is (= 1938.84 (interest :principal 1500 :rate 4.3 :years 6 :period 4)))
    (is (= 7840.26 (interest :principal 2000 :rate 20.0 :years 7 :period 4)))
    (is (= 1785.71 (interest :principal 1503 :rate 4.332 :years 4 :period 4))))
  (testing "Formatting"
    (is (= 
          "After 4 years at 4.3% compunded 4 times per year, the investment will be worth $1758.00."
          (format-interest 
            :amount 1758.0 
            :principal 1500 
            :rate 4.3 
            :years 4.0
            :period 4)))))
 
