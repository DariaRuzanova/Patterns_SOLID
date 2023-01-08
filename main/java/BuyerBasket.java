public class BuyerBasket extends Basket {
    private final Logger logger;

    public BuyerBasket(Logger logger) {
        this.logger = logger;
    }

    @Override
    public void addItem(Product product, int count) {
        super.addItem(product, count);
        logger.log("Товар помещен в корзину");
    }

    @Override
    public void removeItem(Product product) {
        super.removeItem(product);
        logger.log("Товар удален из корзины");

    }
}
