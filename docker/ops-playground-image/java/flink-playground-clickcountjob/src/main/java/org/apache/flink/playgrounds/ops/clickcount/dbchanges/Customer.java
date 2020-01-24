package org.apache.flink.playgrounds.ops.clickcount.dbchanges;

import java.util.Objects;

public class Customer {
    private Integer id;
    private String last_name;
    private String first_name;
    private String email;

    public Customer() {
    }

    public Customer(Integer id, String last_name, String first_name, String email) {
        this.id = id;
        this.last_name = last_name;
        this.first_name = first_name;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        Customer customer = (Customer)o;
        return Objects.equals(id, customer.id) &&
               Objects.equals(last_name, customer.last_name) &&
               Objects.equals(first_name, customer.first_name) &&
               Objects.equals(email, customer.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, last_name, first_name, email);
    }

    @Override
    public String toString() {
        return "Customer{" +
               "id='" + id + '\'' +
               ", last_name='" + last_name + '\'' +
               ", first_name='" + first_name + '\'' +
               ", email='" + email + '\'' +
               '}';
    }
}
