package cs3500.animation.model;

import java.util.ArrayList;
import java.util.Map;

import cs3500.animation.model.dimension.Dimension2D;
import cs3500.animation.model.position.Position2D;

/**
 * This interface represents the operations offered by an AnimationModel. Provides the classes that
 * implements this interface with methods that gets the target value. Serves as a bridge that
 * communicates between the caller and the model. One object of the model represents one animation
 * model.
 */
public interface AnimationModel {

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
   * @return ArrayList of Transformations
   */

  ArrayList<Transformation> getTransformations();

  ArrayList<Transformation> getTransformations(int tick);

  void setTransormations(ArrayList<Transformation> transormations);
}
