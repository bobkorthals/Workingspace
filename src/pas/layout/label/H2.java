package pas.layout.label;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

/**
 *
 * @author Frank
 */
public class H2 extends JLabel {

    // Color
    private Color color = new Color(0, 0, 0);
    // Font size
    private int fontSize = 16;

    public H2() {
        setForeground(this.color);
        setFont(new Font(getFont().getFontName(), Font.PLAIN, this.fontSize));
    }
}
