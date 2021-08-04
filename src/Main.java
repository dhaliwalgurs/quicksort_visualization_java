/* Name:       Gursimran Dhaliwal
 * Email:      gdhal233@mtroyal.ca
*  Course:     COMP 2631
*  Instructor: Jason Heard
*/
import java.awt.Color;

import javax.swing.JFrame;

public class Main {
    static final int FRAME_SIZE = 1000; //  x = 500
    static final int ARRAY_SIZE = 40;
    static final int MAX_VALUE_IN_ARRAY = 100;
    static final double MAX_BAR_HEIGHT = FRAME_SIZE / 2;
    static final int BAR_WIDTH = (int) (FRAME_SIZE / (ARRAY_SIZE * 1.25));
    static final Color PALE_BLUE = new Color (208, 237, 255);
    static final Color PINK = new Color (255, 0, 255);
    static final Color PURPLE = new Color (138, 43, 226);
    static final Color GREEN = new Color (0, 255, 0);
    static final Color YELLOW = new Color (255, 255, 0);
    static final int TIME_STEP_DELAY = 100;
    static JFrame window = new JFrame();
    static int[] intArr = new int[ARRAY_SIZE];
    private static int pivot = -1;



    public static void main(String args[]) {
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setBounds(0, 0, FRAME_SIZE, FRAME_SIZE);
        window.setBackground(PALE_BLUE);
        initializeRandomArray();

        paintVisualtArray();
        QuickSort.sort(intArr, 0, ARRAY_SIZE - 1);
    }

    public static void updateGraphic(int index1, int index2) {
        try {
            Thread.sleep(TIME_STEP_DELAY);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        swapElementsVisualArray(index1, index2);
        paintVisualtArray();
        printArray();
    }


    public static void paintVisualtArray() {
        int locX = 0;
        int locY = 0;

        for (int i = 0; i < ARRAY_SIZE; i++) {

            if (pivot != i) {
                locX = i * BAR_WIDTH + (FRAME_SIZE - BAR_WIDTH * ARRAY_SIZE) / 2;
                locY = (int)(FRAME_SIZE - intArr[i] * (MAX_BAR_HEIGHT / MAX_VALUE_IN_ARRAY)) - 100;
                window.getContentPane().add(new SingleBarImage(locX, locY, BAR_WIDTH, intArr[i], PINK));
                window.setVisible(true);
            } else {
                locX = pivot * BAR_WIDTH + (FRAME_SIZE - BAR_WIDTH * ARRAY_SIZE) / 2;
                locY = (int)(FRAME_SIZE - intArr[pivot] * (MAX_BAR_HEIGHT / MAX_VALUE_IN_ARRAY)) - 100;
                window.getContentPane().add(new SingleBarImage(locX, locY, BAR_WIDTH, intArr[pivot], PURPLE));
                window.setVisible(true);
            }

        }
    }

    public static void swapElementsVisualArray(int index1, int index2) {
        int locX = index1 * BAR_WIDTH + (FRAME_SIZE - BAR_WIDTH * ARRAY_SIZE) / 2;
        int locX2 = index2 * BAR_WIDTH + (FRAME_SIZE - BAR_WIDTH * ARRAY_SIZE) / 2;


        window.getContentPane().add(new SingleBarImage(locX, FRAME_SIZE - 100, BAR_WIDTH, FRAME_SIZE, GREEN));
        window.setVisible(true);
        window.getContentPane().add(new SingleBarImage(locX2, FRAME_SIZE - 100, BAR_WIDTH, FRAME_SIZE, GREEN));
        window.setVisible(true);
        try {
            Thread.sleep(TIME_STEP_DELAY);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        window.getContentPane().add(new SingleBarImage(locX, 0 , BAR_WIDTH, FRAME_SIZE, PALE_BLUE));
        window.setVisible(true);
        window.getContentPane().add(new SingleBarImage(locX2, 0, BAR_WIDTH, FRAME_SIZE, PALE_BLUE));
        window.setVisible(true);
    }


    public static void compareElementsVisual(int index1, int index2) {
        int locX = index1 * BAR_WIDTH + (FRAME_SIZE - BAR_WIDTH * ARRAY_SIZE) / 2;
        int locX2 = index2 * BAR_WIDTH + (FRAME_SIZE - BAR_WIDTH * ARRAY_SIZE) / 2;

        window.getContentPane().add(new SingleBarImage(locX, FRAME_SIZE - 100, BAR_WIDTH, FRAME_SIZE, YELLOW));
        window.setVisible(true);
        window.getContentPane().add(new SingleBarImage(locX2, FRAME_SIZE - 100, BAR_WIDTH, FRAME_SIZE, YELLOW));
        window.setVisible(true);
        try {
            Thread.sleep(TIME_STEP_DELAY);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        window.getContentPane().add(new SingleBarImage(locX, FRAME_SIZE - 99, BAR_WIDTH, FRAME_SIZE, PALE_BLUE));
        window.setVisible(true);
        window.getContentPane().add(new SingleBarImage(locX2, FRAME_SIZE - 99, BAR_WIDTH, FRAME_SIZE, PALE_BLUE));
        window.setVisible(true);
    }

    public static void setPivot(int arrPivot) {
        pivot = arrPivot;
    }

    public static void initializeRandomArray() {
        for (int i = 0; i < ARRAY_SIZE; i++) {
            intArr[i] = (int) (Math.random() * MAX_VALUE_IN_ARRAY);
        }
    }

    public static void printArray() {
        for (int i = 0; i < ARRAY_SIZE; i++) {
            if (i != ARRAY_SIZE - 1) {
                System.out.print(intArr[i] + ", ");
            } else {
                System.out.print(intArr[i]);
            }
        }
        System.out.println();
    }
}