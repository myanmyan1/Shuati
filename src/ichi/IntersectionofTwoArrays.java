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
        	if (set.contains(i)) {
        		continue;
        	}
        	
        	for (int j:nums2) {
        		if (i == j) {
        			set.add(i);
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
