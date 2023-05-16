public interface Deque<T> {
    public void addFirst(T item0);
    public void addLast(T item0);
    public T removeFirst();
    public T removeLast();
    public T get(int index);
    public int size();
    public boolean isEmpty();
    public void printDeque();
}
