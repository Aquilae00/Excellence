package cs3500.animation.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
