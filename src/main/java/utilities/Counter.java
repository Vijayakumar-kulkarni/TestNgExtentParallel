package utilities;

public class Counter {
	public static int count = 0;
	public static synchronized void setCount(int val) {
		count = val;
	}
	public static synchronized int getCount() {
		return count;
	}
}
