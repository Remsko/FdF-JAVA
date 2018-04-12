package src.fdf;

public class Map
{
	protected int map[][] = this.getMap();
	protected int height = this.map.length;
	protected int width = this.map[0].length;
	protected OriginVector coord[][] =
		new OriginVector[this.height][this.width];
	protected double maxX = 0;
	protected double maxY = 0;
	protected double minX = 1000000;
	protected double minY = 1000000;
	
	public Map() {}
	
	public int getHeight() { return (this.height); }
	public int getWidth() { return (this.width); }
	public double getMaxX() { return (this.maxX); }
	public double getMinX() { return (this.minX); }
	public double getMaxY() { return (this.maxY); }
	public double getMinY() { return (this.minY); }


	private void getExtremum(double x, double y)
	{
		if (x == 0.0 && y == 0.0)
		{
			this.minX = x;
			this.minY = y;
			this.maxX = x;
			this.maxY = y;
		}
		else
		{
			this.minX = x < this.minX ? x : this.minX;
			this.minY = y < this.minY ? y : this.minY;
			this.maxX = x > this.maxX ? x : this.maxX;
			this.maxY = y > this.maxY ? y : this.maxY;
		}
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
								this.getExtremum(this.coord[y][x].getX(), this.coord[y][x].getY());
                        }
                }
		return (this.coord);
	}

	private int[][] getMap()
	{
		int map[][] = /*{{50, 50 ,50, 50, 50, 50, 50},
                        {40, 30, 30, 30, 20, 30, 30, 40},
                        {30, 10, 10, 10, 10, 10, 10, 30},
                        {20, 20, 20, 20, 0, 20, 20, 20},
                        {10, 0, 0, 0, 0, 0, 0, 0, 10}};*/

		{{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 10, 10, 0, 0, 10, 10, 0, 0, 0, 10, 10, 10, 10, 10, 0, 0, 0},
			{0, 0, 10, 10, 0, 0, 10, 10, 0, 0, 0, 0, 0, 0, 0, 10, 10, 0, 0},
			{0, 0, 10, 10, 0, 0, 10, 10, 0, 0, 0, 0, 0, 0, 0, 10, 10, 0, 0},
			{0, 0, 10, 10, 10, 10, 10, 10, 0, 0, 0, 0, 10, 10, 10, 10, 0, 0, 0},
			{0, 0, 0, 10, 10, 10, 10, 10, 0, 0, 0, 10, 10, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 10, 10, 0, 0, 0, 10, 10, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 10, 10, 0, 0, 0, 10, 10, 10, 10, 10, 10, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
                return (map);
	}
}
