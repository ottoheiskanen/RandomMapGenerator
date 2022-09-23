import java.util.Arrays;
import java.util.Random;

public class Generator {
    public static void printMap(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
    }
    public static int randomPosition(int dir) {
        return (int)(Math.random() * dir - 1);
    }
    public static float randomWeight() {
        Random rand = new Random();
        float f = rand.nextFloat() / 10;
        return f;
    }
    public static void weightedMap(int[][] mapArray, int lastRow, int lastCol) {
        float weight = randomWeight();
        System.out.println(weight);
        System.out.println(weight * 1.1);
        for (int i = 0; i < mapArray.length; i++) {
            //Block change
            for (int j = 0; j < mapArray[i].length; j++) {
                if (weight > 0.35) {   //0.25
                    mapArray[i][j] = 1;
                }
                //Re-weighting
                if (weight * (float) 1.1 < 0.90) {
                   weight = weight * (float) 1.1;
                } else {
                    weight = randomWeight();
                }
            }
        }
    }
    public static void baseMap(int[][] mapArray, int lastRow, int lastCol) {
        for (int i = 0; i < mapArray.length; i++) {
            for (int j = 0; j < mapArray[i].length; j++) {
                if((i == 0) || (i == lastRow) || (j == 0) || j == lastCol) {
                    mapArray[i][j] = 1;
                }
            }
        }
    }
}
