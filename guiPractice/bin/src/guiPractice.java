import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;

public class guiPractice implements ActionListener {
  // number of clicks
  static public int clicks = 0;
  static private JLabel label;
  static private JLabel label2;
  static private JPanel panel;
  static private JFrame frame;
  static private JButton button;
  static private JButton decrement;
  Object firstButton = null;
  public guiPractice() {
    label = new JLabel("Number of clicks: 0");
    button = new JButton("Increment");
    decrement = new JButton("Decrement");    
    panel = new JPanel();
    frame = new JFrame(); 
    // setup click event
    button.addActionListener(this);
    decrement.addActionListener(this);
    // make it so you can specify size and location of objects
    panel.setLayout(null);
    // add button to screen
    panel.add( button );
    button.setLocation(200, 160);
    button.setSize(100, 30);
    // add decrement button
    panel.add(decrement);
    decrement.setSize(100, 30);
    decrement.setLocation(200, 200);
    
    // add text to screen
    frame.add(label);
    label.setLocation(200, 230);
    label.setSize(200, 20);
    // add window to frame
    frame.add(panel);
    // default setup shit lol
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("My first gui");
    // save
	frame.pack();
	frame.setSize(400, 400);
    panel.setBackground(Color.yellow);
    frame.setVisible(true);
  }
  
  // define a method to save
  public static void refresh() {
	  int frameX = frame.getWidth();
	  int frameY = frame.getHeight();
	  frame.pack();
	  frame.setSize(400, 400);
	  panel.setBackground(Color.yellow);
	  frame.setVisible(true);
  }
  // define a method to get frame size
  public static Dimension getFrameSize() {
	  return frame.getSize();
  }

  public static void main(String[] args) {
    // call constructor
    new guiPractice();
    getFrameSize();  
    // move items to center of window and resize them
    while (true) {
      int x = (int)getFrameSize().getWidth() / 2;
      int y = (int)getFrameSize().getHeight() / 2;
      button.setLocation(x - 50, y - 40);
      decrement.setLocation(x - 50, y);
      label.setLocation(x - 50, y + 30);
	  getFrameSize();
    }
  }

  // on click event
  @Override
  public void actionPerformed(ActionEvent e) {  
	// find out which button is pressed
	if (e.getSource() == button) {
	    clicks++;
	} else if (e.getSource() == decrement) {
		clicks--;
	}
    label.setText("Number of clicks: " + clicks);
	// negative clicks
	if (clicks <= -1) {
	  System.out.println("Yay");
	  label2 = new JLabel("How did you do that?!");
	  frame.add(label2);
	  label2.setLocation(10, 10);
	  label2.setSize(200, 20);
	  refresh();
	}
  }
}