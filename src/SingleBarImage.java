/* Name:       Gursimran Dhaliwal
 * Email:      gdhal233@mtroyal.ca
*  Course:     COMP 2631
*  Instructor: Jason Heard
*/
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

class SingleBarImage extends JPanel {
    static final Color BLACK = new Color (0, 0, 0);
    int xloc = 0;
    int yloc = 0;
    int width = 0;
    int height = 0;
    Color color = null;


    public SingleBarImage(int xloc, int yloc, int width, int height, Color color) {
        this.xloc = xloc;
        this.yloc = yloc;
        this.width = width;
        this.height = (int) (Main.MAX_BAR_HEIGHT * height / Main.MAX_VALUE_IN_ARRAY);
        this.color = color;
    }



    @Override
    public void paint(Graphics graphics) {
        graphics.setColor(color);
        graphics.fillRect (this.xloc, this.yloc, this.width, this.height);

        if (color == Main.PALE_BLUE) {
            graphics.drawRect (this.xloc, this.yloc, this.width, this.height);
        } else {
            graphics.setColor(BLACK);
            graphics.drawRect (this.xloc, this.yloc, this.width, this.height);
        }
    }
}
