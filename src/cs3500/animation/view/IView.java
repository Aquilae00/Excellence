package cs3500.animation.view;

import cs3500.animation.model.AnimationModel;

/**
 * This interface represents the operations offered by an IView. Provides the classes that
 * implements this interface with methods that gets the target value and setting visibility. Serves
 * as a bridge that communicates between the caller and the classes that implements this interface.
 * One object of the model represents one animation model.
 */
public interface IView {
  /**
   * Make the view visible. This is usually called after the view is constructed
   */
  void makeVisible();

  /**
   * It gets the animation model of the view.
   *
   * @return the animation model of the view
   */
  AnimationModel getViewModel();

}
