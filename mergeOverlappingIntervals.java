package solving100DaysOfCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

class Intervals{
    int start;
    int end;
    Intervals(int start,int end){
        this.start = start;
        this.end = end;
    }
}
public class mergeOverlappingIntervals {


    public static void mergeOverlappingIntervals(Intervals []arr){
        Arrays.sort(arr,new Comparator<Intervals>() {
            public int compare(Intervals i1,Intervals i2){
                return  i1.start - i2.start;
            }
        });

        Stack<Intervals> st = new Stack<>();

        st.push(arr[0]);

        for(int i=0;i<arr.length;i++){
            Intervals top = st.peek();

            if(top.end < arr[i].start){
                st.push(arr[i]);
            }

            else if(top.end < arr[i].start){
                top.end = arr[i].end;
                st.pop();
                st.push(top);
            }
        }

        System.out.print("The Merged Intervals are: ");
        while (!st.isEmpty()) {
            Intervals t = st.pop();
            System.out.print("[" + t.start + "," + t.end
                             + "] ");
        }
    }
    
    public static void main(String[] args) {
        Intervals arr[] = new Intervals[4];
        arr[0] = new Intervals(6, 8);
        arr[1] = new Intervals(1, 9);
        arr[2] = new Intervals(2, 4);
        arr[3] = new Intervals(4, 7);
        mergeOverlappingIntervals(arr);   
    }
}
