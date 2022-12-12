package com.ae2dms.bubblebobble.marks;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Marks handles all the ooperations about the game score:
 * store the score, read the score and sort the score.
 *
 * @author Ke Liu
 */
public class Marks {

    File file = new File("Bubblebobble/src/main/resources/com/ae2dms/bubblebobble/marks.txt");
    public ArrayList<Integer> ranklist = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0));

    /**
     * Initialize Marks.
     */
    public Marks() {
    }

    /**
     * Initialize Marks with store the score.
     *
     * @param score int type, the goals after defeat the enemy and boss.
     * @throws IOException If the target score list file does not exist, then throws exception.
     */
    public Marks(int score) throws IOException {
        String str = String.valueOf(score);
        FileWriter writer = new FileWriter(file, true);
        writer.append(str + "\n");
        writer.flush();
        writer.close();
    }

    /**
     * Read the score list.
     *
     * @throws IOException
     */
    public void readMarks() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String s;
        int marks;
        while ((s = br.readLine()) != null) {
            marks = Integer.parseInt(s);
            ranklist.add(marks);
        }
        br.close();
    }

    /**
     * Sort the scores from highest to lowest.
     */
    public void order() {
        ranklist.sort(Comparator.reverseOrder());
    }
}


