(ns exercise-20.core-test
  (:require [clojure.test :refer :all]
            [exercise-20.core :refer :all]))

(deftest a-test
  (testing "Missing state gives nil"
    (is (nil? (sales-tax 1000.0 "Norrbotten" "Kiruna"))))
  (testing "Missing county gives nil"
    (is (nil? (sales-tax 2000.0 "Wisconsin" "Dane County"))))
  (testing "Illinois has no sales tax"
    (is (= {:tax 80.0 :total 1080.0} (sales-tax 1000.0 "Illinois" "Fulton County"))))
  (testing "Some Wisconsin counties have tax"
    (is (= {:tax 50.0 :total 1050.0} (sales-tax 1000.0 "Wisconsin" "Eau Claire County")))
    (is (= {:tax 40.0 :total 1040.0} (sales-tax 1000.0 "Wisconsin" "Dunn County")))))

