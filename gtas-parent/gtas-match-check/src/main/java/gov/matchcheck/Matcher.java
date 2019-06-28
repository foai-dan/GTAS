package gov.matchcheck;

import gov.matchcheck.matchable.Matchable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Matcher {

	private List<MatchResult> results = new ArrayList<>();
	private MatchSummary summary = new MatchSummary();


	public static Matcher match(Map<String, NameRecord> names, Matchable matchable) {

		long start = System.currentTimeMillis();

		Matcher matcher = new Matcher();

		for (NameRecord a : names.values()) {

			for (NameRecord b : names.values()) {

				if (!a.equals(b)) {    //Avoid comparing ones self

					matcher.results.add(new MatchResult(a, b, a.getAliases().contains(b.getName()), matchable.match(a, b)));

				}

			}

		}

		//Calculate Matching Summaries

		matcher.summary.setTruePositive((int) matcher.results.stream().filter(MatchResult::isTruePositive).count());
		matcher.summary.setTrueNegative((int) matcher.results.stream().filter(MatchResult::isTrueNegative).count());
		matcher.summary.setFalsePositive((int) matcher.results.stream().filter(MatchResult::isFalsePositive).count());
		matcher.summary.setFalseNegative((int) matcher.results.stream().filter(MatchResult::isFalseNegative).count());

		matcher.summary.setDuration(System.currentTimeMillis() - start);

		return matcher;

	}

	public List<MatchResult> getResults() {
		return results;
	}

	public MatchSummary getSummary() {
		return summary;
	}

}
