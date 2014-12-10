// A peak element is an element that is greater than its neighbors.

// Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

// The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

// You may imagine that num[-1] = num[n] = -∞.

// For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.


class FindPeekElement {

	public static void main(String[] args) {

		int[] num = {1, 2};
		System.out.println(findPeakElement(num));			
		
	}

	static int findPeakElement(int[] num) {
			
		if (num.length == 0) {
			return 0;
		}

		for (int i = 0; i < num.length-1; i++) {
			if (i == 0) {
				if (num[i] > num[i+1])
					return i;
			} else {
				if (num[i] > num[i-1] && num[i] > num[i+1]) {
					return i;
				}
			}			
		}

		// reaches here only if the last element is the peak
		return num.length-1;
    }

}