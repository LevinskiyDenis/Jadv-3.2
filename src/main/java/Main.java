public class Main {

    public static void main(String[] args) throws InterruptedException {

        ShopCalc shopCalc = new ShopCalc();

        Runnable shop1 = () -> shopCalc.addToReport(shopCalc.generateArray(4, 0, 100));
        Runnable shop2 = () -> shopCalc.addToReport(shopCalc.generateArray(2, 0, 200));
        Runnable shop3 = () -> shopCalc.addToReport(shopCalc.generateArray(2, 0, 3000));

        Thread thread1 = new Thread(null, shop1, "Магазин 1");
        Thread thread2 = new Thread(null, shop2, "Магазин 2");
        Thread thread3 = new Thread(null, shop3, "Магазин 3");

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        System.out.println("Выручка всех магазинов: " + shopCalc.getReport().sum());
    }
}
