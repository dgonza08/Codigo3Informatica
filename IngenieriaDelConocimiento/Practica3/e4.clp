(deftemplate pelicula
	(slot titulo)
	(slot director)
)

(deffacts hechos-iniciales
	(entrar si)
)

(defrule pedir
	(entrar si)
	=>
	(printout t "¿Introducir nueva película?(si/no)" crlf)
	(bind ?input (read))
)

(defrule comprobarNo
	?entrarBorrar<-(entrar ?sino)
	(test(eq ?sino no))
	=>
	(assert(entrar no))
	(retract ?entrarBorrar)
)

(defrule comprobarSi
	?entrarBorrar<-(entrar ?sino)
	(test(eq ?sino si))
	=>
	(printout t "Introduce el titulo: " crlf)
	(bind ?titulo(read))
	(printout t "Introduce el director: " crlf)
	(bind ?director(read))
	(assert(pelicula (titulo ?titulo)(director ?director)))
)		