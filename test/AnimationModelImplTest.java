import org.junit.Assert;
import org.junit.Test;


import cs3500.animation.model.AnimationModel;
import cs3500.animation.model.AnimationModelImpl;

import cs3500.animation.model.position.Position2D;

/**
 * The class testing animation model.
 */
public class AnimationModelImplTest {

  @Test
  public void testAddShape() {
    AnimationModel m = new AnimationModelImpl.Builder().setBounds(0, 0, 0, 0)
            .declareShape("R", "rectangle")
            .addKeyframe("R", 1, 200, 200, 50, 100, 255, 0, 0)
            .addMotion("R", 1, 200, 200, 50, 100, 255, 0, 0,
                    10,
                    200, 200, 50, 100, 255, 0, 0)
            .build();
    m.addShape("disk4","rectangle");
    for (String s : m.getShapes().keySet()) {
      System.out.println(s);
    }
  }
  @Test
  public void testGetState() {
    AnimationModel m = new AnimationModelImpl.Builder().setBounds(0, 0, 0, 0)
            .declareShape("R", "rectangle")
            .addKeyframe("R", 1, 200, 200, 50, 100, 255, 0, 0)
            .addMotion("R", 1, 200, 200, 50, 100, 255, 0, 0,
                    10,
                    200, 200, 50, 100, 255, 0, 0)
            .build();

    Assert.assertEquals("canvas 0 0 0 0\n" +
            "shape R rectangle\n" +
            "motion R 1 200 200 50 100 255 0 0    1 200 200 50 100 255 0 0\n" +
            "motion R 1 200 200 50 100 255 0 0    10 200 200 50 100 255 0 0\n",
            m.getAnimationState());
    System.out.println(m.getAnimationState());
  }

  @Test
  public void testGetState2() {
    AnimationModel m = new AnimationModelImpl.Builder().setBounds(0, 0, 0, 0)
            .declareShape("R", "rectangle")
            .addKeyframe("R", 1, 200, 200, 50, 100, 255, 0, 0)
            .addMotion("R", 1, 200, 200, 50, 100, 255, 0, 0,
                    1,
                    200, 200, 50, 100, 255, 0, 0)
            .build();

    Assert.assertEquals("canvas 0 0 0 0\n" +
            "shape R rectangle\n" +
            "motion R 1 200 50 100 255 0 0    1 200 200 50 100 255 0 0\n" +
            "motion R 1 200 50 100 255 0 0    1 200 200 50 100 255 0 0\n", m.getAnimationState());
    System.out.println(m.getAnimationState());
  }

  // tests if shape is not running animation
  @Test
  public void testGetState3() {
    AnimationModel m = new AnimationModelImpl.Builder().setBounds(0, 0, 0, 0)
            .declareShape("R", "rectangle")
            .addKeyframe("R2", 1, 200, 200, 50, 100, 255, 0, 0)
            .addMotion("R2", 1, 200, 200, 50, 100, 255, 0, 0,
                    1,
                    200, 200, 50, 100, 255, 0, 0)
            .build();

    Assert.assertEquals("canvas 0 0 0 0\n" +
                    "shape R rectangle\n"
            , m.getAnimationState());
    System.out.println(m.getAnimationState());
  }

  // tests if no shapes are declared
  @Test
  public void testGetState4() {
    AnimationModel m = new AnimationModelImpl.Builder().setBounds(0, 0, 0, 0)
            .build();

    Assert.assertEquals("canvas 0 0 0 0\n", m.getAnimationState());
  }

  // tests if two shape works
  @Test
  public void testGetState5() {
    AnimationModel m = new AnimationModelImpl.Builder().setBounds(0, 0, 0, 0)
            .declareShape("R", "rectangle")
            .declareShape("E", "ellipse")
            .addKeyframe("R", 1, 200, 200, 50, 100, 255, 0, 0)
            .addKeyframe("E", 10, 250, 200, 10, 20, 0, 255, 0)
            .addMotion("R", 1, 200, 200, 50, 100, 255, 0, 0,
                    20,
                    200, 200, 50, 100, 255, 0, 0)
            .addMotion("E", 10, 200, 100, 10, 20,
                    255, 0, 0, 30, 200, 250, 40, 20, 0,
                    255,
                    0).build();

    Assert.assertEquals("canvas 0 0 0 0\n" +
                    "shape R rectangle\n" +
                    "motion R 1 200 50 100 255 0 0    1 200 200 50 100 255 0 0\n" +
                    "motion R 1 200 50 100 255 0 0    20 200 200 50 100 255 0 0\n" +
                    "shape E ellipse\n" +
                    "motion E 10 250 10 20 0 255 0    10 250 200 10 20 0 255 0\n" +
                    "motion E 10 200 10 20 255 0 0    30 200 250 40 20 0 255 0\n"
            , m.getAnimationState());
    System.out.println(m.getAnimationState());
  }

