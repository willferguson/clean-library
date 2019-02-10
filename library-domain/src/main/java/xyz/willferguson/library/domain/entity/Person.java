package xyz.willferguson.library.domain.entity;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * By default everyone is a Borrower.
 */
public class Person implements Identifiable {

    private UUID id;
    private String name;
    private Set<Role> roles = new HashSet<>();
    private BigDecimal outstandingFines;

    public Person(String name) {
        this(name, Role.BORROWER);
    }

    public Person(String name, Role role) {
        this(name, Set.of(role));
    }

    public Person(String name, Set<Role> roles) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.roles.addAll(roles);
        this.roles.add(Role.BORROWER);
        outstandingFines = BigDecimal.ZERO;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public BigDecimal getOutstandingFines() {
        return outstandingFines;
    }

    public boolean isLibrarian() {
        return roles.contains(Role.LIBRARIAN);
    }

    public BigDecimal addFine(BigDecimal bigDecimal) {
        this.outstandingFines = this.outstandingFines.add(bigDecimal);
        return this.outstandingFines;
    }
}
