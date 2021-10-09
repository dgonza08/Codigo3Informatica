(deffacts hechosIniciales
    (rectangulo A 9 6)
    (rectangulo B 7 5)
    (rectangulo C 6 9)
    (rectangulo D 2 5)
    (areaTotal 0)
)

(defrule mostrarArea
    ?rectanguloBorrar<-(rectangulo ?letra ?base ?altura)
    =>
    (printout t "El area de "?letra" es: " (* ?base ?altura) crlf)
	(assert(rectangulo ?letra (* ?base ?altura)))
    (retract ?rectanguloBorrar)
)

(defrule meterAreas
 ?rectanguloBorrar<-(rectangulo ?letra ?areaParticular)
     ?areaBorrar<-(areaTotal ?areaFinal)
    =>
	(assert(areaTotal (+ ?areaFinal ?areaParticular)))
    (retract ?rectanguloBorrar)	
	(retract ?areaBorrar)
)

(defrule imprimirFinal
	(areaTotal ?areaFinal)
	=>
	(printout t "El area de todos sumada es: "?areaFinal crlf)
)