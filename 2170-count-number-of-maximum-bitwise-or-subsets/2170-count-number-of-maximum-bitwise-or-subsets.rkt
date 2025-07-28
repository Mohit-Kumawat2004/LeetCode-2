(define (count-max-or-subsets nums)
  (let ([res 0]
        [target (apply bitwise-ior nums)])
    (let loop ([L nums] [path '()])
      (if (null? L)
          (when (= target (apply bitwise-ior path))
            (set! res (add1 res)))
          (begin
            (loop (cdr L) path)
            (loop (cdr L) (cons (car L) path)))))
    res))