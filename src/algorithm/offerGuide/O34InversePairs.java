package algorithm.offerGuide;


public class O34InversePairs {
    public static void main(String[] args) {
        O34InversePairs pairs = new O34InversePairs();
        int i = pairs.InversePairs(new int[]{1, 2, 3, 4, 5, 6, 7, 0});
        System.out.println(i);
    }
    int count;
    public int InversePairs(int [] array) {
        count = 0;
        if (array.length > 1){
            mergeSort(array, 0, array.length-1);
        }
        return count;
    }

    private void mergeSort(int[] array, int low, int high) {
        if (low >= high) return;
        int mid = (high - low) / 2 + low;
        mergeSort(array, low, mid);
        mergeSort(array, mid+1, high);
        merge(array, low, mid, high);
    }

    private void merge(int[] array, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = mid, j = high, k = high - low;
        while (i >= low && j >= mid+1){
            if (array[i] <= array[j]) temp[k--] = array[j--];
            if (array[i] > array[j]){
                temp[k--] = array[i--];
                count += (j - mid);
                count %= 1000000007;
            }
        }
        while (i >= low) temp[k--] = array[i--];
        while (j >= mid+1) temp[k--] = array[j--];
        for ( i = low, k = 0; k < temp.length; k++) {
            array[i++] = temp[k];
        }
    }
}
