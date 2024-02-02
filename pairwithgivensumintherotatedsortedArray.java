package solving100DaysOfCode;

public class pairwithgivensumintherotatedsortedArray {

    public static boolean pairsum(int []arr,int n,int sum){
        int i;
        // linear search for finding the pivot index . with this you can take out how many times array has been rotated.
            for(i=0;i<n-1;i++){
                if(arr[i]>arr[i+1]){
                    break;
                }
            }

            int l = (i+1)%n; //l will point to smallest element 
            int r = i; //r will point on largest element.

            while(l!=r){
                if(arr[l] + arr[r] == sum){
                    return true;
                }
                if(arr[l]+arr[r]<sum){ //if it is not greater than sum so we have to increase the l as l is pointing to smaller value. 
                    l = (l+1)%n;
                }
                else{//if it is greater than sum so we have to reduce the r as r is pointing to higher values.
                    r = (n+r-1)%n;
                }
            }
            return false;
    }
    public static void main(String[] args) {
        int arr[] = {11, 15, 6, 8, 9, 10};
        System.out.println(pairsum(arr, arr.length, 16));
    }
}
// very smartly they have created condition similar to the question in given pair sum.
// they found the pivot index which tell them about min and max element is situation in which index.
// and due to which they can easily move the pointer accordingly respect to the sum.
