### Partition Linked List

  **approach:** 
  The idea is to put the elements less than x in a seperate linked list 
  and put elements greater than or equal to  x into a seperate list and then join both the lists

    
### Container with Maximum Water 
  ***approach:***
   ***two pointer binary search***
   initialise two pointers left and right at start and end position of the array.
   keep finding the maximum area between the two pointers until l<r.

### Daily Temperatures https://leetcode.com/problems/daily-temperatures/ ### 
  ***approach***
   ***stacks***

  We are going to store the index of the temperatures array element in the stack.
  
    first we iterate through the temperatures array and
    1. we check if the stack is not empty and also check:
    2. if the topmost element in the stack is less than the current element of the temperatures array (temperatures[stack.peek()] < temperatures[i])).
        a. if yes then we find the difference between i and stack.peek() ( because this is the number of days from temperatures[stack.peek()] to the next warmer day  (temperature[i]).
        remember if the condition satisfies, then the temperature at stack.peek() will always be less than temperature at i. so we do 
        result[stack.pop()] = difference 

        b. if no then just add the index i to the stack.
