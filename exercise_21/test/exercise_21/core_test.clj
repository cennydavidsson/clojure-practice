(ns exercise-21.core-test
  (:require [clojure.test :refer :all]
            [exercise-21.core :refer :all]))

(deftest number-to-text
  (testing "number outside 1...12 is nil"
    (is (nil? (month 0)))
    (is (nil? (month 13))))
  (testing "number within 1...12 is month in text"
    (is (= "January" (month 1)))
    (is (= "March" (month 3)))))
