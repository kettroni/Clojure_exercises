(ns clojure-by-example.sandbox)

(defn helloworld
   "This function says Hello!"
   [name]
    (str "Hello, " name "!"))

(helloworld "Roni")

;; https://4clojure.oxal.org/#/problem/1
(=  (not false) true)

;; https://4clojure.oxal.org/#/problem/16
(= (#(str "Hello, " % "!") "Dave") "Hello, Dave!")

;; https://4clojure.oxal.org/#/problem/17
(= '(6 7 8) (map #(+ % 5) '(1 2 3)))

;; https://4clojure.oxal.org/#/problem/18
(= '(6 7) (filter #(> % 5) '(3 4 5 6 7)))

;; https://4clojure.oxal.org/#/problem/57
(= '(5 4 3 2 1) ((fn foo [x] (when (> x 0) (conj (foo (dec x)) x))) 5))

;; https://4clojure.oxal.org/#/problem/71
(= (last (sort (rest (reverse [2 5 4 1 3 6]))))
   (-> [2 5 4 1 3 6] reverse rest sort last)
   5)

;; https://4clojure.oxal.org/#/problem/134
(defn problem134
  [k,m]
  (nil? (m k 1)))

(true?  (problem134 :a {:a nil :b 2}))
(false? (problem134 :b {:a nil :b 2}))
(false? (problem134 :c {:a nil :b 2}))

;; https://4clojure.oxal.org/#/problem/27
(defn problem27
  [xs]
  (= (reverse xs) (vec xs)))

(false? (problem27 '(1 2 3 4 5)))
(true? (problem27 "racecar"))
(true? (problem27 [:foo :bar :foo]))
(true? (problem27 '(1 1 3 3 1 1)))
(false? (problem27 '(:a :b :c)))

;; https://4clojure.oxal.org/#/problem/26
(defn fibo
   ""
  ([n]
   (fibo '[0,1] n))
  ([xs, n]
   (if (<= (count xs) n)
     (fibo (conj xs (reduce + (take-last 2 xs))) n)
     (pop (apply list xs)))))

(= (fibo 3) '(1 1 2))
(= (fibo 6) '(1 1 2 3 5 8))
(= (fibo 8) '(1 1 2 3 5 8 13 21))


;; https://4clojure.oxal.org/#/problem/39
(defn problem39
  ([xs ys]
   (problem39 xs ys [])
  )
  ([xs ys zs]
   (if (> (count xs) 0)
    (if (> (count ys) 0)
      (problem39 (rest xs) (rest ys) (conj zs (first xs) (first ys)))
      zs)
    zs)))

(= (problem39 [1 2 3] [:a :b :c]) '(1 :a 2 :b 3 :c))
(= (problem39 [1 2] [3 4 5 6]) '(1 3 2 4))
(= (problem39 [1 2 3 4] [5]) [1 5])
(= (problem39 [30 20] [25 15]) [30 25 20 15])

;; Quicksort
(defn quicksort
  [xs]
  (if (= (count xs) 2)
    (if (< (first xs) (second xs))
      (conj ())
      (conj ()))
    (conj (quicksort ()) (quicksort ()))))
