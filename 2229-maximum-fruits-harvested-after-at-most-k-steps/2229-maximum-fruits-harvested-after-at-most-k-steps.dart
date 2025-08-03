class Solution {
  int maxTotalFruits(List<List<int>> fruits, int startPos, int k) {
    int n = fruits.length;
    List<int> positions = [];
    List<int> amounts = [];
    for (var fruit in fruits) {
        positions.add(fruit[0]);
        amounts.add(fruit[1]);
    }
    List<int> prefixSum = List.filled(n + 1, 0);
    for (int i = 0; i < n; i++) {
        prefixSum[i + 1] = prefixSum[i] + amounts[i];
    }
    int maxFruits = 0;
    for (int direction = 0; direction < 2; direction++) {
        bool isRightFirst = direction == 1;
        for (int stepsRight = 0; stepsRight <= k; stepsRight++) {
            int stepsLeft = k - 2 * stepsRight;
            if (isRightFirst) {
                stepsLeft = k - stepsRight;
                stepsRight = stepsLeft;
                stepsLeft = k - 2 * stepsRight;
            }
            int leftPos = startPos - (isRightFirst ? stepsLeft : stepsLeft);
            int rightPos = startPos + stepsRight;
            if (!isRightFirst) {
                leftPos = startPos - stepsLeft;
                rightPos = startPos + (stepsLeft >= 0 ? stepsRight : 0);
            }
            int l = lowerBound(positions, leftPos);
            int r = upperBound(positions, rightPos) - 1;
            if (l <= r) {
                int current = prefixSum[r + 1] - prefixSum[l];
                if (current > maxFruits) {
                    maxFruits = current;
                }
            }
        }
    }
    
    for (int direction = 0; direction < 2; direction++) {
        bool isLeftFirst = direction == 0;
        for (int stepsLeft = 0; stepsLeft <= k; stepsLeft++) {
            int stepsRight = k - 2 * stepsLeft;
            if (!isLeftFirst) {
                stepsRight = k - stepsLeft;
                stepsLeft = stepsRight;
                stepsRight = k - 2 * stepsLeft;
            }
            int leftPos = startPos - stepsLeft;
            int rightPos = startPos + stepsRight;
            int l = lowerBound(positions, leftPos);
            int r = upperBound(positions, rightPos) - 1;
            if (l <= r) {
                int current = prefixSum[r + 1] - prefixSum[l];
                if (current > maxFruits) {
                    maxFruits = current;
                }
            }
        }
    }
    return maxFruits;
    }

    int lowerBound(List<int> arr, int target) {
    int left = 0;
    int right = arr.length;
    while (left < right) {
            int mid = left + (right - left) ~/ 2;
        if (arr[mid] < target) {
            left = mid + 1;
        } else {
            right = mid;
        }
    }
    return left;
    }

    int upperBound(List<int> arr, int target) {
    int left = 0;
    int right = arr.length;
    while (left < right) {
        int mid = left + (right - left) ~/ 2;
        if (arr[mid] <= target) {
            left = mid + 1;
        } else {
            right = mid;
        }
    }
    return left;
    }
}