class Solution {
    public int countComponents(int n, int[][] edges) {
       int components=n;

       DSU dsu = new DSU(n);
       
       for(int i=0;i<edges.length;i++){
            // every time two nodes are combined into  1 component, union() returns 1.
            
            // remember a node can either be combined to an existing component, or create a new component with another disjoint node. in both cases union return 1.

            // it returns 0 only if there is a cycle 
            components-= dsu.union(edges[i][0],edges[i][1]);
       }
       return components;
    }


     class DSU{
            int N;
            int[] parent;
            int[] size;

            public DSU(int N){
                this.N = N;
                parent = new int[N];
                size = new int[N];

                for(int i =0;i<N;i++){
                    parent[i]=i;
                    size[i]=1;

                }
            }

            public int find(int x){
                if(parent[x]!=x){
                    parent[x] = find(parent[x]);
                }
                return  parent[x];
            }

            public int union(int x, int y){
                int p = find(x);
                int q = find(y);

                if(p==q){
                    return 0;
                }
                else{
                    if(size[p]>size[q]){
                        parent[q]=p; 
                        size[p]+=size[q];
                    }
                    else{
                        parent[p]=q;
                        size[q]+=size[p];
                    }
                }
                return 1;
                
            }

          
            

        }


}
