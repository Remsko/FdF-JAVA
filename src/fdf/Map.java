package src.fdf;

public class Map
{
	protected int map[][] = this.getMap();
	protected int height = this.map.length;
	protected int width = this.map[0].length;
	protected OriginVector coord[][] =
		new OriginVector[this.height][this.width];

	public Map()
	{
	}
	
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
		double z = 0;

                for (int y = 0; y < this.height; y++)
                {
                        for (int x = 0; x < this.width; x++)
                        {
                                z = (double)this.map[y][x];
                                OriginVector tmp = new OriginVector(x * 10d, y * 10d, z * 10d);
                                this.coord[y][x] = tmp.Projection();

                        }
                }
		return (this.coord);
	}

	/* map = z positions */
	private int[][] getMap()
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
