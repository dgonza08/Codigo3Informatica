;TODO Conseguir mostrar por pantalla la union y la interseccion de 
; los dos conjuntos de letras 
(deffacts hechos-iniciales
    (letras A B C D E F G H I J K L M N O P)
    (conjunto c1 A B F I L E)
    (conjunto c2 A B H E M N D C P)
    (conjunto union)
    (conjunto completo)
    (auxiliar 0)
)

;Se unen las dos listas independientemente de que esten repetidos o no
(defrule unirListas
    (conjunto c1 $?cosa1)
    (conjunto c2 $?cosa2)
    (conjunto completo $?principioUnion $?finalUnion)
    =>
    (assert(conjunto completo $?cosa1 $?cosa2))
)

;Todo a y todo b
(defrule union
    ?conjuntoCompletoBorrar<-(conjunto completo $?inicio ?actual ?siguiente $?final)
    ?auxiliarBorrar<-(auxiliar ?aux)
    ?conjuntoUnionBorrar<-(conjunto interseccion $?principioInterseccion $?finalInterseccion)
    =>
    (if (eq ?actual ?siguiente) then
        (assert(conjunto interseccion $?principioUnion ?actual $?finalUnion))
        (retract ?conjuntoUnionBorrar)
    )
    (assert(conjunto completo $?inicio ?siguiente ?actual $?final))
    (retract ?conjuntoCompletoBorrar)
)

;(defrule imprimir
;    (conjunto completo $?cosa)
;    =>
;    (printout t "Conjunto completo: " $?cosa crlf)
;)

;Solo comunes de ambos a y b
(defrule interseccion
    ?conjunto1Borrar<-(conjunto c1 $?inicio1 ?actual ?siguiente $?final1)
    ?conjunto2Borrar<-(conjunto c2 $?inicio2 ?actual ?siguiente $?final2)
    =>
)