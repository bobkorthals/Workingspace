package pas.layout.panel;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * Background panel
 * 
 * @author Frank
 */
public class Background extends javax.swing.JPanel {

    // Repeat options
    public static final int NO_REPEAT = 0;
    public static final int REPEAT = 1;
    public static final int REPEAT_HORIZONTAL = 2;
    public static final int REPEAT_VERTICAL = 3;
    
    // Position options
    public static final int CENTER = 0;
    public static final int LEFT = 1;
    public static final int RIGHT = 2;
    public static final int TOP = 3;
    public static final int BOTTOM = 4;
    
    // Background image
    private String src;
    private int mode = Background.NO_REPEAT;
    private int x;
    private int y;
    
    public Background() {
        initComponents();
    }
    
    /**
     * Creates new Background
     * 
     * @param String image source
     * @param int repeat mode
     */
    public Background(String src, int mode) {
        initComponents();
        this.src = src;
        this.mode = mode;
    }
    
    /**
     * Creates new Background, repeat mode
     * defaults to no repeat
     * 
     * @param String image sources 
     */
    public Background(String src) {
        this(src, Background.NO_REPEAT);
    }
    
    /*
     * Change the background image
     * 
     * @param String image source
     * @param int repeat mode
     * @return void
     */
    public void setBackground(String src, int mode) {
        this.src = src;
        this.mode = mode;
        revalidate();
        repaint();
    }
    
   /*
     * Change the background image
     * 
     * @param String image source
     * @return void
     */
    public void setBackground(String src) {
        this.setBackground(src, Background.NO_REPEAT);
    }
    
    /*
     * Draw an image as background repeating both horizontal
     * and vertical.
     * 
     * @param Graphics
     * @return void
     */
    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        if (null != this.src) {
            Image background = new ImageIcon(
                    getClass().getResource(this.src)).getImage();

            if (this.mode != Background.NO_REPEAT) {
                int imageWidth  = background.getWidth(this);
                int imageHeight = background.getHeight(this);

                if (imageWidth > 0 && imageHeight > 0) {

                    // Repeat vertical
                    if (this.mode == Background.REPEAT_HORIZONTAL) {
                        for (int x = 0; x < getWidth(); x += imageWidth) {
                            graphics.drawImage(background, x, this.getYPos(background), imageWidth, imageHeight, this);
                        }
                    }

                    // Repeat Horizontal
                    else if (this.mode == Background.REPEAT_VERTICAL) {
                        for (int y = 0; y < getHeight(); y += imageHeight) {
                            graphics.drawImage(background, this.getXPos(background), y, imageWidth, imageHeight, this);
                        }
                    }

                    // Repeat both horizontal and vertical
                    else if (this.mode == Background.REPEAT){
                        for (int x = 0; x < getWidth(); x += imageWidth) {
                            for (int y = 0; y < getHeight(); y += imageHeight) {
                                graphics.drawImage(background, x, y, imageWidth, imageHeight, this);
                            }
                        }
                    }
                }
            }

            else {
                // Single image left top
                graphics.drawImage(background, this.getXPos(background), this.getYPos(background), this);
            }
        }
    }
    
    /*
     * Calculate the background x position
     * 
     * @param Image background
     * @return int x pos
     */
    private int getXPos(Image background) {
        int pos;
        
        switch (this.x) {
            case Background.RIGHT:
                pos = this.getWidth() - background.getWidth(this);
                break;
            case Background.LEFT:
                pos = 0;
                break;
            case Background.CENTER:
            default:
                pos = (this.getWidth() - background.getWidth(this)) / 2;
                break;
        }
        
        return pos;
    }
    
    /*
     * Calculate the background y position
     * 
     * @param Image background
     * @return int y pos
     */
    private int getYPos(Image background) {
        int pos;
        
        switch (this.y) {
            case Background.BOTTOM:
                pos = this.getHeight() - background.getHeight(this);
                break;
            case Background.TOP:
                pos = 0;
                break;
            case Background.CENTER:
            default:
                pos = (this.getHeight() - background.getHeight(this)) / 2;
                break;
        }
        
        return pos;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 794, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 571, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
