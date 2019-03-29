package cs3500.animation.view;

import cs3500.animation.view.panels.MenuPanel;
import cs3500.animation.view.panels.VisualPanel;

/**
 * The view that is used to control the animation.
 */
public interface EnhancedIView extends IView {

  /**
   * It starts the timer.
   */
  void startTimer();

  /**
   * It stops the timer.
   */
  void stopTimer();

  /**
   * It restarts the timer.
   */
  void restartTimer();

  /**
   * It deletes the shape from arraylist and all transformation relevant to it.
   */
  void deleteShape(String name);

  /**
   * Creates a new shape with the given name and type.
   */
  void createShape(String name, String type);

  /**
   * It returns the visual panel of the view.
   *
   * @return visual panel
   */
  VisualPanel getVisualPanel();

  /**
   * It increases the speed of animation.
   */
  void increaseSpeed();

  /**
   * It decreases the speed of animation.
   */
  void decreaseSpeed();

  /**
   * It toggles the loop.
   */
  void toggleLoop();

  /**
   * It shows the current speed in the user interface.
   */
  void setLabelSpeed();

  /**
   * It gives the command for the shape.
   *
   * @return the command
   */
  String getCreateShapeCommand();


  /**
   * It handles with deleting the shape after it looks for the name of the shape.
   *
   * @return the command for delete shape
   */

  String getDeleteShapeCommand();

  /**
   * It gives the coomand for the transformation.
   *
   * @return command to create transformation.
   */
  String getTransformationCommand();

  /**
   * It inserts the transformation at the visual panel.
   */
  void insertTransformation();

  /**
   * It removes the transformation at the visual panel.
   */

  void removeTransformation();

  /**
   * It clears up the transformation field to make it clean.
   */
  void clearMenuTrans();

  /**
   * It retweens the panel.
   */
  void retweenPanel();

  /**
   * Ge the Menu Panel of class that implements EnchancedIView interface.
   *
   * @return the MenuPanel class
   */
  MenuPanel getMenuPanel();
}
