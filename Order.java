public class Order {
	private String orderID;
	private int arrivalTime, deadline;

	public Order() {
		orderID = null;
		deadline = -1;
		arrivalTime = -1;
	}

	public Order(String orderID, int deadline) {
		this.orderID = orderID;
		this.deadline = deadline;
		arrivalTime = -1;
	}

	public void setArrivalMinute(int arrivalMin) {
		arrivalTime = arrivalMin;
	}

	public int getArrivalMinute() {
		return arrivalTime;
	}

	public int getDeadlineMinute() {
		return deadline;
	}

	public String getId() {
		return orderID;
	}
}
