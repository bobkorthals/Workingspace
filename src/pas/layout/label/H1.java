package pas.layout.label;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

/**
 *
 * @author Frank
 */
public class H1 extends JLabel {

    // Color
    private Color color = new Color(0, 0, 88);
    // Font size
    private int fontSize = 20;

    public H1() {
        setForeground(this.color);
        setFont(new Font(getFont().getFontName(), Font.PLAIN, this.fontSize));
    }
}
