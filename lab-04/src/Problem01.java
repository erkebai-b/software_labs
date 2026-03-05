
import java.util.ArrayList;
import java.util.Scanner;

public class Problem01 {
    public static void main(String[] args) {
        var nums = new ArrayList<Integer>();

        var scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            nums.add(num);
        }

        System.out.println("Before reversing:\n" + nums);

        reverse(nums);
        System.out.println("After reversing:\n" + nums);
    }

    private static void reverse(ArrayList<Integer> nums) {
        for (int i = 0, j = nums.size() - 1; i < j; ++i, --j) {
            int temp = nums.get(i);
            nums.set(i, nums.get(j));
            nums.set(j, temp);
        }
    }
}
