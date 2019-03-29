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
   */
  public ImmAnimationModel(IReadOnlyModel model) {
    this.am = model;
  }

  @Override
  public ArrayList<Transformation> getTransformations() {
    return am.getTransformations();
  }

  @Override
  public Dimension2D getBoundingDimension() {
    return am.getBoundingDimension();
  }

  @Override
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
  @Override
  public Position2D getLeftTopMostPosn() {
    return am.getLeftTopMostPosn();
  }
}
