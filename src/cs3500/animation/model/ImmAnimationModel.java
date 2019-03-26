package cs3500.animation.model;

import com.sun.org.apache.bcel.internal.generic.IREM;

import java.util.ArrayList;
import java.util.Map;

import cs3500.animation.model.dimension.Dimension2D;
import cs3500.animation.model.position.Position2D;

public final class ImmAnimationModel implements IReadOnlyModel {
  private IReadOnlyModel am;

  public ImmAnimationModel(IReadOnlyModel model) {
    this.am = model;
  }

  public ArrayList<Transformation> getTransformations() {
    return am.getTransformations();
  }


  public Dimension2D getBoundingDimension() {
    return am.getBoundingDimension();
  }

  public Map<String, String> getShapes() {
    return am.getShapes();
  }

  @Override
  public String getAnimationState() {
    return null;
  }

  public Position2D getLeftTopMostPosn() {
    return am.getLeftTopMostPosn();
  }
}
