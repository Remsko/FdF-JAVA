import src.fdf.*;

public class Main
{
	public static void main(String args[])
	{

		int map[][] = get_map();
		int height = map.length;
		int width = map[0].length;
		double z = 0;

		OriginVector Coord[][] = new OriginVector[height][width];

		for (int y = 0; y < height; y++)
		{
			for (int x = 0; x < width; x++)
			{
				z = map[y][x];
				OriginVector tmp = new OriginVector(x, y, z);
				Coord[y][x] = tmp.Projection();
			}
		}
		Window win = new Window(Coord);
		win.pack();
		win.setVisible(true);
	}

	public static int[][] get_map()
	{
		int map[][] = {{50, 50 ,50},
			{40, 20, 40},
			{30, 10, 30},
			{20, 0, 20},
			{10, 0, 10}};

		return (map);
	}
}
