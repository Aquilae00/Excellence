package cs3500.animation.provider.model;

import java.util.List;
import java.util.Map;

import cs3500.animation.provider.model.Animation;
import cs3500.animation.model.AnimationModel;

public class AnimationModelToProvider implements Animation {
  AnimationModel am;


  @Override
  public int getX() {
    return am.getLeftTopMostPosn().getX();
  }

  @Override
  public int getY() {
    return am.getLeftTopMostPosn().getY();
  }

  @Override
  public void addShape(String name, String type) {
    am.addShape(name,type);
  }

  @Override
  public void removeShape(String name) {
  }

  @Override
  public void addMotion(String shapeName, Keyframe start, Keyframe end) {

  }

  @Override
  public void addRotationless2DMotion(String shapeName, int startingTick, double x0, double y0, double w0, double h0, double r0, double g0, double b0, int endingTick, double x1, double y1, double w1, double h1, double r1, double g1, double b1) {

  }

  @Override
  public String toFile() {
    return null;
  }

  @Override
  public int totalDuration() {
    return 0;
  }

  @Override
  public Map<String, Shape> getShapes() {
    return null;
  }

  @Override
  public AnimationBuilder<Animation> getBuilder() {
    return null;
  }

  @Override
  public void setBounds(int x, int y, int width, int height) {

  }

  @Override
  public int getCanvasWidth() {
    return 0;
  }

  @Override
  public int getCanvasHeight() {
    return 0;
  }

  @Override
  public List<String> getShapeNames() {
    return null;
  }
}
