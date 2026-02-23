import java.util.*;

public class MyPriorityQueue<T> implements PriorityQueueADT<T> {
	private T[] queue;
	private int trackBack;
	private Comparator<T> comparator;
	private static final int DEFAULT_VALUE = 10;

	public MyPriorityQueue(int cap, Comparator<T> comparator) {
		if (cap > MAX_CAPACITY) {
			throw new IllegalStateException();
		}
		@SuppressWarnings("unchecked")
		T[] temp = (T[]) new Object[cap];
		queue = temp;
		trackBack = 0;
		this.comparator = comparator;
	}

	public MyPriorityQueue(Comparator<T> comparator) {
		this(DEFAULT_VALUE, comparator);
	}

	@Override
	public void enqueue(T item) {
		if (item == null) {
			throw new IllegalArgumentException();
		}

		if (trackBack >= queue.length) {
			throw new IllegalStateException("PriorityQueue is full");
		}

		int i = trackBack - 1;
		while (i >= 0 && comparator.compare(item, queue[i]) < 0) {
			queue[i + 1] = queue[i];
			i--;
		}

		queue[i + 1] = item;
		trackBack++;
	}

	public T dequeue() {
		if (trackBack <= 0) {
			throw new NoSuchElementException();
		}
		T temp = queue[0];
		for (int i = 1; i < trackBack; i++) {
			queue[i - 1] = queue[i];
		}
		queue[trackBack - 1] = null;
		trackBack--;
		return temp;
	}

	public T peek() {
		if (trackBack <= 0) {
			throw new NoSuchElementException();
		}
		return queue[0];
	}

	public boolean isEmpty() {
		if (trackBack <= 0) {
			return true;
		} else {
			return false;
		}
	}

	public int size() {
		return trackBack;
	}

	public Object[] toArray() {
		Object[] temp = new Object[size()];
		for (int i = 0; i < trackBack; i++) {
			temp[i] = queue[i];
		}
		return temp;
	}

}