(ns exercise-11.core-test
  (:require [clojure.test :refer :all]
            [exercise-11.core :refer :all]))

(deftest a-test
  (testing "FIXME, I fail."
    (is (= 
          "81 euros at an exchange rate of 137.51 is 111.39 U.S. dollars." 
          (convert-currency :amount 81 :rate-from 137.51 :rate-to 100.0)))))