  // tests if there is no keyframe
  @Test
  public void testGetState6() {
    AnimationModel m = new AnimationModelImpl.Builder().setBounds(0, 0, 0, 0)
            .declareShape("R", "rectangle")
            .declareShape("E", "ellipse")
            .addMotion("R", 1, 200, 200, 50, 100, 255, 0, 0,
                    20,
                    200, 200, 50, 100, 255, 0, 0)
            .addMotion("E", 10, 200, 100, 10, 20,
                    255, 0, 0, 30, 200, 250, 40, 20, 0,
                    255,
                    0).build();

    Assert.assertEquals("canvas 0 0 0 0\n" +
                    "shape R rectangle\n" +
                    "motion R 1 200 50 100 255 0 0    20 200 200 50 100 255 0 0\n" +
                    "shape E ellipse\n" +
                    "motion E 10 200 10 20 255 0 0    30 200 250 40 20 0 255 0\n"
            , m.getAnimationState());
    System.out.println(m.getAnimationState());
  }

  // tests for overlapping time interval
  @Test(expected = IllegalArgumentException.class)
  public void testGetState7() {
    AnimationModel m = new AnimationModelImpl.Builder().setBounds(0, 0, 0, 0)
            .declareShape("R", "rectangle")
            .declareShape("E", "ellipse")
            .addKeyframe("R", 1, 200, 200, 50, 100, 255, 0, 0)
            .addKeyframe("E", 10, 250, 200, 10, 20, 0, 255, 0)
            .addMotion("R", 1, 200, 200, 50, 100, 255, 0, 0,
                    20,
                    200, 200, 50, 100, 255, 0, 0)
            .addMotion("E", 10, 200, 100, 10, 20,
                    255, 0, 0, 30, 200, 250, 40, 20, 0,
                    255,
                    0)
            .addMotion("R", 18, 200, 200, 50, 100, 255, 0, 0,
                    30,
                    200, 200, 50, 100, 255, 0, 0)
            .build();

    Assert.assertEquals("canvas 0 0 0 0\n" +
                    "shape R rectangle\n" +
                    "motion R 1 200 50 100 255 0 0    1 200 200 50 100 255 0 0\n" +
                    "motion R 1 200 50 100 255 0 0    20 200 200 50 100 255 0 0\n" +
                    "shape E ellipse\n" +
                    "motion E 10 250 10 20 0 255 0    10 250 200 10 20 0 255 0\n" +
                    "motion E 10 200 10 20 255 0 0    30 200 250 40 20 0 255 0\n"
            , m.getAnimationState());
    System.out.println(m.getAnimationState());
  }

