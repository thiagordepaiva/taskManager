package com.ipog.taskmanager.model.enums;

public enum PrioritysEnum {

    HIGH("Alta"),
    MEDIA("Média"),
    LOW("Baixa");

    String value;

    PrioritysEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static PrioritysEnum get(String value) {
        if (value == null || value.trim().length() == 0)
            return null;

        for (PrioritysEnum priority : PrioritysEnum.values()) {
            if (priority.getValue().equals(value))
                return priority;
        }

        return null;
    }
}
