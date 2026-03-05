public class MyArrays {
    public static void sort(int[] integers) {
        for (int i = 0; i < integers.length - 1; i++) {
            int minI = i;
            for (int j = i + 1; j < integers.length; j++) {
                if (integers[j] < integers[minI]) {
                    minI = j;
                }
            }
            if (minI != i) {
                int temp = integers[i];
                integers[i] = integers[minI];
                integers[minI] = temp;
            }
        }
    }

    public static void sort(Object[] items) {
        for (int i = 0; i < items.length - 1; i++) {
            int minI = i;
            for (int j = i + 1; j < items.length; j++) {
                if (((MyComparable) items[j]).compareTo(items[minI]) < 0) {
                    minI = j;
                }
            }
            if (minI != i) {
                Object temp = items[i];
                items[i] = items[minI];
                items[minI] = temp;
            }
        }
    }

    public static void sort(Object[] items, MyComparator comparator) {
        for (int i = 0; i < items.length - 1; i++) {
            int minI = i;
            for (int j = i + 1; j < items.length; j++) {
                if (comparator.compare(items[j], items[minI]) < 0) {
                    minI = j;
                }
            }
            if (minI != i) {
                Object temp = items[i];
                items[i] = items[minI];
                items[minI] = temp;
            }
        }
    }
}
