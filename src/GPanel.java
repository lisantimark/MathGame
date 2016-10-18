/**
 * 
 */

import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import hw6_group.GPanel;

/**
 * @author owmner
 *
 */
public class GPanel extends JPanel implements MouseListener {
	private Image img;
	private boolean answered;
	private int w;
	private int h;
	private int state = 0;
	private TextField textField;
	private Label textFieldLabel;
	private JPanel p;
	private JButton b1 = new JButton("Submit Answer");
	private JTextField tf = new JTextField(10);

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GPanel(Image img) {
		this.img = img;
		w = img.getWidth(this);
		h = img.getHeight(this);
		setPreferredSize(new Dimension(w, h));
		answered = false;
		addMouseListener(this);
		p = new JPanel();
	}

	public void setAnswered() {
		answered = true;
	}

	public boolean getAnswered() {
		return answered;
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		if (!answered) {
			if (state == 1){
				g2.setColor(Color.lightGray);
				g2.fillRect(0, 0, w, h);
				g2.setPaint(Color.yellow);
				g2.setFont(new Font("Sans-serif", Font.BOLD, 20));
				g2.drawString("MATH PROBLEM AND STUFF", w/3, h/2);
				add(tf);
				add(b1);

				
			}
			else if (state == 0){
				g2.setColor(Color.darkGray);
				g2.fillRect(0, 0, w, h);
				g2.setPaint(Color.green);
				g2.setFont(new Font("Sans-serif", Font.BOLD, 20));
				g2.drawString("Start Problem", w/3, h/2);
				add(tf);
				add(b1);


			}
			else {
			g2.drawImage(img, 0, 0, this);
			remove(tf);
			remove(b1);
			}
		}
		//answered = !answered; // toggles on and off 
	}

	public static void main(String[] args) {
		JFrame f = new JFrame("SWEET COOL FRAME");

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(new GPanel(new ImageIcon("moon.jpg").getImage()));
		f.pack();
		f.setVisible(true);
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("Changing state");
		state++;
		validate();
		repaint();
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
	
