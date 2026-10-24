# University projects

Coursework collection: sparse-matrix examples in Python and a parallel travelling-salesperson exercise in Java.

## Sparse matrices

applied_artificial_intelligence/sparseMatrixClasses contains examples of BSR, COO, CSC, CSR, DIA and DOK formats using NumPy/SciPy. Install numpy and scipy in a virtual environment, then run an individual script:

~~~sh
python applied_artificial_intelligence/sparseMatrixClasses/csr_matrix.py
~~~

## Parallel TSP

The Java sources are in parallelInformationProcessing/src, with example datasets in input. From parallelInformationProcessing:

~~~sh
javac -encoding UTF-8 -d build src/main.java src/TSP.java src/points.java
java -cp build main input/inputTwoCities.txt
~~~

The program asks for a thread count and starting point. Pass an input path as the first argument, or omit it to use the fifteen-city input; filenames are case-sensitive on Linux. Search is expensive as the dataset grows. No benchmark or optimality claim is established by this documentation.

## Maintenance

Preserve the existing source and sample assets when making changes. Do not commit credentials, personal data or generated build output. This review documents the checked-in project; it does not certify production readiness or a successful build on every platform.
