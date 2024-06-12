(ns exercise-24.core-test
  (:require [clojure.test :refer :all]
            [exercise-24.core :refer :all]))

(deftest anagram
  (testing "anagram response"
    (is (=
         "foo and bar are not anagrams" 
         (anagram-response "foo" "bar"))))
  (testing "is not anagram when"
    (testing "diffrent length"
      (is (false? (anagram? "foo" "ooff")))))

    (testing "letters are diffrent"
      (is (false? (anagram? "foo" "bar"))))

  (testing "is anagram when"
    (testing "all letters appears once"
      (is (true? (anagram? "note" "tone"))))))

