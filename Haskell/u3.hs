data Tree = Node Int Tree Tree | Nil deriving (Show)
insert :: Tree -> [Int] -> Tree
insert t [] = t
insert Nil (x:xs) = insert (Node x Nil Nil) xs
insert (Node v t1 t2) (x:xs)
    | v < x = insert (Node v t1 (insert t2 [x])) xs
    | otherwise = insert (Node v (insert t1 [x]) t2) xs


isEqual :: Tree -> Tree -> Bool
isEqual Nil Nil = True
isEqual Nil _ = False
isEqual _ Nil = False
isEqual (Node v1 t1l t1r) (Node v2 t2l t2r)
    | v1 == v2 = (isEqual t1l t2l) && (isEqual t1r t2r)

data BigTree = BigNode Int [BigTree]
noLeaves :: BigTree -> Int
noLeaves (BigNode _ []) = 1
noLeaves (BigNode _ ts) = noLeaves' ts

noLeaves' :: [BigTree] -> Int
noLeaves' [] = 0
noLeaves' (t:ts) = noLeaves t + noLeaves' ts 

-- let t = (BigNode 1 [(BigNode 2 []), (BigNode 3 []), (BigNode 4 [(BigNode 5 []), (BigNode 6 [])])])

-- f :: [Int] -> Int
-- map :: (Int -> Int) -> [Int] -> [Int]
-- map f [] = []
-- map f (x:xs)
--     | 

data Treee a = Nodee a (Treee a) (Treee a) | Leaf a deriving Show
sub :: Treee a -> [Treee a]
sub (Leaf x) = []
sub (Nodee x t1 t2) = [Nodee x t1 t2] ++ (sub t1) ++ (sub t2)
















