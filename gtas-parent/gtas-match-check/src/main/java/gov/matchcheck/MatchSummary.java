package gov.matchcheck;

import static com.google.common.base.MoreObjects.toStringHelper;

public class MatchSummary {

	private int truePositive;
	private int trueNegative;
	private int falsePositive;
	private int falseNegative;
	private long duration;

	public void setTruePositive(int truePositive) {
		this.truePositive = truePositive;
	}

	public void setTrueNegative(int trueNegative) {
		this.trueNegative = trueNegative;
	}

	public void setFalsePositive(int falsePositive) {
		this.falsePositive = falsePositive;
	}

	public void setFalseNegative(int falseNegative) {
		this.falseNegative = falseNegative;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	public int getTruePositive() {
		return truePositive;
	}

	public int getTrueNegative() {
		return trueNegative;
	}

	public int getFalsePositive() {
		return falsePositive;
	}

	public int getFalseNegative() {
		return falseNegative;
	}

	public long getDuration() {
		return duration;
	}

	@Override
	public String toString() {

		return toStringHelper(MatchSummary.class)
				.add("tp", truePositive)
				.add("tn", trueNegative)
				.add("fp", falsePositive)
				.add("fn", falseNegative)
				.add("duration", duration)
				.toString();

	}

}
