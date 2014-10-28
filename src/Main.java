import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		/*
		 * String time1 = "12:00:00"; String time2 = "12:01:00";
		 * 
		 * SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss"); Date
		 * date1 = format.parse(time1); Date date2 = format.parse(time2); long
		 * difference = date2.getTime() - date1.getTime();
		 * System.out.println(difference/1000);
		 */

		int[] num = { -1, -2, 5, -2 };
		int max = maxSubArray5(num);

		System.out.println(max);

	}

public static int maxSubArray5(int[] A) {
	int newsum = A[0];
	int max = A[0];
	for (int i = 1; i < A.length; i++) {
		newsum = Math.max(newsum + A[i], A[i]);
		max = Math.max(max, newsum);
	}
	return max;
}

	public static int maxSubArray4(int[] A) {
		int max = A[0];
		int[] sum = new int[A.length];
		sum[0] = A[0];

		int begin = 0;
		int end = 0;

		for (int i = 1; i < A.length; i++) {

			int newBegin = begin;
			int newEnd = end;

			if (A[i] > sum[i - 1] + A[i]) {
				sum[i] = A[i];
				newBegin = i;
				newEnd = i;
			} else {
				sum[i] = sum[i - 1] + A[i];
				newEnd = i;
			}

			if (sum[i] > max) {
				max = sum[i];
				begin = newBegin;
				end = newEnd;
			}
		}

		// print the subArray
		for (int i = begin; i <= end; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();

		return max;
	}

	public static int maxSubArray(int[] arr) {
		int maxSum = Integer.MIN_VALUE;
		for (int i = 0, sumSoFar = -1, sum; i < arr.length; i++) {
			sum = sumSoFar + arr[i];
			if (arr[i] > sum) {
				sumSoFar = arr[i];
			} else {
				sumSoFar = sum;

			}
			maxSum = Math.max(maxSum, sumSoFar);
		}
		return maxSum;
	}

	public static int maxSubArray3(int[] A) {
		int newsum = A[0];
		int max = A[0];
		for (int i = 1; i < A.length; i++) {
			newsum = Math.max(newsum + A[i], A[i]);
			max = Math.max(max, newsum);
		}
		return max;
	}

	public static int maxSubArray2(int[] A) {
		int sum = 0;
		int maxSum = Integer.MIN_VALUE;

		for (int i = 0; i < A.length; i++) {
			sum += A[i];
			// maxSum = Math.max(maxSum, sum);

			if (sum < 0) {
				// sum = 0;
				sum = A[i]; // change
				maxSum = Math.max(maxSum, sum); // change
			}

		}

		return maxSum;
	}

	public static ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
		ArrayList<ArrayList<Integer>> returnList = new ArrayList<ArrayList<Integer>>();
		returnList.add(new ArrayList<Integer>());

		for (int i = 0; i < num.length; i++) {
			Set<ArrayList<Integer>> currentSet = new HashSet<ArrayList<Integer>>();
			for (List<Integer> l : returnList) {
				for (int j = 0; j < l.size() + 1; j++) {
					l.add(j, num[i]);
					ArrayList<Integer> T = new ArrayList<Integer>(l);
					l.remove(j);
					currentSet.add(T);
				}
			}
			returnList = new ArrayList<ArrayList<Integer>>(currentSet);
		}

		return returnList;
	}

	public static boolean isPalindrome(int x) {
		// negative numbers are not palindrome
		if (x < 0)
			return false;

		// initialize how many zeros
		int div = 1;
		while (x / div >= 10) {
			div *= 10;
		}

		while (x != 0) {
			int left = x / div;
			int right = x % 10;

			if (left != right)
				return false;

			x = (x % div) / 10;
			div /= 100;
		}

		return true;
	}

	public static int longestConsecutive(int[] num) {
		// if array is empty, return 0
		if (num.length == 0) {
			return 0;
		}

		Set<Integer> set = new HashSet<Integer>();
		int max = 1;

		for (int e : num)
			set.add(e);

		for (int e : num) {
			int left = e - 1;
			int right = e + 1;
			int count = 1;

			while (set.contains(left)) {
				count++;
				set.remove(left);
				left--;
			}

			while (set.contains(right)) {
				count++;
				set.remove(right);
				right++;
			}

			max = Math.max(count, max);
		}

		return max;
	}
}