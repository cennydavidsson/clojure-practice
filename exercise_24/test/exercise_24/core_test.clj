(ns exercise-24.core-test
  (:require [clojure.test :refer :all]
            [exercise-24.core :refer :all]))

(deftest anagram
  (testing "is not anagram when"
    (testing "diffrent length"
      (is (not (anagram? "foo" "ooff")))))
    (testing "letters are diffrent"
      (is (not (anagram? "foo" "bar"))))
  (testing "is anagram when"
    (testing "all letters appears once"
      (is (anagram? "note" "tone")))))
