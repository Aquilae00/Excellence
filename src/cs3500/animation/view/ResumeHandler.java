package cs3500.animation.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResumeHandler implements ActionListener {
  private VisualPanel vp;
  public ResumeHandler(VisualPanel vp){
    this.vp = vp;
  }
  @Override
  public void actionPerformed(ActionEvent e) {
    vp.startTimer();
  }

}
