import numpy as np
from scipy.sparse import csr_matrix
csrMatrix = csr_matrix((3, 4), dtype=np.int8).toarray()
print("csrMatrix")
print(csrMatrix)

row = np.array([0, 0, 1, 2, 2, 2])
col = np.array([0, 2, 2, 0, 1, 2])
data = np.array([1, 2, 3, 4, 5, 6])
csrMatrix = csrMatrix = csr_matrix((data, (row, col)), shape=(3, 3)).toarray()
print("csrMatrix after input row, coll and data")
print(csrMatrix)

indptr = np.array([0, 2, 3, 6])
indices = np.array([0, 2, 2, 0, 1, 2])
data = np.array([1, 2, 3, 4, 5, 6])
csrMatrix = csr_matrix((data, indices, indptr), shape=(3, 3)).toarray()
print("csr after input indptr, indices and data")
print(csrMatrix)

row = np.array([0, 1, 2, 0])
col = np.array([0, 1, 1, 0])
data = np.array([1, 2, 4, 8])
csrMatrix = csr_matrix((data, (row, col)), shape=(3, 3)).toarray()
print("csr after input row, col and data")
print(csrMatrix)

print("As an example of how to construct a CSR matrix incrementally, the following snippet builds a term-document matrix from texts:")

docs = [["hello", "world", "hello"], ["goodbye", "cruel", "world"]]
indptr = [0]
indices = []
data = []
vocabulary = {}
for d in docs:
     for term in d:
         index = vocabulary.setdefault(term, len(vocabulary))
         indices.append(index)
         data.append(1)
     indptr.append(len(indices))

csrMatrix = csr_matrix((data, indices, indptr), dtype=int).toarray()
print(csrMatrix)
