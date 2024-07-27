class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int []nse = new int[n];
        int []pse = new int[n];
        st.push(n-1);
        nse[n-1]=n;
//         finding the next smaller element
        for(int i=n-2;i>=0;i--){
            while(st.size()>0 && heights[st.peek()] >= heights[i])
                st.pop();
            
            if(st.size()==0) nse[i] = n;
            else nse[i] = st.peek();
            st.push(i);
        }
        
        while(!st.isEmpty()){
            st.pop();
        }
        
//         finding the previous smaller element
        st.push(0);
        pse[0] = -1;
         for(int i=1;i<=n-1;i++){
            while(st.size()>0 && heights[st.peek()] >= heights[i])
                st.pop();

            if(st.size()==0) pse[i] = -1;
            else pse[i] = st.peek();
            st.push(i);
        }
        
//         finding the max area
        int maxi = -1;
        for(int i=0;i<n;i++){
            int area = heights[i]*(nse[i]-pse[i]-1);
            maxi = Math.max(maxi,area);
        }
        
        return maxi;
    }
}