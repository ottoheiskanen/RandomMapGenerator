import java.util.Arrays;
public class Main {
    public static int gridSize = 32;
    public static int mapWidth = 960 / gridSize;
    public static int mapHeight = 640 / gridSize;
    public static int [][] mapArray = new int[mapHeight][mapWidth];
    public static int lastRow = mapArray.length - 1;
    public static int lastCol = mapArray[0].length - 1;

    public static void main(String[] args) {
        Generator.baseMap(mapArray, lastRow, lastCol);
        Generator.weightedMap(mapArray, lastRow, lastCol);
        Generator.printMap(mapArray);
        Window window = new Window(mapArray);
    }
}