package cs3500.animation.controller;

import cs3500.animation.provider.model.Animation;
import cs3500.animation.provider.model.AnimationModelToProvider;
import cs3500.animation.provider.view.EditorView;
import cs3500.animation.provider.view.EditorViewImpl;

public class ProviderController implements EnhancedIController {
  EditorView ev;
  Animation model;

  public ProviderController(EditorView ev, AnimationModelToProvider ap) {
    this.ev = ev;
    this.model = ap;
  }
  @Override
  public void goAnimate() {
    ev.displayView(model);
  }
}
