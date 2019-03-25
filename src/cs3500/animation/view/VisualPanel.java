package cs3500.animation.view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


import javax.swing.*;

import cs3500.animation.model.AnimationModel;
import cs3500.animation.model.ImmAnimationModel;
import cs3500.animation.model.Transformation;
import cs3500.animation.model.Tweening;

/**
 * Class of Visual Panel. Extension class of JPanel will be used to represents shapes
 * colors and shapes forms.
 */
public class VisualPanel extends JPanel implements ActionListener {
  private ImmAnimationModel model;
  private int tick;
  private int speed;
  private Timer timer;
  private ArrayList<Transformation> transformations;


  /**
   * Visual panel constructor that takes in model.
   * @param model AnimationModel class.
   */
  public VisualPanel(ImmAnimationModel model,int speed) {
    super();
    this.model = model;
    Tweening tween = new Tweening();
    this.timer = new Timer(1000/speed, this);
    this.tick = 0;
    this.speed = speed;
    transformations = tween.apply(model.getTransformations());
    this.setBackground(Color.WHITE);
  }



  protected void paintComponent(Graphics g) {
    Graphics2D g2d = (Graphics2D) g;
    super.paintComponent(g);
      for (Transformation t : transformations) {
        if (t.getT1() == tick && t.getT2() == tick) {
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
      }
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    tick++;
    repaint();
  }

  public void startTimer() {
    this.timer.start();
  }

  public void stopTimer(){
    this.timer.stop();
  }

  public void restartTimer() {
    tick = 0;
    this.timer.restart();

  }

  public boolean isTimerRunning() {
    return this.timer.isRunning();
  }

  public int getTick() {
    return this.tick;
  }

}
