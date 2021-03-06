package de.unikassel.ann.io.beans;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

public class SynapseBean {
	
	/* CSV */
	/* "from";"to";"value";"random" */
	
	private int to = -1;
	private double value = Double.NaN;
	private boolean random = false;
	
	final static NumberFormat fmt = new DecimalFormat("#.######", DecimalFormatSymbols.getInstance(Locale.ENGLISH));
	
	private int from;
	/**
	 * @return the from
	 */
	public int getFrom() {
		return from;
	}
	/**
	 * @param from the from to set
	 */
	public void setFrom(int from) {
		this.from = from;
	}
	/**
	 * @return the to
	 */
	public int getTo() {
		return to;
	}
	/**
	 * @param to the to to set
	 */
	public void setTo(int to) {
		this.to = to;
	}
	/**
	 * @return the value
	 */
	public double getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(double value) {
		this.value = value;
	}
	/**
	 * @return the random
	 */
	public boolean getRandom() {
		return random;
	}
	/**
	 * @param random the random to set
	 */
	public void setRandom(boolean random) {
		this.random = random;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();	
		sb.append(from);
		sb.append(" -> ");
		sb.append(to);
		sb.append(" = ");
		sb.append(fmt.format(value));
		sb.append(" (");
		sb.append(random);
		sb.append(")\n");
		return sb.toString();
	}

}
