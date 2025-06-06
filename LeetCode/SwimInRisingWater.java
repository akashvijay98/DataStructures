class Solution {
    public int swimInWater(int[][] grid) {
        Queue<Node> pq = new PriorityQueue<>((a,b)-> a.val-b.val);

        int m = grid.length;
        int n = grid[0].length;

       

        int[][] dir= new int[][] {{1,0},{-1,0},{0,1},{0,-1}};

        int[][] visited= new int[m][n];

        visited[0][0]=1;
        pq.add(new Node(0,0,grid[0][0]));

        while(!pq.isEmpty()){
            int size = pq.size();

            for(int i=0;i<size;i++){

                Node node = pq.poll();

                int r = node.row;
                int c = node.col;
                int val = node.val;

              

                if(r==m-1 && c==n-1){
                    return node.val;
                }

                for(int[] d: dir){
                    int newR = r+d[0];
                    int newC = c+d[1];

                    if(newR<0 || newR>=grid.length || newC<0 || newC>=grid[0].length || visited[newR][newC]==1 ){
                        continue;
                    }

                    visited[newR][newC]=1;

                    // you add the max(node, grid[r][c]) value because at time t, the  depth everywhere is going to be t
                    // so if your node value is 2 and you encounter 1 later, the depth is already going to be 2. so append(2)
                    
                    pq.add(new Node(newR,newC,Math.max(node.val,grid[newR][newC])));


                }
            }

        }

        return -1;

    }

    class Node {
        int row;
        int col;
        int val;

        public Node(int row, int col, int val){
            this.row = row;
            this.col = col;
            this.val=val; 
        }
    }
}
