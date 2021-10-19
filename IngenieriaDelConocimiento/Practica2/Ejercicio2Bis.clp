(deffacts hechos-iniciales
    (posicion orilla1 granjero)
    (posicion orilla1 cabra)
    (posicion orilla1 lobo)
    (posicion orilla1 col)
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
    ?posicionBorrar<-(posicion ?nOrilla cabra)
    (opuesto ?nOrilla ?opuesta)
    ?moverBorrar<-(mover cabra)
    =>
    (assert(posicion ?opuesta cabra))
    (assert(mover granjero))
    (retract ?posicionBorrar)
    (retract ?moverBorrar)
)

(defrule moverLobo
    ?posicionBorrar<-(posicion ?nOrilla lobo)
    (opuesto ?nOrilla ?opuesta)
    ?moverBorrar<-(mover lobo)
    =>
    (assert(posicion ?opuesta lobo))
    (assert(mover granjero))
    (retract ?posicionBorrar)
    (retract ?moverBorrar)
)

(defrule moverCol
    ?posicionBorrar<-(posicion ?nOrilla col)
    (opuesto ?nOrilla ?opuesta)
    ?moverBorrar<-(mover col)
    =>
    (assert(posicion ?opuesta col))
    (assert(mover granjero))
    (retract ?posicionBorrar)
    (retract ?moverBorrar)
)

(defrule moverGranjero
    ?posicionBorrar<-(posicion ?nOrilla granjero)
    (opuesto ?nOrilla ?opuesta)
    ?moverBorrar<-(mover granjero)
    =>
    (assert(posicion ?opuesta granjero))
    (retract ?posicionBorrar)
    (retract ?moverBorrar)
)

(defrule comeLoboCabra
    (posicion ?nOrillaCabra cabra)
    (posicion ?nOrillaLobo lobo)
    (posicion ?nOrillaGranjero granjero)
    =>
    (if (and (eq ?nOrillaCabra ?nOrillaLobo) (neq ?nOrillaLobo ?nOrillaGranjero)) then
        (printout t "Has perdido el lobo se comio la cabra en: "?nOrillaLobo crlf)
    )
)

(defrule comeCabraCol
    (posicion ?nOrillaCabra cabra)
    (posicion ?nOrillaCol col)
    (posicion ?nOrillaGranjero granjero)
    =>
    (if (and (eq ?nOrillaCabra ?nOrillaCol) (neq ?nOrillaCol ?nOrillaGranjero)) then
        (printout t "Has perdido la cabra se comio la col en: "?nOrillaCol crlf)
    )
)

(defrule victoria
    (posicion orilla2 lobo)
    (posicion orilla2 cabra)
    (posicion orilla2 col)
    (posicion orilla2 granjero)
    =>
    (printout t "Has ganado enhorabuena." crlf)
)