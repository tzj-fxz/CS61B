public class ArrayDeque<T> {
    private T[] a;
    private int size;
    private int nextFirst;
    private int nextLast;

    public void resizeUp() {
        T[] b = (T[]) new Object[a.length * 2];
        for (int i = 0; i < a.length; ++i) {
            b[i] = a[(nextFirst + i + 1) % a.length];
        }
        nextFirst = b.length - 1;
        nextLast = a.length;
        a = b;
    }

    public void resizeDown() {
        T[] b = (T[]) new Object[a.length / 2];
        for (int i = 0; i < a.length / 4; ++i) {
            b[i] = a[(nextFirst + i + 1) % a.length];
        }
        nextFirst = b.length - 1;
        nextLast = a.length / 4;
        a = b;
    }

    public ArrayDeque() {
        a = (T[]) new Object[8];
        size = 0;
        nextFirst = 7;
        nextLast = 0;
    }

    public void addFirst(T _item) {
        if (size >= a.length) {
            resizeUp();
        }
        size += 1;
        a[nextFirst] = _item;
        nextFirst -= 1;
        nextFirst %= a.length;
    }

    public void addLast(T _item) {
        if (size >= a.length) {
            resizeUp();
        }
        size += 1;
        a[nextLast] = _item;
        nextLast += 1;
        nextLast %= a.length;
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T cur = a[(nextFirst + 1) % a.length];
        size -= 1;
        nextFirst += 1;
        nextFirst %= a.length;
        if (size <= a.length / 4) {
            resizeDown();
        }
        return cur;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T cur = a[(nextLast - 1) % a.length];
        size -= 1;
        nextLast -= 1;
        nextLast %= a.length;
        if (size <= a.length / 4) {
            resizeDown();
        }
        return cur;
    }

    public T get(int index) {
        if (index >= size) {
            return null;
        } else {
            return a[(nextFirst + index + 1) % a.length];
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void printDeque() {
        int index = (nextFirst + 1) % a.length;
        while (index != nextLast) {
            System.out.print(a[index].toString());
            System.out.print(' ');
            index += 1;
            index %= a.length;
        }
    }

}
