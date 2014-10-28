package project1;

public class Run {
	private short red;
	private short green;
	private short blue;
	private int count;

	public short getRed() {
		return red;
	}

	public void setRed(short red) {
		this.red = red;
	}

	public short getGreen() {
		return green;
	}

	public void setGreen(short green) {
		this.green = green;
	}

	public short getBlue() {
		return blue;
	}

	public void setBlue(short blue) {
		this.blue = blue;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Run() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + blue;
		result = prime * result + green;
		result = prime * result + red;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Run other = (Run) obj;
		if (blue != other.blue) {
			return false;
		}
		if (green != other.green) {
			return false;
		}
		if (red != other.red) {
			return false;
		}
		return true;
	}

	public Run(short red, short green, short blue, int count) {
		super();
		this.red = red;
		this.green = green;
		this.blue = blue;
		this.count = count;
	}

	@Override
	public String toString() {
		return "Run [red=" + red + ", green=" + green + ", blue=" + blue
				+ ", count=" + count + "]";
	}

}
