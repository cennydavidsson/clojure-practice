(ns exercise-22.core-test
  (:require [clojure.test :refer :all]
            [exercise-22.core :refer :all]))

(deftest max-number
  (testing "returns largest number"
    (is (= 4 (max-number 1 3 4)))
    (is (= 3 (max-number 1 3 2)))
    (is (= 4 (max-number 4 3 2))))
  (testing "duplicates not allowed"
    (is (nil? (max-number 2 1 1)))
    (is (nil? (max-number 1 1 1)))
    (is (nil? (max-number 1 1 2)))))

