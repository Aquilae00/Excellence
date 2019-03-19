package cs3500.animation.controller;

import cs3500.animation.view.IView;

/**
 * The class that is used to run the model and view.
 */
public class Controller {
  private IView view;

  /**
   * The constructor that takes in the view.
   *
   * @param v the given view
   */
  public Controller(IView v) {
    this.view = v;
  }

  /**
   * Make the controller launch the JPanel, making it visible.
   */
  public void goAnimate() {
    this.view.makeVisible();
  }

}
