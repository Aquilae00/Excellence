package cs3500.animation.provider.model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import cs3500.animation.model.AnimationModelImpl;
import cs3500.animation.model.IReadOnlyModel;
import cs3500.animation.provider.model.Animation;
import cs3500.animation.model.AnimationModel;

public class AnimationModelToProvider implements Animation {
  AnimationModel am;

  public AnimationModelToProvider(AnimationModel am) {
    this.am = am;
  }

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
    am.removeShape(name);
  }

  @Override
  public void addMotion(String shapeName, Keyframe start, Keyframe end) {
    // adds the initial keyframe
    am.insertTransformation(shapeName, start.getTick(), start.getFirstX(), start.getFirstY(),
            (int)start.getFirstWidth(), (int)start.getFirstHeight(),
            (int)start.getTexture().getRed(),
            (int)start.getTexture().getGreen(), (int)start.getTexture().getBlue());

    am.insertTransformation(shapeName, end.getTick(), end.getFirstX(), end.getFirstY(),
            (int)end.getFirstWidth(), (int)end.getFirstHeight(),
            (int)end.getTexture().getRed(),
            (int)end.getTexture().getGreen(), (int)end.getTexture().getBlue());
  }

  @Override
  public void addRotationless2DMotion(String shapeName, int startingTick, double x0, double y0, double w0, double h0, double r0, double g0, double b0, int endingTick, double x1, double y1, double w1, double h1, double r1, double g1, double b1) {
    am.insertTransformation(shapeName, startingTick, (int)x0, (int)y0,
            (int)w0, (int)h0, (int)r0, (int)g0, (int)b0);
    am.insertTransformation(shapeName, endingTick, (int)x1, (int)y1,
            (int)w1, (int)h1, (int)r1, (int)g1, (int)b1);
  }

//  @Override
//  public String toFile() {
//    //TODO
//
//  }

  @Override
  public int totalDuration() {
    return 0;
  }

  @Override
  public Map<String, Shape> getShapes() {
    Map<String, String> shapes = am.getShapes();
    Map<String, Shape> newShapes = new LinkedHashMap<String,Shape>();
    for (String name : shapes.keySet()) {
      Shape s = new ShapeAdapter(name,shapes.get(name));
      newShapes.put(name,s);
    }
    return newShapes;
  }
//  @Override
//  public AnimationBuilder<Animation> getBuilder() {
//    return am.getBuilder();
//  }

  @Override
  public void setBounds(int x, int y, int width, int height) {
      am.getBuilder().setBounds(x, y, width, height);
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
    List<String> ls;
    return null;
  }
}
