package cs3500.animation.provider.model;

import java.awt.*;
import java.lang.reflect.Array;
import java.security.Key;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cs3500.animation.model.Transformation;
import cs3500.animation.model.position.Position2D;
import cs3500.animation.provider.model.qualities.color.ColorToTexture;
import cs3500.animation.provider.model.qualities.color.Texture;
import cs3500.animation.provider.model.qualities.dimensions.Dimension2DToSize;
import cs3500.animation.provider.model.qualities.dimensions.Size;
import cs3500.animation.provider.model.qualities.positions.Position;
import cs3500.animation.provider.model.qualities.positions.Position2DToPosition;

/**
 * An adapter class for Shapes. This Shape class that represents shape in Animation requires
 * new implementation of class, since our original code used Map as shapes name and type
 * representation.
 */
public class ShapeAdapter implements Shape {
  String name;
  String type;
  ArrayList<Motion> m;
  ArrayList<Transformation> transformations;


  public ShapeAdapter(String name, String type, ArrayList<Transformation> t){
    this.name = name;
    this.type = type;
    this.transformations = t;
    this.m = convertTToMotion();
  }

  private ArrayList<Motion> convertTToMotion() {
    ArrayList<Motion> mot = new ArrayList<>();
    for (Transformation t : transformations) {
      Transformation t1 = new Transformation(t.getName(),t.getT1(),t.getPosition1().getX(),
              t.getPosition1().getY(),t.getDimn1().getWidth(),t.getDimn1().getHeight(),
              t.getColor1().getRed(),t.getColor1().getGreen(),t.getColor1().getBlue());
      Transformation t2 = new Transformation(t.getName(),t.getT2(),t.getPosition2().getX(),
              t.getPosition2().getY(),t.getDimn2().getWidth(),t.getDimn2().getHeight(),
              t.getColor2().getRed(),t.getColor2().getGreen(),t.getColor2().getBlue());
      mot.add(new TransformationToMotion(new TransformationToKeyframe(t1),
              new TransformationToKeyframe(t2)));
    }
    return mot;
  }


  @Override
  public String getName() {
    return name;
  }

  @Override
  public String getShape() {
    return type;
  }

  @Override
  public String toFile() {
    return null;
  }

  @Override
  public void addMotion(Motion m) {
    this.m.add(m);
  }

  @Override
  public int totalDuration() {
    int lowest = 99999;
    int highest = 0;
      for(Motion m: this.m) {
        // if each
        if(m.getEndFrame().getTick() > highest) {
          highest = m.getEndFrame().getTick();
        }
        if(m.getFirstTick() < lowest) {
          lowest = m.getFirstTick();
        }
      }
    return highest - lowest;
  }

  @Override
  public double getFirstX() {
    return 0;
  }

  @Override
  public double getFirstY() {
    return 0;
  }

  @Override
  public double getFirstWidth() {
    return 0;
  }

  @Override
  public double getFirstHeight() {
    return 0;
  }

  @Override
  public String getFirstColors() {
    return null;
  }

  @Override
  public int getFirstTick() {
    int beginning = 999;
    for(Transformation t: transformations) {
      if(t.getT1() < beginning) {
        beginning = t.getT1();
      }
    }
    return beginning;
  }

  @Override
  public List<Motion> getMotions() {
    return m;
  }

  @Override
  public Texture getColorAt(int currentTick) {
    Texture text = null;
    for (Transformation t : transformations) {
      if (t.getT1() == currentTick) {
        text = new ColorToTexture(new Color(t.getColor1().getRed(),t.getColor1().getGreen(),t.getColor1().getBlue()));
      }
    }
    return text;
  }

  @Override
  public Position getPositionAt(int currentTick) {
    Position pos = null;
    for (Transformation t : transformations) {
      if (t.getT1() == currentTick) {
        pos = new Position2DToPosition(t.getPosition1());
      }
    }
    return pos;
  }

  @Override
  public Size getSizeAt(int currentTick) {
    Size size = null;
    for (Transformation t : transformations) {
      if (t.getT1() == currentTick) {
        size = new Dimension2DToSize(t.getDimn1());
      }
    }
    return size;
  }
}
