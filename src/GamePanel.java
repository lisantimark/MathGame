
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GamePanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	GPanel[] gPanels;
	
	public GamePanel() {
	}
	
	public void addImages(Image[] imgs) {
		for(Image img : imgs)
			add(new GPanel(img));
	}
	
	public static void main(String[] args) throws Exception {
		String fileName = "dog.jpg";
		Image[] imgs = Viewer.splitImage(fileName, 2, 2, false);
		JFrame f = new JFrame("COOL MATH GAME AND STUFF");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GamePanel gp = new GamePanel();
		gp.addImages(imgs);
		f.add(gp);
		f.pack();
		f.setVisible(true);
	}
	
}
	

