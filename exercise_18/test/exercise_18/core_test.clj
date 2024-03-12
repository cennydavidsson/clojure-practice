(ns exercise-18.core-test
  (:require [clojure.test :refer :all]
            [exercise-18.core :refer :all]))

(deftest convert-temp-test
  (testing "convert temp"
    (are [expected temp from to] (= expected (convert-temp temp from to))
         32 32 :fahrenheit :fahrenheit
         0 32 :fahrenheit :celsius
         32 0 :celsius :fahrenheit))
  (testing "parse"
    (testing "unsuported gives nil"
      (is (nil? (temp-unit "!"))))
    (testing "first letter of unit gives keyword"
      (are [unit input] (= unit (temp-unit input))
           :fahrenheit "F"
           :fahrenheit "f"
           :celsius "C"))))

