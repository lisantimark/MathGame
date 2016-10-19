import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

public class ProblemDisplay extends JComponent {
	private String sign;
	private int firstnum;
	private int secondnum;
	
	public ProblemDisplay(int firstnum, int secondnum, String sign){
		this.sign = sign;
		this.firstnum = firstnum;
		this.secondnum = secondnum;
	}
	
	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		g2.setFont(new Font("Sans-serif", Font.BOLD, 20));
		g2.drawString(""+firstnum, 300, 300);
		g2.drawString(""+secondnum, 300,400);
		g2.drawString(sign, 200, 350);
	
		
	}

}
