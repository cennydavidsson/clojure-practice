(ns exercises-5.core-test
  (:require [clojure.test :refer :all]
            [exercises-5.core :refer :all]))

(deftest test-format
  (testing "formats all expressions with positive numbers"
    (is (= ["10 + 5 = 15" "10 - 5 = 5" "10 * 5 = 50" "10 / 5 = 2"] (format-expressions "10" "5")))))

