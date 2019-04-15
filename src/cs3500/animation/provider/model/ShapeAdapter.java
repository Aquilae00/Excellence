package cs3500.animation.provider.model;

import java.util.List;
import java.util.Map;

import cs3500.animation.model.Transformation;
import cs3500.animation.provider.model.qualities.color.Texture;
import cs3500.animation.provider.model.qualities.dimensions.Size;
import cs3500.animation.provider.model.qualities.positions.Position;

public class ShapeAdapter implements Shape {
  String name;
  String type;
  Motion m;


  public ShapeAdapter(String name, String type){
    this.name = name;
    this.type = type;
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

  }

  @Override
  public int totalDuration() {
    return 0;
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
    return 0;
  }

  @Override
  public List<Motion> getMotions() {
    return null;
  }

  @Override
  public Texture getColorAt(int currentTick) {
    return null;
  }

  @Override
  public Position getPositionAt(int currentTick) {
    return null;
  }

  @Override
  public Size getSizeAt(int currentTick) {
    return null;
  }
}
