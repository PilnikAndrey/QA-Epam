package project.models;

public class Games {
    private String name;
    private int discountRate;
    private String initial;
    private String discountedPrices;

    public String getName() {
        return name;
    }

    public int getDiscountRate() {
        return discountRate;
    }

    public String getInitial() {
        return initial;
    }

    public String getDiscountedPrices() {
        return discountedPrices;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDiscountRate(int rate) {
        this.discountRate = rate;
    }

    public void setInitial(String initial) {
        this.initial = initial;
    }

    public void setDiscountedPrices(String prices) {
        this.discountedPrices = prices;
    }
}
