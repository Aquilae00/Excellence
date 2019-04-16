package cs3500.animation.view.panels;


import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.Map;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.ScrollPaneConstants;
import javax.swing.ListSelectionModel;

/**
 * The class designed for menu in User Interface.
 */
public class MenuPanel extends JPanel {

  private DefaultListModel<String> shapes;
  private JTextField inputName;
  private JTextField inputType;
  private JButton addShape;
  private JButton deleteButton;
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
  private JButton deleteTrans;

  /**
   * Menupanel that is constructed with map of string.
   *
   * @param set the set of strings
   */
  public MenuPanel(Map<String, String> set) {
    JLabel lableInputName;
    Dimension borderDim;
    JList los;
    JLabel labelName;
    JLabel lablelInputType;
    JScrollPane scroll;
    JLabel keyframeMenuLabel;
    JLabel labelTick;
    JLabel labelX;
    JLabel labelY;
    JLabel labelWidth;
    JLabel labelHeight;
    JLabel labelRed;
    JLabel labelGreen;
    JLabel labelBlue;

    borderDim = new Dimension(200, 200);
    this.setPreferredSize(borderDim);
    this.setLayout(new FlowLayout());

    //Label names
    labelName = new JLabel("Shapes Names: ");
    labelName.setBounds(30, 0, 100, 20);
    this.add(labelName);

    //add scroll
    scroll = new JScrollPane();

    scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    scroll.setPreferredSize(new Dimension(180, 100));
    this.add(scroll);

    //list the shape names
    shapes = new DefaultListModel<String>();
    for (String s : set.keySet()) {
      shapes.addElement(s);
    }
    los = new JList(shapes);
    los.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
    los.setSelectedIndex(0);
    los.setVisibleRowCount(5);
    scroll.setViewportView(los);


    //label input
    lableInputName = new JLabel("Name:      ");
    this.add(lableInputName);
    //input of shape name
    inputName = new JTextField(10);
    this.add(inputName);

    //type label input
    lablelInputType = new JLabel("Type:  ");
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

    //label the keyframe menu
    keyframeMenuLabel = new JLabel("- Keyframe Modification Menu -");
    this.add(keyframeMenuLabel);

    //shape name input space
    labelName = new JLabel("Name:    ");
    this.add(labelName);
    shapeName = new JTextField(10);
    this.add(shapeName);

    //shape tick input
    labelTick = new JLabel("Tick:     ");
    this.add(labelTick);
    shapeTick = new JTextField(10);
    this.add(shapeTick);

    //x coord input
    labelX = new JLabel("X:           ");
    this.add(labelX);
    posX = new JTextField(10);
    this.add(posX);

    //y coord input
    labelY = new JLabel("Y:           ");
    this.add(labelY);
    posY = new JTextField(10);
    this.add(posY);

    //shape width input
    labelWidth = new JLabel("Width: ");
    this.add(labelWidth);
    width = new JTextField(10);
    this.add(width);

    //shape height input
    labelHeight = new JLabel("Height: ");
    this.add(labelHeight);
    height = new JTextField(10);
    this.add(height);

    //red input
    labelRed = new JLabel("Red:    ");
    this.add(labelRed);
    red = new JTextField(10);
    this.add(red);

    //green input
    labelGreen = new JLabel("Green:      ");
    this.add(labelGreen);
    green = new JTextField(10);
    this.add(green);

    //blue input
    labelBlue = new JLabel("Blue:      ");
    this.add(labelBlue);
    blue = new JTextField(10);
    this.add(blue);

    //create keyframe button
    createTrans = new JButton("Create");
    createTrans.setActionCommand("addT");
    this.add(createTrans);

    //delete keyframe button
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
   * It gets the field of the transformation.
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
  public void setShapeNameText(String s) {
    this.inputName.setText(s);
  }

  /**
   * Sets the type of the input JTextfield.
   *
   * @param s the type as string
   */
  public void setShapeTypeText(String s) {
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
   * It adds one element with given and name to the list.
   *
   * @param name the name of shape
   */
  public void addList(String name) {
    this.shapes.addElement(name);
  }

  /**
   * It removes the element with given name.
   *
   * @param name name of shape
   */
  public void removeList(String name) {
    String element = name;
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
    return Double.parseDouble(this.posY.getText());
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

  /**
   * It sets the text of the transformation field with the given string.
   *
   * @param s string that clears all field
   */
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
