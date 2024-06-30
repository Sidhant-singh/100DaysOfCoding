class Solution {
    public void moveZeroes(int[] arr) {
        int noz = 0;
//         calculating the zeros because the outer loop will run that time only
        for(int ele : arr){
            if(ele == 0) noz++;
        }
        int n = arr.length;
        for(int x=0;x<noz;x++){
            for(int i=0;i<n-1-x;i++){
                if(arr[i]==0){
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
        }
    }
}