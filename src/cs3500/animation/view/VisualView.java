package cs3500.animation.view;


import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

import cs3500.animation.model.AnimationModel;

/**
 * Visual View Class that will be used to represent a view class of IView. Using java swing to
 * produce animations and make a panel of animation.
 */
public class VisualView extends AView implements IView {

  /**
   * VisualView Constructor that takes in a model and produce a view.
   *
   * @param model model
   */
  public VisualView(AnimationModel model) {
    super();
    this.setTitle("Excellence");
    this.setSize(model.getBoundingDimension().getWidth(), model.getBoundingDimension().getHeight());
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //use a borderlayout with drawing panel in center and button panel in south
    this.setLayout(new BorderLayout());
    VisualPanel vpanel = new VisualPanel(model);
    vpanel.setPreferredSize(new Dimension(500, 500));
    this.add(vpanel, BorderLayout.CENTER);
  }

  @Override
  public void makeVisible() {
    setVisible(true);
  }

  @Override
  public AnimationModel getViewModel() {
    return null;
  }
}
