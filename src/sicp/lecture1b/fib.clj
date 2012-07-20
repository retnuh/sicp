(ns sicp.lecture1b.fib)

(defn fib-tail [n]
  (loop [count 0
         prev 1
         total 0]
    (if (= count n)
      total
      (recur (inc count) total (+ total prev)))))

(defmacro fib [n]
  (if (integer? n)
    (fib-tail n)
    `(fib-tail ~n)))

(defn next-fib [[a b]] [b (+ a b)])

(defn steve-fib [n]
  (map first (take n (iterate next-fib [0 1]))))

(def fib-seq (lazy-cat [0 1] (map + (rest fib-seq) fib-seq)))