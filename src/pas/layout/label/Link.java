package pas.layout.label;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.util.Map;
import javax.swing.JLabel;

/**
 *
 * @author Frank
 */
public class Link extends javax.swing.JLabel {

    // Color
    private Color color = new Color(154, 13, 48);
    // Hover color
    private Color hoverColor;
    // Underline on hover
    private boolean behaveAsLink = true;
    // Cursor
    private int cursor = Cursor.HAND_CURSOR;

    public Link() {
        setCursor(new Cursor(this.cursor));
        setForeground(this.color);

        this.addMouseListener(new MouseAdapter() {
            private Font originalFont;

            @Override
            public void mouseEntered(MouseEvent event) {
                JLabel label = (JLabel) event.getComponent();
                this.originalFont = label.getFont();
                Map attributes = this.originalFont.getAttributes();

                if (behaveAsLink) {
                    attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
                }

                label.setFont(originalFont.deriveFont(attributes));

                if (null != hoverColor && !color.equals(hoverColor)) {
                    setForeground(hoverColor);
                }


            }

            @Override
            public void mouseExited(MouseEvent event) {
                event.getComponent()
                        .setFont(this.originalFont);

                if (null != hoverColor && !color.equals(hoverColor)) {
                    setForeground(color);
                }
            }
        });
    }
}
