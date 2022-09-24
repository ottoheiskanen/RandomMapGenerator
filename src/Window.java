import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    public ImageIcon resizeImage(String url) {
        ImageIcon image = new ImageIcon(url);
        Image tempImage = image.getImage().getScaledInstance(Main.gridSize, Main.gridSize, java.awt.Image.SCALE_SMOOTH);
        ImageIcon scaled_image = new ImageIcon(tempImage);
        return scaled_image;
    }

    public Window(int[][] mapArray) {

        //Grid
        JPanel grid = new JPanel();
        grid.setBackground(Color.black);
        grid.setLayout(new GridLayout(Main.mapHeight, Main.mapWidth));

        // Load object sprites
        ImageIcon block = resizeImage("src/img/block.png");
        ImageIcon empty = resizeImage("src/img/empty.png");
        ImageIcon enemy = resizeImage("src/img/enemy.png");

        // Add blocks
        for (int i = 0; i < mapArray.length; i++) {
            for (int j = 0; j < mapArray[i].length; j++) {
                if (mapArray[i][j] == 1) {
                    grid.add(new JLabel(block));
                } else if (mapArray[i][j] == 0) {
                    grid.add(new JLabel(empty));
                } else if (mapArray[i][j] == 2) {
                    grid.add(new JLabel(enemy));
                }

            }
        }

        int width = Main.mapWidth * Main.gridSize;
        int height = Main.mapHeight * Main.gridSize;

        JFrame frame = new JFrame("Map");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(width, height));
        frame.setResizable(false);
        frame.add(grid);
        frame.pack();
        frame.setVisible(true);
    }
}
