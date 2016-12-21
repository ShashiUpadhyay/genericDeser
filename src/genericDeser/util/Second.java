package genericDeser.util;

/**
 * @author shashiupadhyay
 *
 */
public class Second {
	
	Second(){
		
	}
	
	int IntValue;
	boolean BooleanValue;
	double DoubleValue;

	/**
	 * @return the intValue
	 */
	public int getIntValue() {
		return IntValue;
	}

	/**
	 * @param intValue
	 *            the intValue to set
	 */
	public void setIntValue(int intValue) {
		IntValue = intValue;
	}

	/**
	 * @return the booleanValue
	 */
	public boolean isBooleanValue() {
		return BooleanValue;
	}

	/**
	 * @param booleanValue
	 *            the booleanValue to set
	 */
	public void setBooleanValue(boolean booleanValue) {
		BooleanValue = booleanValue;
	}

	/**
	 * @return the doubleValue
	 */
	public double getDoubleValue() {
		return DoubleValue;
	}

	/**
	 * @param doubleValue
	 *            the doubleValue to set
	 */
	public void setDoubleValue(double doubleValue) {
		DoubleValue = doubleValue;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj == this)
			return true;
		if (!(obj instanceof Second)) {
			return false;
		}
		Second second = (Second) obj;

		return second.isBooleanValue() == BooleanValue && second.getIntValue() == IntValue
				&& second.getDoubleValue() == DoubleValue;
	}

	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * result + IntValue;
		result = 31 * result + new Double(DoubleValue).hashCode();
		if (BooleanValue)
			result = 31 * result + 23;
		else
			result = 31 * result + 42;
		return result;
	}

	@Override
	public String toString() {
		return "Second [IntValue=" + this.getIntValue() + ", BooleanValue=" + this.isBooleanValue() + ", DoubleValue="
				+ this.getDoubleValue() + "]";
	}
}
