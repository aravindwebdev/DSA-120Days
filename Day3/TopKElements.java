import java.util.*;
public class TopKElements{
    public static int[] topKFrequent(int[] nums, int k){

        //Using Priority Queue
        int n=nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> map.get(b)-map.get(a));
        for(int i : map.keySet()){
            pq.offer(i);
        }

        int ans[] = new int[k];
        for(int i=0; i<k; i++){
            ans[i] = pq.poll();
        }
        return ans;
    }

    public static void main(String[] args){
        int[] nums = {1,1,1,2,2,2,3};
        int k = 2;

        int[] solution = topKFrequent(nums,k);
        for(int n : solution){
            System.out.println(n);
        }
    }
}
