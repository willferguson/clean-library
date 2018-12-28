package xyz.willferguson.library.domain.entity;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * By default everyone is a Borrower.
 * You can't borrow if you have outstanding fines.
 */
public class Person {

    private UUID uuid;
    private String name;
    private Set<Role> roles = new HashSet<>();
    private BigDecimal outstandindFines;

    public Person(String name) {
        this(name, Role.BORROWER);
    }

    public Person(String name, Role role) {
        this(name, Set.of(role));
    }

    public Person(String name, Set<Role> roles) {
        this.uuid = UUID.randomUUID();
        this.name = name;
        this.roles.addAll(roles);
        this.roles.add(Role.BORROWER);
        outstandindFines = BigDecimal.ZERO;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public BigDecimal getOutstandindFines() {
        return outstandindFines;
    }

    public boolean isLibrarian() {
        return roles.contains(Role.LIBRARIAN);
    }

    public BigDecimal addFine(BigDecimal bigDecimal) {
        this.outstandindFines = this.outstandindFines.add(bigDecimal);
        return this.outstandindFines;
    }
}
