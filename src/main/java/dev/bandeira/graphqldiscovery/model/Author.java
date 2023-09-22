package dev.bandeira.graphqldiscovery.model;

import java.util.Arrays;
import java.util.List;

public record Author (String id, String firstName, String lastName, String expensiveField) {

    private static final List<Author> AUTHORS = Arrays.asList(
            new Author("author-1", "Joshua", "Bloch", null),
            new Author("author-2", "Douglas", "Adams", null),
            new Author("author-3", "Bill", "Bryson", null)
    );

    public static Author getById(String id) {
        return AUTHORS.stream()
				.filter(author -> author.id().equals(id))
				.findFirst()
				.orElse(null);
    }
    
	public static List<Author> findAll() {
		return AUTHORS;
	}
}