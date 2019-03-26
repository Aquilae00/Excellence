package cs3500.animation.view.Panels;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.Set;

import javax.swing.*;

import cs3500.animation.model.Transformation;

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
  private JButton createTrans;
  private JLabel labelShapeName;
  private JLabel labelTick;
  private JLabel labelX;
  private JLabel labelY;
  private JLabel labelWidth;
  private JLabel labelHeight;
  private JLabel labelRed;
  private JLabel labelGreen;
  private JLabel labelBlue;
  private Map<String,String> set;
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
    addShape.setPreferredSize(new Dimension(180,50));
    this.add(addShape);

    //
    labelName = new JLabel("Name:    ");
    this.add(labelName);
    shapeName = new JTextField(10);
    this.add(shapeName);

    labelTick = new JLabel("Tick:    ");
    this.add(labelTick);
    shapeTick = new JTextField(10);
    this.add(shapeTick);

    labelX = new JLabel("X:              ");
    this.add(labelX);
    posX = new JTextField(10);
    this.add(posX);

    labelY = new JLabel("Y:");
    this.add(labelX);
    posY = new JTextField(10);
    this.add(posY);

    labelWidth = new JLabel("Width:");
    this.add(labelWidth);
    width = new JTextField(10);
    this.add(width);

    height = new JTextField(10);
    this.add(height);

    red = new JTextField(10);
    this.add(red);

    green =new JTextField(10);
    this.add(green);

    blue =new JTextField(10);
    this.add(blue);

    createTrans = new JButton("Create");
    createTrans.setActionCommand("addT");
    this.add(createTrans);
  }

  public String getShapeName() {
    return this.inputName.getText();
  }

  public String getShapeType() {
    return this.inputType.getText();
  }

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
  public void setShapeText(String s) {
    this.inputName.setText(s);
    this.inputType.setText(s);
  }

  public void setButtonListener(ActionListener clicks) {
    this.addShape.addActionListener(clicks);
    this.createTrans.addActionListener(clicks);
  }

  public void addList(String name, String type) {
    this.shapes.addElement(name + " - " + type);
  }

  public String getTShapeName() {
    return this.shapeName.getText();
  }

  public int getTShapeTick() {
    return Integer.parseInt(this.shapeTick.getText());
  }

  public Double getTPosX() {
    return Double.parseDouble(this.posX.getText());
  }
  public Double getTPosY() {
    return  Double.parseDouble(this.posY.getText());
  }

  public int getTWidth() {
    return Integer.parseInt(this.width.getText());
  }

  public int getTHeight() {
    return Integer.parseInt(this.height.getText());
  }
  public int getTRed() {
    return Integer.parseInt(this.red.getText());
  }
  public int getTGreen() {
    return Integer.parseInt(this.green.getText());
  }
  public int getTBlue() {
    return Integer.parseInt(this.blue.getText());
  }
}
