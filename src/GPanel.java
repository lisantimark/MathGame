
/**
 * 
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * 
 *
 */

public class GPanel extends JPanel implements MouseListener, ActionListener, KeyListener {
	private Image img;
	private boolean answered;
	private int w;
	private int h;
	private int state = 0;
	private JPanel p;
	private JButton b1 = new JButton("Submit Answer");
	private JTextField tf = new JTextField(10);
	private String sign = "+";
	private int firstnum = 0;
	private int secondnum = 1;
	private static final long serialVersionUID = 1L;

	
	public GPanel(Image img) {
		this.img = img;
		w = img.getWidth(this);
		h = img.getHeight(this);
		setPreferredSize(new Dimension(w, h));
		answered = false;
		addMouseListener(this);
		p = new JPanel();
		b1.addActionListener(this);
		add(tf);
		add(b1);
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		if(!answered) {
			if (state == 1) {
				g2.setColor(Color.gray);
				g2.fillRect(0, 0, w, h);
				g2.setPaint(Color.green);
				g2.setFont(new Font("Sans-serif", Font.BOLD, 20));
				g2.drawString(""+firstnum, 88, 100);
				g2.drawString(""+secondnum, 112,100);
				g2.drawString(sign, 100, 100);
				g2.drawString("=", 125 , 100);
				g2.drawString("?", 137, 100);
				repaint();
				
			} else if (state == 0) {
				validate();
				g2.setColor(Color.darkGray);
				g2.fillRect(0, 0, w, h);
				g2.setPaint(Color.green);
				g2.setFont(new Font("Sans-serif", Font.BOLD, 20));
				g2.drawString("Start Problem", w / 3, h / 2);
				
			} else {
				g2.drawImage(img, 0, 0, this);
				remove(tf);
				remove(b1);
			}
		}
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
		if(state == 0){
		System.out.println("Changing State");
		state++;
		validate();
		repaint();
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {


	}

	@Override
	public void keyPressed(KeyEvent k) {
		int keyCode = k.getKeyCode();

		if (keyCode == KeyEvent.VK_ENTER) {
			System.out.println("Input Entered");
			state++;
			validate();
			repaint();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
            String answer = tf.getText();
            int ans = Integer.parseInt(tf.getText());
    
            System.out.println(ans);
            if(ans == 1){
	            state++;
	            validate();
	            repaint();
            }

    
        }
}
}