package api.rest.martin.restfulapiwithspring.Model;

public class Triangle {
	private int aSide;
	private int bSide;
	private int cSide;
	private TriangleType triangleType;

	public Triangle(int aSide, int bSide, int cSide) {
		this.aSide = aSide;
		this.bSide = bSide;
		this.cSide = cSide;
		this.triangleType = checkType();
	}

	/**
	 * Checks if it's a triangle.
	 *
	 * @return boolean
	 * */
	public boolean isTriangle() {
		return this.aSide > 0 && this.bSide > 0 && this.cSide > 0;
	}

	/**
	 * Checks the type on the triangle
	 *
	 * @return TriangleType
	 * */
	private TriangleType checkType() {
		if (isTriangle()) {
			boolean isEquilateral = this.aSide == this.bSide && this.bSide == this.cSide;
			boolean isIsosceles = this.aSide == this.bSide || this.bSide == this.cSide || this.aSide == this.cSide;
			boolean isScalene = this.aSide != this.bSide && this.bSide != this.cSide && this.aSide != this.cSide;

			if (isEquilateral) {
				return TriangleType.EQUILATERAL;
			} else if (isIsosceles) {
				return TriangleType.ISOSCELES;
			} else if (isScalene) {
				return TriangleType.SCALENE;
			}
		}

		return TriangleType.INCORRECT;
	}

	public int getaSide() {
		return aSide;
	}

	public void setaSide(int aSide) {
		this.aSide = aSide;
	}

	public int getbSide() {
		return bSide;
	}

	public void setbSide(int bSide) {
		this.bSide = bSide;
	}

	public int getcSide() {
		return cSide;
	}

	public void setcSide(int cSide) {
		this.cSide = cSide;
	}

	public TriangleType getTriangleType() {
		return triangleType;
	}

	public void setTriangleType(TriangleType triangleType) {
		this.triangleType = triangleType;
	}
}
