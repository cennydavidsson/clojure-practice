(ns exercise-23.core-test
  (:require [clojure.test :refer :all]
            [exercise-23.core :refer :all]))

(deftest car-troubleshot
  (testing "car-issue"
    (is (= :battery-corroded (car-issue :silent true)))
    (is (= :clicking (car-issue :silent false)))
    (is (= :clean-terminals (car-issue :battery-corroded true)))
    (is (= :replace-cables (car-issue :battery-corroded false)))
    (is (= :replace-battery (car-issue :clicking true)))
    (is (= :crank-up (car-issue :clicking false)))
    (is (= :check-spark (car-issue :crank-up true)))
    (is (= :engine-die (car-issue :crank-up false)))
    (is (= :fuel-injection (car-issue :engine-die true)))
    (is (= :check-choke (car-issue :fuel-injection false)))
    (is (= :service (car-issue :fuel-injection true))))
  (testing "done"
    (is (not (done :clicking)))
    (is (done :clean-terminals))))
