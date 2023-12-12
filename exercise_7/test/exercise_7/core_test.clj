(ns exercise-7.core-test
  (:require [clojure.test :refer :all]
            [exercise-7.core :refer :all]))

(deftest area
  (testing "area"
    (is (= (str
             "You entered dimensions of 15 feet by 20 feet.\n"
             "The area is\n" 
             "300 square feet\n" 
             "27.871 square meters") 
           (area-answer 15 20)))))

