package cs3500.animation.view.Handlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import cs3500.animation.view.EnhancedIView;

public class RestartHandler implements ActionListener {

  private EnhancedIView evv;
  public RestartHandler(EnhancedIView evv){
    this.evv = evv;
  }

  public void actionPerformed(ActionEvent e) {
    evv.restartTimer();
  }
}
