package models;

public class Utils {
    /**
     * @param principle Starting Amount
     * @param interest Interest Rate
     * @param years Years to compound interest
     * @param compoundingPeriod Number of times per year to compound interest
     * @return The final amount with the interest applied
     */
    public static double calculateCompoundInterest(double principle, double interest, int years, int compoundingPeriod) {
        double compoundInterest = Math.round(principle * Math.pow((1 + interest / compoundingPeriod), years * compoundingPeriod));
        return compoundInterest;
    }
}
