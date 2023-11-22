public class Goods {
    private final String goodsName;
    private final double goodsPrice;

    private final int listIndex;

    public Goods(String goodsName, double goodsPrice, int listIndex) {
        this.goodsName = goodsName;
        this.goodsPrice = goodsPrice;
        this.listIndex = listIndex;
    }

    @Override
    public String toString() {
        return listIndex + ". " + "Назва: " + goodsName + "; Ціна: "
            + goodsPrice;
    }

    public String getProductName() {
        return goodsName;
    }

    public double getPrice() {
        return goodsPrice;
    }

    public int getIndexInTheList() {
        return this.listIndex;
    }
}
