;(defglobal ?*nombrevariable* = valor) variables globales
;(random)
;(defmodule MODULO)
;65535
(deffacts hechos-iniciales
    (busqueda 0)
)

(defglobal ?*secret* = (+ 1 (mod (random) 100)))

(defrule input
    ?busquedaBorrar<-(busqueda ?busqueda)
    =>
    (while (= 0 ?busqueda) do
        (printout t "Introduce el numero: " crlf)
        (bind ?numerillo(read))
        (if (> ?numerillo ?*secret*) then
            (printout t "El numero que buscas es menor" crlf)
        else
            (if(< ?numerillo ?*secret*) then
                (printout t "El numero que buscas es mayor" crlf)
            )
        )
        (if (= ?numerillo ?*secret*) then
            (printout t "Enhorabuena has encontrado el numero, toma un caramelo" crlf)
            (bind ?busqueda 1)
        )
    )
)