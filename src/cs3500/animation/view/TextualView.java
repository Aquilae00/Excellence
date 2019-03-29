package cs3500.animation.view;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import cs3500.animation.model.IReadOnlyModel;

/**
 * This view will show a textual description of the animation. This description should be the
 * description produced from AnimationModelImpl getAnimationState() method.
 */
public class TextualView extends AView {
  /**
   * Constructs an Textual View with given model, output file location and scale of tick. Output
   * file's default is "System.out" and prints out SVG text in the console. scale works by dividing
   * the actual tick by this scale to get a unit in second.
   *
   * @param model       given AnimationModel to operate
   * @param outFileName given desired output file name
   * @param scale       given the scale of tick
   */
  public TextualView(IReadOnlyModel model, String outFileName, int scale) {
    super();
    super.model = model;
    super.tickScale = scale;
    if (outFileName.equals("System.out")) {
      System.out.println(model.getAnimationState());
    } else {
      this.generateTXTFile(outFileName);
    }
  }

  /**
   * It creates the txt file of the given name.
   *
   * @param s name of the txt file that is to be created.
   */
  private void generateTXTFile(String s) {
    try {
      File file = new File(s);
      FileWriter writer = new FileWriter(file);
      writer.write(model.getAnimationState());
      writer.close();
    } catch (IOException io) {
      io.printStackTrace();
    }
  }
}
