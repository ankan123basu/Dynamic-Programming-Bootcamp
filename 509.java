// 509. Fibonacci number

// Recursion :    // O(2^n)  O(n)
// class Solution {

//     public int fib(int n) {

//         if(n<=1)
//             return n;

//         return fib(n-1)+fib(n-2);
//     }
// }

// Memoization :  // O(n)  O(n)
// import java.util.Arrays;

// class Solution {

//     public int fib(int n) {

//         int dp[] = new int[n + 1];

//         Arrays.fill(dp, -1);

//         return solve(n, dp);
//     }

//     public int solve(int n, int dp[]) {

//         if (n <= 1)
//             return n;

//         if (dp[n] != -1)
//             return dp[n];

//         int left = solve(n - 1, dp);

//         int right = solve(n - 2, dp);

//         dp[n] = left + right;

//         return dp[n];
//     }
// }

// Tabulation :  // O(n)  O(n)
// class Solution {

//     public int fib(int n) {

//         if(n<=1)
//             return n;

//         int dp[] = new int[n+1];

//         dp[0]=0;
//         dp[1]=1;

//         for(int i=2;i<=n;i++){
//             dp[i]=dp[i-1]+dp[i-2];
//         }

//         return dp[n];
//     }
// }


// Space Optimization :  // O(n)  O(1)
// class Solution {

//     public int fib(int n) {

//         if(n <= 1)
//             return n;

//         int prev2 = 0;
//         int prev1 = 1;

//         for(int i = 2; i <= n; i++) {

//             int curr = prev1 + prev2;

//             prev2 = prev1;

//             prev1 = curr;
//         }

//         return prev1;
//     }
// }