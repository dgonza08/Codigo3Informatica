(deffacts hechos-iniciales
	(coche 1568 Azul)
	(coche 2456 Negro)
	(coche 5698 Rosa)
	(coche 6103 Blanco)
	(coche 3486 Amarillo)
	(coche 4278 Rojo)
	(coche 2456 Tesla ModelX)
	(coche 1568 Audi A4)
	(coche 6103 Tesla Model3)
	(coche 4278 Citroen C3)
	(coche 5698 Dacia Logan)
	(coche 3486 Nissan Leaf)
	(vendidos 1568 6103 4278)
)

(defrule cochesVendidos
	(coche ?matricula ?color)
	(coche ?matricula ?marca ?modelo)
	(vendidos $?principio ?actual $?final)
	(test(eq ?actual ?matricula))
	=>
	(assert(vendido coche ?marca ?modelo ?matricula color ?color))
)