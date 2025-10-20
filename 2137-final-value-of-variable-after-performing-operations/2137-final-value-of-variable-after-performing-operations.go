func finalValueAfterOperations(operations []string) (x int) {
	for _, op := range operations {
		if op[1] == '+' {
			x++
		} else {
			x--
		}
	}
	return x
}