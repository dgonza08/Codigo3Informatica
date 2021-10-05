(deffacts hechosIniciales
    (rectangulo A 9 6)
    (rectangulo B 7 5)
    (rectangulo C 6 9)
    (rectangulo D 2 5)
    (areaTotal 0)
)

(defrule mostrarAreaA
    (rectangulo A ?base ?altura)
    ?indice<-(areaTotal ?)
    =>
    (assert(areaTotal1 (* ?base ?altura)))
    (printout t "El area de A es: " (* ?base ?altura) crlf)
    (retract ?indice)
)

(defrule mostrarAreaB
    (rectangulo B ?base ?altura)
    ?indice<-(areaTotal1 ?)
    =>
    (assert(areaTotal2 (* ?base ?altura)))
    (printout t "El area de B es: " (* ?base ?altura) crlf)
    (retract ?indice)
)

(defrule mostrarAreaC
    (rectangulo C ?base ?altura)
    ?indice<-(areaTotal2 ?)
    =>
    (assert(areaTotal3 (* ?base ?altura)))
    (printout t "El area de C es: " (* ?base ?altura) crlf)
    (retract ?indice)
)

(defrule mostrarAreaD
    (rectangulo D ?base ?altura)
    ?indice<-(areaTotal3 ?)
    =>
    (assert(areaTotal4 (* ?base ?altura)))
    (printout t "El area de D es: " (* ?base ?altura) crlf)
    (retract ?indice)
)

;NO SE COMO SUMARLE A LA VARIABLE "GLOBAL" mirar a ver