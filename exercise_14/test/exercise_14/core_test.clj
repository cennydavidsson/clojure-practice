(ns exercise-14.core-test
  (:require [clojure.test :refer :all]
            [exercise-14.core :refer :all]))

(deftest a-test
  (testing "Tax calculator"
    (is (= {:total 10.0} 
           (tax 10.0 "MN")))
    (is (= {:total 10.55 :subtotal 10.0 :tax 0.55} 
           (tax 10.0 "WI")))
    (is (= {:total 10.55 :subtotal 10.0 :tax 0.55} 
           (tax 10.0 "Wi"))))
  (testing "tax formater"
    (is (= 
          "The subtotal is $10.00\nThe tax is $0.55\nThe total is $10.55"
          (format-tax {:total 10.55 :subtotal 10.0 :tax 0.55})))
    (is (= 
          "The total is $10.55"
          (format-tax {:total 10.55})))))

