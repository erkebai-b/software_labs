import java.util.ArrayList;

public class Problem04 {
    public static void main(String[] args) {
        final int ELEMENTS = 100_000;

        {
            var nums = new ArrayList<Integer>();

            long startTime = System.nanoTime();
            for (int i = 0; i < ELEMENTS; ++i) {
                nums.add((int) (Math.random() * 100.0));
            }
            for (int i = 0; i < ELEMENTS; i++) {
                nums.add(0, (int) (Math.random() * 100.0));
            }
            for (int i = 0; i < ELEMENTS * 2; i++) {
                nums.remove(0);
            }
            long endTime = System.nanoTime();
            long time = endTime - startTime;
            System.out.printf("%.5f%n", time / 1_000_000_000.0);
        }

        {
            var nums = new ArrayListInt();

            long startTime = System.nanoTime();
            for (int i = 0; i < ELEMENTS; i++) {
                nums.add((int) (Math.random() * 100.0));
            }
            for (int i = 0; i < ELEMENTS; i++) {
                nums.add(0, (int) (Math.random() * 100.0));
            }
            for (int i = 0; i < ELEMENTS * 2; i++) {
                nums.remove(0);
            }
            long endTime = System.nanoTime();
            long time = endTime - startTime;
            System.out.printf("%.5f%n", time / 1_000_000_000.0);
        }
    }
}
