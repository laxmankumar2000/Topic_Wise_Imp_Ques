package Arrays;

/*
Reverse the given Arrays
 */
public class Reverse {
    public static void main(String[] args) {
        int[] arr = {5,7,6,1,9,2,3};
        int n = arr.length;
        reverseArray(arr,0,n-1);
    }

    private static void reverseArray(int[] arr, int i, int j) {

        if (i>=j){
            for (int k:arr
                 ) {
                System.out.print(k + " ");
            }
            return;
        }

        int temp;

        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        reverseArray(arr,i+1,j-1);
    }

}
