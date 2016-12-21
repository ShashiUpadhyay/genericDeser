package genericDeser.util;

import java.util.Objects;

/**
 * @author shashiupadhyay
 *
 */
public class First {
	
	First(){
		
	}
	
	private int IntValue;
	private String StringValue;
	private float FloatValue;
	private short ShortValue;

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
	 * @return the stringValue
	 */
	public String getStringValue() {
		return StringValue;
	}

	/**
	 * @param stringValue
	 *            the stringValue to set
	 */
	public void setStringValue(String stringValue) {
		StringValue = stringValue;
	}

	/**
	 * @return the floatValue
	 */
	public float getFloatValue() {
		return FloatValue;
	}

	/**
	 * @param floatValue
	 *            the floatValue to set
	 */
	public void setFloatValue(float floatValue) {
		FloatValue = floatValue;
	}

	/**
	 * @return the shortValue
	 */
	public short getShortValue() {
		return ShortValue;
	}

	/**
	 * @param shortValue
	 *            the shortValue to set
	 */
	public void setShortValue(short shortValue) {
		ShortValue = shortValue;
	}

	// https://www.tutorialspoint.com/java/lang/float_equals.htm
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj_instance) {
		if (obj_instance == null)
			return false;
		if (obj_instance == this)
			return true;
		if (!(obj_instance instanceof First)) {
			return false;
		}
		First first = (First) obj_instance;

		Float f1 = new Float(FloatValue);
		Float f2 = new Float(first.getFloatValue());
		return f1.equals(f2) && first.getIntValue() == IntValue && first.getShortValue() == ShortValue
				&& ((first.getStringValue() == StringValue)
						|| (first.getStringValue() != null && first.getStringValue().equals(StringValue)));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * result + this.IntValue;
		result = 31 * result + new Float(this.FloatValue).hashCode();
		result = 31 * result + (int) this.ShortValue;
		if (StringValue != null)
			result = 31 * result + StringValue.hashCode();
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "First [IntValue=" + getIntValue() + ", StringValue=" + getStringValue() + ", FloatValue="
				+ getFloatValue() + ", ShortValue=" + getShortValue() + "]";
	}
}
