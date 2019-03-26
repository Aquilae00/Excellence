package cs3500.animation.model;

import java.util.ArrayList;
import java.util.Map;

import cs3500.animation.model.dimension.Dimension2D;
import cs3500.animation.model.position.Position2D;

/**
 * This interface represents the operations offered by an AnimationModel. Provides the classes that
 * implements this interface with methods that gets the target value. Serves as a bridge that
 * communicates between the caller and the model. One object of the model represents one animation
 * model.
 */
public interface AnimationModel extends IReadOnlyModel {
  void setTransformations(ArrayList<Transformation> transformations);

  void addShape(String name,String type);

  void deleteTransformation(String name, int t1, double x1, double y1,
                            int w1, int h1, int r1, int g1, int b1);

  void insertTransformation(String name, int t1, double x1, double y1,
                            int w1, int h1, int r1, int g1, int b1);
}
