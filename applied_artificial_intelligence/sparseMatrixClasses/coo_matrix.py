import numpy as np
from scipy.sparse import coo_matrix
cooMatrix = coo_matrix((3, 4), dtype=np.int8).toarray()
print("Create coo matrix")
print(cooMatrix)

row  = np.array([0, 3, 1, 0])
col  = np.array([0, 3, 1, 2])
data = np.array([4, 5, 7, 9])
cooMatrix = coo_matrix((data, (row, col)), shape=(4, 4)).toarray()
print("cooMatrix = coo_matrix((data, (row, col)), shape=(4, 4)).toarray()");
print(cooMatrix)

row  = np.array([0, 0, 1, 3, 1, 0, 0])
col  = np.array([0, 2, 1, 3, 1, 0, 0])
data = np.array([1, 1, 1, 1, 1, 1, 1])
coo = coo_matrix((data, (row, col)), shape=(4, 4))
# Duplicate indices are maintained until implicitly or explicitly summed
cooMax = np.max(coo.data)
print("np.max(coo.data)")
print(cooMax)
cooMatrix = coo.toarray()
print("cooMatrix")
print(cooMatrix)
