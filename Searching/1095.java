class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peak = peakIndexInMountainArray(mountainArr);
        int firstTry = ascending(mountainArr, target, 0, peak);
        if (firstTry != -1) {
            return firstTry;
        } else {
            return descending(mountainArr, target, peak + 1, mountainArr.length() - 1);
        }
    }

    public int peakIndexInMountainArray(MountainArray mountainArr) {
        int start = 0;
        int end = mountainArr.length() - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return start;
    }

    static int ascending(MountainArray mountainArr, int target, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            int midValue = mountainArr.get(mid);
            if (target == midValue) {
                return mid;
            } else if (target < midValue) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    static int descending(MountainArray mountainArr, int target, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            int midValue = mountainArr.get(mid);
            if (target == midValue) {
                return mid;
            } else if (target < midValue) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
