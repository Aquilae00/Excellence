package cs3500.animation.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PauseHandler implements ActionListener {
  VisualPanel vp;
  public PauseHandler(VisualPanel vp) {
    this.vp = vp;
  }
  @Override
  public void actionPerformed(ActionEvent e) {
    this.vp.stopTimer();
  }
}
