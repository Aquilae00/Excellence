package cs3500.animation.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.NoSuchElementException;
import java.util.Scanner;

import cs3500.animation.view.EnhancedVisualView;

/**
 * The controller that enables the user to see the interface.
 */
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
          evv.setLabelSpeed();
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
      case "Delete":
        String command0 = evv.getDeleteShapeCommand();
        try {
          processDeleteShapeButtonCommand(command0);
        } catch (Exception ee) {
          ee.printStackTrace();
        }
        break;
      case "+1 speed":
        evv.increaseSpeed();
        evv.setLabelSpeed();
        break;
      case "-1 speed":
        evv.decreaseSpeed();
        evv.setLabelSpeed();
        break;
      case "Toggle Loop On":
        evv.toggleLoop();
        break;
      case "Create":
        try {
          String command1 = evv.getCreateShapeCommand();
          processCreateShapeButtonCommand(command1);
        } catch (NoSuchElementException n) {
          throw new IllegalArgumentException("Input cannot be empty");
        } catch (IllegalArgumentException i) {
          throw new IllegalArgumentException(i);
        }
        break;
      case "addT":
        String command2 = evv.getTransformationCommand();
        try {
          processCreateTButtonCommand(command2);
        } catch (Exception ee) {
          ee.printStackTrace();
        }
        evv.insertTransformation();
        evv.clearMenuTrans();
        break;
      case "delT":
        String command3 = evv.getTransformationCommand();
        try {
          processDeleteTButtonCommand(command3);
        } catch (Exception ee) {
          ee.printStackTrace();
        }
        evv.removeTransformation();
        evv.clearMenuTrans();
        break;
      default:
        break;
    }
  }

  private void processCreateShapeButtonCommand(String command) {
    StringBuilder output = new StringBuilder();
    Scanner s = new Scanner(command);
    evv.createShape(s.next(), s.next());
  }

  private void processDeleteShapeButtonCommand(String command) {
    Scanner s = new Scanner(command);
    evv.deleteShape(s.next());
  }

  private void processCreateTButtonCommand(String command) {
    StringBuilder output = new StringBuilder();
    Scanner s = new Scanner(command);
    evv.getModel().insertTransformation(s.next(),
            Integer.parseInt(s.next())
            , Double.parseDouble(s.next()), Double.parseDouble(s.next()), Integer.parseInt(s.next()),
            Integer.parseInt(s.next()), Integer.parseInt(s.next()), Integer.parseInt(s.next()),
            Integer.parseInt(s.next()));
    evv.getVisualPanel().repaint();
    evv.getVisualPanel().revalidate();
  }

  private void processDeleteTButtonCommand(String command) {
    StringBuilder output = new StringBuilder();
    Scanner s = new Scanner(command);
    evv.getModel().deleteTransformation(s.next(),
            Integer.parseInt(s.next())
            , Double.parseDouble(s.next()), Double.parseDouble(s.next()), Integer.parseInt(s.next()),
            Integer.parseInt(s.next()), Integer.parseInt(s.next()), Integer.parseInt(s.next()),
            Integer.parseInt(s.next()));
    evv.getVisualPanel().repaint();
    evv.getVisualPanel().revalidate();
  }


  @Override
  public void goAnimate() {
    evv.makeVisible();
  }
}
