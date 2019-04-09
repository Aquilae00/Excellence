package cs3500.animation.view.panels;


import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Dimension;




/**
 * The class designed for buttons in User Interface.
 */
public class ButtonPanel extends JPanel {

  private JButton startButton;
  private JButton stopButton;
  private JButton resumeButton;
  private JButton restartButton;
  private JButton increaseSpeedButton;
  private JButton decreaseSpeedButton;
  private JButton toggleLoopButton;
  private JLabel speedLabel;
  private JTextField visualText;

  /**
   * Button panel that sets the position and function of button.
   */
  public ButtonPanel() {
    this.setLayout(new FlowLayout());

    visualText = new JTextField("");
    visualText.setPreferredSize(new Dimension(150, 20));
    this.add(visualText);

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
    toggleLoopButton = new JButton("Toggle Loop Off");
    toggleLoopButton.setActionCommand("Toggle Loop Off");
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
   * Set this visualText field to the given string.
   *
   * @param s given string
   */
  public void setVisualText(String s) {
    this.visualText.setText(s);
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
   *
   * @param text given string
   */
  public void setSpeedText(String text) {
    this.speedLabel.setText(text);
  }


}
