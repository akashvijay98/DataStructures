/*
Approach:
--------
Use HashMap to maintain the last occurence of each letter in a string

1. we will first check if the char is already visited by checking the set
    we are only interested in new unvisited chars
2. if not, then we check if the topmost element of the stack is lexographically bigger than the current char 
   and also check if the topmost character of the stack is available later in the string(it has duplicate):
   if all these conditions meet, then we remove the char
   else we just append the current char to the stack.


*/


class Solution {
    public String removeDuplicateLetters(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        Set<Character> set = new HashSet<>();

        Stack<Character> stack = new Stack();

        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),i);
        }

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);

            if(!set.contains(c)){
                while(!stack.isEmpty() && c<stack.peek() && map.get(stack.peek())>i){
                    set.remove(stack.pop());
                }
                set.add(c);
                stack.push(c);

            }
        }
          StringBuilder sb = new StringBuilder(stack.size());

            for(char ch:stack){
                sb.append(ch);
            }
            return sb.toString();

    }
}
