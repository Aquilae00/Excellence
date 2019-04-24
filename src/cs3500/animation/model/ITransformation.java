package cs3500.animation.model;

import java.awt.Color;

import cs3500.animation.model.dimension.Dimension2D;
import cs3500.animation.model.position.Position2D;

/**
 * The interface of Transformation, which represents a method contract relationship with the
 * Transformation class. All methods in the interface is available to be called by the
 * Transformation class that implements this interface.
 */
public interface ITransformation {
  /**
   * Get the name of shape of this Transformation.
   *
   * @return the name of shape
   */
  String getName();

  /**
   * Get the t1 of this Transformation.
   *
   * @return initial tick
   */
  int getT1();

  /**
   * Get the t2 of this Transformation.
   *
   * @return the final tick
   */
  int getT2();

  /**
   * Get the first position of this transform.
   *
   * @return initial position of transform
   */
  Position2D getPosition1();

  /**
   * Get the final position of this transform.
   *
   * @return final position of transform
   */
  Position2D getPosition2();

  /**
   * Get the initial dimension of transform.
   *
   * @return initial dimension
   */
  Dimension2D getDimn1();

  /**
   * Get the final dimension of transform.
   *
   * @return final dimension
   */
  Dimension2D getDimn2();

  /**
   * Get the initial color of transform.
   *
   * @return initial color
   */
  Color getColor1();

  /**
   * Get the final color of transform.
   *
   * @return final color
   */
  Color getColor2();
}
