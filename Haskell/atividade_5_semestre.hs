--Atividade - Paradigma funcional
--1 a
soma x y = x + y

--1 b
quadrado x = x**2

--1 c
multiplicacao x = \y -> x * y

--1 d
elevado x = \y -> x**y

--2
tripla x y z
  | x**2 + y**2 == z**2 = "eh uma tripla de Pitagoras"
  | x**2 + z**2 == y**2 = "eh uma tripla de Pitagoras"
  | y**2 + z**2 == x**2 = "eh uma tripla de Pitagoras"
  | otherwise = "nao eh uma tripla de Pitagoras"

--3
tempo_jogo inicio fim
  | fim < inicio = (fim+24) - inicio
  | inicio == fim = 24
  | otherwise = -(inicio - fim)

--4
russa a b 
  | a == 1 = b
  | mod a 2 == 0 = 0 + russa (div a 2) b*2
  | mod a 2 /= 0 = b + russa (div a 2) b*2
  
--5
quantidade_pares lista = length(lista)- sum([mod x 2  | x <-lista]) 

--6
gera_lista_menor_igual m lista = [f | f <- lista, f <= m]
