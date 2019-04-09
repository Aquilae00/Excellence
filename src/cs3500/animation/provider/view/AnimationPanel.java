package cs3500.animation.provider.view;

import cs3500.animation.provider.model.Animation;
import java.awt.Dimension;

/**
 * Is an animation panel.
 */
public interface AnimationPanel {

  /**
   * Sets the current tick.
   */
  void setCurrentTick(int currentTick);

  /**
   * Sets the model to represent.
   */
  void setModel(Animation model);

  /**
   * Sets the preferred size.
   */
  void setPreferredSize(Dimension dimension);
}
