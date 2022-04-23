import numpy as np
from scipy.sparse import dia_matrix
diaMatrix = dia_matrix((3, 4), dtype=np.int8).toarray()
print("create diaMatrix")
print(diaMatrix)

data = np.array([[1, 2, 3, 4]]).repeat(3, axis=0)
offsets = np.array([0, -1, 2])
diaMatrix = dia_matrix((data, offsets), shape=(4, 4)).toarray()
print("dia after input data and offset")
print(diaMatrix)

from scipy.sparse import dia_matrix
n = 10
ex = np.ones(n)
data = np.array([ex, 2 * ex, ex])
offsets = np.array([-1, 0, 1])
diaMatrix = dia_matrix((data, offsets), shape=(n, n)).toarray()

print(diaMatrix)

