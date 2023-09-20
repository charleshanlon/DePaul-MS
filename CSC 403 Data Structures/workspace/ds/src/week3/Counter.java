package week3;

public class Counter {
	private int count;
	
	public Counter() {
		count = 0;
	}

	public int getCount() {
		return count;
	}
	
	public void clickButton() {
		count++;
	}
	
	public void reset() {
		count = 0;
	}

}
