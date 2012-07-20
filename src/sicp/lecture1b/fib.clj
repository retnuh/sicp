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