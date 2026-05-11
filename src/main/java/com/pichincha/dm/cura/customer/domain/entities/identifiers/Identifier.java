package com.pichincha.dm.cura.customer.domain.entities.identifiers;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;
import lombok.Getter;

/**
 * Base class for UUID-based identifiers in the domain layer.
 * Provides standard value-based equality, hash code, and string representation
 * for specialized identity types.
 */
@Getter
public abstract class Identifier implements Serializable {

    private final UUID value;

    protected Identifier(UUID value) {
        this.value = Objects.requireNonNull(value, "Identifier value must not be null");
    }

    protected Identifier(String value) {
        this(UUID.fromString(Objects.requireNonNull(value, "Identifier string must not be null")));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Identifier that = (Identifier) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value.toString();
    }
}