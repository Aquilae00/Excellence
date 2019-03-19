package cs3500.animation.view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;


import javax.swing.JPanel;

import cs3500.animation.model.AnimationModel;
import cs3500.animation.model.Transformation;

/**
 * Class of Visual Panel. Extension class of JPanel will be used to represents shapes
 * colors and shapes forms.
 */
public class VisualPanel extends JPanel {
  private AnimationModel model;


  /**
   * Visual panel constructor that takes in model.
   * @param model AnimationModel class.
   */
  public VisualPanel(AnimationModel model) {
    super();
    this.model = model;
    this.setBackground(Color.WHITE);
  }

  protected void paintComponent(Graphics g) {
    Graphics2D g2d = (Graphics2D) g;
    super.paintComponent(g);

    for (String name : model.getShapes().keySet()) {
      for (Transformation t : model.getTransformations()) {
        g2d.setColor(new Color(t.getColor1().getRed(), t.getColor1().getGreen(),
                t.getColor1().getBlue()));
        if (model.getShapes().get(name).equals("ellipse")) {
          g2d.drawOval(t.getPosition1().getX(), t.getPosition1().getY(), t.getDimn1().getWidth(),
                  t.getDimn1().getHeight());
          g2d.fillOval(t.getPosition1().getX(), t.getPosition1().getY(), t.getDimn1().getWidth(),
                  t.getDimn1().getHeight());
        } else if (model.getShapes().get(name).equals("rectangle")) {
          g2d.drawRect(t.getPosition1().getX(), t.getPosition1().getY(), t.getDimn1().getWidth(),
                  t.getDimn1().getHeight());
          g2d.fillRect(t.getPosition1().getX(), t.getPosition1().getY(), t.getDimn1().getWidth(),
                  t.getDimn1().getHeight());
        }
      }
    }
  }
}
