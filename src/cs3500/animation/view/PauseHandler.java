package cs3500.animation.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PauseHandler implements ActionListener {
  EnhancedVisualView evv;
  public PauseHandler(EnhancedVisualView evv) {
    this.evv = evv;
  }
  @Override
  public void actionPerformed(ActionEvent e) {
    this.evv.getVPanel().stopTimer();
  }
}
