import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class MergeSortTest {
    static int[] sorted = new int[10];
    public static void main(String[] args) {
        int[] arr = {31, 3, 65, 73, 8, 11, 20, 29, 48, 15};
        long startTime = System.currentTimeMillis();
        mergeSort(arr, 0, arr.length-1);
        long endTime = System.currentTimeMillis();
        System.out.println("=================");
        String data = Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining(", "));
        System.out.println(data);
        System.out.println("수행 시간 : " + (endTime-startTime));

    }

    private static void mergeSort(int[] arr, int l, int r){
        if(l < r){
            int m = (l+r) / 2;

            mergeSort(arr, l , m);
            mergeSort(arr, m+1, r);

            merge(arr, l, m, r);

        }

    }

    private static void merge(int[] arr, int l, int m, int r) {
        int L = l;
        int R = m + 1;
        int k = l;
        // 작은 순서대로 배열에 삽입
        while(L <= m && R <= r){
            sorted[k++] = arr[L] <= arr[R] ? arr[L++] : arr[R++];
        }
        if(L>m){
            for(int t = R; t <= r; t++)
                sorted[k++] = arr[t];
        }else{
            for(int t = L;t <= m; t++)
                sorted[k++] = arr[t];
        }

        for(int t = l; t <= r; t++)
            arr[t] = sorted[t];

        String data = Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining(", "));
        System.out.println(data);
    }
}
