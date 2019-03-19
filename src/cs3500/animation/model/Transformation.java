package cs3500.animation.model;

import java.awt.Color;

import cs3500.animation.model.dimension.Dimension2D;
import cs3500.animation.model.position.Position2D;

/**
 * Transformation class represents the small descriptions needed in animation.
 */
public class Transformation {
  private String name;
  private int t1;
  private Position2D posn1;
  private Dimension2D dimn1;
  private Color color1;
  private int t2;
  private Position2D posn2;
  private Dimension2D dimn2;
  private Color color2;

  /**
   * The constroctor that has same initial and final stats.
   *
   * @param name the name of the shape
   * @param t1   the tick 3
   * @param x1   initial x posiiton
   * @param y1   initial y position
   * @param w1   initial width
   * @param h1   initial height
   * @param r1   initial red color
   * @param g1   initial green color
   * @param b1   initial blue color
   */
  public Transformation(String name, int t1, int x1, int y1,
                        int w1, int h1, int r1, int g1, int b1) {
    this.name = name;
    this.t1 = t1;
    this.posn1 = new Position2D(x1, y1);
    this.dimn1 = new Dimension2D(w1, h1);
    this.color1 = new Color(r1, g1, b1);
    this.t2 = t1;
    this.posn2 = new Position2D(x1, y1);
    this.dimn2 = new Dimension2D(w1, h1);
    this.color2 = new Color(r1, g1, b1);
  }

  /**
   * The constructor that has different initial and final stats.
   *
   * @param name the name of the shape
   * @param t1   the initial tick of the shape
   * @param x1   the initial x position
   * @param y1   the initial y position
   * @param w1   the initial width
   * @param h1   the initial height
   * @param r1   initial red
   * @param g1   initial green
   * @param b1   initial blue
   * @param t2   final tick
   * @param x2   final x position
   * @param y2   final y position
   * @param w2   final width
   * @param h2   final height
   * @param r2   final red color
   * @param g2   final green color
   * @param b2   final blue color
   */
  Transformation(String name, int t1, int x1, int y1, int w1, int h1, int r1, int g1, int b1,
                 int t2,
                 int x2, int y2, int w2, int h2, int r2, int g2, int b2) {
    this.name = name;
    this.t1 = t1;
    this.posn1 = new Position2D(x1, y1);
    this.dimn1 = new Dimension2D(w1, h1);
    this.color1 = new Color(r1, g1, b1);
    this.t2 = t2;
    this.posn2 = new Position2D(x2, y2);
    this.dimn2 = new Dimension2D(w2, h2);
    this.color2 = new Color(r2, g2, b2);
  }

  /**
   * Get the name of shape of this Transformation.
   *
   * @return the name of shape
   */
  public String getName() {
    return this.name;
  }

  /**
   * Get the t1 of this Transformation.
   *
   * @return initial tick
   */
  public int getT1() {
    return this.t1;
  }

  /**
   * Get the t2 of this Transformation.
   *
   * @return the final tick
   */
  public int getT2() {
    return this.t2;
  }

  /**
   * Get the first position of this transform.
   *
   * @return initial position of transform
   */
  public Position2D getPosition1() {
    return this.posn1;
  }

  /**
   * Get the final position of this transform.
   *
   * @return final position of transform
   */
  public Position2D getPosition2() {
    return this.posn2;
  }

  /**
   * Get the initial dimension of transform.
   *
   * @return initial dimension
   */
  public Dimension2D getDimn1() {
    return this.dimn1;
  }

  /**
   * Get the final dimension of transform.
   *
   * @return final dimension
   */
  public Dimension2D getDimn2() {
    return this.dimn2;
  }

  /**
   * Get the initial color of transform.
   *
   * @return initial color
   */
  public Color getColor1() {
    return this.color1;
  }

  /**
   * Get the final color of transform.
   *
   * @return final color
   */
  public Color getColor2() {
    return this.color2;
  }
}
