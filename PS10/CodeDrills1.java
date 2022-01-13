class CocaCola {
    // DO NOT read from stdin or write to stdout
    // Input is given as function argument
    // Output is taken as the function return value
    int totalbottles(int N, int X) {
        int ans = N;
        int count = 0;
        for (; N >= X; N -= X, N++, count++) {
        }
        return ans + count;
    }
};

// https://codedrills.io/submissions/332216
// https://codedrills.io/contests/interview-practice-round-26/problems/coca-cola