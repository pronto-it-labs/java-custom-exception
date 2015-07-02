package com.prontoitlabs.customexception.domain.enums;

public enum Role {

    USER(1), MODERATOR(10), ADMIN(100);

    private int priority;

    private Role(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }
}
