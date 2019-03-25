package cs3500.animation.view.Handlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import cs3500.animation.view.EnhancedIView;

public class StartHandler implements ActionListener {
  private EnhancedIView evv;
  public StartHandler(EnhancedIView evv){
    this.evv = evv;
  }
  @Override
  public void actionPerformed(ActionEvent e) {
    if(evv.getVisualPanel().getTick() != 0) {

    } else{
      evv.startTimer();
    }
  }
}
