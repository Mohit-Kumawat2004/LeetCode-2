func findLucky(arr []int) int {
    sort.Ints(arr)
    for i := len(arr) - 1; i >= 0; {
        j := i - 1
        for ; j >= 0; j-- {
            if arr[i] != arr[j] {
                break
            }
        }

        if arr[i] == i - j {
            return arr[i]
        } else {
            i = j
        }
    }
    return -1
}