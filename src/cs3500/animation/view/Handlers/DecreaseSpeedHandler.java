package cs3500.animation.view.Handlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import cs3500.animation.view.EnhancedIView;

public class DecreaseSpeedHandler implements ActionListener {
  private EnhancedIView evv;
  public DecreaseSpeedHandler(EnhancedIView evv) {
    this.evv = evv;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    evv.decreaseSpeed();
  }
}
