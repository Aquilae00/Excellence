package cs3500.animation.view.panels;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.Timer;
import javax.swing.JPanel;
import javax.swing.JButton;


import cs3500.animation.model.IReadOnlyModel;
import cs3500.animation.model.Transformation;
import cs3500.animation.model.Tweening;

/**
 * Class of Visual Panel. Extension class of JPanel will be used to represents shapes colors and
 * shapes forms.
 */
public class VisualPanel extends JPanel implements ActionListener {
  private IReadOnlyModel model;
  private int tick;
  private int speed;
  private boolean loop;
  private Timer timer;
  private ArrayList<Transformation> transformations;
  private Tweening tween;

  /**
   * Visual panel constructor that takes in model.
   *
   * @param model AnimationModel class.
   */
  public VisualPanel(IReadOnlyModel model, int speed) {
    super();
    this.model = model;
    this.tween = new Tweening();
    this.speed = speed;
    this.timer = new Timer(1000 / this.speed, this);
    this.tick = 0;
    this.loop = true;
    transformations = tween.apply(model.getTransformations());
    this.setBackground(Color.WHITE);
  }

  /**
   * It draws the interface based on the given graphics.
   *
   * @param g the graphic used to design interface
   */
  protected void paintComponent(Graphics g) {
    Graphics2D g2d = (Graphics2D) g;
    super.paintComponent(g);
    for (Transformation t : transformations) {
      if (t.getT1() == tick) {
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

    if (loop) {
      if (tick > transformations.size() / 2) {
        tick = 0;
      }
    }
    repaint();
  }

  /**
   * It starts the timer of the animation.
   */
  public void startTimer() {
    this.timer.start();
  }

  /**
   * It stops the timer of the animation.
   */
  public void stopTimer() {
    this.timer.stop();
  }

  /**
   * It restarts the timer of the animation.
   */
  public void restartTimer() {
    tick = 0;
    this.timer.restart();
  }

  /**
   * It gets the current tick of the animation.
   *
   * @return current tick
   */
  public int getTick() {
    return this.tick;
  }

  /**
   * It increments the speed by 1.
   */
  public void increaseSpeed() {
    this.speed++;
    timer.setDelay(1000 / speed);
  }

  /**
   * It decreases the speed by 1.
   */
  public void decreaseSpeed() {
    if (speed < 1) {
      throw new IllegalArgumentException("Speed can't get below 0");
    }
    this.speed--;
    timer.setDelay(1000 / speed);
  }

  /**
   * It toggles the loop.
   */
  public void toggleLoop() {
    if (this.loop) {
      this.loop = false;
    } else {
      this.loop = true;
    }
  }

  /**
   * It gets the current loop.
   *
   * @return current loop
   */
  public boolean getLoop() {
    return this.loop;
  }

  /**
   * It makes the copy of trnasformation with given component and inserts the transformation into
   * the list of transformation.
   *
   * @param name the name of shape
   * @param t1   initial tick
   * @param x1   initial x position
   * @param y1   initial y position
   * @param w1   initial width
   * @param h1   initial height
   * @param r1   initial red color
   * @param g1   initial green color
   * @param b1   initial blue color
   */
  public void insertTransformation(String name, int t1, double x1, double y1,
                                   int w1, int h1, int r1, int g1, int b1) {
    if (model.getShapes().containsKey(name)) {
      Transformation temp = new Transformation(name, t1, x1, y1, w1, h1, r1, g1, b1);
      this.transformations.add(temp);
    }
  }

  /**
   * Get the speed of this panel.
   *
   * @return speed
   */
  public int getSpeed() {
    return this.speed;
  }

  /**
   * It removes the transformation of the given field.
   *
   * @param name name of shape
   * @param t1   initial tick
   * @param x1   initial x
   * @param y1   initial y
   * @param w1   initial width
   * @param h1   initial height
   * @param r1   initial red color
   * @param g1   initial green color
   * @param b1   initial blue color
   */
  public void removeTransformation(String name, int t1, double x1, double y1,
                                   int w1, int h1, int r1, int g1, int b1) {
    Iterator<Transformation> iter = transformations.iterator();
    while (iter.hasNext()) {
      Transformation t = iter.next();
      if (t.getName().equals(name) && t.getT1() == t1 && t.getPosition1().getX() == x1
              && t.getPosition1().getY() == y1 && t.getDimn1().getWidth() == w1
              && t.getDimn1().getHeight() == h1 && t.getColor1().getRed() == r1
              && t.getColor1().getGreen() == g1 && t.getColor1().getBlue() == b1) {
        iter.remove();
      }
    }
    transformations = tween.apply(model.getTransformations());
  }

  // usually better off with mousePressed rather than clicked

  /**
   * It handles the event when the mouse is pressed.
   *
   * @param e the action that is going to be performed
   * @return the name of the panel
   */
  public String mousePressed(ActionEvent e) {
    JButton btnPanel = (JButton) e.getSource();
    return btnPanel.getName();
  }

  /**
   * It deletes the shape with the given name.
   *
   * @param name name of the shape
   */
  public void deleteShape(String name) {
    Iterator<Transformation> iter = transformations.iterator();
    while (iter.hasNext()) {
      Transformation t = iter.next();
      if (t.getName().equals(name)) {
        iter.remove();
      }
    }
    model.getShapes().remove(name);
  }

  /**
   * It tweens the value in between.
   */
  public void retween() {
    this.transformations = tween.apply(model.getTransformations());
  }

  /**
   * Check if the timer is running.
   *
   * @return true of false
   */
  public boolean isTimerRunning() {
    return this.timer.isRunning();
  }

}
