package org.apache.flink.playgrounds.ops.clickcount.dbchanges;

import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.JsonNode;
import java.util.Objects;

public class DbChange {
    private JsonNode schema;
    private Customer before;
    private Customer after;
    private String source;

    public DbChange() {
    }

    public DbChange(JsonNode schema, Customer before, Customer after, String source) {
        this.schema = schema;
        this.before = before;
        this.after = after;
        this.source = source;
    }

    public JsonNode getSchema() {
        return schema;
    }

    public void setSchema(JsonNode schema) {
        this.schema = schema;
    }

    public Customer getBefore() {
        return before;
    }

    public void setBefore(Customer before) {
        this.before = before;
    }

    public Customer getAfter() {
        return after;
    }

    public void setAfter(Customer after) {
        this.after = after;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        DbChange dbChange = (DbChange)o;
        return Objects.equals(schema, dbChange.schema) &&
               Objects.equals(before, dbChange.before) &&
               Objects.equals(after, dbChange.after) &&
               Objects.equals(source, dbChange.source);
    }

    @Override
    public int hashCode() {
        return Objects.hash(schema, before, after, source);
    }

    @Override
    public String toString() {
        return "DbChange{" +
               "schema='" + schema + '\'' +
               ", before=" + before +
               ", after=" + after +
               ", source='" + source + '\'' +
               '}';
    }
}
