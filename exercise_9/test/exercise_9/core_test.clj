(ns exercise-9.core-test
  (:require [clojure.test :refer :all]
            [exercise-9.core :refer :all]))

(deftest paint-calculator
  (testing "paint-calculator"
    (is (= 
          "You will need to purchase 2 gallons of paint to cover 360 square feet." 
           (paint 10 36)))))

