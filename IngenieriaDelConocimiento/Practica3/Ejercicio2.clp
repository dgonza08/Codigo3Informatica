(deffacts hechos-iniciales
    (letras A B C D E F G H I J K L M N O P)
    (conjunto c1 A B F I L P)
    (conjunto c2 A E H O M N D C J)
    (conjunto union 0)
    (conjunto interseccion)
    (conjuntoConjunto)
)

(defrule crearListaConjunta
    (conjunto c1 $?cosac1)
    (conjunto c2 $?cosac2)
    ?conjuntoBorrar<-(conjuntoConjunto $?)
    =>
    (assert(conjuntoConjuntoNuevo $?cosac1 $?cosac2))
    (retract ?conjuntoBorrar)
)

(defrule union
    ?conjuntoBorrar<-(conjuntoConjuntoNuevo $?inicio ?anterior ?numero $?final)
    =>
    (if (eq ?anterior ?numero) then
        (assert(conjuntoConjuntoNuevo $?inicio ?numero ?anterior $?final))
        (retract ?conjuntoBorrar)
    else (assert(conjuntoConjuntoNuevo $?inicio ?numero ?anterior $?final))
        (retract ?conjuntoBorrar) 
    )  
)