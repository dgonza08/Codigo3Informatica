(deffacts hechos-iniciales
	(equipajeDeMano Armas Ropa Baterias Telefono Liquidos)
	(maleta Ropa Telefono Explosivos Animales)
	(prohibidos Armas Baterias Liquidos Explosivos Animales)
)

(defrule conjunto
	(equipajeDeMano $?principioMano ?actualMano $?finalMano)
	(maleta $?principioMaleta ?actualMaleta $?finalMaleta)
	(prohibidos $?principioProhibidos ?actualProhibidos $?finalProhibidos)
	(test(and (eq ?actualMano ?actualMaleta)(neq ?actualMano ?actualProhibidos)))
	=>
	(assert(resultado ?actualMano))
)