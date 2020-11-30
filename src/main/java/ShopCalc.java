import java.util.concurrent.atomic.LongAdder;

public class ShopCalc {

    LongAdder report = new LongAdder();

    public void addToReport(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Thread.currentThread().getName() + " добавляю в LongAdder " + arr[i]);
            report.add(arr[i]);
        }
    }

    public int[] generateArray(int length, int a, int b) {

        System.out.println(Thread.currentThread().getName() + " создаю массив");

        int[] array = new int[length];

        for (int i = 0; i < array.length; i++) {
            int c = (int) (Math.random() * (b - a)) + a;
            array[i] = c;
        }

        return array;
    }

    public LongAdder getReport() {
        System.out.println(Thread.currentThread().getName() + " получаю ЛонгЭддер");
        return report;
    }
}
