import java.util.Arrays;
import java.util.stream.Collectors;

public class QuickSortTest {
    public static void main(String[] args) {
        int[] arr = {15, 8, 48, 73, 11, 3, 20, 29, 65, 31};
        long startTime = System.currentTimeMillis();
        quick_sort(arr, 0, arr.length-1);
        long endTime = System.currentTimeMillis();
        String collect = Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining(", "));
        System.out.println(collect);
        System.out.println("수행 시간 : " + (endTime-startTime));
    }

    private static void quick_sort(int[] arr, int left, int right) {
        if(left < right){
            int pivot = partition(arr, left, right);

            quick_sort(arr, left , pivot-1);
            quick_sort(arr, pivot+1, right);
        }
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = (left - 1);

        for(int j=left; j<= right-1;j++){
            if(arr[j] <= pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[right];
        arr[right] = temp;
        return (i+1);
    }
}

