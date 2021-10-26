;TODO Conseguir mostrar por pantalla la union y la interseccion de 
; los dos conjuntos de letras 

(deftemplate letra
    (slot letrilla
        (type SYMBOL)
    )
)

(deffacts hechos-iniciales
    (letras A B C D E F G H I J K L M N O P)
    (conjunto c1 A B F I L E)
    (conjunto c2 A B H E M N D C P)
    (conjunto union)
    (conjunto completo) ;conjunto con todas las letras de los dos conjuntos con repeticion
    ; A B F I L E A B H E M N D C P
    (conjunto interseccion)
    (auxiliar)
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

(defrule distribuirLetras
    (conjunto completo $?inicio ?actual $?final)
    =>
    (assert(letra(letrilla ?actual)))
)

;Solo comunes de ambos a y b
(defrule interseccion
    ?conjuntoCompletoBorrar<-(conjunto completo $?principio ?anterior ?siguiente $?final)
    ?conjuntoInterseccionBorrar<-(conjunto interseccion $?inicio ?actual ?siguiente1)
    =>
    (if (eq ?anterior ?siguiente) then
        (assert(conjunto interseccion $?inicio ?siguiente1 ?anterior))
        (retract ?conjuntoInterseccionBorrar)
    )
)

;Todo a y todo b
(defrule union
    (letra(letrilla ?letra))
    ?conjuntoUnionBorrar<-(conjunto union $?principio ?actual)
    =>
    (assert(conjunto union $?principio ?letra))
    (retract ?conjuntoUnionBorrar)
)

(defrule imprimir
    (contador ?count)
    =>
    (printout t "El conjunto union es: " crlf)
)

(defrule imprimirPrueba
    ?letraBorrar<-(letra(letrilla ?letra))
    =>
    (printout t " "?letra)
)

(defrule imprimir
    =>
    (printout t crlf)
)