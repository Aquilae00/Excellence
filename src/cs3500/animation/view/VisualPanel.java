package cs3500.animation.view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Timer;
import java.util.concurrent.TimeUnit;


import javax.swing.JPanel;

import cs3500.animation.model.AnimationModel;
import cs3500.animation.model.Transformation;
import cs3500.animation.model.Tweening;

/**
 * Class of Visual Panel. Extension class of JPanel will be used to represents shapes
 * colors and shapes forms.
 */
public class VisualPanel extends JPanel {
  private AnimationModel model;
  private int tick;
  private int speed;


  /**
   * Visual panel constructor that takes in model.
   * @param model AnimationModel class.
   */
  public VisualPanel(AnimationModel model) {
    super();
    this.model = model;
    Tweening tween = new Tweening();
    this.tick = 0;
    this.speed = 100;
    ArrayList<Transformation> alt = tween.apply(model.getTransformations());
    this.model.setTransormations(alt);
    this.setBackground(Color.WHITE);
  }



  protected void paintComponent(Graphics g) {
    Graphics2D g2d = (Graphics2D) g;
    super.paintComponent(g);

      for (Transformation t : this.model.getTransformations(this.tick)) {
        g2d.setColor(new Color(t.getColor1().getRed(), t.getColor1().getGreen(),
                t.getColor1().getBlue()));
        if (model.getShapes().get(t.getName()).equals("ellipse")) {
          g2d.drawOval(t.getPosition1().getX(), t.getPosition1().getY(), t.getDimn1().getWidth(),
                  t.getDimn1().getHeight());
          g2d.fillOval(t.getPosition1().getX(), t.getPosition1().getY(), t.getDimn1().getWidth(),
                  t.getDimn1().getHeight());
        } else if (model.getShapes().get(t.getName()).equals("rectangle")) {
          g2d.drawRect(t.getPosition1().getX(), t.getPosition1().getY(), t.getDimn1().getWidth(),
                  t.getDimn1().getHeight());
          g2d.fillRect(t.getPosition1().getX(), t.getPosition1().getY(), t.getDimn1().getWidth(),
                  t.getDimn1().getHeight());
      }
    }
    try {
      Thread.sleep(1000 / speed);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    tick++;
      repaint();
  }
}
