package cs3500.animation.view;

import cs3500.animation.view.Panels.VisualPanel;

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
   * Create a new shape with the given name and type
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
}
