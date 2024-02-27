(ns exercise-16.core-test
  (:require [clojure.test :refer :all]
            [exercise-16.core :refer :all]))

(deftest a-test
  (testing "Driving age"
    (is (= "You are not old enough to legally drive" 
           (driving-age 15)))
    (is (= "You are old enough to legally drive" 
           (driving-age 16)))))

