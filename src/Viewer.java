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
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 * 
 *
 */
public class Viewer extends JFrame {
	static String file_name;
	static int problem_num;
	static boolean exit;
	private GamePanel gamePanel;
	protected Image[] imgs;
	private static int img_choice;
	private static int dimension;
	private static final long serialVersionUID = 1L;

	public Viewer(Image[] imgs) {
		
		setTitle("COOL MATH AND STUFF");
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gamePanel = new GamePanel();
		gamePanel.setLayout(new GridLayout(2, 2, 1, 1));
		gamePanel.addImages(imgs);
		add(gamePanel, BorderLayout.CENTER);
		TopMenu topmenu = new TopMenu();
		setJMenuBar(topmenu.menu(null));
		pack();
		setVisible(true);
	}
	
	public void setImgChoice(int img_choice){
		this.img_choice = img_choice;
	}
	
	public int getImageChoice(){
		return img_choice;
	}
	

	public static String getImageName(){
		return file_name;
	}
	
	public static String setImageName(int img_choice){
		if(img_choice == 1){
			file_name = "moon.jpg";
	}
		if(img_choice == 2){
			file_name = "dog.jpg";
		}
		if(img_choice == 3){
			file_name = "sky.jpg";
		}
	return file_name;
	}
	
	public static int setDimension(int dimension){
		if(dimension == 4){
			dimension = 2;
		}
		if(dimension == 9){
			dimension = 3;
		}
		if(dimension == 16){
			dimension = 4;
		}
		return dimension;
	}
	
	public void setImages(String fileName, int rows, int cols) {
		remove(gamePanel);
		revalidate();
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
			if (saveToFile) {
				String name = fileName.split(".")[0];
				for (int i = 0; i < imgs.length; i++) {
					ImageIO.write(imgs[i], "jpg", new File(name + i + ".jpg"));
				}
			}
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}

		for (int i = 0; i < rows * cols; i++) {
			Image img = (Image) imgs[i];
			if (pieceWidth / cols < 100) {
				images[i] = img.getScaledInstance(2*pieceWidth, 2*pieceWidth, Image.SCALE_DEFAULT);
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
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter and image choice (1,2,3):  ");
		img_choice = sc.nextInt();
		file_name = setImageName(img_choice);
		System.out.println("Would you like 4, 9, or 16 problems?:  ");
		dimension = sc.nextInt();
		try {
			imgs = splitImage(file_name,setDimension(dimension),setDimension(dimension), false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Viewer mv = new Viewer(imgs);
		//mv.setImages(file_name, setDimension(dimension), setDimension(dimension));
		
		
	}
}		
