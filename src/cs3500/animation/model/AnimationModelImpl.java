package cs3500.animation.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import cs3500.animation.model.animator.util.AnimationBuilder;
import cs3500.animation.model.dimension.Dimension2D;
import cs3500.animation.model.position.Position2D;

/**
 * The Class implementation of AnimationModel. A class that represents a model of animation, that
 * records the history of transformations, shapes, the bounding box of canvas.
 */
public class AnimationModelImpl implements AnimationModel {
  private Position2D leftTopMostPosn;
  private Dimension2D boundingDimension;
  private Map<String, String> shapes;
  private ArrayList<Transformation> transforms;

  /**
   * The animationmodelimpl that is constructed with builder.
   *
   * @param b the given builder
   */
  public AnimationModelImpl(Builder b) {
    this.shapes = b.shapes;
    this.leftTopMostPosn = new Position2D(b.x, b.y);
    this.boundingDimension = new Dimension2D(b.width, b.height);
    this.transforms = b.transforms;
  }

  @Override
  public String getAnimationState() {
    //   After each animate act, adds a new line. After each log of shape, adds a new line for the
    //   following shape.
    StringBuilder s = new StringBuilder();

    s.append("canvas" + " " + this.leftTopMostPosn.getX() + " " + this.leftTopMostPosn.getY()
            + " " + this.boundingDimension.getWidth() + " " + this.boundingDimension.getHeight()
            + "\n");

    for (String name : this.shapes.keySet()) {
      s.append("shape" + " " + name + " " + this.shapes.get(name) + "\n");
      for (Transformation t : this.transforms) {
        if (t.getName().equals(name)) {
          s.append("motion" + " " +
                  name + " " + t.getT1() + " " + t.getPosition1().getX() + " "
                  + t.getPosition1().getY() + " "
                  + t.getDimn1().getWidth() + " " + t.getDimn1().getHeight() + " "
                  + t.getColor1().getRed() + " " + t.getColor1().getGreen() + " "
                  + t.getColor1().getBlue()
                  + "    "
                  + t.getT2() + " " + t.getPosition2().getX()
                  + " " + t.getPosition2().getY() + " " +
                  +t.getDimn2().getWidth() + " " + t.getDimn2().getHeight() + " "
                  + t.getColor2().getRed() + " " + t.getColor2().getGreen() + " "
                  + t.getColor2().getBlue() +
                  "\n");
        }
      }
    }
    return s.toString();
  }

  @Override
  public Position2D getLeftTopMostPosn() {
    return this.leftTopMostPosn;
  }

  @Override
  public Dimension2D getBoundingDimension() {
    return this.boundingDimension;
  }

  @Override
  public Map<String, String> getShapes() {
    return this.shapes;
  }

  @Override
  public ArrayList<Transformation> getTransformations() {
    return this.transforms;
  }

  @Override
  public void setTransformations(ArrayList<Transformation> transformations) {
    this.transforms = transformations;
  }

  @Override
  public void addShape(String name, String type) {
    this.shapes.put(name, type);
  }

  @Override
  public void deleteTransformation(String name, int t1, double x1,
                                   double y1, int w1, int h1, int r1, int g1, int b1) {
    Iterator<Transformation> iter = transforms.iterator();
    while (iter.hasNext()) {
      Transformation t = iter.next();
      if (t.getName().equals(name) && t.getT1() == t1 && t.getPosition1().getX() == x1
              && t.getPosition1().getY() == y1 && t.getDimn1().getWidth() == w1
              && t.getDimn1().getHeight() == h1 && t.getColor1().getRed() == r1
              && t.getColor1().getGreen() == g1 && t.getColor1().getBlue() == b1) {
        iter.remove();
      }
    }
  }

  @Override
  public void insertTransformation(String name, int t1, double x1,
                                   double y1, int w1, int h1, int r1, int g1, int b1) {
    Transformation temp = new Transformation(name, t1, x1, y1, w1, h1, r1, g1, b1);
    if (!this.transforms.add(temp)) {
      throw new IllegalArgumentException("Keyframe Not Found");
    }
  }


  /**
   * The builder that builds up the animation using methods provided by the AnimationBuilder
   * interface. Each method call can be followed by another method call, constructing a final
   * document to the last, and build it.
   */
  public static class Builder implements AnimationBuilder<AnimationModel> {
    private int x;
    private int y;
    private int width;
    private int height;

    private Map<String, String> shapes = new LinkedHashMap<>();
    private ArrayList<Transformation> transforms = new ArrayList<>();
    private Map<String, Integer> endTicks = new LinkedHashMap<>();

    @Override
    public AnimationModel build() {
      return new AnimationModelImpl(this);
    }

    @Override
    public AnimationBuilder<AnimationModel> setBounds(int x, int y, int width, int height) {
      this.x = x;
      this.y = y;
      this.width = width;
      this.height = height;
      // set bound in the view
      return this;
    }

    @Override
    public AnimationBuilder<AnimationModel> declareShape(String name, String type) {
      shapes.put(name, type);
      return this;
    }

    @Override
    public AnimationBuilder<AnimationModel> addMotion(String name, int t1, int x1,
                                                      int y1, int w1, int h1, int r1,
                                                      int g1, int b1, int t2, int x2,
                                                      int y2, int w2, int h2,
                                                      int r2, int g2, int b2) {
      for (Transformation t : transforms) {
        if (t.getName().equals(name) && t1 != endTicks.get(name)) {
          throw new IllegalArgumentException("cannot have time gaps");
        }

      }
      this.endTicks.put(name, t2);
      this.transforms.add(new Transformation(name, t1, x1, y1, w1, h1, r1, g1, b1,
              t2, x2, y2, w2, h2, r2, g2, b2));
      return this;
    }

    @Override
    public AnimationBuilder<AnimationModel> addKeyframe(String name, int t, int x, int y, int w,
                                                        int h, int r, int g, int b) {
      this.endTicks.put(name, t);
      this.transforms.add(new Transformation(name, t, x, y, w, h, r, g, b));
      return this;
    }


  }
}




