class Solution {
    public int search(int[] nums, int target) {
        int peak = pivot(nums, target);
        int firsthalf = binary(nums, target, 0 , peak);
        if(firsthalf != -1){
            return firsthalf;
        }
        else{
            return binary(nums, target, peak+1, nums.length-1);
        }
    }

    public int pivot(int[] nums, int target){
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(mid < end && nums[mid] > nums[mid + 1]){
                return mid;
            }
            if(mid > start && nums[mid] < nums[mid-1]){
                return mid-1;
            }
            if(nums[start] >= nums[mid]){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return -1;
    }

    public int binary(int[] num, int target, int start, int end){
        while(start <= end){
            int mid = (start + end) / 2;
            if(target == num[mid]){
                return mid;
            }
            else if(target < num[mid]){
                end = mid-1;
            }
            else{
                start = mid + 1;
            }
        }
        return -1;
    }
}
