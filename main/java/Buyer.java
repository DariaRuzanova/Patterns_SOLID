public class Buyer {
    String name;
    String phone;
    String address;

    public Buyer(String name, String phone, String address) {
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Покупатель " + name + '\n' +
                ", Телефон " + phone + '\n' +
                ", Адрес доставки " + address;
    }
}
