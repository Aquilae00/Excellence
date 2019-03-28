package cs3500.animation.view.Panels;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import javax.swing.*;

import cs3500.animation.model.Transformation;

/**
 * The class designed for menu in User Interface.
 */
public class MenuPanel extends JPanel {
  private Dimension borderDim;
  private DefaultListModel<String> shapes;
  private JList los;
  private JLabel labelName;
  private JLabel lablelInputType;
  private JLabel lableInputName;
  private JTextField inputName;
  private JTextField inputType;
  private JButton addShape;
  private JButton deleteButton;
  private JScrollPane scroll;
  private JTextField shapeName;
  private JTextField shapeTick;
  private JTextField posX;
  private JTextField posY;
  private JTextField width;
  private JTextField height;
  private JTextField red;
  private JTextField green;
  private JTextField blue;
  private JLabel labelTick;
  private JLabel labelX;
  private JLabel labelY;
  private JLabel labelWidth;
  private JLabel labelHeight;
  private JLabel labelRed;
  private JLabel labelGreen;
  private JLabel labelBlue;
  private JButton createTrans;
  private JButton deleteTrans;
  private Map<String,String> set;

  /**
   * Menupanel that is constructed with map of string.
   *
   * @param set the set of strings
   */
  public MenuPanel(Map<String,String> set) {
    this.set = set;

    borderDim = new Dimension(200,200);
    this.setPreferredSize(borderDim);
    this.setLayout(new FlowLayout());

    //Label names
    labelName = new JLabel("Shapes Names: ");
    labelName.setBounds(30,0,100,20);
    this.add(labelName);


    //list the shape names
    shapes = new DefaultListModel<String>();
    for (String s : this.set.keySet()) {
      shapes.addElement(s + " - " + set.get(s));
    }
    this.los = new JList(shapes);
    los.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
    los.setSelectedIndex(0);
    los.setVisibleRowCount(5);
    los.setPreferredSize(new Dimension(180,100));
    this.add(los);

    //add scroll
    scroll = new JScrollPane(los);
    scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    this.add(scroll);

    //label input
    lableInputName = new JLabel("Name: ");
    this.add(lableInputName);
    //input of shape name
    inputName = new JTextField(10);
    this.add(inputName);

    //type label input
    this.lablelInputType = new JLabel("Type:  ");
    this.add(lablelInputType);
    //input of shape type
    inputType = new JTextField(10);
    this.add(inputType);

    //create shape button
    addShape = new JButton("Create Shape");
    addShape.setActionCommand("Create");
    this.add(addShape);
    // add delete button
    deleteButton = new JButton("Delete");
    deleteButton.setActionCommand("Delete");
    this.add(deleteButton);

    //
    labelName = new JLabel("Name:    ");
    this.add(labelName);
    shapeName = new JTextField(10);
    this.add(shapeName);

    labelTick = new JLabel("Tick:     ");
    this.add(labelTick);
    shapeTick = new JTextField(10);
    this.add(shapeTick);

    labelX = new JLabel("X:           ");
    this.add(labelX);
    posX = new JTextField(10);
    this.add(posX);

    labelY = new JLabel("Y:           ");
    this.add(labelY);
    posY = new JTextField(10);
    this.add(posY);

    labelWidth = new JLabel("Width: ");
    this.add(labelWidth);
    width = new JTextField(10);
    this.add(width);

    labelHeight = new JLabel("Height: ");
    this.add(labelHeight);
    height = new JTextField(10);
    this.add(height);

    labelRed = new JLabel("Red:    ");
    this.add(labelRed);
    red = new JTextField(10);
    this.add(red);

    labelGreen = new JLabel("Green:  ");
    this.add(labelGreen);
    green =new JTextField(10);
    this.add(green);

    labelBlue = new JLabel("Blue: ");
    this.add(labelBlue);
    blue =new JTextField(10);
    this.add(blue);

    createTrans = new JButton("Create");
    createTrans.setActionCommand("addT");
    this.add(createTrans);

    deleteTrans = new JButton("Delete");
    deleteTrans.setActionCommand("delT");
    this.add(deleteTrans);
  }

  /**
   * It gets the name of the shape.
   *
   * @return name of shape
   */
  public String getShapeName() {
    return this.inputName.getText();
  }

  /**
   * It gets the type of the shape.
   *
   * @return type of shape.
   */
  public String getShapeType() {
    return this.inputType.getText();
  }

  /**
   * It gets the field of the transformation
   *
   * @return
   */
  public String getTransformationFields() {
    StringBuilder temp = new StringBuilder();
    temp.append(shapeName.getText())
            .append(" ").append(shapeTick.getText())
            .append(" ").append(posX.getText())
            .append(" ").append(posY.getText())
            .append(" ").append(width.getText())
            .append(" ").append(height.getText())
            .append(" ").append(red.getText())
            .append(" ").append(green.getText())
            .append(" ").append(blue.getText());
    return temp.toString();
  }

  /**
   * It sets the text of the shape by given string.
   *
   * @param s the text of shape
   */
  public void setShapeText(String s) {
    this.inputName.setText(s);
    this.inputType.setText(s);
  }

  /**
   * It sets the role of each button.
   *
   * @param clicks on mouse click
   */
  public void setButtonListener(ActionListener clicks) {
    this.addShape.addActionListener(clicks);
    this.createTrans.addActionListener(clicks);
    this.deleteTrans.addActionListener(clicks);
    this.deleteButton.addActionListener(clicks);
  }

  /**
   * It adds one element with given type and name to the list.
   *
   * @param name the name of shape
   * @param type the type of shape
   */
  public void addList(String name, String type) {
    this.shapes.addElement(name + " - " + type);
  }

  public void removeList(String name,String type) {
    String element = name + " - " + type;
    if (this.shapes.contains(element)) {
      this.shapes.removeElement(element);
    }
  }
  /**
   * It gets the text shape name.
   *
   * @return text shape name
   */
  public String getTShapeName() {
    return this.shapeName.getText();
  }

  /**
   * It gets the text shape tick.
   *
   * @return text shape tick
   */
  public int getTShapeTick() {
    return Integer.parseInt(this.shapeTick.getText());
  }

  /**
   * It gets the text position x.
   *
   * @return text position x
   */
  public Double getTPosX() {
    return Double.parseDouble(this.posX.getText());
  }

  /**
   * It gets the text position y.
   *
   * @return text position y
   */
  public Double getTPosY() {
    return  Double.parseDouble(this.posY.getText());
  }

  /**
   * It gets the text width.
   *
   * @return text width
   */
  public int getTWidth() {
    return Integer.parseInt(this.width.getText());
  }

  /**
   * It gets the text height.
   *
   * @return text height
   */
  public int getTHeight() {
    return Integer.parseInt(this.height.getText());
  }

  /**
   * It gets the text red color.
   *
   * @return text red color
   */
  public int getTRed() {
    return Integer.parseInt(this.red.getText());
  }

  /**
   * It gets the text green color.
   *
   * @return text green color
   */
  public int getTGreen() {
    return Integer.parseInt(this.green.getText());
  }

  /**
   * It gets the text blue color.
   *
   * @return text blue color
   */
  public int getTBlue() {
    return Integer.parseInt(this.blue.getText());
  }

  public void clearTransField(String s) {
    this.shapeName.setText(s);
    this.shapeTick.setText(s);
    this.posX.setText(s);
    this.posY.setText(s);
    this.width.setText(s);
    this.height.setText(s);
    this.red.setText(s);
    this.green.setText(s);
    this.blue.setText(s);
  }
}
