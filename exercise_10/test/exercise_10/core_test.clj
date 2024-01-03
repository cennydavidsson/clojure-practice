(ns exercise-10.core-test
  (:require [clojure.test :refer :all]
            [exercise-10.core :refer :all]))

(deftest a-test
  (testing "Self-checkout"
    (is (= 
          "Subtotal: $64.00\nTax: $3.52\nTotal: $67.52" 
          (total-cost [{:price 25 :quantiy 2} 
                       {:price 10 :quantiy 1} 
                       {:price 4 :quantiy 1}])))))
