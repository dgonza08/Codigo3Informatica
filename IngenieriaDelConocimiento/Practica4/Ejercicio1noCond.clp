;(defglobal ?*nombrevariable* = valor) variables globales
;(random)
;(defmodule MODULO)
;65535
(deffacts hechos-iniciales
    (busqueda 0)
    (numerillo)
)

(defglobal ?*secret* = (+ 1 (mod (random) 100)))
(defglobal ?*numerillo*)

(defrule pedir
    (busqueda 0)
    =>
    (printout t "Introduce un numero" crlf)
    (read ?*numerillo*)
)

(defrule input
    (test (= ?*numerillo* ?*secret*))
    =>
    (printout t "Enhorabuena has encontrado el numero, toma un caramelo" crlf)
)