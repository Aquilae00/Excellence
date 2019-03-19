package cs3500.animation.view;

import javax.swing.JFrame;

import cs3500.animation.model.AnimationModel;

/**
 * An abstract class of View, which provides necessary fields to the subclasses. Provide the
 * subclasses with methods structure.
 */
public class AView extends JFrame implements IView {
  protected AnimationModel model;
  protected int tickScale;

  @Override
  public void makeVisible() {
    setVisible(false);
  }

  @Override
  public AnimationModel getViewModel() {
    return this.model;
  }
}
