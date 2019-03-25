package cs3500.animation.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartHandler implements ActionListener {
  private EnhancedVisualView evv;
  public StartHandler(EnhancedVisualView evv){
    this.evv = evv;
  }
  @Override
  public void actionPerformed(ActionEvent e) {
    evv.getVPanel().startTimer();
  }
}