  // tests two motions on one object
  @Test
  public void testGetState8() {
    AnimationModel m = new AnimationModelImpl.Builder().setBounds(0, 0, 0, 0)
            .declareShape("R", "rectangle")
            .declareShape("E", "ellipse")
            .addKeyframe("R", 1, 200, 200, 50, 100, 255, 0, 0)
            .addKeyframe("E", 10, 250, 200, 10, 20, 0, 255, 0)
            .addMotion("R", 1, 200, 200, 50, 100, 255, 0, 0,
                    20,
                    200, 200, 50, 100, 255, 0, 0)
            .addMotion("E", 10, 200, 100, 10, 20,
                    255, 0, 0, 30, 200, 250, 40, 20, 0, 255,
                    0)
            .addMotion("R", 20, 200, 200, 50, 100, 255, 0, 0,
                    30,
                    200, 200, 50, 100, 255, 0, 0)
            .build();

    Assert.assertEquals("canvas 0 0 0 0\n" +
                    "shape R rectangle\n" +
                    "motion R 1 200 50 100 255 0 0    1 200 200 50 100 255 0 0\n" +
                    "motion R 1 200 50 100 255 0 0    20 200 200 50 100 255 0 0\n" +
                    "motion R 20 200 50 100 255 0 0    30 200 200 50 100 255 0 0\n" +
                    "shape E ellipse\n" +
                    "motion E 10 250 10 20 0 255 0    10 250 200 10 20 0 255 0\n" +
                    "motion E 10 200 10 20 255 0 0    30 200 250 40 20 0 255 0\n"
            , m.getAnimationState());
    System.out.println(m.getAnimationState());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGetState9() {
    AnimationModel m = new AnimationModelImpl.Builder().setBounds(0, 0, -3, -3)
            .declareShape("R", "rectangle")
            .addKeyframe("R", 1, 200, 200, 50, 100, 255, 0, 0)
            .addMotion("R", 1, 200, 200, 50, 100, 255, 0, 0,
                    1,
                    200, 200, 50, 100, 255, 0, 0)
            .build();
  }


  @Test(expected = IllegalArgumentException.class)
  public void testTimeGaps() {
    AnimationModel m = new AnimationModelImpl.Builder().setBounds(0, 0, 0, 0)
            .declareShape("R", "rectangle")
            .addKeyframe("R", 1, 200, 200, 50, 100, 255, 0, 0)
            .addMotion("R", 1, 200, 200, 50, 100, 255, 0, 0,
                    10,
                    200, 200, 50, 100, 255, 0, 0)
            .addMotion("R", 11, 200, 200, 50, 100, 255, 0, 0,
                    20,
                    200, 200, 50, 100, 255, 0, 0).build();

    Assert.assertEquals("canvas 0 0 0 0\n" +
            "shape R rectangle\n" +
            "motion R 1 200 50 100 255 0 0    1 200 200 50 100 255 0 0\n" +
            "motion R 1 200 50 100 255 0 0    10 200 200 50 100 255 0 0\n", m.getAnimationState());
    System.out.println(m.getAnimationState());
  }

  @Test
  public void testGetLeftTopMostPos() {
    AnimationModel m = new AnimationModelImpl.Builder().setBounds(30, 10, 10,
            10)
            .declareShape("R", "rectangle")
            .addKeyframe("R", 1, 200, 200, 50, 100, 255, 0, 0)
            .addMotion("R", 1, 200, 200, 50, 100, 255, 0, 0,
                    10,
                    200, 200, 50, 100, 255, 0, 0)
            .addMotion("R", 10, 200, 200, 50, 100, 255, 0, 0,
                    20,
                    200, 200, 50, 100, 255, 0, 0).build();

    System.out.println(m.getLeftTopMostPosn().getX() + " " + m.getLeftTopMostPosn().getY());
    Assert.assertEquals(new Position2D(30, 10), m.getLeftTopMostPosn());
  }

  @Test
  public void testGetBoundingDimension() {
    AnimationModel m = new AnimationModelImpl.Builder().setBounds(0, 0, 10, 20)
            .declareShape("R", "rectangle")
            .addKeyframe("R", 1, 200, 200, 50, 100, 255, 0, 0)
            .addMotion("R", 1, 200, 200, 50, 100, 255, 0, 0,
                    10,
                    200, 200, 50, 100, 255, 0, 0)
            .addMotion("R", 10, 200, 200, 50, 100, 255, 0,
                    0, 20,
                    200, 200, 50, 100, 255, 0, 0).build();
    Assert.assertEquals(10, m.getBoundingDimension().getWidth());
    Assert.assertEquals(20, m.getBoundingDimension().getHeight());
  }

  @Test
  public void testGetShapes() {
    AnimationModel m = new AnimationModelImpl.Builder().setBounds(0, 0, 10, 20)
            .declareShape("R", "rectangle")
            .addKeyframe("R", 1, 200, 200, 50, 100, 255, 0, 0)
            .addMotion("R", 1, 200, 200, 50, 100, 255, 0, 0,
                    10,
                    200, 200, 50, 100, 255, 0, 0)
            .addMotion("R", 10, 200, 200, 50, 100, 255, 0,
                    0, 20,
                    200, 200, 50, 100, 255, 0, 0).build();
    Assert.assertEquals("rectangle", m.getShapes().get("R"));
  }

  @Test
  public void testGetTransformation() {
    AnimationModel m = new AnimationModelImpl.Builder().setBounds(0, 0, 10, 20)
            .declareShape("R", "rectangle")
            .addKeyframe("R", 1, 200, 200, 50, 100, 255, 0, 0)
            .addMotion("R", 1, 200, 200, 50, 100, 255, 0,
                    0, 10,
                    200, 200, 50, 100, 255, 0, 0)
            .addMotion("R", 10, 200, 200, 50, 100, 255, 0,
                    0, 20,
                    200, 200, 50, 100, 255, 0, 0).build();
    Assert.assertEquals("R",
            m.getTransformations().get(0).getName());
    Assert.assertEquals(50,
            m.getTransformations().get(0).getDimn1().getWidth());
    Assert.assertEquals(100,
            m.getTransformations().get(0).getDimn1().getHeight());
    Assert.assertEquals(200,
            m.getTransformations().get(0).getPosition1().getX());
    Assert.assertEquals(200,
            m.getTransformations().get(0).getPosition1().getY());
    Assert.assertEquals(255,
            m.getTransformations().get(0).getColor1().getRed());
    Assert.assertEquals(0,
            m.getTransformations().get(0).getColor1().getGreen());
    Assert.assertEquals(0,
            m.getTransformations().get(0).getColor1().getBlue());
  }
}
