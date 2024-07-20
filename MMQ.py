import pandas as pd
import numpy as np
import matplotlib.pyplot as plt

# Função de MMQ
def OLSfit(x, y, dy=None):
  
    if dy is None:
        #if no error bars, weight every point the same
        dy = np.ones(x.size)
    denom = np.sum(1 / dy**2) * np.sum((x / dy)**2) - (np.sum(x / dy**2))**2
    a = (np.sum(1 / dy**2) * np.sum(x * y / dy**2) -
         np.sum(x / dy**2) * np.sum(y / dy**2)) / denom
    b = (np.sum(x**2 / dy**2) * np.sum(y / dy**2) -
         np.sum(x / dy**2) * np.sum(x * y / dy**2)) / denom
    da = np.sqrt(np.sum(1 / dy**2) / denom)
    db = np.sqrt(np.sum((x / dy)**2) / denom)
    return([a, da, b, db])


df = pd.DataFrame()

x = np.array([0.808, 0.883, 1.001, 1.094, 1.195, 1.297, 1.4, 1.5, 1.55])
dx = np.array([0.001, 0.001, 0.001, 0.001, 0.001, 0.001, 0.001, 0.001, 0.001])
y = np.array([0.0, 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8])
dy = np.array([0.05, 0.05, 0.05, 0.05, 0.05, 0.05, 0.05, 0.05, 0.05])

df['x'] = x
df['dx'] = dx
df['y'] = y
df['dy'] = dy

bestfit = OLSfit(x,y,dy)
print(bestfit)
a = bestfit[0]
b = bestfit[2]

# A linha de melhor ajuste
xrange = np.arange(0.9*min(x),1.1*max(x),(1.1*max(x)-min(x))/100)
yfit = a*xrange + b

plt.errorbar(x,y,yerr=dy,xerr=dx,fmt='o')
plt.xlabel('x')
plt.ylabel('y')

plt.plot(xrange,yfit,lw=3,color='red')
plt.grid()
plt.title('y vs. x com a linha de melhor ajuste')
plt.show()












