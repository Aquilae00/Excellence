package cs3500.animation.controller;

import cs3500.animation.provider.model.Animation;
import cs3500.animation.provider.model.AnimationModelToProvider;
import cs3500.animation.provider.view.EditorView;

/**
 * The controller that works with the provider Animation and EditorView.
 */
public class ProviderController implements EnhancedIController {
  EditorView ev;
  Animation model;

  /**
   * The constructor takes in the provider class, EditorView and AnimationModelProvider class
   * adapter for Animation interface.
   *
   * @param ev EditorView class from provider
   * @param ap AnimationModelToProvider adapter class
   */
  public ProviderController(EditorView ev, AnimationModelToProvider ap) {
    this.ev = ev;
    this.model = ap;
  }

  @Override
  public void goAnimate() {
    ev.displayView(model);
  }
}
