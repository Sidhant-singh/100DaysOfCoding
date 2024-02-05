package solving100DaysOfCode;

public class minimumOpToMakeAnArrayPallindrome {

    public static int minimumOperations(int []arr){
        int left = 0;
        int right = arr.length-1;
        int count = 0;
        while(left<=right){
            if(arr[left] == arr[right]){
                left++;
                right--;
            }
            // if left ele is smaller than we have to merge 2 left elements.
            /*If the element at left is smaller than the element at right, it means merging the two elements at the 
            left will bring them closer to each other in value. 
            Therefore, it merges the two left elements, increments left, and increases the count. */
            else if(arr[left]<arr[right]){
                left++;
                arr[left] += arr[left-1];
                count++;
            }

            // if left ele is greater than we have to merge 2 right elements
            /*If the element at left is greater than the element at right, it means merging the two elements at 
            the right will bring them closer to each other in value. Therefore, 
            it merges the two right elements, decrements right, and increases the count. */
            else{
                right--;
                arr[right] = arr[right] + arr[right+1];
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int [] arr = {11,14,15,99};
        System.out.println(minimumOperations(arr));
    }
}
