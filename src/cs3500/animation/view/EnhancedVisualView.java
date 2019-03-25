package cs3500.animation.view;

import java.awt.*;

import javax.swing.*;

import cs3500.animation.model.AnimationModel;
import cs3500.animation.model.ImmAnimationModel;

public class EnhancedVisualView extends JFrame implements IView{
  private JButton startButton;
  private JButton stopButton;
  private JButton resumeButton;
  private JButton restartButton;
  private JPanel buttonPanel;
  private VisualPanel vPanel;

  public EnhancedVisualView(AnimationModel model, int speed) {
    super();
    this.setTitle("Excellence");
    this.setSize(model.getBoundingDimension().getWidth(), model.getBoundingDimension().getHeight());
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    //use a borderlayout with drawing panel in center and button panel in south
    this.setLayout(new BorderLayout());
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
    startButton.addActionListener(new StartHandler(vPanel));

    // add resume button
    resumeButton = new JButton("Resume");
    buttonPanel.add(resumeButton);
    resumeButton.addActionListener(new ResumeHandler(vPanel));


    //add stop button
    stopButton = new JButton("Pause");
    buttonPanel.add(stopButton);
    stopButton.addActionListener(new PauseHandler(vPanel));

    //add restart button
    restartButton = new JButton("Restart");
    buttonPanel.add(restartButton);
    restartButton.addActionListener(new RestartHandler(vPanel));

  }

  public VisualPanel getVPanel() {
    return this.vPanel;
  }

  @Override
  public void makeVisible() {
    setVisible(true);
  }

  @Override
  public AnimationModel getViewModel() {
    return null;
  }
}
