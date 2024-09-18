(ns exercise-25.core-test
  (:require [clojure.test :refer [deftest is testing]]
            [exercise-25.core :refer [password-strength]]))

(deftest password-strength-test
  (testing "only numbers is very weak"
    (is (= :very-weak (password-strength "")))
    (is (= :very-weak (password-strength "3")))
    (is (= :very-weak (password-strength "12345"))))
  (testing "shorter than 8 and only letters is weak"
    (is (password-strength "abcdeff"))
    (is (= :weak (password-strength "abcf"))))
  (testing ":::"
    (is (= :medium (password-strength "abcdefdasdfsadf")))
    (is (= :medium (password-strength "abcdefdasdfsadf"))))
  (testing ""
    (is (= :strong (password-strength "abc123xyz"))))
  (testing ""
    (is (= :very-strong (password-strength "1337h@xor!")))))

