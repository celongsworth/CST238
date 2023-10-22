/*
 * Title: Hw01a_Distinct.java
 * Abstract: This program displays each distinct number in a file, and how many times it occurred
 * Author: Claire Longsworth
 * Email: clongsworth@csumb.edu
 * Estimate: 2.5 hours
 * Date: 08/27/2023
 */

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);

        String filename;
        System.out.print("Enter file name: ");
        filename = in.next();

        FileReader fr = new FileReader(filename);
        Scanner fs = new Scanner(fr);

        int quantity = fs.nextInt();
        int[] allInputs = new int[quantity];
        for (int i = 0; i < quantity; i++) {
            allInputs[i] = fs.nextInt();
        }

        int[] contents = new int[quantity];
        int[] occur = new int[quantity];
        int count = 0;

        for (int i = 0; i < quantity; i++) {
            if (isDistinct(contents, allInputs[i], count)) {
                contents[count++] = allInputs[i];
                occur[count - 1] += 1;
            } else {
                for (int j = 0; j <= count; ++j) {
                    if (allInputs[i] == contents[j]) {
                        occur[j] += 1;
                    }
                }
            }
        }
        int minVal = contents[0];
        for (int i = 0; i < count; i++) {
            if (contents[i] < minVal) {
                minVal = contents[i];
            }
        }
        System.out.println("Min Number: " + minVal);
        System.out.println("Number    Count ");
        for (int i = 0; i < count; ++i) {
            if (contents[i] < 10 && contents[i] >= 0) {
                System.out.println(contents[i] + "         " + occur[i]);
            } else if (contents[i] < 100) {
                System.out.println(contents[i] + "        " + occur[i]);
            } else {
                System.out.println(contents[i] + "       " + occur[i]);
            }
        }
        fr.close();
    }

    public static boolean isDistinct(int[] a, int value, int size) {
        for (int i = 0; i < size; i++) {
            if (value == a[i]) {
                return false;
            }
        }
        return true;
    }
}