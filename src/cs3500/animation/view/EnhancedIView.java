package cs3500.animation.view;

public interface EnhancedIView extends IView {
  void startTimer();

  void stopTimer();

  void restartTimer();

  VisualPanel getVisualPanel();

  void increaseSpeed();

  void decreaseSpeed();
}
