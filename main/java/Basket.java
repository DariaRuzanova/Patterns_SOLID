import java.util.ArrayList;
import java.util.List;

public class Basket {
    private final ArrayList<ProductItem> items;

    public Basket() {
        items = new ArrayList<>();
    }

    public List<ProductItem> getItems() {
        return items;
    }

    public void addItem(Product product, int count) {
        ProductItem item = items.stream().filter(x -> x.product.id == product.id).findFirst().orElse(null);
        if (item != null) {
            ProductItem newItem = new ProductItem(product, item.count + count);
            items.remove(item);
            items.add(newItem);
        } else {
            ProductItem basketItem = new ProductItem(product, count);
            items.add(basketItem);
        }
    }

    public void removeItem(Product product) {
        ProductItem item = items.stream().filter(x -> x.product == product).findFirst().orElse(null);
        if (item != null) {
            items.remove(item);
            ProductItem newItem = new ProductItem(product, item.count - 1);
            if (newItem.count > 0) {
                items.add(newItem);
            }
        }
    }

    public static void outputListProduct(List<ProductItem> items) {
        for (ProductItem item : items) {
            System.out.println(item.toString());
        }
    }
}
