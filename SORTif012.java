import java.util.Scanner;

public class SORTif012 {


    public static void sort(int arr[] , int n){
        int start = 0;
        int mid = 0;
        int end = n - 1;
        while(mid<=end){
            if (arr[mid] == 0){
                swap(arr , start ,mid);
                start++;
                mid++;
            }
            else if (arr[mid] == 1){
                mid++;
            }
            else{
                swap(arr , mid , end);
                end--;
                mid++;
            }
        }
    }

    public static void swap(int arr[] , int a ,int b ){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String []args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            int temp = scan.nextInt();
            arr[i] = temp;
        }
        sort(arr,n );
        for(int i=0;i<n;i++){
            System.out.print(arr[i] + " ");
        }
    }



    
}
