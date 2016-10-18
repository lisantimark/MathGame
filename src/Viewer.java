/**
 * 
 */

import java.awt.BorderLayout;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 * @author Mark
 *
 */
public class Viewer extends JFrame {
	private static int split_state;
	private GamePanel gamePanel;
	private static final long serialVersionUID = 1L;

	public Viewer(Image[] imgs) {
		setTitle("COOL MATH AND STUFF");
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		TopMenu topMenu = new TopMenu();
		setJMenuBar(topMenu.menu());
		gamePanel = new GamePanel();
		gamePanel.setLayout(new GridLayout(2, 2, 1, 1));
		gamePanel.addImages(imgs);

		add(gamePanel, BorderLayout.CENTER);

		pack();
		setVisible(true);
	}


	public void setImages(String fileName, int rows, int cols) {
		//remove(gamePanel);
		//revalidate();
		gamePanel = new GamePanel();
		gamePanel.setLayout(new GridLayout(rows, cols, 1, 1));
		gamePanel.addImages(splitImage(fileName, rows, cols, false));
		add(gamePanel, BorderLayout.CENTER);
		repaint();

	}
	public static Image[] splitImage(String fileName, int rows, int cols, boolean saveToFile) {
		BufferedImage[] imgs = new BufferedImage[rows * cols]; // Image array to
																// hold images
		Image[] images = new Image[rows * cols];
		int pieceWidth = 100;
		int pieceHeight = 100;

		try {
			File file = new File(fileName); // takes picture from
											// directory
			FileInputStream fis = new FileInputStream(file);
			BufferedImage image = ImageIO.read(fis); // reading the image file

			pieceWidth = image.getWidth() / cols; // determines the width
			pieceHeight = image.getHeight() / rows; // and height of each piece
			
			for (int x = 0; x < rows; x++) {
				for (int y = 0; y < cols; y++) {
					// Initialize the image array with image pieces
					imgs[x * rows + y] = new BufferedImage(pieceWidth, pieceHeight, image.getType());
					// draws the image piece
					Graphics2D gr = imgs[x * rows + y].createGraphics();
					gr.drawImage(image, 0, 0, pieceWidth, pieceHeight, pieceWidth * y, pieceHeight * x,
							pieceWidth * y + pieceWidth, pieceHeight * x + pieceHeight, null);
					gr.dispose();
				}
			}
			System.out.print("\nSplitting done " + pieceWidth / cols + " X " + pieceHeight / rows);
			if (saveToFile) {
				// writing mini images into image files
				String name = fileName.split(".")[0];
				for (int i = 0; i < imgs.length; i++) {
					ImageIO.write(imgs[i], "jpg", new File(name + i + ".jpg"));
				}
				System.out.println("Mini images saved to files");
			}
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}

		for (int i = 0; i < rows * cols; i++) {
			Image img = (Image) imgs[i];
			if (pieceWidth / cols < 100) {
				images[i] = img.getScaledInstance(2*pieceWidth, 2*pieceHeight, Image.SCALE_DEFAULT);
				System.out.println(" resized to " + 2*pieceWidth + " X " + 2*pieceHeight);
			} else
				images[i] = img;
		}

		return images;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Image[] imgs = null;
		
		try {
			imgs = splitImage("moon.jpg", 2,2, false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Viewer mv = new Viewer(imgs);
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		mv.setImages("moon.jpg", 3, 3);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		/**
		//if (split_state = 3){
		mv.setImages("moon.jpg", 4, 4);
		**/
		}
	

}
