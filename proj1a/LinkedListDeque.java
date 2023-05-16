public class LinkedListDeque<T> {
    public class Node {
        public T item;
        public Node prev;
        public Node next;

        public Node(T _item, Node _prev, Node _next) {
            item = _item;
            prev = _prev;
            next = _next;
        }
    }
    private Node sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new Node(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    public int size() {
        return size;
    }

    public void addFirst(T _item) {
        size += 1;
        Node cur = new Node(_item, sentinel, sentinel.next);
        sentinel.next.prev = cur;
        sentinel.next = cur;
    }

    public void addLast(T _item) {
        size += 1;
        Node cur = new Node(_item, sentinel.prev, sentinel);
        sentinel.prev.next = cur;
        sentinel.prev = cur;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void printDeque() {
        Node p = sentinel;
        while (p.next != sentinel) {
            p = p.next;
            System.out.print(p.item.toString());
            System.out.print(' ');
        }
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        size -= 1;
        Node cur = sentinel.next;
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        return cur.item;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        size -= 1;
        Node cur = sentinel.prev;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        return cur.item;
    }

    public T get(int index) {
        if (index >= size) {
            return null;
        }
        Node cur = sentinel;
        while (cur.next != sentinel) {
            cur = cur.next;
            if (index == 0) {
                break;
            }
            index -= 1;
        }
        return cur.item;
    }

    public T getRecursive(int index) {
        if (index >= size) {
            return null;
        }
        return Recursive(index, sentinel.next);
    }

    public T Recursive(int index, Node p) {
        if (index == 0) {
            return p.item;
        } else {
            return Recursive(index - 1, p.next);
        }
    }
}
