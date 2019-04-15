package cs3500.animation.provider.model.qualities.positions;

import cs3500.animation.model.position.Position2D;
import cs3500.animation.provider.model.qualities.Quality;

public class Position2DToPosition implements Position {
  Position2D pos;

  /**
   * Adapter constructor for Position2D to Position interface. Takes in Position2D.
   * @param pos position2D instance
   */
  public Position2DToPosition(Position2D pos) {
    this.pos = pos;
  }

  @Override
  public double getX() {
    return pos.getX();
  }

  @Override
  public double getY() {
    return pos.getY();
  }

  @Override
  public double getZ() {
    return 0;
  }

  @Override
  public Quality addTogether(Quality quality) {
    return null;
  }

  @Override
  public String getQualities() {
    return null;
  }

  @Override
  public Quality getDifference(Quality other) {
    return null;
  }

  @Override
  public Quality divideBy(int duration) {
    return null;
  }

  @Override
  public Quality multiplyBy(int currentTick) {
    return null;
  }

  @Override
  public String toFile() {
    return null;
  }
}
