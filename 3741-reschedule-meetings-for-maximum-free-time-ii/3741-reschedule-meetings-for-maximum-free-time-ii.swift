class Solution {
  func maxFreeTime(_ eventTime: Int, _ startTime: [Int], _ endTime: [Int]) -> Int {
    let sizes = zip(endTime, startTime).map(-)
    let gaps = zip(chain(startTime, [eventTime]), chain([0], endTime)).map(-)
    let prefixSum = gaps.reductions(0,max)
    let suffixSum = Array(chain(gaps.dropFirst(2),[0]).reversed().reductions(max).reversed())
    let lrGaps = gaps.adjacentPairs().map(+)
    let meetingSizes = zip(sizes, zip(prefixSum, suffixSum).map(max)).map{$0<=$1 ? $0:0}
    return zip(lrGaps, meetingSizes).map(+).max()!
  }
}