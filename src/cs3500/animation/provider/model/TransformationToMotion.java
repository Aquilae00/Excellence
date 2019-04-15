package cs3500.animation.provider.model;

import java.awt.*;

import cs3500.animation.model.Transformation;
import cs3500.animation.provider.model.qualities.color.ColorToTexture;
import cs3500.animation.provider.model.qualities.color.Texture;

public class TransformationToMotion implements Motion {
  Keyframe keyframe1;
  Keyframe keyframe2;

  /**
   * Transformation to motion adapter. Takes in a transformation for composition.
   * @param
   */
  public TransformationToMotion(Keyframe k1,Keyframe k2) {
    this.keyframe1 = k1;
    this.keyframe2 = k2;
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
    Transformation t = new Transformation("hold",keyframe1.getTick(),x,y,(int)w,(int)h,(int)r,(int)g,(int)b);
    keyframe1 = new TransformationToKeyframe(t,new ColorToTexture(new Color((int)r,(int)g,(int)b)));
  }

  @Override
  public void setEndFrame(double x, double y, double w, double h, double r, double g, double b) {
    Transformation t = new Transformation("hold",keyframe1.getTick(),x,y,(int)w,(int)h,(int)r,(int)g,(int)b);
    keyframe2 = new TransformationToKeyframe(t,new ColorToTexture(new Color((int)r,(int)g,(int)b)));
  }

  @Override
  public void setEndFrame(Keyframe keyframe) {
    this.keyframe2 = keyframe;
  }
}
