aply 'o' x y z g = (y:[])
aply x y 'o' z g = (x:[])
aply 'd' 2 x y z = aply 'o' 1 x y z
aply x y 'd' 2 g = aply  x y 'o' 1 g
aply 

sting 1 = "1"
sting 0 = "0"
sting 2 = "2"
sting 3 = "3"
sting 4 = "4"
sting 5 = "5"