import Data.List

aply [] x = []
aply (x:xs) y = (lam x y) : (aply xs y)

lam 1 (y:ys) = y
lam x (y:ys) = lam (x-1) ys

q = [[1, 2, 3, 4], [1, 2, 4, 3], [2, 1, 3, 4], [2, 1, 4, 3]]

