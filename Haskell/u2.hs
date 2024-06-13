retrieve' :: Eq c => [c] -> [c] -> [[c]]
retrieve' x [] = [x]
retrieve' [] x = undefined
retrieve' [c] [a]
    | c /= a = [[c],[a]]
    | otherwise = [[c,a]]
retrieve' (x:xs) (y:ys)
    | x == y = retrieve' (x:y:xs) ys
    | otherwise = (x:xs) : retrieve' [y] ys

pack' :: Eq c => [c] -> [[c]]
pack' [] = [[]]
pack' [a] = [[a]]
pack' (x1:xs) = retrieve' [x1] xs

zaehler :: Eq a => [(Int, a)] -> [a] -> [(Int, a)]
zaehler x [] = x
zaehler ((n, c):xs) (y:ys)
    | c == y = zaehler ((n+1,c):xs) ys
    | otherwise = (n,c) : zaehler xs (y:ys)

encodeInit :: Eq a => [a] -> [(Int, a)]
encodeInit [x1,x2]
    | x1 == x2 = [(0, x1)]
    | otherwise = [(0, x1), (0, x2)]
encodeInit (x1:x2:xs)
    | x1 == x2 = encodeInit (x2:xs)
    | otherwise = (0, x1) : encodeInit (x2:xs)
    
encode :: Eq a => [a] -> [(Int, a)]
encode [] = undefined
encode x = zaehler (encodeInit x) x 
-- encode (x:xs) = zaehler [(0, x)] (x:xs)

-- zaehler' :: Eq a => [(Int, a)] -> [a] -> [(Int, a)]    
-- zaehler' x [] = x
-- zaehler' ((n, x):xs) [a]
--     | x == a = [(n+1, x)]
--     | otherwise = (n,x) : (1, a) : xs
-- zaehler' ((n,x):xs) (y:ys)
--     | x == y = zaehler' ((n+1,x):xs) ys
--     | otherwise = (n,x) : zaehler ((1,y):xs) ys 

decode :: Eq a => [(Int, a)] -> [a]
decode [] = []
decode ((0, c):xs) = decode xs
decode ((x, c):xs) = c : decode ((x-1, c):xs)

rotate :: [Int] -> Int -> [Int]
rotate [] _ = []
rotate (x:xs) a
    | a > 0 = rotate (xs ++ [x]) (a-1)
    | a < 0 = rotate (x:xs) ((length (x:xs))+a)
    | otherwise = (x:xs)

unwords' :: [String] -> String
unwords' [] = ""
unwords' [s] = s
unwords' (x:xs) = x ++ " " ++ unwords' xs

-- detectSpace :: String -> Bool
-- detectSpace "" = False
-- detectSpace x:xs
--     | x == " " = True
--     | otherwise = False

words' :: String -> [String]
words' [] = []
words' xs = stringAsCharList [] xs
    where stringAsCharList xs [] = (xs:[])
          stringAsCharList xs (' ':ys) = xs : stringAsCharList [] ys
          stringAsCharList xs (y:ys) = stringAsCharList (xs++[y]) ys

data Tree = Node String [Tree] deriving (Show)
-- "Wurzel" [Node "l" [], Node "m" [Node "lu" [], Node "ru" []], Node "r" []]
level :: Int -> Tree -> [String]
level 0 (Node v _)= [v]
level _ (Node _ []) = []
level n (Node v (t:ts))
    | n < 0 = undefined
    | otherwise = (level (n-1) t) ++ (level n (Node v ts))


data Queue = Queue [Int] deriving (Show)
isEmpty :: Queue -> Bool
isEmpty (Queue []) = True
isEmpty _ = False

enqueue :: Int -> Queue -> Queue
enqueue x (Queue []) = Queue [x]
enqueue x (Queue xs) = Queue (xs ++ [x])

first :: Queue -> Int
first (Queue []) = undefined
first (Queue (x:xs)) = x

rest :: Queue -> Queue
rest (Queue []) = Queue []
rest (Queue (x:xs)) = Queue xs


















