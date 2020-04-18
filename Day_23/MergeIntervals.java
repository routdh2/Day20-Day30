package coding_interview;
import java.util.*;
class Interval {
	int start;
	int end;
	public Interval(int start,int end) {
		this.start=start;
		this.end=end;
	}
	@Override
	public String toString() {
		return "["+start+", "+end+"]";
	}
}

class IntervalComparator implements Comparator<Interval> {
	public int compare(Interval ob1, Interval ob2) {
		return ob1.start-ob2.start;
	}
}
public class MergeIntervals {
	
	
	public static List<Interval> mergeIntervals(List<Interval> intervals) {
		//check error conditions
		if(intervals.size()<2)
			throw new IllegalArgumentException("Minimum of two intervals needed.");
		Collections.sort(intervals, new IntervalComparator());
		List<Interval> result = new ArrayList<>();
		Iterator<Interval> itr = intervals.iterator();
		Interval first = itr.next();
		int start=first.start;
		int end=first.end;
		while(itr.hasNext()) {
			Interval second = itr.next();
			//check if overlap or not
			if(end<second.start) {//don't overlap
				result.add(new Interval(start,end));
				start=second.start;
				end=second.end;
			}
			else {//overlap
				end=Math.max(end, second.end);
			}
		}
		result.add(new Interval(start,end));
		return result;
	}

	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(1,4));
		intervals.add(new Interval(2,5));
		intervals.add(new Interval(7,9));
		System.out.println(mergeIntervals(intervals));
		
		intervals = new ArrayList<>();
		intervals.add(new Interval(6,7));
		intervals.add(new Interval(2,4));
		intervals.add(new Interval(5,9));
		System.out.println(mergeIntervals(intervals));
		
		intervals = new ArrayList<>();
		intervals.add(new Interval(1,4));
		intervals.add(new Interval(2,6));
		intervals.add(new Interval(3,5));
		System.out.println(mergeIntervals(intervals));

	}

}
