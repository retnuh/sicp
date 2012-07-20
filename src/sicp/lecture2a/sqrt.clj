(ns sicp.lecture2a.sqrt)

(defn fixed-point [f guess]
  (let [tolerance 0.0001]
    (loop [old guess]
      (let [new (f old)]
        (if (> tolerance (Math/abs (- old new)))
          new
          (recur new))))))

(defn derivative [f]
  (let [dx 0.000001]
    (fn [x] (/ (- (f (+ x dx)) (f x)) dx))))

(defn newton [f guess]
  (let [df (derivative f)]
    (fixed-point (fn [y] (- y (/ (f y) (df y)))) guess)))

(defn sqrt [x]
  (newton (fn [y] (- x (* y y))) 1))

(defn cubic [a b c]
  (fn [x] (+ (* x x x) (* a x x) (* b x) c)))

(defn cubic-roots [a b c]
  (newton (cubic a b c) 1))

(defn twice [f]
  (fn [x] (f (f x))))
