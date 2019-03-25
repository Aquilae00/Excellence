package cs3500.animation.view.Handlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import cs3500.animation.view.EnhancedIView;

public class IncreaseSpeedHandler implements ActionListener {
  private EnhancedIView evv;
  public IncreaseSpeedHandler(EnhancedIView evv) {
    this.evv = evv;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    evv.increaseSpeed();
  }
}
