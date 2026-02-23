import java.util.*;

public class MyStack<T> implements StackADT<T> {
	private T[] stack;
	private int top;
	private static final int DEFAULT_CAPACITY = 10;

	public MyStack() {
		this(DEFAULT_CAPACITY);
	}

	public MyStack(int cap) {
		if (cap > MAX_CAPACITY) {
			throw new IllegalStateException();
		}
		@SuppressWarnings("unchecked")
		T[] temp = (T[]) new Object[cap];
		stack = temp;
		top = -1;

	}

	@Override
	public void push(T item) {
		if (top >= stack.length - 1) {
			throw new IllegalStateException();
		}
		if (item == null) {
			throw new IllegalArgumentException();
		}
		top++;
		stack[top] = item;
	}

	@Override
	public T pop() {
		if (top == -1) {
			throw new NoSuchElementException();
		}
		T temp = (T) stack[top];
		stack[top] = null;
		top--;
		return temp;

	}

	@Override
	public T peek() {
		if (top == -1) {
			throw new NoSuchElementException();
		}
		return (T) stack[top];
	}

	@Override
	public boolean isEmpty() {
		if (top == -1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int size() {
		return top + 1;
	}

	public Object[] toArray() {
		Object[] arr = new Object[size()];
		for (int i = 0; i < size(); i++) {
			arr[i] = stack[i];
		}
		return arr;
	}
}
