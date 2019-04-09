package cs3500.animation.provider.view;

import cs3500.animation.provider.model.Animation;

/**
 * This interface represents all supported types of views.
 */
public interface View {

  /**
   * Displays the model through some visual form.
   */
  void displayView(Animation model);
}