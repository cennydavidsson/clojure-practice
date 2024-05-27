(ns exercise-19.core-test
  (:require [clojure.test :refer :all]
            [exercise-19.core :refer :all]))

(deftest a-test
  (testing ""
    (is (= 13 (bmi {:height 72 :weight 100})))
    (is (= 21 (bmi {:height 72 :weight 160})))
    (is (= 31 (bmi {:height 72 :weight 230}))))
  (testing "FIXME, I fail."
    (is (= :overweight (health 43)))
    (is (= :normal (health 20)))
    (is (= :underweight (health 11)))))

