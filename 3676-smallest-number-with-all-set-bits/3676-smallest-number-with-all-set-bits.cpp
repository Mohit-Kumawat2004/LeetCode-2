class Solution {
public:
    int smallestNumber(int n) {
        int powerTwo = 1;
        while(powerTwo <= n){
            powerTwo *= 2; // OR powerTwo <<= 1; left shift by 1 bit
        }

        return powerTwo-1;
    }
};