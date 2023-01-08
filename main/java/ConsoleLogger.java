public class ConsoleLogger implements Logger {
    void printlnConsole(String msg) {
        System.out.println(msg);
    }

    @Override
    public void log(String msg) {
        printlnConsole(msg);
    }
}
