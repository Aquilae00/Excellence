package cs3500.animation.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import cs3500.animation.model.AnimationModel;
import cs3500.animation.model.IReadOnlyModel;
import cs3500.animation.view.panels.ButtonPanel;
import cs3500.animation.view.panels.MenuPanel;
import cs3500.animation.view.panels.VisualPanel;

/**
 * The visual view that is used to set up the animation.
 */
public class EnhancedVisualView extends JFrame implements EnhancedIView {

  private ButtonPanel buttonPanel;
  private MenuPanel menuBar;
  private VisualPanel vPanel;
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
    VisualView vView = new VisualView(mm, speed);
    this.setTitle(vView.getTitle());
    this.setSize(vView.getSize());
    this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
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

  @Override
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
      buttonPanel.setToggleLoopButton("Toggle Loop Off");
    } else {
      buttonPanel.setToggleLoopButton("Toggle Loop On");
    }
  }

  @Override
  public String getCreateShapeCommand() {
    String command = null;
    if (!(menuBar.getShapeType().equals("rectangle") || menuBar.getShapeType().equals("ellipse"))) {
      throw new IllegalArgumentException("Illegal Type");
    }
    if (menuBar.getShapeName().equals("") || menuBar.getShapeType().equals("")) {
      buttonPanel.setVisualText("Input cannot be empty");
      throw new IllegalArgumentException("Input cannot be empty");
    }
    if (!mm.getShapes().containsKey(this.menuBar.getShapeName())) {
      command = this.menuBar.getShapeName() + " " + this.menuBar.getShapeType();
      menuBar.addList(menuBar.getShapeName());
      this.menuBar.setShapeNameText("");
      this.menuBar.setShapeTypeText("");
    } else {
      buttonPanel.setVisualText("Shape name already exists");
    }
    return command;
  }

  @Override
  public String getDeleteShapeCommand() {
    String command = null;
    if (menuBar.getShapeName().equals("")) {
      throw new IllegalArgumentException("Input cannot be empty");
    }
    if (mm.getShapes().containsKey(this.menuBar.getShapeName())) {
      command = this.menuBar.getShapeName() + " " + this.menuBar.getShapeType();
      menuBar.removeList(menuBar.getShapeName());
      menuBar.setShapeNameText("");
    } else {
      buttonPanel.setVisualText("No shape with such name");
    }
    return command;
  }

  @Override
  public String getTransformationCommand() {
    return menuBar.getTransformationFields();
  }

  @Override
  public void insertTransformation() {
    vPanel.insertTransformation(menuBar.getTShapeName(), menuBar.getTShapeTick(),
            menuBar.getTPosX(), menuBar.getTPosY(), menuBar.getTWidth(), menuBar.getTHeight(),
            menuBar.getTRed(), menuBar.getTGreen(), menuBar.getTBlue());

  }

  @Override
  public void removeTransformation() {
    vPanel.removeTransformation(menuBar.getTShapeName(), menuBar.getTShapeTick());
  }

  @Override
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

  @Override
  public MenuPanel getMenuPanel() {
    return this.menuBar;
  }

  @Override
  public void setVisualText(String s) {
    buttonPanel.setVisualText(s);
  }
}
