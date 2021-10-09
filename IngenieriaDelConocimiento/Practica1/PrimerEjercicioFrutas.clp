(deffacts hechos-iniciales
    (fruta pera calorias 23)
    (fruta manzana calorias 45)
    (fruta fresa calorias 60)
    (fruta platano calorias 18)
    (fruta ciruela calorias 30)
)

(defrule saberCalorias
    (fruta ?nombreFruta ? ?numeroCalorias)
    =>
    (printout t "La fruta llamada "?nombreFruta" tiene "?numeroCalorias" calorias" crlf)
)

(defrule hipercaloricas
    (fruta ?nombreFruta ? ?numeroCalorias)
    (test(> ?numeroCalorias 20))
    =>
    (assert(Fruta ?nombreFruta hipercalorica))
)

(defrule borrar
    (fruta ?nombre ? ?numeroCalorias)
    ?fruta<-(fruta $?)
    (test(< ?numeroCalorias 30))
    =>
    (retract ?fruta)
)