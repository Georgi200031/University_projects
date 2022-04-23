import numpy as np
from scipy.sparse import bsr_matrix
bsrMatrix = bsr_matrix((3, 4), dtype=np.int8).toarray()
print("Create bsrMatrix [3, 4]");
print(bsrMatrix);

row = np.array([0, 0, 1, 2, 2, 2]) 
col = np.array([0, 2, 2, 0, 1, 2])
data = np.array([1, 2, 3 ,4, 5, 6])
bsrMatrix = bsr_matrix((data, (row, col)), shape=(3, 3)).toarray()
print("bsr_matrix((data, (row, col)), shape=(3, 3)).toarray()")
print(bsrMatrix);

indptr = np.array([0, 2, 3, 6])
indices = np.array([0, 2, 2, 0, 1, 2])
data = np.array([1, 2, 3, 4, 5, 6]).repeat(4).reshape(6, 2, 2)
bsrMatrix = bsr_matrix((data,indices,indptr), shape=(6, 6)).toarray()
print("bsrMatrix = bsr_matrix((data,indices,indptr), shape=(6, 6)).toarray()")
print(bsrMatrix);
