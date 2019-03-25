package cs3500.animation.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResumeHandler implements ActionListener {
  private EnhancedIView evv;
  public ResumeHandler(EnhancedIView evv){
    this.evv = evv;
  }
  @Override
  public void actionPerformed(ActionEvent e) {
    evv.startTimer();
  }

}
