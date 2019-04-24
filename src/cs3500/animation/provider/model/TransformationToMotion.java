package cs3500.animation.provider.model;

import cs3500.animation.model.Transformation;

/**
 * An adapter class that adapts Transformation class to Motion Interface. This class uses two
 * keyframes, which have been initialized by passing in Transformation. Using the Keyframe interface
 * from the provider to call the methods provided in the interface.
 */
public class TransformationToMotion implements Motion {
  private Keyframe keyframe1;
  private Keyframe keyframe2;

  /**
   * Transformation to motion adapter. Takes in two Keyframe, which act as start point keyframe and
   * end point keyframe.
   *
   * @param k1 start point KeyFrame
   * @param k2 end point KeyFrame
   */
  public TransformationToMotion(Keyframe k1, Keyframe k2) {
    this.keyframe1 = k1;
    this.keyframe2 = k2;
  }

  @Override
  public String toFile() {
    return keyframe1.toFile() + " " + keyframe2.toFile();
  }

  @Override
  public Shape getParent() {
    return null;
  }

  @Override
  public Keyframe getStartFrame() {
    return keyframe1;
  }

  @Override
  public Keyframe getEndFrame() {
    return keyframe2;
  }

  @Override
  public double getFirstX() {
    return keyframe1.getFirstX();
  }

  @Override
  public double getFirstY() {
    return keyframe1.getFirstY();
  }

  @Override
  public double getFirstWidth() {
    return keyframe1.getFirstWidth();
  }

  @Override
  public double getFirstHeight() {
    return keyframe1.getFirstHeight();
  }

  @Override
  public String getFirstColors() {
    return keyframe1.getFirstColors();
  }

  @Override
  public int getFirstTick() {
    return keyframe1.getTick();
  }

  @Override
  public void setStartFrame(Keyframe keyframe) {
    this.keyframe1 = keyframe;
  }

  @Override
  public void setStartFrame(double x, double y, double w, double h, double r, double g, double b) {
    Transformation t = new Transformation("hold", keyframe1.getTick(), x, y,
            (int) w, (int) h, (int) r, (int) g, (int) b);
    keyframe1 = new TransformationToKeyframe(t);
  }

  @Override
  public void setEndFrame(double x, double y, double w, double h, double r, double g, double b) {
    Transformation t = new Transformation("hold", keyframe2.getTick(), x, y, (int) w,
            (int) h, (int) r, (int) g, (int) b);
    keyframe2 = new TransformationToKeyframe(t);
  }

  @Override
  public void setEndFrame(Keyframe keyframe) {
    this.keyframe2 = keyframe;
  }
}
