;TODO Conseguir mostrar por pantalla la union y la interseccion de 
; los dos conjuntos de letras 
(deffacts hechos-iniciales
    (letras A B C D E F G H I J K L M N O P)
    (conjunto c1 A B F I L E)
    (conjunto c2 A B H E M N D C P)
    (conjunto union)
    (conjunto completo)
    (conjunto interseccion)
    (auxiliar 0)
    (contador 0)
)

;Se unen las dos listas independientemente de que esten repetidos o no
(defrule unirListas
    (conjunto c1 $?cosa1)
    (conjunto c2 $?cosa2)
    (conjunto completo $?principioUnion $?finalUnion)
    =>
    (assert(conjunto completo $?cosa1 $?cosa2))
)

(deffunction longitud
    ($?argumentos)
    (length $?argumentos)
)

;Todo a y todo b
(defrule union
    (conjunto completo $?argumentos)
    ?conjuntoCompletoBorrar<-(conjunto completo $?inicio ?actual ?siguiente $?final)
    ?conjuntoInterseccionBorrar<-(conjunto interseccion $?principio)
    ?auxBorrar<-(auxiliar ?aux)
    ?contadorBorrar<-(contador ?contador)
    =>
    (assert(auxiliar ?actual))
    (retract ?auxBorrar)
    (while (< ?contador (longitud $?argumentos)) do
        (if (eq ?actual ?siguiente) then
            (assert(conjutno interseccion $?principio ?actual))
            (assert(conjunto completo $?inicio ?actual $?final))
            (retract ?conjuntoInterseccionBorrar)
            (retract ?conjuntoCompletoBorrar)
        )
        (assert(contador (+ 1 ?contador)))
        (retract ?contadorBorrar)
    )
)

(defrule imprimir
    (conjunto completo $?cosa)
    (conjunto interseccion $?cosaInterseccion)
    =>
    (printout t "Conjunto completo: " $?cosa crlf)
    (printout t "Conjunto interseccion: " $?cosaInterseccion crlf)
)

;Solo comunes de ambos a y b
(defrule interseccion
    ?conjunto1Borrar<-(conjunto c1 $?inicio1 ?actual ?siguiente $?final1)
    ?conjunto2Borrar<-(conjunto c2 $?inicio2 ?actual ?siguiente $?final2)
    =>
)