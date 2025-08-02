class Solution {
  String longestPalindrome(String s) {
    int n = s.length;
    int start = 0;
    int end = 0;

    for (var i = 0; i < n; i++) {
      int oddLen = expandFromCenter2(s, i, i);
      int evenLen = expandFromCenter2(s, i, i + 1);

      int len = max(oddLen, evenLen);

      if (len > end - start) {
        start = i - (len - 1) ~/ 2;
        end = i + len ~/ 2;
      }
    }

    return s.substring(start, end + 1);
  }

    int expandFromCenter2(String s, int left, int right) {
    int n = s.length;
    while (left >= 0 && right < n && s[left] == s[right]) {
      left--;
      right++;
    }
    return right - left - 1;
  }
}