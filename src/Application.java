import gui.Controller;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Application {
    private static JFrame mainWindow;

    private Application(){
        mainWindow = new JFrame();
        mainWindow.setPreferredSize(new Dimension(720, 600));
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon icon = new ImageIcon("img/icon.png");
        mainWindow.setIconImage(icon.getImage());
        mainWindow.setTitle("Snake game");
    }

    public static void main(String[] args) throws IOException {

        new Application();

        Controller controller = new Controller(mainWindow);
        controller.setUp();

    }
}
