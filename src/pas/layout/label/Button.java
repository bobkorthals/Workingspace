package pas.layout.label;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.font.TextAttribute;
import java.util.Map;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author Frank
 */
public class Button extends JLabel implements MouseListener {

    public static int INACTIVE = 1;
    public static int ACTIVE = 2;
    /*
     * Button state
     */
    private int status = Button.INACTIVE;
    private boolean behaveAsLink = true;
    /*
     * Button style
     */
    private int fontSize = 12;
    private int width = 120;
    private int height = 35;
    private Color color = new Color(255, 255, 255);
    private Color backgroundColor = new Color(154, 13, 48);
    private int cursor = Cursor.HAND_CURSOR;
    /*
     * Hover style
     */
    private Color hoverColor = null;
    private Color hoverBackgroundColor = null;
    /*
     * Active style
     */
    private Color activeColor = null;
    private Color activeBackgroundColor = new Color(79, 79, 79);

    public Button() {
        setCursor(new Cursor(this.cursor));
        setForeground(this.color);
        setFont(new Font(getFont().getFontName(), Font.PLAIN, this.fontSize));
        setHorizontalAlignment(SwingConstants.CENTER);
        setBackground(this.backgroundColor);
        setPreferredSize(new Dimension(this.width, this.height));
        setOpaque(true);
        addMouseListener(this);
    }

    /*
     * Toggle status
     * 
     * @return void
     */
    public void toggleStatus() {
        switch (this.status) {
            case 1:
                this.setStatus(Button.ACTIVE);
                break;
            case 2:
                this.setStatus(Button.INACTIVE);
                break;
        }
    }

    /*
     * Activate or deactivate the button
     * 
     * @param int status
     * @return void
     */
    public void setStatus(int status) {
        switch (status) {
            case 1:
                this.status = Button.INACTIVE;
                this.setInactive();
                break;
            case 2:
                this.status = Button.ACTIVE;
                this.setActive();
                break;
        }
    }

    @Override
    public void mouseClicked(MouseEvent event) {
        switch (status) {
            case 1:
                setStatus(Button.ACTIVE);
                break;
            case 2:
                setStatus(Button.INACTIVE);
                break;
        }
    }

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

        if (null != hoverBackgroundColor && !color.equals(hoverBackgroundColor)) {
            setBackground(hoverBackgroundColor);
        }
    }

    @Override
    public void mouseExited(MouseEvent event) {
        event.getComponent()
                .setFont(this.originalFont);

        if (status == Button.INACTIVE) {
            setInactive();
        } else {
            if (null != activeColor && !color.equals(activeColor)) {
                setForeground(activeColor);
            } else {
                setForeground(color);
            }

            if (null != activeBackgroundColor && !backgroundColor.equals(activeBackgroundColor)) {
                setBackground(activeBackgroundColor);
            } else {
                setBackground(backgroundColor);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    /*
     * Activate button
     * 
     * @return void
     */
    private void setActive() {
        if (null != activeColor && !color.equals(activeColor)) {
            setForeground(activeColor);
        }

        if (null != activeBackgroundColor && !backgroundColor.equals(activeBackgroundColor)) {
            setBackground(activeBackgroundColor);
        }
    }

    /*
     * Deactivate button (back to default state)
     * 
     * @return void
     */
    private void setInactive() {
        setForeground(color);
        setBackground(backgroundColor);
    }
    /*
     * Don't edit from here directly
     */
    private Font originalFont;
}
