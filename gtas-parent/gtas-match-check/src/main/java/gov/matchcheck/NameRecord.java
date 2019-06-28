package gov.matchcheck;

import com.google.common.collect.Sets;
import org.apache.commons.codec.language.DoubleMetaphone;

import java.util.TreeSet;

public class NameRecord implements Comparable<NameRecord> {
	private final static DoubleMetaphone DM = new DoubleMetaphone();

	private String name;
	private String doubleMetaphone;
	private TreeSet<String> aliases = Sets.newTreeSet();

	public NameRecord(String name) {

		this.name = name;
		this.doubleMetaphone = DM.doubleMetaphone(name);

	}

	public String getName() {
		return name;
	}

	public String getDoubleMetaphone() {
		return doubleMetaphone;
	}

	public TreeSet<String> getAliases() {
		return aliases;
	}

	@Override
	public int compareTo(NameRecord o) {

		return name.compareTo(o.name);

	}

	@Override
	public String toString() {

		return name;

	}

}
