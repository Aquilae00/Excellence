package cs3500.animation.model.position;

import java.util.Objects;

/**
 * It represents the class for the position of the shape.
 */
public final class Position2D {
  private int x;
  private int y;

  /**
   * Initialize this object to the specified position.
   *
   * @param x the x position of the shape
   * @param y the y position of the shape
   */
  public Position2D(int x, int y) {

    this.setX(x);
    this.setY(y);
  }

  /**
   * Copy constructor.
   *
   * @param v the given position
   */
  public Position2D(Position2D v) {
    this.setX(v.x);
    this.setY(v.y);
  }

  /**
   * Get the x coordinate of this position.
   */
  public int getX() {
    return x;
  }

  /**
   * Set the x coordinate of this object.
   */
  public void setX(int x) {
    this.x = x;
  }

  /**
   * Get the y coordinate of this position.
   */
  public int getY() {
    return y;
  }

  /**
   * Set the y coordiante of this object.
   */
  public void setY(int y) {
    this.y = y;
  }

  @Override
  public boolean equals(Object a) {
    if (this == a) {
      return true;
    }
    if (!(a instanceof Position2D)) {
      return false;
    }

    Position2D that = (Position2D) a;

    return ((Math.abs(this.x - that.x) < 0.01)
            && (Math.abs(this.y - that.y) < 0.01));
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.x, this.y);
  }
}
