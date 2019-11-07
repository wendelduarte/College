import math

def calcFunction(a):
  #f(x) = x³ + 4x² - 10 = 0
  return math.pow(a, 3) + (4*math.pow(a,2)) - 10

def bissecao(a,b,tol,iteracoes):
  i = 1
  fa = calcFunction(a)

  while i <= iteracoes:
    p=a+(b-a)/2
    fp = calcFunction(p)

    if(fp == 0 or abs(fp) < tol):
      return fp
    i = i+1
    if(fa*fp > 0):
      a=p
      fa = fp
    else:
      b=p

  return "Falha"

print(bissecao(1,2,0.1,300))