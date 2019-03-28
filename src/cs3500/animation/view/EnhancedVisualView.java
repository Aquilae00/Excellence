package cs3500.animation.view;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

import cs3500.animation.model.AnimationModel;
import cs3500.animation.model.AnimationModelImpl;
import cs3500.animation.model.IReadOnlyModel;
import cs3500.animation.model.ImmAnimationModel;
import cs3500.animation.model.Transformation;
import cs3500.animation.view.Panels.ButtonPanel;
import cs3500.animation.view.Panels.MenuPanel;
import cs3500.animation.view.Panels.VisualPanel;

/**
 * The visual view that is used to set up the animation.
 */
public class EnhancedVisualView extends JFrame implements EnhancedIView {

  private ButtonPanel buttonPanel;
  private MenuPanel menuBar;
  private VisualPanel vPanel;
  private VisualView vView;
  private AnimationModel mm;

  /**
   * The visual view that takes in readonly model and the speed of animation.
   *
   * @param model readonly model
   * @param speed speed of animation
   */
  public EnhancedVisualView(IReadOnlyModel model, int speed) {
    super();
    this.mm = (AnimationModel) model;
    this.vView = new VisualView(mm, speed);
    this.setTitle(vView.getTitle());
    this.setSize(vView.getSize());
    this.setDefaultCloseOperation(vView.getDefaultCloseOperation());

    //use a borderlayout with drawing panel in center and button panel in south
    this.setLayout(vView.getLayout());
    this.vPanel = new VisualPanel(mm, speed);
    vPanel.setPreferredSize(new Dimension(500, 500));
    this.add(vPanel, BorderLayout.CENTER);

    //set play button
    buttonPanel = new ButtonPanel();
    this.add(buttonPanel, BorderLayout.SOUTH);

    //sets the menu bar
    menuBar = new MenuPanel(mm.getShapes());
    this.add(menuBar, BorderLayout.WEST);
  }

  /**
   * It sets the role of the button.
   *
   * @param clicks on mouse click
   */
  public void setButtonListeners(ActionListener clicks) {
    buttonPanel.setListeners(clicks);
    menuBar.setButtonListener(clicks);
  }

  public void setLabelSpeed() {
    buttonPanel.setSpeedText("Speed " + vPanel.getSpeed());
  }

  @Override
  public void makeVisible() {
    setVisible(true);
  }

  @Override
  public AnimationModel getModel() {
    return this.mm;
  }

  @Override
  public void startTimer() {
    vPanel.startTimer();
  }

  @Override
  public void stopTimer() {
    vPanel.stopTimer();
  }

  @Override
  public void restartTimer() {
    vPanel.restartTimer();
  }

  @Override
  public void deleteShape(String name) {
    vPanel.deleteShape(name);
  }

  @Override
  public VisualPanel getVisualPanel() {
    return this.vPanel;
  }

  @Override
  public void increaseSpeed() {
    vPanel.increaseSpeed();
  }

  @Override
  public void decreaseSpeed() {
    vPanel.decreaseSpeed();
  }

  @Override
  public void toggleLoop() {
    vPanel.toggleLoop();
    if (vPanel.getLoop()) {
      buttonPanel.setToggleLoopButton("Toggle Loop On");
    } else {
      buttonPanel.setToggleLoopButton("Toggle Loop Off");
    }
  }

  /**
   * It gives the command for the shape.
   *
   * @return the command
   */
  public String getCreateShapeCommand() {
    if (!(menuBar.getShapeType().equals("rectangle") || menuBar.getShapeType().equals("ellipse"))) {
      throw new IllegalArgumentException("Illegal Type");
    }
    String command = this.menuBar.getShapeName() + " " + this.menuBar.getShapeType();
    if (menuBar.getShapeName().equals("") || menuBar.getShapeType().equals("")) {
      throw new IllegalArgumentException("Input cannot be empty");
    }
    menuBar.addList(menuBar.getShapeName(), menuBar.getShapeType());
    this.menuBar.setShapeText("");
    return command;
  }

  public String getDeleteShapeCommand() {
    if (!(menuBar.getShapeType().equals("rectangle") || menuBar.getShapeType().equals("ellipse"))) {
      throw new IllegalArgumentException("Illegal Type");
    }
    if (menuBar.getShapeName().equals("") || menuBar.getShapeType().equals("")) {
      throw new IllegalArgumentException("Input cannot be empty");
    }
    String command = this.menuBar.getShapeName() + " " + this.menuBar.getShapeType();
    menuBar.removeList(menuBar.getShapeName(), menuBar.getShapeType());
    menuBar.setShapeText("");
    return command;
  }

  /**
   * It gives the coomand for the transformation.
   *
   * @return command to create transformation.
   */
  public String getTransformationCommand() {
    return menuBar.getTransformationFields();
  }

  public void insertTransformation() {
    vPanel.insertTransformation(menuBar.getTShapeName(),menuBar.getTShapeTick(),
            menuBar.getTPosX(),menuBar.getTPosY(),menuBar.getTWidth(),menuBar.getTHeight(),
            menuBar.getTRed(),menuBar.getTGreen(),menuBar.getTBlue());

  }

  public void removeTransformation() {
    vPanel.removeTransformation(menuBar.getTShapeName(),menuBar.getTShapeTick(),
            menuBar.getTPosX(),menuBar.getTPosY(),menuBar.getTWidth(),menuBar.getTHeight(),
            menuBar.getTRed(),menuBar.getTGreen(),menuBar.getTBlue());
  }

  public void clearMenuTrans() {
    menuBar.clearTransField("");
  }

  @Override
  public void createShape(String name, String type) {
    if (name == null || type == null) {
      throw new IllegalArgumentException("input can't be null");
    }
    this.getModel().addShape(name, type);
  }
}
