package findMedian;

import java.util.Arrays;

public class GetMedianOfTwoArrays {

	public static void main(String[] args) {
		int array2[] = {1,3};
		int array1[] = {2};
		
		System.out.println(findMedianSortedArrays(array1, array2));
	}
	
	public static double useMergeAndSort(int[] nums1, int[] nums2) {
		//Just an experiment to compare the efficiency of this solutions vs the other.
		double median = 0;
		int [] bigArray= new int [nums1.length + nums2.length];
		int medianIndex = 0;
		
		System.arraycopy(nums1, 0, bigArray, 0, nums1.length);
		System.arraycopy(nums2, 0, bigArray, nums1.length, nums2.length);
		
		Arrays.sort(bigArray);
		
		 if ((bigArray.length & 1) == 0 ) {
			 //Even number of entries
			 medianIndex = (bigArray.length / 2) - 1;
			 median = (double)(bigArray[medianIndex] + bigArray[medianIndex+1]) / 2;
		 } else {
			 //Odd number of entries
			 medianIndex = (nums1.length +nums2.length) / 2;
			 median = bigArray[medianIndex];
		 }	
		return median;
				
	}
	 public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		 int n1 = 0; 
		 int n2 = 0;
		 double median = 0;
		 int medianIndex = 0;
		 boolean evenNumber;
		 
		 //if we have an odd number of total entries, the median wiill be the middle number. if there is an odd number
		 //of total entries, we need to return the average of the middle two. So lets find out 
		 
		 if (((nums1.length + nums2.length) & 1) == 0 ) {
			 evenNumber = true;
			 medianIndex = (nums1.length +nums2.length) / 2;
		 } else {
			 evenNumber = false;
			 medianIndex = (nums1.length +nums2.length) / 2 +1;
		 }
		 
		 for (int i=1; i <= medianIndex; i++) {
			 
			if (n1>= nums1.length) {
				median = nums2[n2];
				 n2++;
			} else 	if (n2>= nums2.length) {
				median = nums1[n1];
				 n1++;
			} else if (nums1[n1] < nums2[n2]) {
				 median = nums1[n1];
				 n1++; 
			 } else {
				 median = nums2[n2];
				 n2++;
			 }
		 }  //End for loop
	 
		 //If we have an odd number of total elements we have the median. If we have an even number we need to find the nex
		 //lowest value and average the two.
		 if (evenNumber) {
			 if (n1 >= nums1.length) {
				 median = (median + nums2[n2]) / 2;
			 } else if(n2 >= nums2.length) {
				 median = (median + nums1[n1]) / 2;
			 } else if (nums1[n1] < nums2[n2]) {
				 median = (median + nums1[n1]) / 2; 
			 } else {
				 median = (median + nums2[n2]) / 2; 
			 }
		 }
		 
		 return median;
	    }

}
