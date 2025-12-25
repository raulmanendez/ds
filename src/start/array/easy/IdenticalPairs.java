package start.array.easy;

public class IdenticalPairs {

	//my
	public int numIdenticalPairs_my(int[] nums) {
        int count=0;
        for(int i=0;i<nums.length;i++) {

            for(int j=i+1;j<nums.length; j++) {
                if(nums[i]==nums[j]) {
                    count++;
                }
            }
        }
        return count;
    }

	//optimized
	public static int numIdenticalPairs(int[] A) {
		int ans = 0, cnt[] = new int[101];
		for (int a : A) {
			ans += cnt[a]++;
		}
		return ans;
	}

	public static void main(String[] args) {
		int x = numIdenticalPairs(new int[] { 1, 2, 3, 1, 1, 3 });

		System.out.println(x);
	}
}
