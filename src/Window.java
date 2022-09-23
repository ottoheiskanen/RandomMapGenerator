import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Window extends JFrame {

    public Window(int[][] mapArray) {
        //Grid
        JPanel grid = new JPanel();
        grid.setBackground(Color.black);
        grid.setLayout(new GridLayout(Main.mapHeight, Main.mapWidth));

        ImageIcon tempBlock = new ImageIcon("src/img/block.png");
        Image blockImage = tempBlock.getImage().getScaledInstance(Main.gridSize, Main.gridSize, java.awt.Image.SCALE_SMOOTH);
        ImageIcon block = new ImageIcon(blockImage);

        ImageIcon tempEmpty = new ImageIcon("src/img/empty.png");
        Image emptyImage = tempEmpty.getImage().getScaledInstance(Main.gridSize, Main.gridSize, java.awt.Image.SCALE_SMOOTH);
        ImageIcon empty = new ImageIcon(emptyImage);

        ImageIcon tempEnemy = new ImageIcon("src/img/enemy.png");
        Image enemyImage = tempEnemy.getImage().getScaledInstance(Main.gridSize, Main.gridSize, java.awt.Image.SCALE_SMOOTH);
        ImageIcon enemy = new ImageIcon(enemyImage);

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
