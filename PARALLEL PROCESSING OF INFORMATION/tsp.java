public class main {
    static int MAXN = 150;
    static int MAX_VALUE = 10000;
    static int n = 6;
    static int[][] matrix = {
            {0, 5, 0, 0, 7, 7},
            {5, 0, 5, 0, 0, 0},
            {0, 5, 0, 6, 5, 0},
            {0, 0, 6, 0, 3, 3},
            {7, 0, 5, 3, 0, 5},
            {7, 0, 0, 3, 5, 0}
    };
    static char[] used = new char[MAXN];
    static int[] minCycle = new int[MAXN];
    static int[] cycle = new int[MAXN];
    static int curSum, minSum;

    static void printCycle() {
        System.out.println("Минимален Хамилтонов цикъл: 1");
        for (int i = 0; i < n - 1; i++) {
            System.out.println(minCycle[i] + 1);
        }
        System.out.println("1, дължина " + minSum);
    }

    static void hamilton(int i, int level) {
        if ((i == 0) && (level > 0)) {
            if (level == n) {
                minSum = curSum;
                for (int k = 0; k < n; k++) {
                    minCycle[k] = cycle[k];
                }
            }
            return;
        }
        if (used[i] == 1) {
            return;
        }
        used[i] = 1;
        for (int k = 0; k < n; k++) {
            if (matrix[i][k] == 1 && k != i) {
                cycle[level] = k;
                curSum += matrix[i][k];
                if (curSum < minSum)
                    hamilton(k, level + 1);
                curSum -= matrix[i][k];
            }
        }
        used[i] = 0;
    }

    public static void main(String[] args) {
        for (int k = 0; k < n; k++) {
            used[k] = 0;
        }
        minSum = MAX_VALUE;
        curSum = 0;
        cycle[0] = 1;
        hamilton(0, 0);
        printCycle();
    }
}
