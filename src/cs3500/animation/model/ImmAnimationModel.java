package cs3500.animation.model;


import java.util.ArrayList;
import java.util.Map;

import cs3500.animation.model.dimension.Dimension2D;
import cs3500.animation.model.position.Position2D;

/**
 * The animation m odel that will not change.
 */
public final class ImmAnimationModel implements IReadOnlyModel {
  private IReadOnlyModel am;

  /**
   * Immutable animation model that takes in the readonly model.
   *
   * @param model
   */
  public ImmAnimationModel(IReadOnlyModel model) {
    this.am = model;
  }

  /**
   * It returns the list of transformation of the model.
   *
   * @return list of transformation of the model
   */
  public ArrayList<Transformation> getTransformations() {
    return am.getTransformations();
  }


  /**
   * It gets the bounding width and height of the animation screen.
   *
   * @return the dimension of the screen
   */
  public Dimension2D getBoundingDimension() {
    return am.getBoundingDimension();
  }

  /**
   * It gets the shape of the given string.
   *
   * @return the map of given string
   */
  public Map<String, String> getShapes() {
    return am.getShapes();
  }

  @Override
  public String getAnimationState() {
    return null;
  }

  /**
   * It gets the left top most position.
   *
   * @return left top most position
   */
  public Position2D getLeftTopMostPosn() {
    return am.getLeftTopMostPosn();
  }
}
