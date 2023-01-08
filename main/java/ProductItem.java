public class ProductItem {
    public final Product product;
    public final int count;

    public ProductItem( Product product, int count) {
        this.product = product;
        this.count = count;
    }


    @Override
    public String toString() {
        return product +
                ", количество " + count+" руб.";
    }
}
