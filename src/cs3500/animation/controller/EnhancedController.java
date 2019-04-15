package cs3500.animation.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.NoSuchElementException;
import java.util.Scanner;

import cs3500.animation.provider.view.EditorView;
import cs3500.animation.view.EnhancedVisualView;

/**
 * The controller that enables the user to see the interface.
 */
public class EnhancedController implements EnhancedIController, ActionListener {
  private EnhancedVisualView evv;

  /**
   * Controller that takes in enhancedvisualview as constructor.
   *
   * @param view the enhanced visual view
   */
  public EnhancedController(EnhancedVisualView view) {
    this.evv = view;
    evv.setButtonListeners(this);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    switch (e.getActionCommand()) {
      case "Play":
        if (evv.getVisualPanel().getTick() == 0) {
          evv.startTimer();
          evv.setLabelSpeed();
          evv.setVisualText("Played");
        }
        break;
      case "Resume":
        evv.startTimer();
        evv.setVisualText("Resumed");
        break;
      case "Pause":
        this.evv.stopTimer();
        evv.setVisualText("Paused");
        break;
      case "Restart":
        evv.restartTimer();
        evv.setVisualText("Restarting");
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
        evv.setVisualText("+1 speed");
        break;
      case "-1 speed":
        evv.decreaseSpeed();
        evv.setLabelSpeed();
        evv.setVisualText("-1 speed");
        break;
      case "Toggle Loop Off":
        evv.toggleLoop();
        evv.setVisualText("Loop is Off");
        break;
      case "Create":
        try {
          String command1 = evv.getCreateShapeCommand();
          processCreateShapeButtonCommand(command1);
        } catch (NoSuchElementException n) {
          throw new IllegalArgumentException("Input cannot be empty");
        } catch (IllegalArgumentException i) {
          evv.setVisualText("Illegal Type");
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
          evv.removeTransformation();
        } catch (IllegalArgumentException n) {
          evv.setVisualText("Invalid KeyFrame tick");
          throw new IllegalArgumentException(n);
        }

        evv.clearMenuTrans();
        break;
      default:
        break;
    }
  }

  /**
   * Process the given command string and create shape after scanned command input.
   *
   * @param command the given string command
   */
  private void processCreateShapeButtonCommand(String command) {
    Scanner s = new Scanner(command);
    String name = s.next();
    String type = s.next();
    evv.createShape(name, type);
    evv.setVisualText("Created " + name + " " + type);
  }

  /**
   * It processes the delete button.
   *
   * @param command the command input
   */
  private void processDeleteShapeButtonCommand(String command) {
    Scanner s = new Scanner(command);
    String name = s.next();
    evv.deleteShape(name);
    evv.setVisualText("Deleted " + name);
  }

  /**
   * It processes the create button.
   *
   * @param command the input command
   */
  private void processCreateTButtonCommand(String command) {
    Scanner s = new Scanner(command);
    evv.getModel().insertTransformation(s.next(),
            Integer.parseInt(s.next())
            , Double.parseDouble(s.next()), Double.parseDouble(s.next()),
            Integer.parseInt(s.next()),
            Integer.parseInt(s.next()), Integer.parseInt(s.next()), Integer.parseInt(s.next()),
            Integer.parseInt(s.next()));
    evv.getVisualPanel().repaint();
    evv.getVisualPanel().revalidate();
    evv.setVisualText("Added Key Frame");
  }

  /**
   * It processes the delete button.
   *
   * @param command the input command
   */
  private void processDeleteTButtonCommand(String command) {
    Scanner s = new Scanner(command);
    evv.getModel().deleteTransformation(s.next(), Integer.parseInt(s.next()));
    evv.getVisualPanel().repaint();
    evv.getVisualPanel().revalidate();
    evv.setVisualText("Deleted Key Frame");
  }


  @Override
  public void goAnimate() {
    evv.makeVisible();
  }
}
