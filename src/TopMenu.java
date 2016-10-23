/**
 * 
 */


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
/**
 * 
 *
 */
public class TopMenu implements ActionListener, MenuListener, KeyListener{
	
	JTextArea output;
	JScrollPane scrollPane;
	private JMenu exit;
	
	public JMenuBar menu(Viewer viewer) {

		JMenuBar menuBar;
		JMenu menu;
		JMenu submenu;
	
		// Creates the first menu
		menuBar = new JMenuBar();

		// Outside the first menu- Name on top
		menu = new JMenu("Settings");
		menuBar.add(menu);
		
		submenu = new JMenu("Exit");
		menu.add(submenu);
		// IMAGES SUBMENU
		menu.addSeparator();
		submenu = new JMenu("Select Image");
		submenu.setMnemonic(KeyEvent.VK_1);
		
		JMenuItem menuItemA = new JMenuItem("Image 1", KeyEvent.VK_2);
		submenu.add(menuItemA);
		menu.add(submenu);

		JMenuItem menuItemB = new JMenuItem("Image 2", KeyEvent.VK_3);
		submenu.add(menuItemB);
		menu.add(submenu);

		JMenuItem menuItemC = new JMenuItem("Image 3", KeyEvent.VK_3);
		submenu.add(menuItemC);
		menu.add(submenu);
		// NUMBER OF PROBLEMS SUBMENU
		menu.addSeparator();
		submenu = new JMenu("Choose Number of Problems");
		submenu.setMnemonic(KeyEvent.VK_4);

		JMenuItem menuItemD = new JMenuItem("4 Problems", KeyEvent.VK_5);
		submenu.add(menuItemD);
		menu.add(submenu);

		JMenuItem menuItemE = new JMenuItem("9 Problems", KeyEvent.VK_6);
		submenu.add(menuItemE);
		menu.add(submenu);

		JMenuItem menuItemF = new JMenuItem("16 Problems", KeyEvent.VK_7);
		submenu.add(menuItemF);
		menu.add(submenu);
		// TYPE SUBMENU
		menu.addSeparator();
		submenu = new JMenu("Problem Type/ Number Family");
		submenu.setMnemonic(KeyEvent.VK_8);

		JMenuItem menuItemG = new JMenuItem("Add", KeyEvent.VK_9);
		menuItemG.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_PLUS, ActionEvent.ALT_MASK));
		submenu.add(menuItemG);
		menu.add(submenu);

		JMenuItem menuItemH = new JMenuItem("Subtract", KeyEvent.VK_9);
		menuItemH.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, ActionEvent.ALT_MASK));
		submenu.add(menuItemH);
		menu.add(submenu);
		
		
		menuItemA.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e){
		    	
			
		    
		    		}
				    });
		   
		   menuItemB.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent e){
				   
				     
				    }
				    });
		   
		   menuItemC.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent e){
				   
				     
				    }
				    });
		   
		   menuItemD.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent e){
			     System.out.println("You have selected 4 problems");
			     
			    }
			    });
		   
		   menuItemE.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
	
			
			    }
			    });
		   
		   menuItemF.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
			     System.out.println("You have selected 16 problems");
	
			    }
			    });

		return menuBar;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void menuCanceled(MenuEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void menuDeselected(MenuEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void menuSelected(MenuEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}


