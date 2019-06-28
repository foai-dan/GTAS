package gov.matchcheck;

import com.google.common.base.Splitter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.TreeMap;

public class NamesParser {

	private final static Splitter CSV_SPLITTER = Splitter.on(",");


	public static TreeMap<String, NameRecord> parse(File file) throws IOException {

		TreeMap<String, NameRecord> records = new TreeMap<>();

		BufferedReader reader = new BufferedReader(new FileReader(file));

		reader.lines().forEach(line -> {

			List<String> names = CSV_SPLITTER.splitToList(line);

			NameRecord root = new NameRecord(names.get(0));

			names.stream().skip(1).forEach(name -> {

				root.getAliases().add(name);

			});

			records.put(root.getName(), root);

		});

		reader.close();

		System.out.println("Parsed " + records.size() + " names ");

		return records;

	}

}
