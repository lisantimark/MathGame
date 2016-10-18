
import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Class will create a GUI frame that accepts user input
 * in the for of a string. GUI will show the most immediate previous 
 * name inputed by the user.
 */
public class UserInput extends JFrame implements ActionListener, KeyListener
{
 String lastString;
 private Label textFieldLabel; 
 private TextField textField;  
 private Button enterButton;  
 private TextField displayName; 

 public UserInput()
 {
  // initializes textFieldLabel and sets value
  textFieldLabel = new Label("Enter: ");
  
  // initializes TextField, sets initial value, and sets size.
  // allows user to edit value
  textField = new TextField("", 30);
  textField.setEnabled(true);
  
  // Adds KeyListener to listen for Enter key when textField component
  // is selected.
  textField.addKeyListener(this);
  
  // initializes enterButton and adds actionListener
  enterButton = new Button("Enter");
  enterButton.addActionListener(this);
  
  // declares displayName, sets initial value, and sets size.
  // prevents user from editing displayName TextField
  displayName = new TextField("", 30);
  displayName.setEditable(false);
  
  // declares and initializes JPanels for frame
  JPanel first = new JPanel();
  JPanel second = new JPanel();
  JPanel third = new JPanel();
  
  // Adds components to appropriate JPanels
  first.add(textFieldLabel);
  first.add(textField);
  second.add(enterButton);
  third.add(displayName);
  
  // Adds JPanels to frame in appropriate order
  add(first);
  add(second);
  add(third);
  
  //packs frame and sets visibility. 
  pack();
  setVisible(true);
 }
 
 @Override
 public void actionPerformed(ActionEvent e)
 {
  // changes the text of displayName to what
  // the text in textField is.
  displayName.setText(textField.getText());
 }
 
 @Override
 public void keyPressed(KeyEvent k)
 {
  int keyCode = k.getKeyCode();
  
  if (keyCode == KeyEvent.VK_ENTER)
  {
   displayName.setText(textField.getText());
  }
 }
 
 @Override
 public void keyTyped(KeyEvent k)
 {
  // Nothing
 }
 @Override
 public void keyReleased(KeyEvent k)
 {
  // Nothing
 }

 public static void main(String[] args)
 {
  new UserInput();
 }
}
