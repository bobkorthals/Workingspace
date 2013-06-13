package pas.layout.form;

/**
 *
 * @author Frank
 */
public final class ComboListItem {

    private String text;
    private Object value;
    
    public ComboListItem(String text) {
        setText(text);
    }
    
    public ComboListItem(String text, int value) {
        this.setText(text);
        this.setValue(value);
    }
    
    public ComboListItem(String text, String value) {
        this.setText(text);
        this.setValue(value);
    }
    
    public ComboListItem(String text, Object value) {
        this.setText(text);
        this.setValue(value);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    public void setValue(int value) {
        this.value = value;
    }
    
    public void setValue(String value) {
        this.value = value;
    }
    
    public void setValue(Object value) {
        this.value = value;
    }
    
    public int getIntegerValue() {
        return (Integer) this.value;
    }
    
    public String getStringValue() {
        return (String) this.value;
    }
    
    public Object getValue() {
        return this.value;
    }
    
    public boolean hasValue() {
        return null != this.value;
    }

    @Override
    public String toString() {
        return this.text;
    }
}
