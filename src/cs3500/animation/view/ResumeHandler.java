package cs3500.animation.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResumeHandler implements ActionListener {
  private EnhancedVisualView evv;
  public ResumeHandler(EnhancedVisualView evv){
    this.evv = evv;
  }
  @Override
  public void actionPerformed(ActionEvent e) {
    evv.getVPanel().startTimer();
  }

}
