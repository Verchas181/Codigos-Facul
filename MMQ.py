
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

x = np.array([145.89, 174.87, 199.09, 40.65, 48.65, 56.60, 64.37, 72.13, 79.79, 75.48, 80.56, 84.90, 95.49, 107.91, 124.04, 141.07, 160.03, 183.02])

# Valores de Y e Erro em Y
y = np.array([0.00207025, 0.00255025, 0.003136, 0.000576, 0.000729, 0.001089, 0.00126025, 0.00140625, 0.001521, 0.001296, 0.001444, 0.00164025, 0.001764, 0.001849, 0.00207025, 0.00245025, 0.00286225, 0.00308025])
import numpy as np
dy = np.array([
    0.0001287, 0.0001500, 0.0001693, 0.0000411, 0.0000474, 0.0000568,
    0.0000626, 0.0000678, 0.0000724, 0.0000672, 0.0000717, 0.0000765,
    0.0000835, 0.0000910, 0.0001024, 0.0001162, 0.0001313, 0.0001474
])



bestfit = OLSfit(x,y,dy)
print(bestfit)
a = bestfit[0]
b = bestfit[2]
equacao = (f"R² = {a} * V/I² + {b}")


xrange = np.arange(0.9 * min(x), 1.1 * max(x), (1.1 * max(x) - min(x)) / 100)
yfit = a * xrange + b

plt.errorbar(x,y, yerr=dy, fmt='o', color='red')
plt.xlabel('V/I²')
plt.ylabel('R²')

plt.plot(xrange, yfit, lw=3, color='black')
plt.grid()
plt.title('R² X V/I²')
plt.text(0.05, 0.95, equacao, transform=plt.gca().transAxes, fontsize=12, verticalalignment='top')
plt.show()
