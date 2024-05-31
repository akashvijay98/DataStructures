class Solution {
    public int[] closestRoom(int[][] rooms, int[][] queries) {

        Arrays.sort(rooms, (a,b)->Integer.compare(a[1],b[1]));

        int n = queries.length;
        int[] ans = new int[n];

        for(int i=0;i<n;i++){
            int id = queries[i][0];
            int minSize = queries[i][1];

            int index = binarySearch(rooms,id,minSize);

            if(index == -1){
                ans[i]=-1;
                continue;
            }

            int idx=find(rooms,index,id);

            ans[i] = rooms[idx][0];

        }

        return ans;
    }

    public int binarySearch(int[][]rooms, int id, int minSize){
        int index = -1;
        int left=0; int right = rooms.length-1;

        while(left<=right){
            int mid = (left+right)/2;

            if(rooms[mid][1]<minSize){
                left = mid+1;
            }
            else{
                index = mid;
                right = mid-1;
            }
        }
        return index;
    }

    public int find(int[][]rooms, int index, int id){
        int min = Math.abs(rooms[index][0]-id);

        int ans = index;

        for(int i=index+1; i<rooms.length;i++){
            int temp = Math.abs(id-rooms[i][0]);

            // incase the difference between preferredId != room[index][0], then take the id with the minimum difference
            if(temp<min){
                ans=i;
                min = temp;
            }

            // else if preferredId == room[index][0], then take the id with minimum value, not minimum difference both are different things.
            else if(temp == min){
                if(rooms[i][0]<rooms[ans][0]){
                    ans = i;
                }
            }
        }
        return ans;
    }

    
}
