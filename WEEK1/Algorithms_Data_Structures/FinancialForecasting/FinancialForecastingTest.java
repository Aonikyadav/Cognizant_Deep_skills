import java.util.HashMap;

public class FinancialForecastingTest {

    public static void main(String[] args) {

        System.out.println("=================================================");
        System.out.println("       Financial Forecasting Tool Demo");
        System.out.println("=================================================\n");

        double principal = 10_000.0;
        double rate      = 0.08;
        int[]  periods   = {1, 5, 10, 20, 30};

        System.out.printf("  Principal : $%,.2f%n", principal);
        System.out.printf("  Rate      : %.0f%% per year%n%n", rate * 100);

        System.out.printf("  %-6s  %-18s  %-18s  %-18s%n",
                "Years", "Recursive (naive)", "Memoized", "Closed-Form");
        System.out.println("  " + "-".repeat(66));

        for (int years : periods) {

            double rv = FinancialForecasting
                            .calculateFutureRecursive(principal, rate, years);

            double mv = FinancialForecasting
                            .calculateFutureMemo(principal, rate, years,
                                                 new HashMap<>());

            double cv = FinancialForecasting
                            .calculateFutureClosedForm(principal, rate, years);

            System.out.printf("  %-6d  $%,16.2f  $%,16.2f  $%,16.2f%n",
                              years, rv, mv, cv);
        }

        System.out.println("\n-------------------------------------------------");
        System.out.println("  Time Complexity Summary");
        System.out.println("-------------------------------------------------");
        System.out.println("  Approach           Time      Space  Notes");
        System.out.println("  Naive Recursive    O(n)      O(n)   Stack overflow risk for large n");
        System.out.println("  Memoized Recursive O(n)      O(n)   Safe when sub-problems repeat");
        System.out.println("  Closed-Form        O(1)      O(1)   Best for production use");
        System.out.println("  Iterative          O(n)      O(1)   Safe, no recursion overhead");

        System.out.println("\n  Optimization Tip:");
        System.out.println("  For single-scenario forecasts, use the closed-form");
        System.out.println("  FV = P x (1+r)^n to avoid recursion entirely.");
        System.out.println("  For multi-scenario analysis reusing sub-results,");
        System.out.println("  memoization eliminates redundant computation.");

        System.out.println("\n-------------------------------------------------");
        System.out.println("  Large n = 10,000 years (stress test)");
        System.out.println("-------------------------------------------------");
        int largeN = 10_000;

        long t0 = System.nanoTime();
        double iterResult = FinancialForecasting
                                .calculateFutureIterative(principal, rate, largeN);
        long iterTime = System.nanoTime() - t0;

        t0 = System.nanoTime();
        double cfResult = FinancialForecasting
                              .calculateFutureClosedForm(principal, rate, largeN);
        long cfTime = System.nanoTime() - t0;

        System.out.printf("  Iterative   result (n=%d): %.4e  [%d ns]%n",
                          largeN, iterResult, iterTime);
        System.out.printf("  Closed-Form result (n=%d): %.4e  [%d ns]%n",
                          largeN, cfResult, cfTime);
        System.out.println("\n  NOTE: Naive recursive with n=10,000 would cause");
        System.out.println("        StackOverflowError - avoided intentionally.");
        System.out.println("=================================================");
    }
}
