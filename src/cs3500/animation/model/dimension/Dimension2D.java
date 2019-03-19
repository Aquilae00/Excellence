package cs3500.animation.model.dimension;


/**
 * It is the dimension of shape.
 */
public class Dimension2D {


  int width;
  int height;

  /**
   * It sets the dimension width and height.
   *
   * @param x the width
   * @param y the height
   */

  public Dimension2D(int x, int y) {
    if (x < 0 || y < 0) {
      throw new IllegalArgumentException("Dimension can't be negative");
    }
    this.setWidth(x);
    this.setHeight(y);
  }

  /**
   * It sets the constructor based on v.
   *
   * @param v the given dimension
   */
  public Dimension2D(Dimension2D v) {
    this.setWidth(v.width);
    this.setHeight(v.height);
  }

  /**
   * Gets the width of the shape.
   */
  public int getWidth() {
    return width;
  }

  /**
   * Sets the width of this object.
   */
  public void setWidth(int x) {
    this.width = x;
  }

  /**
   * Get the height of the shape.
   */
  public int getHeight() {
    return height;
  }

  /**
   * Sets the height of this object.
   */
  public void setHeight(int y) {
    this.height = y;
  }
}
