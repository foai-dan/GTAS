package gov.matchcheck.matchable;

import gov.matchcheck.NameRecord;
import org.apache.commons.text.similarity.JaroWinklerDistance;

public class JaroWinklerMatcher implements Matchable {

	private final static JaroWinklerDistance JWD = new JaroWinklerDistance();

	private final Double threshold;

	public JaroWinklerMatcher(Double threshold) {

		this.threshold = threshold;

	}

	@Override
	public boolean match(NameRecord name1, NameRecord name2) {

		return JWD.apply(name1.getName(), name2.getName()) >= threshold;

	}

}
