class Solution {
    public int[] plusOne(int[] digits) {
        

        for (int i = digits.length-1; i>=0;i--){
            
            // if the number at position i is less than 9, then we jsut add 1 and return;
            if(digits[i] < 9){
                digits[i] += 1;
                return digits;
            }

            // else the number must be 9, so 9+1 = 10. 
            // so we make the number at position i to 0.
            // then we continue the loop to see if the next number is less than 9.
            digits[i]=0;
       
        }

    // we are out of the for loop which means that the array was something like [999]
    // so we if we add 1, we need to increase the length of the array by 1.
    // so we create a new array with length +1
    // by default the array will have [0,0,0,0]
    // we just add 1 to the first element of the array 
    digits = new int[digits.length+1];
    digits[0]=1;
    return digits;
    }


}
