(deffacts hechosIniciales
    (rectangulo A 9 6)
    (rectangulo B 7 5)
    (rectangulo C 6 9)
    (rectangulo D 2 5)
    (areaTotal 0)
)

(defrule mostrarArea
    (rectangulo ?letra ?base ?altura)
    ;?indice<-(areaTotal ?)
    =>
    (assert(areaTotal1 (* ?base ?altura)))
    (printout t "El area de "?letra" es: " (* ?base ?altura) crlf)
    ;(retract ?indice)
)