import org.junit.Test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import cs3500.animation.model.AnimationModel;
import cs3500.animation.model.AnimationModelImpl;
import cs3500.animation.view.EnhancedVisualView;

import static org.junit.Assert.assertEquals;

public class ShapeTest {

  private void initData() {
    AnimationModel m = new AnimationModelImpl.Builder().setBounds(0, 0, 10, 20)
            .declareShape("R", "rectangle")
            .addKeyframe("R", 1, 200, 200, 50, 100, 255, 0, 0)
            .addMotion("R", 1, 200, 200, 50, 100, 255, 0, 0,
                    10,
                    200, 200, 50, 100, 255, 0, 0).build();
    EnhancedVisualView evv = new EnhancedVisualView(m, 1);

  }

  @Test
  public void testEventListener() {
    ActionListener subjectUnderTest = new MyActionListener();
    ActionEvent mockEvent = mock(ActionEvent.class);
    // Or just create a new ActionEvent, e.g. new ActionEvent();
    // setup mock

    subjectUnderTest.actionPerformed(mockEvent);

    // validate
  }

  //create shape
//  @Test
//  public void testCreateShape() {
//    AnimationModel m = new AnimationModelImpl.Builder().setBounds(0, 0, 10, 20)
//            .declareShape("R", "rectangle")
//            .addKeyframe("R", 1, 200, 200, 50, 100, 255, 0, 0)
//            .addMotion("R", 1, 200, 200, 50, 100, 255, 0, 0,
//                    10,
//                    200, 200, 50, 100, 255, 0, 0).build();
//    EnhancedVisualView evv = new EnhancedVisualView(m, 1);
//    evv.createShape("E", "Ellipse");
//
//    assertEquals("rectangle", evv.getModel().getShapes().get("R"));
//  }

 // test if weird string is stored
//  @Test (expected = IllegalArgumentException.class)
//  public void testCreateShape2() {
//    AnimationModel m = new AnimationModelImpl.Builder().setBounds(0, 0, 10, 20)
//            .declareShape("R", "rectangle")
//            .addKeyframe("R", 1, 200, 200, 50, 100, 255, 0, 0)
//            .addMotion("R", 1, 200, 200, 50, 100, 255, 0, 0,
//                    10,
//                    200, 200, 50, 100, 255, 0, 0).build();
//    EnhancedVisualView evv = new EnhancedVisualView(m, 1);
//    evv.createShape("E", "rectancircularectangle");
//
//    assertEquals("rectangle", evv.getModel().getShapes().get("R"));
//  }
  // delete shape
  @Test
//  public void testDeleteShape() {
//    AnimationModel m = new AnimationModelImpl.Builder().setBounds(0, 0, 10, 20)
//            .declareShape("R", "rectangle")
//            .addKeyframe("R", 1, 200, 200, 50, 100, 255, 0, 0)
//            .addMotion("R", 1, 200, 200, 50, 100, 255, 0, 0,
//                    10,
//                    200, 200, 50, 100, 255, 0, 0).build();
//
//    EnhancedVisualView evv = new EnhancedVisualView(m, 1);
//    evv.createShape("E", "ellipse");
//
//    evv.deleteShape("R");
//    assertEquals(null, m.getShapes().get("R"));
//    assertEquals("ellipse", m.getShapes().get("E"));
//  }



}

