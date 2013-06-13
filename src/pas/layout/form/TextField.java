package pas.layout.form;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;

/**
 *
 * @author Frank
 */
public class TextField extends JTextField implements FocusListener {

    /*
     * Default text options
     */
    private Color defaultTextColor = new Color(79, 79, 79);
    private int defaultFontStyle = Font.ITALIC;

    public TextField() {
    }

    public TextField(String defaultText) {
        this.defaultText = defaultText;
        this.originalFont = getFont();
        this.originalTextColor = getForeground();
        this.defaultTextFont = new Font(
                this.originalFont.getFontName(), 
                this.defaultFontStyle, 
                this.originalFont.getSize());
        
        this.focusLost(null);
        addFocusListener(this);
    }

    public String getDefaultText() {
        return defaultText;
    }

    @Override
    public void focusGained(FocusEvent event) {
        if (this.getText().isEmpty()) {
            super.setText("");
            setFont(this.originalFont);
            setForeground(this.originalTextColor);
        }
    }

    @Override
    public void focusLost(FocusEvent event) {
        if (this.getText().isEmpty()) {
            super.setText(this.getDefaultText());
            setFont(this.defaultTextFont);
            setForeground(this.defaultTextColor);
        }
    }

    @Override
    public String getText() {
        String text = super.getText();
        return text.equals(this.getDefaultText()) ? "" : text;
    }
    /*
     * Don't edit from here directly
     */
    private String defaultText;
    private Font defaultTextFont;
    private Color originalTextColor;
    private Font originalFont;
}
