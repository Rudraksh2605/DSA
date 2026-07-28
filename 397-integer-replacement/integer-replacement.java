class Solution {
    private Map<Long, Integer> memo = new HashMap<>();

    public int integerReplacement(int n) {
        return (int) getMinSteps((long) n); 
    }

    private long getMinSteps(long n) {
        if (n == 1) {
            return 0;
        }
        
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        long steps;
        if (n % 2 == 0) {
            steps = 1 + getMinSteps(n / 2);
        } 
        else {
            steps = 1 + Math.min(getMinSteps(n + 1), getMinSteps(n - 1));
        }

        memo.put(n, (int) steps);
        return steps;
    }
}