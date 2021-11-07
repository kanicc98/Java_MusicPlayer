package client;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
import java.io.File;
import java.util.LinkedList;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *
 * Duy Pham Junit Test for Music Player
 */
public class musicPlayerTest {

    private File directory;
    private File[] files;
    private LinkedList<File> songList = new LinkedList<File>();
    private String[] tempArray;
    private int songNumber;
    private Media media;
    private MediaPlayer mediaPlayer;
    private static int min = 0;
    private static int max;
    private static int mid;

    public musicPlayerTest() {

        directory = new File("music");
        files = directory.listFiles();
        tempArray = new String[files.length];
        max = files.length;
        int counter = 0;
        //save into tempArray
        if (files != null) {
            for (File file : files) {
                tempArray[counter] = file.toString();
                counter++;
            }
        }
        mergeSort(tempArray, 0, tempArray.length - 1);
        for (int i = 0; i < counter; i++) {
            File tempFile = new File(tempArray[i]);
            songList.add(tempFile);
        }
    }

    public static int stringBinarySearch(LinkedList<File> searchList, String key) {
        while (min <= max) {
            mid = (min + max) / 2;
            if (searchList.get(mid).getName().compareTo(key) < 0) {
                min = mid + 1;
            } else if (searchList.get(mid).getName().compareTo(key) > 0) {
                max = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    //mergeSort
    public static void mergeSort(String[] a, int from, int to) {
        if (from == to) {
            return;
        }
        int mid = (from + to) / 2;
        // sort the first and the second half
        mergeSort(a, from, mid);
        mergeSort(a, mid + 1, to);
        merge(a, from, mid, to);
    }// end mergeSort

    public static void merge(String[] a, int from, int mid, int to) {
        int n = to - from + 1;       // size of the range to be merged
        String[] b = new String[n];   // merge both halves into a temporary array b
        int i1 = from;               // next element to consider in the first range
        int i2 = mid + 1;            // next element to consider in the second range
        int j = 0;                   // next open position in b

        // as long as neither i1 nor i2 past the end, move the smaller into b
        while (i1 <= mid && i2 <= to) {
            if (a[i1].compareTo(a[i2]) < 0) {
                b[j] = a[i1];
                i1++;
            } else {
                b[j] = a[i2];
                i2++;
            }
            j++;
        }

        // note that only one of the two while loops below is executed
        // copy any remaining entries of the first half
        while (i1 <= mid) {
            b[j] = a[i1];
            i1++;
            j++;
        }

        // copy any remaining entries of the second half
        while (i2 <= to) {
            b[j] = a[i2];
            i2++;
            j++;
        }

        // copy back from the temporary array
        for (j = 0; j < n; j++) {
            a[from + j] = b[j];
        }
    }//end merge

    @Test
    public void testAddSong() {
        int expInt = files.length;
        int result = tempArray.length;
        assertEquals(expInt, result);
        System.out.println("\nTest Add Music Method \n" + "Expected number of songs: " + expInt + "\nActual number of songs: " + result);
    }

    @Test
    public void testSort() {
        System.out.println("\r\nTest Merge Sort");
        String[] testSort = {"W", "B", "D", "C", "A", "I", "O"};
        String print = "";
        for (int i = 0; i < testSort.length; i++) {
            print += testSort[i] + ",";
        }
        System.out.println("Before sort: " + print);
        mergeSort(testSort, 0, testSort.length - 1);
        print = "";
        for (int i = 0; i < testSort.length; i++) {
            print += testSort[i] + ",";
        }
        System.out.println("After sort: " + print);
    }

    @Test
    public void testSearch() {
        System.out.println("\r\nTest Binary Search");
        String searchSong = "Yiruma-River-Flows-in-You.wav";
        System.out.println("Searched Song: " + searchSong);
        System.out.println("Song found at: " + stringBinarySearch(songList, searchSong) + "\nSong name: " + songList.get(stringBinarySearch(songList, searchSong)).getName());
        assertTrue(stringBinarySearch(songList, searchSong) > 0);
    }
}
