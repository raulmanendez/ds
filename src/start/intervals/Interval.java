package start.intervals;

public class Interval<T> {

	public T start;
	public T end;

	public Interval(T start, T end) {
		this.start = start;
		this.end = end;
	}
	
	@Override
	public String toString() {
		return "["+start.toString()+","+end.toString()+"]";
	}
}
