package src.fdf;
import java.lang.Math.*;
import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
//import src.vector.*;

public class MyPanel extends JPanel
{
	private BufferedImage img;
	private int color = 0;
	private int w = 0;
	private int h = 0;
	private OriginVector coord[][];

	public MyPanel()
	{
		super();
		this.w = this.getWidth();
		this.h = this.getHeight();
	}

	public MyPanel(OriginVector coord[][], int w, int h)
	{
		super();
		this.w = w;
		this.h = h;
		this.coord = coord;
		System.out.println("MyPanel is good");
	}


	public void paint(Graphics g)
	{
		int color = 0;
		int x = 0;
		int y = 0;
		int tmpW = this.getWidth();
		int tmpH = this.getHeight();
		this.img = new BufferedImage(tmpW, tmpH, BufferedImage.TYPE_INT_ARGB);
		for (int imgX = 0; imgX < tmpW; imgX++)
		{
			for (int imgY = 0; imgY < tmpH; imgY++)
			{
				this.color = Color.BLACK.getRGB();
				this.img.setRGB(imgX, imgY, this.color);
			}
		}
		System.out.println("get width = " + w);
		System.out.println("get height = " + h);
		for (y = 0; y < this.h; y++)
		{
			for (x = 0; x < this.w; x++)
			{
				if (x > 0)
					drawLine(this.coord[y][x], this.coord[y][x - 1]);
				if (y > 0)
					drawLine(this.coord[y][x], this.coord[y - 1][x]);

//				System.out.print("\t");
//				System.out.println(coord[y][x].getZ());
			}
				System.out.print("\n");
		}
		g.drawImage(img, 0, 0, null);
		System.out.println("Draw is done !");
	}

	/* line algo */
	private void drawLine(OriginVector a, OriginVector b)
	{
		double x = b.getX() - a.getX();
		double y = b.getY() - a.getY();
		double step = Math.abs(x) > Math.abs(y) ? Math.abs(x) : Math.abs(y);
		double incrX = x / step;
		double incrY = y / step;
		double posX = a.getX();
		double posY = a.getY();
		for (int i = 0; i < (int)step; i++)
		{
			posX += incrX;
			posY += incrY;
		}
		posX = Math.floor(posX);
		posY = Math.floor(posY);
		this.color = Color.WHITE.getRGB();
		if ((int)posX < (int)(this.getWidth() - 1) && (int)posX > 0 && (int)posY < (int)(this.getHeight() - 1) && (int)posY > 0)
			this.img.setRGB((int)posX, (int)posY, this.color);
	}
}
