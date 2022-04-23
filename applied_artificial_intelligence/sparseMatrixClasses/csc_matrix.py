import numpy as np
from scipy.sparse import csc_matrix
cscMatrix = csc_matrix((3, 4), dtype=np.int8).toarray()
print("csc matrix")
print(cscMatrix)

row = np.array([0, 2, 2, 0, 1, 2])
col = np.array([0, 0, 1, 2, 2, 2])
data = np.array([1, 2, 3, 4, 5, 6])
cscMatrix = csc_matrix((data, (row, col)), shape=(3, 3)).toarray()
print("csc after input data")
print(cscMatrix)

indptr = np.array([0, 2, 3, 6])
indices = np.array([0, 2, 2, 0, 1, 2])
data = np.array([1, 2, 3, 4, 5, 6])
cscMatrix = csc_matrix((data, indices, indptr), shape=(3, 3)).toarray()
print("csc after input indptr and indices")
print(cscMatrix)
