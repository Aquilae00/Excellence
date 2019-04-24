package cs3500.animation.provider.model;


import cs3500.animation.model.Transformation;
import cs3500.animation.provider.model.qualities.color.ColorToTexture;
import cs3500.animation.provider.model.qualities.color.Texture;
import cs3500.animation.provider.model.qualities.dimensions.Size;
import cs3500.animation.provider.model.qualities.positions.Position;

/**
 * Adapter class that adapts Transformation to the provider Keyframe interface. To make a class
 * implementation of Keyframe using our Transformation class that has been written.
 */
public class TransformationToKeyframe implements Keyframe {
  private Transformation transformation;
  private Texture t;

  /**
   * Constructor for TransformationToKeyframe adapter that takes in Transformation and Texture.
   *
   * @param t a Transformation instance
   */
  public TransformationToKeyframe(Transformation t) {
    this.transformation = t;
    this.t = new ColorToTexture(t.getColor1());
  }

  @Override
  public String toFile() {
    StringBuilder s = new StringBuilder();
    s.append(
            transformation.getName() + " " + transformation.getT1() + " " +
                    transformation.getPosition1().getX() + " "
                    + transformation.getPosition1().getY() + " "
                    + transformation.getDimn1().getWidth() + " " +
                    transformation.getDimn1().getHeight()
                    + " "
                    + transformation.getColor1().getRed() + " " +
                    transformation.getColor1().getGreen()
                    + " "
                    + transformation.getColor1().getBlue()
                    + "    "
                    + transformation.getT2() + " " + transformation.getPosition2().getX()
                    + " " + transformation.getPosition2().getY() + " " +
                    +transformation.getDimn2().getWidth() + " " +
                    transformation.getDimn2().getHeight()
                    + " "
                    + transformation.getColor2().getRed() + " " +
                    transformation.getColor2().getGreen()
                    + " "
                    + transformation.getColor2().getBlue() +
                    "\n");
    return s.toString();
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
    return this.t;
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
