public class ArrayListInt {
    private static final int INITIAL_CAPACITY = 10;
    private static final float GROWTH_FACTOR = 2.0f;

    private int[] data;
    private int size;

    public ArrayListInt() {
        data = new int[INITIAL_CAPACITY];
        size = 0;
    }

    public int size() {
        return size;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        return data[index];
    }

    public void set(int index, int element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        data[index] = element;
    }

    public void add(int element) {
        if (size + 1 > data.length) {
            int[] temp = new int[(int) (size * GROWTH_FACTOR)];
            for (int i = 0; i < size; i++) {
                temp[i] = data[i];
            }
            data = temp;
        }
        data[size] = element;
        ++size;
    }

    public void add(int index, int element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        if (size + 1 > data.length) {
            int size = size();
            int[] temp = new int[(int) (size * GROWTH_FACTOR)];
            for (int i = 0; i < index; i++) {
                temp[i] = data[i];
            }
            for (int i = index; i < size; i++) {
                temp[i + 1] = data[i];
            }
            data = temp;
        } else {
            for (int i = size; i > index; --i) {
                data[i] = data[i - 1];
            }
        }
        data[index] = element;
        ++size;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        if (size - 1 <= (int) (data.length / (GROWTH_FACTOR * 2.0f))) {
            int[] temp = new int[(int) (data.length / GROWTH_FACTOR)];
            for (int i = 0; i < index; ++i) {
                temp[i] = data[i];
            }
            for (int i = index + 1; i < size; ++i) {
                temp[i - 1] = data[i];
            }
            data = temp;
        } else {
            for (int i = index + 1; i < size; ++i) {
                data[i - 1] = data[i];
            }
        }
        --size;
    }


    public String toString() {
        StringBuilder res = new StringBuilder("[");
        int size = size();
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            res.append((i < size - 1 ? ", " : "]"));
        }

        return res.toString();
    }
}
