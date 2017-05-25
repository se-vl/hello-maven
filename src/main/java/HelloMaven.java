import java.util.*;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

class HelloMaven {
	private static final String[] KEYWORDS = {
		"abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class", "const",
		"continue", "default", "do", "double", "else", "enum", "extends", "final", "finally", "float",
		"for", "goto", "if", "implements", "import", "instanceof", "int", "interface", "long", "native",
		"new", "package", "private", "protected", "public", "return", "short", "static", "strictfp", "super",
		"switch", "synchronized", "this", "throw", "throws", "transient", "try", "void", "volatile", "while"
	};

	public static void main(String[] words) {
		if (words.length != 1) {
			System.out.println("You may want to add a command line argument that resembles a Java keyword...");
		} else {
			System.out.println(nearestKeywordsTo(words[0]));
		}
	}

	private static List<String> nearestKeywordsTo(String word) {
		Map<Integer, List<String>> byDistance = Arrays.stream(KEYWORDS).collect(Collectors.groupingBy(
			keyword -> Integer.valueOf(StringUtils.getLevenshteinDistance(word, keyword)),
			TreeMap::new,
			Collectors.toList()
		));
		return byDistance.values().iterator().next();
	}
}
