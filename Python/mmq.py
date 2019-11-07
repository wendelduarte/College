#Metodo Minimos quadrados de newton
#Para calcular com valores diferentes comente X e Y (duas linhas abaixo) e tire o comentário das linhas seguintes à X e Y

x = [0,0.25,0.50,0.75,1.00]
y = [1.0000,1.2840,1.6487,2.1170,2.7183]

# x = []
# y = []
# size = int(input("Digite a quantidade de pontos: "))
# for i in range(size):
#   x.append(float(input("Digite X: ")))
# print("----------------------------")
# for i in range(size):
#   y.append(float(input("Digite Y: ")))

sumXQuadrado = sumQuadrado(x)
sumY = sum(y)
sumXY = sumMult(x, y)
sumX = sum(x)
sumXQuadradoMultSize = sumXQuadrado*len(x)
sumXPotDois = sumX**2

sumXYMultSize = sumXY*len(x)

a0 = (sumXQuadrado*sumY - sumXY*sumX)/(sumXQuadradoMultSize-sumXPotDois)
a1 = (sumXYMultSize-sumX*sumY)/(sumXQuadradoMultSize-sumXPotDois)

print("----------------------------")

print("A0: ",a0, 
      "\nA1: ", a1)

#Funções para cálculos:
def sumQuadrado(vet):
  aux = []
  count = 0
  for i in range(len(x)):
    aux.append(vet[i]*vet[i])
  for i in range(len(x)):
    count += aux[i]
  return count

def sum(vet):
  count = 0
  for i in range(len(y)):
    count += vet[i]
  return count

def sumMult(x, y):
  aux = []
  count = 0
  for i in range(len(x)):
    aux.append(x[i]*y[i])
  for i in range(len(x)):
    count += aux[i]
  return count