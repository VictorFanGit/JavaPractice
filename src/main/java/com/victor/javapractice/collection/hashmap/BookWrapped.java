package com.victor.javapractice.collection.hashmap;

import java.util.Objects;

public class BookWrapped {
    private String name;

    public BookWrapped(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BookWrapped bookWrapped = (BookWrapped) obj;
        return Objects.equals(name, bookWrapped.name);
    }
}
