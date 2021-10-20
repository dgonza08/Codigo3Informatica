(deffacts hechos-iniciales
    (letras A B C D E F G H I J K L M N O P)
    (conjunto c1 A B F I L P)
    (conjunto c2 A E H O M N D C J)
    (conjunto union)
    (conjunto interseccion)
)

(defrule union
    (conjunto c1 $?inicioc1 ?actualc1 $?finalc1)
    (conjunto c2 $?inicioc2 ?actualc2 $?finalc2)
    =>
    
)

(defrule interseccion

)