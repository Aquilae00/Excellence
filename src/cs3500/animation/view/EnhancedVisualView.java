package cs3500.animation.view;

import java.awt.*;

import javax.swing.*;

import cs3500.animation.model.AnimationModel;
import cs3500.animation.model.ImmAnimationModel;
import cs3500.animation.view.Handlers.DecreaseSpeedHandler;
import cs3500.animation.view.Handlers.IncreaseSpeedHandler;
import cs3500.animation.view.Handlers.PauseHandler;
import cs3500.animation.view.Handlers.RestartHandler;
import cs3500.animation.view.Handlers.ResumeHandler;
import cs3500.animation.view.Handlers.StartHandler;

public class EnhancedVisualView extends JFrame implements EnhancedIView {
  private JButton startButton;
  private JButton stopButton;
  private JButton resumeButton;
  private JButton restartButton;
  private JButton increaseSpeedButton;
  private JButton decreaseSpeedButton;
  private JPanel buttonPanel;
  private VisualPanel vPanel;
  private VisualView vView;
  private int speedAcc;

  public EnhancedVisualView(AnimationModel model, int speed) {
    super();
    this.vView = new VisualView(model,speed);
    this.setTitle(vView.getTitle());
    this.setSize(vView.getSize());
    this.setDefaultCloseOperation(vView.getDefaultCloseOperation());

    //use a borderlayout with drawing panel in center and button panel in south
    this.setLayout(vView.getLayout());
    this.vPanel = new VisualPanel(new ImmAnimationModel(model),speed);
    vPanel.setPreferredSize(new Dimension(500, 500));
    this.add(vPanel, BorderLayout.CENTER);

    //set play button
    buttonPanel = new JPanel();
    buttonPanel.setLayout(new FlowLayout());
    this.add(buttonPanel,BorderLayout.SOUTH);

    //add play button
    startButton = new JButton("Play");
    buttonPanel.add(startButton);
    startButton.addActionListener(new StartHandler(this));

    // add resume button
    resumeButton = new JButton("Resume");
    buttonPanel.add(resumeButton);
    resumeButton.addActionListener(new ResumeHandler(this));


    //add stop button
    stopButton = new JButton("Pause");
    buttonPanel.add(stopButton);
    stopButton.addActionListener(new PauseHandler(this));

    //add restart button
    restartButton = new JButton("Restart");
    buttonPanel.add(restartButton);
    restartButton.addActionListener(new RestartHandler(this));

    //add increase speed button
    increaseSpeedButton = new JButton("+1 speed");
    buttonPanel.add(increaseSpeedButton);
    increaseSpeedButton.addActionListener(new IncreaseSpeedHandler(this));

    //add decrease speed Button
    decreaseSpeedButton = new JButton("-1 speed");
    buttonPanel.add(decreaseSpeedButton);
    decreaseSpeedButton.addActionListener(new DecreaseSpeedHandler(this));

  }


  @Override
  public void makeVisible() {
    setVisible(true);
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
}
