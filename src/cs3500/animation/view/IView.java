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

  /*
  TODO:
  1. DO I need this interface right here ?
  2. Shaking image
  3. the use of read only model
  4. Having timer control from Interface of EVV
  5. Invalid delay
  6. How to adapt the button to panel
   */
}
