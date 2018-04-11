package src.fdf;
import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
//import src.vector.*;

public class MyPanel extends JPanel
{
	private BufferedImage img;
	private int color = 0;
	private int x = 0;
	private int y = 0;
	private OriginVector Coord[][];

	public MyPanel()
	{
		super();
	}

	public MyPanel(OriginVector Coord[][])
	{
		super();
		this.Coord = Coord;
		System.out.println("MyPanel is good");
	}


	public void paint(Graphics g)
	{
		int w = this.getWidth();
		int h = this.getHeight();
		System.out.println("get wiiidth = " + w);
		System.out.println("get heiight = " + h);

		img = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		for (x = 0; x < w; x++)
		{
			for (y = 0; y < h; y++)
			{
				color = ((x % 2 == 0 && y % 2 == 0)? Color.BLACK.getRGB() : Color.WHITE.getRGB());
				img.setRGB(x, y, color);
			}
		}
		g.drawImage(img, 0, 0, null);
		System.out.println("Draw is done !");
	}
}
