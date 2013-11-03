import Data.List
--No clue what this does but look how elegant it is!
evl (x, 2) = evl(x, 0)
evl (2, x) = evl(0, x)
evl x = x
plus (a, b) (c, d) = evl (a + c, b + d)

forg = [(0, 0), (0, 1), (1, 0), (1, 1)]

ferf x = farf x forg

farf x y = flurf x y []

flurf x [] hlp = hlp
flurf x (y:xs) garbgae = flurf x xs ((x, y):garbgae)

combos = map ferf forg

q = ["abc", "def", "ghi", "jkl"]

ant x [[], bs, cs, ds] y = y
ant [as, bs, cs, ds] [xs, ys, zs, []] y = ant [as, bs, cs, ds] [xs, ys, tail zs, ds] y
ant [as, bs, cs, ds] [xs, ys, [], zs] y = ant [as, bs, cs, ds] [xs, tail ys, cs, zs] y
ant [as, bs, cs, ds] [xs, [], ys, zs] y = ant [as, bs, cs, ds] [tail xs, bs, ys, zs] y
ant x [xs, ys, zs, as] y = ant x [xs, ys, zs, tail as] ([head xs, head ys, head zs, head as]:y)

bijects = filter bigect $ ant combos combos []

bigect x = not (notbigect x)
notbigect [(a, b), (c, d), (e, f), (g, h)] = b == d || b == f || b == h || d == f || d == h || f == h

furst (x, y) = x
lats (x, y) = y
trash z (x, y) = x == z
hedd (x:xs) = x
aply m x = lats $ hedd $ filter (trash x) m

mrph m x y = aply m (plus x y) == plus (aply m x) (aply m y)

garple m [[]] = True
garple m ([]:xs) = garple m xs
garple m (((x, y):xs):ys) = mrph m x y && garple m (xs:ys)

graple m (x, y) = mrph m x y

greple m [] = True
greple m (x:xs) = graple m x && greple m xs

lagit m [] = True
lagit m (x:xs) = greple m x && lagit m xs

islegit m = lagit m combos