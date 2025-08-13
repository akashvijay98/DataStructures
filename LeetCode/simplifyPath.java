class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();

        String[] list = path.split("/");

        for(String dir: list){
            if(dir.equals("..") ){
                if( !stack.isEmpty()){
                    stack.pop();
                }
                
            }

            else if(!dir.equals(".") && !dir.isEmpty()){
                stack.push(dir);
            }
        }

        StringBuilder sb = new StringBuilder();

        for(String s : stack){
            sb.append("/").append(s);
        }

        if(sb.length()>0){
            return sb.toString();
        }

        return new String("/");
    }
}
