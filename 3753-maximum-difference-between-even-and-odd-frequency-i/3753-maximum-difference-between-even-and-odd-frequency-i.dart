class Solution {
  int maxDifference(String s) {
    final frequencyMap = <String, int>{};
    for (var i = 0; i < s.length; i++) {
        final char = s[i];
        frequencyMap[char] = (frequencyMap[char] ?? 0) + 1;
    }
    final oddFrequencies = <int>[];
    final evenFrequencies = <int>[];
    frequencyMap.forEach((char, count) {
        if (count % 2 == 1) {
            oddFrequencies.add(count);
        } else {
            evenFrequencies.add(count);
        }
    });
    if (oddFrequencies.isEmpty || evenFrequencies.isEmpty) {
        return 0;
    }
    final maxOdd = oddFrequencies.reduce((a, b) => a > b ? a : b);
    final minEven = evenFrequencies.reduce((a, b) => a < b ? a : b);   
    return maxOdd - minEven;
  }
}