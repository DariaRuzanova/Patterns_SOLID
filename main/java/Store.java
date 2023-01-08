import java.util.*;

public class Store extends Basket {

    private final Logger logger;

    public Store(Logger logger) {
        this.logger = logger;
    }

    @Override
    public void addItem(Product product, int count) {
        super.addItem(product, count);
        logger.log(String.format("Товар %s поступил на склад", product.name));
    }

    @Override
    public void removeItem(Product product) {
        super.removeItem(product);
        logger.log(String.format("Товар %s продан", product.name));
    }

    public ProductItem getProductItemByProductId(int productId) {
        return getItems().stream().filter(x -> productId == x.product.id).findFirst().orElse(null);
    }

    public Product getProductById(int id) {
        ProductItem item = getProductItemByProductId(id);
        return item == null ? null : item.product;
    }

    public List<ProductItem> findProductName(String name) {
        List<ProductItem> productItemsLists = getItems().stream().filter(productItem -> name.equals(productItem.product.name)).toList();
        if (productItemsLists.size() != 0) {
            productItemsLists.forEach(System.out::println);
        } else {
            System.out.println("Такого товара нет!");

        }
        return productItemsLists;

    }

    public List<ProductItem> filterByProducer(String producer, List<ProductItem> listProduct) {

        return listProduct.stream().filter(productItem ->
                producer.equals(productItem.product.producer)).toList();
    }

    public List<ProductItem> sortedByPrice(String input, List<ProductItem> listProduct) {
        List<ProductItem> listProductSortedByPrice = null;
        if (input.equals("high")) {
            listProductSortedByPrice = listProduct.stream().sorted(Comparator.comparing(x -> x.product.price)).toList();
        }
        if (input.equals("low")) {
            listProductSortedByPrice = listProduct.stream().sorted(Comparator.comparingDouble(x -> -x.product.price)).toList();
        }
        return listProductSortedByPrice;
    }

    public List<ProductItem> filtredByRatingHigh(List<ProductItem> listProduct) {
        return listProduct.stream().filter(productItem -> StoreConstants.highRating <= productItem.product.rating).toList();
    }

    public List<ProductItem> filtredWithoutRatingLow(List<ProductItem> listProduct) {
        return listProduct.stream().filter(productItem -> StoreConstants.lowRating <= productItem.product.rating).toList();
    }
}
