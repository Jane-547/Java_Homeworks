package Task03;

import java.util.Arrays;

class HeapSort {
    public static void buildTree(int[] tree, int sortLength) {
        // Введите свое решение ниже
        for (int i = 0; i < sortLength; i++) {
            int max = i;
            int l = 2*i + 1; // левый = 2*i + 1
            int r = 2*i + 2; // правый = 2*i + 2

            if (l < sortLength && tree[l] > tree[max]) {
                max = l;
            }

            if (r < sortLength && tree[r] > tree[max]) {
                max = r;
            }

            if  (!(i == max)) {
                int temp = tree[i];
                tree[i] = tree[max];
                tree[max] =temp;
                i--;
                buildTree(tree, sortLength);
            }
        }
    }

    public static void heapSort(int[] sortArray, int sortLength) {
    // Введите свое решение ниже
        buildTree(sortArray, sortLength);

        int size = sortLength;
        while (size > 0) {
            int temp = sortArray [0];
            sortArray [0] = sortArray[size - 1];
            sortArray [size - 1] = temp;
            size--;
            buildTree(sortArray, size);
        }
    }
}

// Не удаляйте и не меняйте метод Main!
public class Printer {
    public static void main(String[] args) {
        int[] initArray;

        if (args.length == 0) {
            initArray = new int[]{17, 22, 14, 5, 28, 11, 7};
        } else {
            initArray = Arrays.stream(args[0].split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        System.out.println("Initial array:");
        System.out.println(Arrays.toString(initArray));
        HeapSort.heapSort(initArray, initArray.length);
        System.out.println("Sorted array:");
        System.out.println(Arrays.toString(initArray));
    }
}
