package pas.layout.label;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

/**
 *
 * @author Frank
 */
public class Title extends JLabel {

    // Color
    private Color color = new Color(0, 0, 88);
    // Font size
    private int fontSize = 20;

    public Title() {
        setForeground(this.color);
        setFont(new Font(getFont().getFontName(), Font.PLAIN, this.fontSize));
    }
}
