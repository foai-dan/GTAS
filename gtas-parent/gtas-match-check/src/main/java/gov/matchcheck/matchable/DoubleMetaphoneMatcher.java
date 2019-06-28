package gov.matchcheck.matchable;

import gov.matchcheck.NameRecord;

public class DoubleMetaphoneMatcher implements Matchable {

	@Override
	public boolean match(NameRecord name1, NameRecord name2) {

		return name1.getDoubleMetaphone().equals(name2.getDoubleMetaphone());

	}

}
