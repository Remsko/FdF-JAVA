package src.fdf;
import java.lang.Math.*;
import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

public class MyPanel extends JPanel
{
	private BufferedImage img;
	private int color = 0;
	private int w = 0;
	private int h = 0;
	private OriginVector coord[][];
	private double maxY = 0;
	private double maxX = 0;
	private double minY = 0;
	private double minX = 0;

	public MyPanel()
	{
		super();
		Map map = new Map();
		this.w = map.getWidth();
		this.h = map.getHeight();
		coord = map.getCoord();
		this.maxX = map.getMaxX();
		this.minX = map.getMinX();
		this.maxY = map.getMaxY();
		this.minY = map.getMinY();
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
				this.color = Color.WHITE.getRGB();
				this.img.setRGB(imgX, imgY, this.color);
			}
		}
		for (y = 0; y < this.h; y++)
		{
			for (x = 0; x < this.w; x++)
			{
				coord[y][x].normalize(this.minX, this.maxX, this.minY, this.maxY);
				if (x > 0)
					drawLine(this.coord[y][x], this.coord[y][x - 1]);
				if (y > 0)
					drawLine(this.coord[y][x], this.coord[y - 1][x]);

			}
		}
		System.out.println("Draw is done !");
		g.drawImage(img, 0, 0, null);
	}

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
			this.color = Color.BLACK.getRGB();
			if ((int)Math.floor(posX) < (int)(this.getWidth()) && (int)Math.floor(posX) > 0 && (int)Math.floor(posY) < (int)(this.getHeight()) && (int)Math.floor(posY) > 0)
				this.img.setRGB((int)Math.floor(posX), (int)Math.floor(posY), this.color);
		}
	}
}
