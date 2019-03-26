package cs3500.animation.view;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

import cs3500.animation.model.AnimationModel;
import cs3500.animation.model.AnimationModelImpl;
import cs3500.animation.model.IReadOnlyModel;
import cs3500.animation.model.ImmAnimationModel;
import cs3500.animation.view.Panels.ButtonPanel;
import cs3500.animation.view.Panels.MenuPanel;
import cs3500.animation.view.Panels.VisualPanel;

public class EnhancedVisualView extends JFrame implements EnhancedIView {
  private ButtonPanel buttonPanel;

  private MenuPanel menuBar;
  private VisualPanel vPanel;
  private VisualView vView;
  private AnimationModel mm;

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

  public void setButtonListeners(ActionListener clicks) {
    buttonPanel.setListeners(clicks);
    menuBar.setButtonListener(clicks);
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

  public String getCreateShapeCommand() {
    String command = this.menuBar.getShapeName() + " " + this.menuBar.getShapeType();
    menuBar.addList(menuBar.getShapeName(), menuBar.getShapeType());
    this.menuBar.setShapeText("");
    return command;
  }

  public String getCreateTransformationCommand() {
    String command = menuBar.getTransformationFields();
    vPanel.insertTransformation(menuBar.getTShapeName(),menuBar.getTShapeTick(),
            menuBar.getTPosX(),menuBar.getTPosY(),menuBar.getTWidth(),menuBar.getTHeight(),menuBar.getTRed(),menuBar.getTGreen(),menuBar.getTBlue());
    return command;
  }
}
