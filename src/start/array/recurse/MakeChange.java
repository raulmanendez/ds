package start.array.recurse;

public class MakeChange {

	public int makeChange(int arr[],int x) {
		return makeChange(x, arr, 0);
	}

	public int makeChange(int x,int arr[],int index) {
		if(index>= arr.length - 1) return 1;

		int ways=0;
		for(int i=0; i * arr[index] <= x ; i++) {
			int remaining = x - i * arr[index];
			ways+=makeChange(remaining,arr, index +1);
		}

		return ways;
	}

	public static void main(String[] args) {
		MakeChange test=new MakeChange();

		int money=75;
		int arr[]= {25,10,5,1};

		System.out.println("ways to get::"+test.makeChange(arr, money));


	}
}
