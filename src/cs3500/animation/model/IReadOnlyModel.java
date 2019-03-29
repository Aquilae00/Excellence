package cs3500.animation.model;

import java.util.ArrayList;
import java.util.Map;

import cs3500.animation.model.dimension.Dimension2D;
import cs3500.animation.model.position.Position2D;

/**
 * The interface for the read only model.
 */
public interface IReadOnlyModel {
  /**
   * Return a string that represents the current log of animation. Lists out the history of
   * movements for each shape.
   *
   * @return the description of animation
   */
  String getAnimationState();

  /**
   * Get the Position2D of left most x and Top most y.
   *
   * @return the Position2D of left most x and Top most y
   */
  Position2D getLeftTopMostPosn();

  /**
   * Get the Dimension of the bounding box.
   *
   * @return the Dimension2D of the bounding box.
   */
  Dimension2D getBoundingDimension();

  /**
   * Get the Map of shapes, with the name of shape being the key and type the value.
   *
   * @return the HashMap of shapes.
   */
  Map<String, String> getShapes();

  /**
   * Get the list of Transformations.
   *
   * @return ArrayList of Transformations
   */
  ArrayList<Transformation> getTransformations();
}
