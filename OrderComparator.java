import java.util.*;

public class OrderComparator implements Comparator<Order> {

	@Override
	public int compare(Order one, Order two) {
		if (one.getDeadlineMinute() != two.getDeadlineMinute()) {
			return one.getDeadlineMinute() - two.getDeadlineMinute();
		} else {
			return one.getArrivalMinute() - two.getArrivalMinute();
		}
	}
}
