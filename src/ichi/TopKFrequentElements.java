/**
 * 
 */
package ichi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

/**
 * @author kje511
 *
 */
public class TopKFrequentElements {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] l = {1,1,1,2,2,3};
		
		List<Integer> ret = topKFrequent(l, 2);
		
		System.out.println(ret);
		

	}
	
	public static class Pair {
		public int key;
		public int value;
		
		public Pair(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}
	
	private static Comparator<Pair> pairComparator =  new Comparator<Pair>() {
		@Override
		public int compare(Pair left, Pair right) {
			if (left.value != right.value) {
				return - left.value + right.value;
			}
			
			return - left.key + right.key;
		}
	};

	public static List<Integer> topKFrequent(int[] nums, int k) {
		List<Integer> result = new ArrayList<Integer>();
		
		if (k == 0) {
			result.add(nums[0]);
		}

		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for (int i:nums) {
			Integer freq = map.get(i);
			if (freq == null) {
				map.put(i, 1);
			}
			else {
				map.put(i, freq + 1);
			}
		}
		
		PriorityQueue<Pair> pairQueue = new PriorityQueue<Pair>(k, pairComparator);
		
		Iterator<Entry<Integer, Integer>> it = map.entrySet().iterator();
		
		while (it.hasNext()) {
			Entry<Integer, Integer> e = it.next();
			
			Pair pair = new Pair(e.getKey(), e.getValue());
			
			pairQueue.add(pair);
		}
		
		result.add(pairQueue.poll().key);
		result.add(pairQueue.poll().key);
		
		return result;
	}

}
