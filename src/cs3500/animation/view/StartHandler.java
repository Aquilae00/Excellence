package cs3500.animation.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartHandler implements ActionListener {
  private VisualPanel vp;
  public StartHandler(VisualPanel vp){
    this.vp = vp;
  }
  @Override
  public void actionPerformed(ActionEvent e) {
    if(vp.getTick() != 0) {

    } else{
      vp.startTimer();
    }
  }
}
