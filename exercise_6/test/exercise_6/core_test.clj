(ns exercise-6.core-test
  (:require [clojure.test :refer :all]
            [exercise-6.core :refer :all]))

(deftest exercise-6 
  (testing "valid age"
    (is (valid-age? 45))
    (is (valid-age? 0))
    (is (not (valid-age? 45.5))) 
    (is (not (valid-age? "foobar")))
    (is (not (valid-age? -99))))

  (testing "retirement age"
    (is (= "You have 40 years left to retirement\nIt's 2020, so you can retire in 2060" 
           (retirement-answer 65 25 2020)))
    (is (= "You can already retire" 
           (retirement-answer 65 65 2020)))
    (is (= "You can already retire" 
           (retirement-answer 65 66 2020)))))
    
