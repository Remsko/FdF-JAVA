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
		this.posX = x * 10.0d;
		this.posY = y * 10.0d; /* 10 = taille des "cases" */
		this.posZ = z * 10.0d;
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

		ret = (Math.sqrt(2.0d) / 2.0d) * (this.posX - this.posY);
		return (ret);
	}

	public double ProjectionIsoY()
	{
		double ret;

		ret = (Math.sqrt(2.0d / 3.0d) * this.posZ);
		ret -= ((1.0 / Math.sqrt(6.0d)) * (this.posX + this.posY));
		
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
}
