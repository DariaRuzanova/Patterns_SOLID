import java.util.*;

public class Store extends Basket {

    public Store() {
    }

    public Product getProductById (int id){
        List<Product> items = getItems().stream().filter(productItem1 -> id == productItem1.product.id)
                .map(x->x.product)
                .toList();
        return items.size() == 0 ? null : items.get(0);
    }

    public List<ProductItem> findProductName(String name){
        List<ProductItem> productItemsLists = getItems().stream().filter(productItem -> name.equals(productItem.product.name)).toList();
        if(productItemsLists.size() != 0) {
            productItemsLists.forEach(System.out::println);
        } else {
            System.out.println("Такого товара нет!");

        }
        return productItemsLists;

    }
    public List<ProductItem> filterByProducer(String producer,List<ProductItem> listProduct){

        return listProduct.stream().filter(productItem ->
                producer.equals(productItem.product.producer)).toList();
    }
    public List<ProductItem> sortedByPrice(String input,List<ProductItem> listProduct){
        List<ProductItem> listProductSortedByPrice = null;
        if(input.equals("high")){
             listProductSortedByPrice = listProduct.stream().sorted(Comparator.comparing(x->x.product.price)).toList();
        }if(input.equals("low")){
            listProductSortedByPrice = listProduct.stream().sorted(Comparator.comparingDouble(x->-x.product.price)).toList();
        }
        return listProductSortedByPrice;
    }
    public List<ProductItem> filtredByRatingHigh(List<ProductItem> listProduct){
        return listProduct.stream().filter(productItem -> StoreConstants.highRating <= productItem.product.rating).toList();
    }
    public List<ProductItem> filtredWithoutRatingLow(List<ProductItem> listProduct){
        return listProduct.stream().filter(productItem -> StoreConstants.lowRating <= productItem.product.rating).toList();
    }
}
