public class Product {
    int id;
    String name;
    String producer;
    double price;
    double rating;


    public Product(int id, String name, String producer, double price, double rating) {
        this.id = id;
        this.name = name;
        this.producer = producer;
        this.price = price;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return id + " наименование товара " + name +
                ", Производитель " + producer +
                ", Цена " + price +
                ", Рейтинг " + rating;
    }
}
