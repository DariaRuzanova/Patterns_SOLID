import java.util.List;
import java.util.Scanner;

public class Main {
    private static Store store;
    private static Buyer buyer1;
    private static BuyerBasket basket;
    private static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {
        Product milk1 = new Product(1,"Молоко","Чабан",120.0,9.5);
        Product milk2 = new Product(2,"Молоко","Вольское",86.0,8.7);
        Product milk3 = new Product(3,"Молоко","Домик в деревне",100.5,6.3);
        Product milk4 = new Product(4,"Молоко","Пестравка",68.0,3.2);
        Product milk5 = new Product(5,"Молоко","Чабан",130.0,9.8);
        Product cheese1 = new Product(6,"Сыр","Беларусь",560.2,6.2);
        Product cheese2 = new Product(7,"Сыр","Фермерское",900,9.9);
        Product cheese3 = new Product(8,"Сыр","Италия",1200,9.8);

        store = new Store();
        store.addItem(milk1,32);
        store.addItem(milk2,20);
        store.addItem(milk3,15);
        store.addItem(milk4,5);
        store.addItem(milk5,8);
        store.addItem(cheese1,25);
        store.addItem(cheese2,8);
        store.addItem(cheese3,12);

        buyer1 = new Buyer("Иван","89172541617","Саратов, ул.Карла Маркса 200");
        basket = new BuyerBasket(buyer1);
        menuStore();
    }

    public static void menuStore() {
        System.out.println("Добро пожаловать в онлайн-магазин молочных продуктов, " + buyer1.name);

        System.out.println("Выберете команду: 1/Перейти в магазин 2/Перейти в корзину, 3/Выйти");
        int input1 = sc.nextInt();
        switch (input1) {
            case 1:
                GotoStore();
                break;
            case 2:
                GotoBasket();
                break;
            default:
                menuStore();
            case 3:
                break;

        }
    }
    public static void GotoStore() {
        int input = -1;
        while(input != 4) {
            System.out.println("Выберите действие: 1/Вывести список всех товаров, 2/Поиск, 3/Добавить в корзину, 4/Выйти из магазина");
            input = sc.nextInt();

            switch (input) {
                case 1 -> Basket.outputListProduct(store.getItems());
                case 2 -> searchProducts();
                case 3 -> addToBasket();
            }
        }
    }

    public static void searchProducts() {
        System.out.println("Введите наименование товара");
        String inputNameProduct = sc.next();
        List<ProductItem> listProduct = store.findProductName(inputNameProduct);
        System.out.println("Выберите фильтр/сортировку: 1/Отфильтровать по производителю, 2/Сортировать по цене, " +
                "3/Показать товары только с высоким рейтингом, 4/Показать товары со средним и высоким рейтингом, 5/Вернуться на уровень выше ");
        int inputTypeSorted = sc.nextInt();
        switch (inputTypeSorted) {
            case 1 -> filtredByProduced(listProduct);
            case 2 -> sortedByPrice(listProduct);
            case 3 -> store.filtredByRatingHigh(listProduct).forEach(System.out::println);
            case 4 -> store.filtredWithoutRatingLow(listProduct).forEach(System.out::println);
            case 5 -> GotoStore();
            default -> searchProducts();
        }
        GotoStore();
    }
    public static void filtredByProduced(List<ProductItem> listProduct) {
        System.out.println("Введите производителя из списка имеющихся");
        String inputProducer = sc.next();
        List<String> listProducer = listProduct.stream().map(x->x.product.producer).distinct().toList();
        if (listProducer.contains(inputProducer)) {
            List<ProductItem> listFiltredByProducer = store.filterByProducer(inputProducer,listProduct);
            listFiltredByProducer.forEach(System.out::println);
        }else {
            System.out.println("Такого производителя нет!");
            filtredByProduced(listProduct);
        }
    }
    public static void sortedByPrice(List<ProductItem> listProduct){
        System.out.println("Сортировать по возрастанию или убыванию: high/low");
        String inputSort = sc.next();
        store.sortedByPrice(inputSort,listProduct).forEach(System.out::println);
    }

    public static void GotoBasket(){
        Basket.outputListProduct(basket.getItems());
        System.out.println("Удалить товар из корзины? y/n");
        String input = sc.next();
        if(input.equals("y")){
            deleteFromBacket();
        }else {
            System.out.println("To be continued");
        }

    }

    public static void addToBasket(){
//        System.out.println("Введите номер(id) товара, который нужно добавить в корзину");
//        int id = sc.nextInt();
//        System.out.println("Введите количество");
//        int countProduct = sc.nextInt();
//        int countAvailable = 0;
//        Product product = store.getProductById(id);
//        basket.addItem(product,countProduct);
//        basket.outputListProduct();
    }
    public static void deleteFromBacket(){
        System.out.println("Введите номер(id) товара, который нужно удалить из корзины");
        int id = sc.nextInt();
        Product product = store.getProductById(id);
        basket.removeItem(product);
    }
}