public class WarehouseSimulation implements SimulationInterface {

	private int currentMinute;
	private int totalArrived;
	private int totalShipped;
	private int totalLate;

	private MyPriorityQueue<Order> queue;
	private MyStack<Order> returnStack;

	OrderComparator compares;
	private Order[] orders;
	private int nextOrderIndex;

	public WarehouseSimulation(Order[] orders) {
		this.orders = orders;

		compares = new OrderComparator();
		nextOrderIndex = 0;
		currentMinute = 0;
		totalArrived = 0;
		totalShipped = 0;
		totalLate = 0;

		queue = new MyPriorityQueue<>(orders.length, compares);
		returnStack = new MyStack<>(orders.length);
	}

	@Override
	public void tick() {

		if (nextOrderIndex < orders.length) {
			Order o = orders[nextOrderIndex];
			o.setArrivalMinute(currentMinute);
			queue.enqueue(o);
			nextOrderIndex++;
			totalArrived++;
		}

		if (!queue.isEmpty()) {
			Order shipped = queue.dequeue();
			totalShipped++;

			if (currentMinute > shipped.getDeadlineMinute()) {
				returnStack.push(shipped);
				totalLate++;
			}
		}
		currentMinute++;
	}

	@Override
	public boolean isFinished() {
		if (nextOrderIndex == orders.length && queue.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	public int getCurrentMinute() {
		return currentMinute;
	}

	public int getTotalArrived() {
		return totalArrived;
	}

	public int getTotalShipped() {
		return totalShipped;
	}

	public int getTotalLate() {
		return totalLate;
	}
}