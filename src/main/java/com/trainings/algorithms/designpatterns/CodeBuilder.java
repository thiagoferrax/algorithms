package com.trainings.algorithms.designpatterns;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Implement the builder design pattern for rendering simple chunks of code.
 * https://www.udemy.com/design-patterns-java/learn/quiz/412390#overview
 */
public class CodeBuilder {

    private final String className;
    private final Map<String, String> fields;

    public CodeBuilder(String className) {
        this.className = className;
        this.fields = new HashMap<>();
    }

    public CodeBuilder addField(String name, String type) {
        fields.put(name, type);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("public class " + this.className + "\n");
        builder.append("{\n");

        for (Entry<String, String> entry : fields.entrySet()) {
            builder.append("  public " + entry.getValue() + " " + entry.getKey() + ";\n");
        }

        builder.append("}");

        return builder.toString();
    }
}
