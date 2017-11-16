package io.yanaga.mono2micro.customer.domain.model;

import com.google.common.collect.ComparisonChain;

import java.io.Serializable;
import java.util.Objects;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

public class Surname implements Serializable, Comparable<Surname> {

    private final String value;

    private Surname(String value) {
        this.value = value;
    }

    public static Surname of(String value) {
        checkNotNull(value);
        checkArgument(value.trim().length() > 0);
        return new Surname(value);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Surname) {
            Surname other = (Surname) obj;
            return Objects.equals(this.value, other.value);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.value);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public int compareTo(Surname o) {
        return ComparisonChain.start().compare(this.value, o.value).result();
    }

}
