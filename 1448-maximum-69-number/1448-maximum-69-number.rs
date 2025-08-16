// Rust
impl Solution {
    pub fn maximum69_number(num: i32) -> i32 {
        let mut s: Vec<char> = num.to_string().chars().collect();
        for c in &mut s {
            if *c == '6' {
                *c = '9';
                break;
            }
        }
        s.iter().collect::<String>().parse().unwrap()
    }
}