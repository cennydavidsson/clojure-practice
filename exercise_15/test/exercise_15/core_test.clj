(ns exercise-15.core-test
  (:require [clojure.test :refer :all]
            [exercise-15.core :refer :all]))

(deftest a-test
  (testing "Password validator"
    (is (= true 
           (validate-user :username "foo" :password "123" :store {"foo" "123"})))
    (is (= false 
           (validate-user :username "foo" :password "123" :store {"bar" "123", "foo" "321"})))
    (is (= false 
           (validate-user :username "foo" :password "123" :store { "foo" "abc"})))))
