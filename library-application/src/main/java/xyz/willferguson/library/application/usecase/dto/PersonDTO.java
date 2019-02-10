package xyz.willferguson.library.application.usecase.dto;

import xyz.willferguson.library.domain.entity.Role;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class PersonDTO {

    private UUID id;
    private String name;
    private Set<Role> roles = new HashSet<>();
    private BigDecimal outstandingFines;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public BigDecimal getOutstandingFines() {
        return outstandingFines;
    }

    public void setOutstandingFines(BigDecimal outstandingFines) {
        this.outstandingFines = outstandingFines;
    }
}
