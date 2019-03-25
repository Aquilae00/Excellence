package cs3500.animation.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RestartHandler implements ActionListener {

  private VisualPanel vp;
  public RestartHandler(VisualPanel evv){
    this.vp = evv;
  }

  public void actionPerformed(ActionEvent e) {
    vp.restartTimer();
  }
}
