(ns exercise-25.core
  (:require [clojure.string :as str])
  (:gen-class))

(defn- exit! [message]
  (println message)
  (System/exit 0))

(defn- ask-text!
  ([text]
   (ask-text! (fn [x] x) text))
  ([f text]
   (ask-text! f "Couldn't parse input" text))
  ([f error text]
   (println text)
   (flush)
   (if-let [value (f (read-line))]
     value
     (exit! error))))

(def special-characters #"[^A-Za-z0-9]")
(def numbers #"\d+")
(def letters #"\p{L}+")

(defn password-strength [password]
  (letfn [(any? [pattern] (re-find pattern password))
          (missing? [pattern] (not (any? pattern)))
          (only? [pattern] (re-matches pattern password))
          (fewer? [size] (> size (count password)))
          (same-or-more? [size] (not (fewer? size)))]
    (cond
      (or (empty? password) (and (fewer? 8) (only? numbers))) :very-weak
      (and (fewer? 8) (only? letters)) :weak
      (and (same-or-more? 8) (or (only? letters) (only? numbers))) :medium
      (and (any? letters) (any? numbers) (missing? special-characters)) :strong
      :else :very-strong)))

(defn format-password-response [strength]
  (str "Your password is " (str/replace (name strength) "-" " ")))

(defn -main
  "Password strength checker"
  [& _]
  (let [password (ask-text! "What is your password?")
        strength (password-strength password)]
    (println (format-password-response strength))))

