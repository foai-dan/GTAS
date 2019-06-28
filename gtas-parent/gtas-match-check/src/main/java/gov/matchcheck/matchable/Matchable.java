package gov.matchcheck.matchable;

import gov.matchcheck.NameRecord;

public interface Matchable {

	/**
	 * Whether name1 and name2 match
	 */
	boolean match(NameRecord name1, NameRecord name2);

}
