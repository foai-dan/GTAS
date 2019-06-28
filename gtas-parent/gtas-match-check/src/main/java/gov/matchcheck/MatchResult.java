package gov.matchcheck;

public class MatchResult {

	private NameRecord name1;
	private NameRecord name2;
	private Boolean related;
	private Boolean hit;

	public MatchResult(NameRecord name1, NameRecord name2, Boolean related, Boolean hit) {

		this.name1 = name1;
		this.name2 = name2;
		this.related = related;
		this.hit = hit;

	}

	public boolean isTruePositive() {

		return related && hit;

	}

	public boolean isTrueNegative() {

		return !related && !hit;

	}

	public boolean isFalsePositive() {

		return !related && hit;

	}

	public boolean isFalseNegative() {

		return related && !hit;

	}

	@Override
	public String toString() {

		return name1 + " > " + name2 + " " + related + " - " + hit;

	}

}
