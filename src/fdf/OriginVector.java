package src.fdf;
import java.lang.Math.*;

public class OriginVector
{
	protected double posX;
	protected double posY;
	protected double posZ;

	public OriginVector() {}

	public OriginVector(double x, double y, double z)
	{
		this.posX = x;
		this.posY = y; /* 10 = taille des "cases" */
		this.posZ = z;
	}

	public double getX() { return this.posX; }
	public double getY() { return this.posY; }
	public double getZ() { return this.posZ; }

	public void setX(double x) { this.posX = x; }
        public void setY(double y) { this.posY = y; }
        public void setZ(double z) { this.posZ = z; }

	public double ProjectionIsoX()
	{
		double ret;

		ret = (Math.sqrt(2) / 2.0) * (this.posX - this.posY);
		return (ret);
	}

	public double ProjectionIsoY()
	{
		double ret;

		ret = (Math.sqrt(2 / 3.0) * this.posZ) - ((1.0 / Math.sqrt(6)) * (this.posX + this.posY));
		
		return (ret);
	}

	public OriginVector Projection()
	{
		OriginVector ret = new OriginVector(
			this.ProjectionIsoX(),
			this.ProjectionIsoY(),
			this.posZ);
		
		return (ret);
	}
/*
	public void normalize(double minX, double maxX, double minY, double maxY)
	{
		this.posX = ((this.posX - minX) / (maxX - minX)) * (double)(750 - 1);	
		this.posY = ((this.posY - minY) / (maxY - minY)) * (double)(750 - 1);	
	}*/
}
