package src.fdf;
import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

public class Window extends JFrame
{
	Container c = getContentPane();
	
	public Window()
	{
		super();

		this.setTitle("FdF JAVA version 1.0");
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new MyPanel();
		panel.setPreferredSize(new Dimension(1000, 1000));
		c.add(panel);
	}
}
