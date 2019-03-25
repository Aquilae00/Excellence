package cs3500.animation.model;

import java.util.ArrayList;
import java.util.function.Function;

public class Tweening implements Function<ArrayList<Transformation>, ArrayList<Transformation>> {

  @Override
  public ArrayList<Transformation> apply(ArrayList<Transformation> transformations) {
    ArrayList<Transformation> al = new ArrayList<>();
    for (Transformation t : transformations) {
      int between = t.getT2() ;
      while (between >= t.getT1()) {
        Transformation temp = new Transformation(t.getName(),between,
                this.tween(between,t.getT1(), t.getPosition1().getX(), t.getT2(), t.getPosition2().getX())  ,
                this.tween(between,t.getT1(), t.getPosition1().getY(), t.getT2(), t.getPosition2().getY()) ,
                this.tween(between, t.getT1(), t.getDimn1().getWidth(), t.getT2(), t.getDimn2().getWidth()) ,
                this.tween(between, t.getT1(), t.getDimn1().getHeight(), t.getT2(), t.getDimn2().getHeight()),
                this.tween(between, t.getT1(), t.getColor1().getRed(), t.getT2(), t.getColor2().getRed()) ,
                this.tween(between, t.getT1(), t.getColor1().getGreen(), t.getT2(), t.getColor2().getGreen()) ,
                this.tween(between, t.getT1(), t.getColor1().getBlue(), t.getT2(), t.getColor2().getBlue()));
        al.add(temp);
        between--;
      }
    }
    return al;
  }

  private int tween(int t,int t1,int a, int t2, int b) {
    if (t2 == t1) {
      return a;
    }
    return a * (t2 - t) / (t2 - t1) + b * (t - t1) / (t2 - t1);
  }
}
