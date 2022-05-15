
package airplane;
import java.awt.Color;
import javax.swing.*;

/**
 *
 * @author geff6
 */
public class Main extends JFrame{
	public Main(){
		getContentPane().add(new Board());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600,400);
		setLocationRelativeTo(null);
		setTitle("Evita le bombe");
		setResizable(false);
		setVisible(true);
	}
	public static void main(String args[]){
		new Main();
	}
    
}
