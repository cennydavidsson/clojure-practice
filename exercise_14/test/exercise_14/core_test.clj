(ns exercise-14.core-test
  (:require [clojure.test :refer :all]
            [exercise-14.core :refer :all]))

(deftest a-test
  (testing "FIXME, I fail."
    (is (= {:total 10.0} 
           (tax 10.0 "MN")))
    (is (= {:total 10.55 :subtotal 10.0 :tax 0.55} 
           (tax 10.0 "WI")))))
