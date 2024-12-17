class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes,(a1,a2)->(a2[1]-a1[1]));
        
        int sum = 0;
        for(int i=0;i<boxTypes.length;i++){
            int boxes = boxTypes[i][0];
            int units = boxTypes[i][1];
            
            int cap = Math.min(boxes,truckSize);
            truckSize -= cap;
            sum += cap*units;
            if(truckSize==0){
                return sum;
            }
        }
        
        return sum;
    }
}