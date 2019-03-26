package cs3500.animation.view;

import javax.swing.JFrame;

import cs3500.animation.model.AnimationModel;
import cs3500.animation.model.IReadOnlyModel;

/**
 * An abstract class of View, which provides necessary fields to the subclasses. Provide the
 * subclasses with methods structure.
 */
public abstract class AView extends JFrame implements IView {
  protected IReadOnlyModel model;
  protected int tickScale;

  @Override
  public void makeVisible() {
    setVisible(false);
  }

  public IReadOnlyModel getModel() {
    return this.model;
  }
}
