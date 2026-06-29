import java.util.HashMap;
import java.util.Map;

/**
 * Exercise 7: Financial Forecasting
 *
 * Predicts the future value of an investment given:
 *   - an initial principal amount
 *   - a constant annual growth rate
 *   - a number of years to project
 *
 * ─── Recursion Concept ────────────────────────────────────────────────────────
 *
 * Recursion means a method calls itself to solve a smaller sub-problem until
 * a base case is reached.  It can simplify problems that have a naturally
 * self-similar (recursive) structure, such as compound growth where
 *
 *     FV(principal, rate, years) = FV(principal * (1 + rate), rate, years - 1)
 *
 * Each call reduces `years` by 1 → the problem shrinks toward the base case.
 *
 * ─── Time Complexity Analysis ────────────────────────────────────────────────
 *
 * NAIVE RECURSIVE
 *   T(n) = T(n-1) + O(1)  →  O(n)  linear calls
 *   Space: O(n) call-stack depth  (risk of StackOverflowError for large n)
 *
 * MEMOIZED RECURSIVE  (implemented below as calculateFutureMemo)
 *   Each unique sub-problem is solved exactly once → O(n) time, O(n) space
 *   (HashMap stores already-computed values; avoids redundant calls)
 *
 * ITERATIVE (for comparison)
 *   O(n) time, O(1) space — most practical for production forecasting tools.
 *
 * ─── Optimization: avoid excessive computation ────────────────────────────────
 *
 * 1. Memoization (top-down DP) – cache results of recursive calls so no
 *    sub-problem is solved more than once.  See calculateFutureMemo().
 *
 * 2. Use the closed-form formula directly:
 *       FV = principal * (1 + rate)^years
 *    This is O(1) using Math.pow() and completely avoids recursion.
 *    See calculateFutureClosedForm().
 */
public class FinancialForecasting {

    // ── 1. Naive Recursive ────────────────────────────────────────────────────
    /**
     * Calculates future value using pure recursion (no caching).
     *
     * @param principal  initial investment amount
     * @param rate       annual growth rate as a decimal (e.g. 0.08 for 8%)
     * @param years      number of years into the future
     * @return           predicted future value
     *
     * Time : O(n)   Space : O(n) stack frames
     */
    public static double calculateFutureRecursive(double principal,
                                                  double rate,
                                                  int    years) {
        // Base case: no more years to compound
        if (years == 0) {
            return principal;
        }
        // Recursive step: apply one year of growth, then recurse
        return calculateFutureRecursive(principal * (1 + rate), rate, years - 1);
    }

    // ── 2. Memoized Recursive ─────────────────────────────────────────────────
    /**
     * Calculates future value using memoized recursion.
     * Useful when the same year-count sub-problem appears multiple times
     * (e.g., comparing several growth scenarios sharing sub-results).
     *
     * @param principal  initial investment amount
     * @param rate       annual growth rate as a decimal
     * @param years      number of years into the future
     * @param memo       HashMap cache keyed by remaining years
     * @return           predicted future value
     *
     * Time : O(n)   Space : O(n) cache entries
     */
    public static double calculateFutureMemo(double principal,
                                             double rate,
                                             int    years,
                                             Map<Integer, Double> memo) {
        if (years == 0) return principal;

        if (memo.containsKey(years)) {
            // Return cached result scaled to this principal
            return memo.get(years);
        }

        double result = calculateFutureMemo(principal * (1 + rate),
                                            rate, years - 1, memo);
        memo.put(years, result);
        return result;
    }

    // ── 3. Closed-Form Formula ────────────────────────────────────────────────
    /**
     * Calculates future value using the compound-interest formula directly.
     *   FV = P * (1 + r)^n
     *
     * This is the most efficient approach: O(1) time and O(1) space.
     * Recommended for production financial forecasting tools.
     */
    public static double calculateFutureClosedForm(double principal,
                                                   double rate,
                                                   int    years) {
        return principal * Math.pow(1 + rate, years);
    }

    // ── 4. Iterative (for comparison) ─────────────────────────────────────────
    /**
     * O(n) time, O(1) space — avoids stack-overflow risk for large n.
     */
    public static double calculateFutureIterative(double principal,
                                                  double rate,
                                                  int    years) {
        double value = principal;
        for (int i = 0; i < years; i++) {
            value *= (1 + rate);
        }
        return value;
    }
}
