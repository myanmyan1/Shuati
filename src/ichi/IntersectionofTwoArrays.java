/**
 * 
 */
package ichi;

import java.util.HashSet;
import java.util.Set;

/**
 * @author kje511
 *
 */
public class IntersectionofTwoArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<Integer>();
        
        for (int i:nums1) {
        	if (set.contains(nums1[i])) {
        		continue;
        	}
        	
        	for (int j:nums2) {
        		if (nums1[i] == nums2[j]) {
        			set.add(nums1[i]);
        		}
        	}
        }
    	
    	int size = set.size();
    	int[] result = new int[size];
    	int i=0;
    	for (int k:set) {
    		result[i++] = k; 
    	}
    	return result;
    }
}
