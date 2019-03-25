package cs3500.animation.view.Handlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import cs3500.animation.view.EnhancedIView;

public class PauseHandler implements ActionListener {
  private EnhancedIView evv;
  public PauseHandler(EnhancedIView evv) {
    this.evv = evv;
  }
  @Override
  public void actionPerformed(ActionEvent e) {
    this.evv.stopTimer();
  }
}
