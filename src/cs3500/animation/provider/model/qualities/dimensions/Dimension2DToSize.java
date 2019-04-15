package cs3500.animation.provider.model.qualities.dimensions;

import cs3500.animation.model.dimension.Dimension2D;
import cs3500.animation.provider.model.qualities.Quality;

public class Dimension2DToSize implements Size {
  Dimension2D d;

  public Dimension2DToSize(Dimension2D d) {
    this.d = d;
  }

  @Override
  public double getWidth() {
    return d.getWidth();
  }

  @Override
  public double getHeight() {
    return d.getHeight();
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
