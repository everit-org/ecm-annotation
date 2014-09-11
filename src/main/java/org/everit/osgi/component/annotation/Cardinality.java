package org.everit.osgi.component.annotation;

/**
 * Cardinality for any attribute annotation.
 */
public enum Cardinality {
    /**
     * The attribute is mandatory and multiple. That is, the attribute has a cardinality of {@code 1..n}.
     */
    AT_LEAST_ONE("1..n"),

    /**
     * The attribute is mandatory and unary. That is, the attribute has a cardinality of {@code 1..1}.
     */
    MANDATORY("1..1"),

    /**
     * The attribute is optional and multiple. That is, the attribute has a cardinality of {@code 0..n}.
     */
    MULTIPLE("0..n"),

    /**
     * The attribute is optional and unary. That is, the attribute has a cardinality of {@code 0..1}.
     */
    OPTIONAL("0..1");

    private final String value;

    Cardinality(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
