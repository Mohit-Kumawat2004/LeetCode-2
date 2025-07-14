impl Solution {
    pub fn get_decimal_value(mut head: Option<Box<ListNode>>) -> i32 {
        let mut result = 0;
        while let Some(node) = head {
            result = (result << 1) | node.val;
            head = node.next;
        }
        result
    }
}