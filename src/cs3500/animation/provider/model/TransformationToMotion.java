package cs3500.animation.provider.model;

import cs3500.animation.model.Transformation;

public class TransformationToMotion implements Motion {
  Transformation transformation;

  /**
   * Transformation to motion adapter. Takes in a transformation for composition.
   * @param t
   */
  public TransformationToMotion(Transformation t) {
    this.transformation = t;
  }

  @Override
  public Shape getParent() {
    return null;
  }

  @Override
  public Keyframe getStartFrame() {
    return null;
  }

  @Override
  public Keyframe getEndFrame() {
    return null;
  }

  @Override
  public double getFirstX() {
    return 0;
  }

  @Override
  public double getFirstY() {
    return 0;
  }

  @Override
  public double getFirstWidth() {
    return 0;
  }

  @Override
  public double getFirstHeight() {
    return 0;
  }

  @Override
  public String getFirstColors() {
    return null;
  }

  @Override
  public int getFirstTick() {
    return 0;
  }

  @Override
  public void setStartFrame(Keyframe keyframe) {

  }

  @Override
  public void setStartFrame(double x, double y, double w, double h, double r, double g, double b) {

  }

  @Override
  public void setEndFrame(double x, double y, double w, double h, double r, double g, double b) {

  }

  @Override
  public void setEndFrame(Keyframe keyframe) {

  }
}
