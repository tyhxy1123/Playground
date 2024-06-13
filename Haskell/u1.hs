prod :: [Int] -> Int
prod [] = 0
prod [x] = x
prod (x:xs) = x * prod xs

rev' :: [Int] -> [Int]
rev' [] = []
rev' [x] = [x]
rev' (x:xs) = rev' xs ++ [x]

rem' :: Int -> [Int] -> [Int]
rem' _ [] = []
rem' x [a]
    | x == a = []
    | otherwise = [a]
rem' a (x:xs)
    | a == x = rem' a xs
    | otherwise = [x] ++ rem' a xs

isOrd' :: [Int] -> Bool
isOrd' [] = True
isOrd' [x] = True
isOrd' [a,b] 
    | a > b = False
    | (a < b) || (a == b) = True
isOrd' (x1:x2:xs)
    | x1 > x2 = False
    | otherwise = isOrd' (x2:xs)

merge' :: [Int] -> [Int] -> [Int]
merge' x [] = x
merge' [] x = x
merge' [a] [b]
    | a <= b = [a,b]
    | otherwise = [b,a]
merge' [a] (x:xs)
    | a <= x = [a] ++ (x:xs)
    | otherwise = [x] ++ merge' [a] xs 
merge' (x:xs) y = merge' xs (merge' [x] y)

fibonacci :: Int -> Int
fibonacci 1 = 1
fibonacci 2 = 1
fibonacci n = fibonacci (n-1) + fibonacci (n-2)

erzeugeFib :: [Int] -> [Int]
erzeugeFib [] = undefined
erzeugeFib [x] = undefined
erzeugeFib (x:xs) = fibonacci x : erzeugeFib xs

fibs :: [Int]
fibs = erzeugeFib [1..]







