package src.fdf;

public class Map
{
	private int map[][] = this.getMap();
	private int height = map.length;
	private int width = map[0].length;
	private OriginVector coord[][] = new OriginVector[height][width];
	private double z = 0;
	private double min = 0;
	private double max = 0;

	public Map() {}
	
	public int getHeight()
	{
		return (this.height);
	}

	public int getWidth()
	{
		return (this.width);
	}

	public OriginVector[][] getCoord()
	{
		for (int y = 0; y < height; y++)
                {
                        for (int x = 0; x < width; x++)
                        {
                                z = (double)this.map[y][x];
                                OriginVector tmp = new OriginVector(x * 10d, y * 10d, z * 10d);
                                this.coord[y][x] = tmp.Projection();
				
                        }
                }
		return (this.coord);
	}

	/* map = z positions */
	private static int[][] getMap()
	{
		int map[][] = {{50, 50 ,50, 50, 50, 50, 50},
                        {40, 30, 30, 30, 20, 30, 30, 40},
                        {30, 10, 10, 10, 10, 10, 10, 30},
                        {20, 20, 20, 20, 0, 20, 20, 20},
                        {10, 0, 0, 0, 0, 0, 0, 0, 10}};

                return (map);
	}

/*	public static OriginVector normalize(OriginVector o, int w, int h)
	{
		
	}
*/
}
