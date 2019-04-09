package cs3500.animation.model;

import java.util.ArrayList;

/**
 * This interface represents the operations offered by an AnimationModel. Provides the classes that
 * implements this interface with methods that gets the target value. Serves as a bridge that
 * communicates between the caller and the model. One object of the model represents one animation
 * model.
 */
public interface AnimationModel extends IReadOnlyModel {

  /**
   * It assigns the list of transformation and give it to the animation model.
   *
   * @param transformations list of transformation given
   */
  void setTransformations(ArrayList<Transformation> transformations);

  /**
   * It saves the given type to the name storage.
   *
   * @param name the keyword string that can store value.
   * @param type the value that needs to be stored.
   */
  void addShape(String name, String type);

  /**
   * It removes the transformation based on the given component.
   *
   * @param name the name of shape
   * @param t1   the tick
   */
  void deleteTransformation(String name, int t1);

  /**
   * It creates the transformation with the given component and add it to list of transformation.
   *
   * @param name the name of shape
   * @param t1   initial tick
   * @param x1   initial x position
   * @param y1   initial y position
   * @param w1   initial width
   * @param h1   initial height
   * @param r1   initial red color
   * @param g1   initial green color
   * @param b1   initial blue color
   */
  void insertTransformation(String name, int t1, double x1, double y1,
                            int w1, int h1, int r1, int g1, int b1);
}
