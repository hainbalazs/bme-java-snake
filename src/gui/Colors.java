package gui;
import java.awt.*;

/**
 * The Colors class provides a collection of color constants and methods for manipulating colors.
 */
public class Colors {
    public static final Color red = new Color(220, 80, 80);
    public static final Color red_deep = new Color(175, 50, 50);

    public static final Color green = new Color(80, 170, 137);
    public static final Color green_deep = new Color(45, 100, 80);

    public static final Color blue = new Color(64, 118, 190);
    public static final Color blue_deep = new Color(34, 70, 112);

    public static final Color yellow = new Color(245, 230, 100);
    public static final Color yellow_deep = new Color(215, 195, 10);

    public static final Color grey = new Color(52, 52, 52);
    public static final Color grey_deep = new Color(47, 47, 47);

    public static final Color whiteish = new Color(228, 228, 228);

    public static Color getDarker(Color c){
        if(c.equals(red))
                return red_deep;
        else if(c.equals(blue))
            return blue_deep;
        else if(c.equals(green))
            return green_deep;
        else if(c.equals(yellow))
            return yellow_deep;
        else if(c.equals(grey))
            return grey_deep;
        else
            return whiteish;

    }
}
