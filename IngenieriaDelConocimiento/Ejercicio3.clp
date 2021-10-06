(deffacts hechosIniciales
    (rectangulo A 9 6)
    (rectangulo B 7 5)
    (rectangulo C 6 9)
    (rectangulo D 2 5)
    (areaTotal 0)
)

(defrule mostrarArea
    (rectangulo ?letra ?base ?altura)
    (areaTotal ?areaFuturaTotal)
    (areaTotal1 ?areaQueVaAAnyadirse)
    ?indice<-(areaTotal1 ?)
    =>
    (assert(areaTotal1 (+ ?areaFuturaTotal (* ?base ?altura))))
    (assert(areaTotal ?areaQueVaAAnyadirse))
    (printout t "El area de "?letra" es: " (* ?base ?altura) crlf)
    (retract ?indice)
)