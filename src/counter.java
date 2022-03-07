import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class counter extends JPanel implements ActionListener {
  // number of clicks
  static public int clicks = 0;
  static private JLabel label;
  static private JPanel panel;
  static private JFrame frame;
  static private JButton button;
  static private JButton decrement;
  static private BufferedImage myPicture;
  Object firstButton = null;
  public counter() {
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
    // add image
	try {
		myPicture = ImageIO.read(new File("C:\\Users\\JuJuR\\Documents\\swingProjects\\guiPractice\\src\\javaLogo.jpg"));
		System.out.println(myPicture);
	    /* picLabel.setLocation(20, 20);
	    picLabel.setSize(40, 40); */
	} catch (IOException e) {
		// TODO Auto-generated catch block
		System.out.println(e);
	}
    // add window to frame
    frame.add(panel);
    // default setup shit lol
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("Counter app");
    // save
	frame.pack();
	frame.setSize(400, 400);
    panel.setBackground(new Color(168, 202, 255));
    frame.setVisible(true);
  }
  
  // define a method to save
  public static void refresh() {
	  int frameX = frame.getWidth();
	  int frameY = frame.getHeight();
	  frame.pack();
	  frame.setSize(400, 400);
	  panel.setBackground(new Color(168, 202, 255));
	  frame.setVisible(true);
  }
  // define a method to get frame size
  public static Dimension getFrameSize() {
	  return frame.getSize();
  }

  public static void main(String[] args) {
    // call constructor
    new counter();
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
  }
}
