package cs3500.animation.view;

import cs3500.animation.view.Panels.VisualPanel;

public interface EnhancedIView extends IView {
  void startTimer();

  void stopTimer();

  void restartTimer();

  VisualPanel getVisualPanel();

  void increaseSpeed();

  void decreaseSpeed();

  void toggleLoop();
}
