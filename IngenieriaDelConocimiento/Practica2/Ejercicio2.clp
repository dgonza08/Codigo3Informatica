(deffacts hechos-iniciales
    (posicion orilla 1 granjero)
    (posicion orilla 1 cabra)
    (posicion orilla 1 lobo)
    (posicion orilla 1 col)
)

(deffacts quienComeAQuien
    (come cabra col)
    (come lobo cabra)
)

(deffacts orillasOpuestas
    (opuesto orilla1 orilla2)
    (opuesto orilla2 orilla1)
)

