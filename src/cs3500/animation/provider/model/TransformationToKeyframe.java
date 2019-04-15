package cs3500.animation.provider.model;

import cs3500.animation.model.Transformation;
import cs3500.animator.model.qualities.color.Texture;
import cs3500.animator.model.qualities.dimensions.Size;
import cs3500.animator.model.qualities.positions.Position;

public class TransformationToKeyframe implements Keyframe {
  Transformation transformation;

  public TransformationToKeyframe(Transformation t) {
    this.transformation = t;
  }
  @Override
  public String toFile() {
    return null;
  }

  @Override
  public int getTick() {
    return transformation.getT1();
  }

  @Override
  public double getFirstX() {
    return transformation.getPosition1().getX();
  }

  @Override
  public double getFirstY() {
    return transformation.getPosition1().getY();
  }

  @Override
  public double getFirstWidth() {
    return transformation.getDimn1().getWidth();
  }

  @Override
  public double getFirstHeight() {
    return transformation.getDimn1().getHeight();
  }

  @Override
  public String getFirstColors() {
    return null;
  }

  @Override
  public Texture getTexture() {
    return null;
  }

  @Override
  public Size getSize() {
    return null;
  }

  @Override
  public Position getPosition() {
    return null;
  }
}
