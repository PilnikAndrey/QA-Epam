package framework.utils;

public class MaxDiscountGame {
    private static String name;
    private static int discountRate;
    private static String initial;
    private static String discountedPrices;

    public static String getName() {
        return name;
    }

    public static int getDiscountRate() {
        return discountRate;
    }

    public static String getInitial() {
        return initial;
    }

    public static String getDiscountedPrices() {
        return discountedPrices;
    }

    public static void setName(String nameGame) {
        name = nameGame;
    }

    public static void setDiscountRate(int rate) {
        discountRate = rate;
    }

    public static void setInitial(String initiall) {
        initial = initiall;
    }

    public static void setDiscountedPrices(String prices) {
        discountedPrices = prices;
    }
}
