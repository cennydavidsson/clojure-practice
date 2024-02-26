(ns exercise-15.core-test
  (:require [clojure.test :refer :all]
            [exercise-15.core :refer :all]))

(deftest a-test
  (testing "Password validator"
    (are [expected username password store] 
         (= expected (validate-user :username username :password password :store store))
         true "foo" "123" {"foo" "123"}
         false "foo" "123" {"bar" "123", "foo" "321"}
         false "foo" "123" {"foo" "abc"})))
