(deffacts hechos-iniciales
	(joya j1 zafiro azul)
	(joya j2 aguamarina azul)
	(joya j3 plata antigua)
	(joya j4 oro blanco)
	(joya j5 oro blanco)
	(joya j6 plata antigua)
	(joya j7 oro rosa)
)

(defrule comprobarJoyas
	(joya ?nombre ?tipo ?color)
	(test(eq ?tipo ?color))
	=>
	(printout t "Las joyas ")
)