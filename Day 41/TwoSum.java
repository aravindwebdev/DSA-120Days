class Solution {
    //Using bruteforce
    boolean twoSum(int arr[], int target) {
        // code here
        int n = arr.length;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(arr[i]+arr[j] == target) return true;
            }
        }
        return false;
    }

    //Using binary search
    boolean twoSum(int arr[], int target) {
        // code here
        int n = arr.length;
        Arrays.sort(arr);
        
        for(int i=0; i<n; i++){
            int complement = target - arr[i];
            
             if(binarySeach(arr,complement,i+1,n-1))
                return true;
        }
        return false;
    }
    
    boolean binarySeach(int[] arr, int target, int low, int high){
        while(low <= high){
            int mid = low + (high - low)/2;
            
            if(arr[mid] == target)
                return true;
            if(arr[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
                
        }
        return false;
    }

    //Using two pointer
    boolean twoSum(int arr[], int target) {
        // code here
        int left = 0;
        int right = arr.length - 1;
        Arrays.sort(arr);
        while(left < right){
            int sum = arr[left] + arr[right];
            if(sum == target){
                return true;
            }else if(sum < target){
                left++;
            }else {
                right--;
            }
        }
        return false;
    }
    //Using hash sets
    boolean twoSum(int arr[], int target) {
        // code here
        int n = arr.length;
        if(target == 0) return false;
        HashSet<Integer> hSet = new HashSet<>();
        
        for(int i=0; i<arr.length; i++){
            int comp = target - arr[i];
            
            if(hSet.contains(comp)){
                return true;
            }
            hSet.add(arr[i]);
        }
        return true;
    }
    
}