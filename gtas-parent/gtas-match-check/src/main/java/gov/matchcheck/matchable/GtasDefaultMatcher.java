package gov.matchcheck.matchable;

import gov.matchcheck.NameRecord;
import org.apache.commons.text.similarity.JaroWinklerDistance;

public class GtasDefaultMatcher implements Matchable {

	private final static JaroWinklerDistance JWD = new JaroWinklerDistance();

	private final Double threshold = 0.95;


	@Override
	public boolean match(NameRecord name1, NameRecord name2) {

		if (name1.getDoubleMetaphone().equals(name2.getDoubleMetaphone())) {

			return JWD.apply(name1.getName(), name2.getName()) >= threshold;

		}

		return false;

	}

}
