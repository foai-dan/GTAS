package gov.matchcheck;

import gov.matchcheck.matchable.DoubleMetaphoneMatcher;
import gov.matchcheck.matchable.GtasDefaultMatcher;
import gov.matchcheck.matchable.JaroWinklerMatcher;
import gov.matchcheck.matchable.Matchable;

import java.io.File;
import java.io.IOException;
import java.util.TreeMap;

public class MatchCheckApplication {

	public static void main(String[] args) throws IOException {

		String db = "resources/NAMES-DEF.txt";

		TreeMap<String, NameRecord> names = NamesParser.parse(new File(db));

		Matchable matchJwd = new JaroWinklerMatcher(0.95);
		Matchable matchDoubleMeta = new DoubleMetaphoneMatcher();
		Matchable matchGtasDefault = new GtasDefaultMatcher();

		Matcher run1 = Matcher.match(names, matchJwd);
		System.out.println(run1.getSummary());

		Matcher run2 = Matcher.match(names, matchDoubleMeta);
		System.out.println(run2.getSummary());

		Matcher run3 = Matcher.match(names, matchGtasDefault);
		System.out.println(run3.getSummary());

		run3.getResults().stream().filter(MatchResult::isFalsePositive).forEach(r -> {

			System.out.println(r);

		});

	}

}
