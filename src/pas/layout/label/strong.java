package pas.layout.label;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

/**
 *
 * @author Frank
 */
public class strong extends JLabel {

    // Color
    private Color color = new Color(0, 0, 0);
    // Font size
    private int fontSize = 14;

    public strong() {
        setForeground(this.color);
        setFont(new Font(getFont().getFontName(), Font.BOLD, this.fontSize));
    }
}
