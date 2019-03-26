package cs3500.animation.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import cs3500.animation.view.EnhancedVisualView;

public class EnhancedController implements EnhancedIController, ActionListener {
  private EnhancedVisualView evv;

  public EnhancedController(EnhancedVisualView view) {
    this.evv = view;
    evv.setButtonListeners(this);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    switch (e.getActionCommand()) {
      case "Play":
        if (evv.getVisualPanel().getTick() != 0) {

        } else {
          evv.startTimer();
        }
        break;
      case "Resume":
        evv.startTimer();
        break;
      case "Pause":
        this.evv.stopTimer();
        break;
      case "Restart":
        evv.restartTimer();
        break;
      case "+1 speed":
        evv.increaseSpeed();
        break;
      case "-1 speed":
        evv.decreaseSpeed();
        break;
      case "Toggle Loop On":
        evv.toggleLoop();
        break;
      case "Create":
        String command1 = evv.getCreateShapeCommand();
        try {
          processShapeButtonCommand(command1);
        } catch (Exception ee) {
          ee.printStackTrace();
        }
        break;
      case "addT":
        String command2 = evv.getCreateTransformationCommand();
        try {
          processTButtonCommand(command2);
        } catch (Exception ee) {
          ee.printStackTrace();
        }
      default:
        break;
    }
  }

  private void processShapeButtonCommand(String command) {
    StringBuilder output = new StringBuilder();
    Scanner s = new Scanner(command);
    evv.getModel().addShape(s.next(),s.next());
  }

  private void processTButtonCommand(String command) {
    StringBuilder output = new StringBuilder();
    Scanner s = new Scanner(command);
    evv.getModel().insertTransformation(s.next(),
            Integer.parseInt(s.next())
            ,Double.parseDouble(s.next()),Double.parseDouble(s.next()),Integer.parseInt(s.next()),
            Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),
            Integer.parseInt(s.next()));
    evv.getVisualPanel().repaint();
    evv.getVisualPanel().revalidate();
  }

  @Override
  public void goAnimate() {
    evv.makeVisible();
  }
}
