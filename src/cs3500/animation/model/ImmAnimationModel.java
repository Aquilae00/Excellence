package cs3500.animation.model;

import java.util.ArrayList;
import java.util.Map;

import cs3500.animation.model.dimension.Dimension2D;
import cs3500.animation.model.position.Position2D;

public final class ImmAnimationModel {
  private Position2D leftTopMostPosn;
  private Dimension2D boundingDimension;
  private Map<String, String> shapes;
  private ArrayList<Transformation> transformations;

  public ImmAnimationModel(AnimationModel model) {
    this.leftTopMostPosn = model.getLeftTopMostPosn();
    this.boundingDimension = model.getBoundingDimension();
    this.shapes = model.getShapes();
    this.transformations = model.getTransformations();
  }

  public ArrayList<Transformation> getTransformations() {
    return transformations;
  }

  public Dimension2D getBoundingDimension() {
    return boundingDimension;
  }

  public Map<String, String> getShapes() {
    return shapes;
  }

  public Position2D getLeftTopMostPosn() {
    return leftTopMostPosn;
  }
}
