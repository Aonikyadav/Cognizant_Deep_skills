import java.util.HashMap;
import java.util.Map;

public class FinancialForecasting {

    public static double calculateFutureRecursive(double principal,
                                                  double rate,
                                                  int    years) {
        if (years == 0) {
            return principal;
        }
        return calculateFutureRecursive(principal * (1 + rate), rate, years - 1);
    }

    public static double calculateFutureMemo(double principal,
                                             double rate,
                                             int    years,
                                             Map<Integer, Double> memo) {
        if (years == 0) return principal;

        if (memo.containsKey(years)) {
            return memo.get(years);
        }

        double result = calculateFutureMemo(principal * (1 + rate),
                                            rate, years - 1, memo);
        memo.put(years, result);
        return result;
    }

    public static double calculateFutureClosedForm(double principal,
                                                   double rate,
                                                   int    years) {
        return principal * Math.pow(1 + rate, years);
    }

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
