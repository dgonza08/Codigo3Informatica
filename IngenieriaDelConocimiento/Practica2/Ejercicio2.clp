(deffacts hechos-iniciales
    (posicion orilla 1 granjero)
    (posicion orilla 1 cabra)
    (posicion orilla 1 lobo)
    (posicion orilla 1 col)
    (numeroOrillaGranjero 1)
    (auxiliar 0)
)

(deffacts quienComeAQuien
    (come cabra col)
    (come lobo cabra)
)

(deffacts orillasOpuestas
    (opuesto orilla1 orilla2)
    (opuesto orilla2 orilla1)
)

(defrule moverCabra
    ?orillaGranjeroBorrar<-(numeroOrillaGranjero ?orillaGranjero)
    ?posicionBorrar<-(posicion orilla ?nOrilla cabra)
    ?borrarQuien<-(mover cabra)
    =>
    (if (= ?nOrilla 2) then
        (assert(posicion orilla 1 cabra))
        (retract ?posicionBorrar)
    )
    (if (= ?nOrilla 1) then
        (assert(posicion orilla 2 cabra))
    ) 

    (if (= ?orillaGranjero 1) then
        (assert(orillaGranjero 2))  
    )  
    (if (= ?orillaGranjero 2) then
        (assert(orillaGranjero 1))
    )
    
    (retract ?posicionBorrar)
    (retract ?borrarQuien)
    (retract ?orillaGranjeroBorrar)
)

(defrule moverLobo
    ?orillaGranjeroBorrar<-(numeroOrillaGranjero ?orillaGranjero)
    ?posicionBorrar<-(posicion orilla ?nOrilla lobo)
    ?borrarQuien<-(mover lobo)
    =>
    (if (= ?nOrilla 2) then
        (assert(posicion orilla 1 lobo))
        (retract ?posicionBorrar)
    )
    (if (= ?nOrilla 1) then
        (assert(posicion orilla 2 lobo))
        (retract ?posicionBorrar)
    )

    (if (= ?orillaGranjero 1) then
        (assert(orillaGranjero 2))  
    )  
    (if (= ?orillaGranjero 2) then
        (assert(orillaGranjero 1))
    )

    (retract ?posicionBorrar)   
    (retract ?borrarQuien)
    (retract ?orillaGranjeroBorrar)
)

(defrule moverCol
    ?orillaGranjeroBorrar<-(numeroOrillaGranjero ?orillaGranjero)
    ?posicionBorrar<-(posicion orilla ?nOrilla col)
    ?borrarQuien<-(mover col)
    =>
    (if (= ?nOrilla 2) then
        (assert(posicion orilla 1 col))
        (retract ?posicionBorrar)
    )
    (if (= ?nOrilla 1) then
        (assert(posicion orilla 2 col))
        (retract ?posicionBorrar)
    )

    (if (= ?orillaGranjero 1) then
        (assert(orillaGranjero 2))  
    )  
    (if (= ?orillaGranjero 2) then
        (assert(orillaGranjero 1))
    )
    
    (retract ?posicionBorrar)
    (retract ?borrarQuien)
    (retract ?orillaGranjeroBorrar)
)

(defrule comprobar
    (posicion orilla ?nOrilla ?quien)
    ?auxBorrar<-(auxiliar ?aux)
    (numeroOrillaGranjero ?nOrillagranjero)
    =>
    (if (= ?nOrilla 2) then
        (assert(auxiliar (+ 1 ?aux)))
    )

    (if (= ?aux 4) then
        (printout t "Has ganado" crlf)
    )
)

(defrule comprobarSiSeComenCabras
    (nOrillagranjero ?nOrillaGranjero)
    (posicion orilla ?nOrillaCabra cabra)
    (posicion orilla ?nOrillaLobo lobo)
    =>
    (if (and (= ?nOrillaCabra ?nOrillaLobo)(neq ?nOrillaGranjero ?nOrillaCabra))then
        (printout t "Has perdido, el lobo se comio a la cabra" crlf)
    )
)

(defrule comprobarSiSeComenColes
    (nOrillagranjero ?nOrillaGranjero)
    (posicion orilla ?nOrillaCol col)
    (posicion orilla ?nOrillaCabra cabra)
    =>
    (if (and (= ?nOrillaCabra ?nOrillaCol)(neq ?nOrillaGranjero ?nOrillaCol)) then
        (printout t "Has perdido, la cabra se comio a la col" crlf)
    )
)