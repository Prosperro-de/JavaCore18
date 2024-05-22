package org.example.module8.enums;

public enum OrderStatus {
    CREATION_IN_PROGRESS(false),
    CREATED(true);

    private final boolean isTerminatedStatus;

    OrderStatus(boolean isTerminatedStatus) {
        this.isTerminatedStatus = isTerminatedStatus;
    }

    public boolean isTerminatedStatus() {
        return isTerminatedStatus;
    }
}
