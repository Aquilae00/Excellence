package cs3500.animation.view.Panels;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.*;

import cs3500.animation.model.Transformation;

/**
 * The class designed for buttons in User Interface.
 */
public class ButtonPanel extends JPanel {
  private JButton startButton;
  private JButton stopButton;
  private JButton resumeButton;
  private JButton restartButton;
  private JButton deleteButton;
  private JButton increaseSpeedButton;
  private JButton decreaseSpeedButton;
  private JButton toggleLoopButton;
  private JLabel speedLabel;

  /**
   * Button panel that sets the position and function of button.
   */
  public ButtonPanel() {
    this.setLayout(new FlowLayout());

    speedLabel = new JLabel("Speed: 0");
    this.add(speedLabel);
    //add play button
    startButton = new JButton("Play");
    startButton.setActionCommand("Play");
    this.add(startButton);

    // add resume button
    resumeButton = new JButton("Resume");
    resumeButton.setActionCommand("Resume");
    this.add(resumeButton);


    //add stop button
    stopButton = new JButton("Pause");
    stopButton.setActionCommand("Pause");
    this.add(stopButton);

    //add restart button
    restartButton = new JButton("Restart");
    restartButton.setActionCommand("Restart");
    this.add(restartButton);



    //add increase speed button
    increaseSpeedButton = new JButton("+1 speed");
    increaseSpeedButton.setActionCommand("+1 speed");
    this.add(increaseSpeedButton);

    //add decrease speed Button
    decreaseSpeedButton = new JButton("-1 speed");
    decreaseSpeedButton.setActionCommand("-1 speed");
    this.add(decreaseSpeedButton);

    //add toggle loop button
    toggleLoopButton = new JButton("Toggle Loop On");
    toggleLoopButton.setActionCommand("Toggle Loop On");
    this.add(toggleLoopButton);
  }

  /**
   * It assign roles for what each button will do.
   *
   * @param clicks the click of the mouse
   */
  public void setListeners(ActionListener clicks) {
    this.startButton.addActionListener(clicks);
    this.resumeButton.addActionListener(clicks);
    this.stopButton.addActionListener(clicks);
    this.restartButton.addActionListener(clicks);
    this.increaseSpeedButton.addActionListener(clicks);
    this.decreaseSpeedButton.addActionListener(clicks);
    this.toggleLoopButton.addActionListener(clicks);
  }

  /**
   * It sets the text of loop button.
   *
   * @param text the text that will be shown
   */
  public void setToggleLoopButton(String text) {
    this.toggleLoopButton.setText(text);
  }

  /**
   * Set the Label speed to the given text.
   * @param text given string
   */
  public void setSpeedText(String text) {
    this.speedLabel.setText(text);
  }


}
