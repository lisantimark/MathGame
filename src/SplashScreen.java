
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SplashScreen extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame f = new JFrame();
	JPanel bp = new JPanel();
	JButton b1 = new JButton("Image 1");
	JButton b2 = new JButton("Image 2");
	JButton b3 = new JButton("Image 3");
	JButton b4 = new JButton("4 Problems");
	JButton b5 = new JButton("9 Problems");
	JButton b6 = new JButton("16 Problems");
	JButton b7 = new JButton("Add");
	JButton b8 = new JButton("Subtract");
	JButton b9 = new JButton("Multiply");
	JButton b10 = new JButton("Divide");
	JButton b12 = new JButton("START");
	JLabel images = new JLabel("PICK YOUR IMAGE!");
	JLabel problems = new JLabel("PICK YOUR PROBLEM NUMBER!");
	JLabel operator = new JLabel("PICK YOUR OPERATOR!");
	JLabel family = new JLabel("TYPE YOUR NUMBER FAMILY (1-12)!");
	JTextField inputField = new JTextField(10);
	
	public SplashScreen()  {
		f.setTitle("SET UP YOUR GAME AND STUFF COOL");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(425, 600);
		Dimension d = new Dimension(110, 25);

		bp.setLayout(null);
		images.setSize(d);
		images.setLocation(150,20);
		b1.setSize(d);
		b1.setLocation(150, 50);
		b2.setSize(d);
		b2.setLocation(150, 85);
		b3.setSize(d);
		b3.setLocation(150, 120);
		problems.setSize(300, 25);
		problems.setLocation(119,150);
		b4.setSize(d);
		b4.setLocation(150, 185);
		b5.setSize(d);
		b5.setLocation(150, 220);
		b6.setSize(d);
		b6.setLocation(150, 55);
		operator.setSize(150, 25);
		operator.setLocation(140,250);
		b7.setSize(d);
		b7.setLocation(150, 285);
		b8.setSize(d);
		b8.setLocation(150, 320);
		b9.setSize(d);
		b9.setLocation(150, 355);
		b10.setSize(d);
		b10.setLocation(150, 390);
		family.setSize(200, 25);
		family.setLocation(110,420);
		b12.setSize(110, 40);
		b12.setLocation(150, 500);
		inputField.setSize(d);
		inputField.setLocation(150, 455);
		bp.add(problems);
		bp.add(operator);
		bp.add(images);
		bp.add(family);
		bp.add(inputField);
		bp.add(b1);
		bp.add(b2);
		bp.add(b3);
		bp.add(b4);
		bp.add(b5);
		bp.add(b6);
		bp.add(b7);
		bp.add(b8);
		bp.add(b9);
		bp.add(b10);
		bp.add(b12);

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		b10.addActionListener(this);
		b12.addActionListener(this);
		// f.pack();
		f.add(bp);
		f.setVisible(true);
	}

	public static void main(String[] args) {
		new SplashScreen();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {

		}
	}

}