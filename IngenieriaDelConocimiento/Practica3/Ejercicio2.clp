;TODO Conseguir mostrar por pantalla la union y la interseccion de 
; los dos conjuntos de letras 

(deffacts hechos-iniciales
    (letras)
    (conjunto c1 A B F I L E)
    (conjunto c2 A B H E M N D C P)
    (conjunto union)
    (conjunto completo)
    (conjunto interseccion)
    (auxiliar)
)

(defrule letras
    (conjunto c1 $?todo1)
    (conjunto c2 $?todo2)
    ?letrasBorrar<-(letras $?cosa)
    =>
    (assert(letrasAtope $?todo1 $?todo2))
    (retract ?letrasBorrar)
)

;Solo comunes de ambos a y b
(defrule interseccion
    (letrasAtope $?prin1 ?med1 $?medio ?med1 $?final)
    =>
    (assert(auxiliar ?med1))
)

(defrule meterEnLista
    ?interseccionBorrar<-(conjunto interseccion $?cosaInterseccion)
    ?auxBorrar<-(auxiliar ?letra)
    =>
    (assert(conjunto interseccion $?cosaInterseccion ?letra))
    (retract ?interseccionBorrar)
    (retract ?auxBorrar)
)

(defrule meterEnLista2
    (letrasAtope $?todo)
    =>
    (assert(unionn $?todo))
)

;Todo a y todo b

(defrule union1
    ?chisme<-(unionn $?prin1 ?med1 $?medio ?med1 $?final)
    =>
    (assert(unionn $?prin1 ?med1 ?medio $?final))
    (retract ?chisme)
)

(defrule imprimir
    (conjunto interseccion $?inter)
    (unionn $?union)
    =>
    (printout t "El conjunto interseccion es: " $?inter crlf)
    (printout t "El conjunto union es: " $?union crlf)
)
