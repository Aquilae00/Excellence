package cs3500.animation.provider.model.qualities.color;

import java.awt.Color;

import cs3500.animation.provider.model.qualities.Quality;

/**
 * Adapter class that adapts the Color class to the provider Texture class.
 */
public class ColorToTexture implements Texture {
  private Color c;

  /**
   * Constructor adaptor for Color to Texture. Takes in a Color that initialize this color.
   *
   * @param c color
   */
  public ColorToTexture(Color c) {
    this.c = c;
  }

  @Override
  public Color getAsJavaAwtColor() {
    return this.c;
  }

  @Override
  public double getRed() {
    return c.getRed();
  }

  @Override
  public double getGreen() {
    return c.getGreen();
  }

  @Override
  public double getBlue() {
    return c.getBlue();
  }

  @Override
  public double getAlpha() {
    return c.getAlpha();
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
    return this.c.getRed() + " " + this.c.getGreen() + " " + this.c.getBlue();
  }
}
