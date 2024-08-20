package org.example.entity.items;

import lombok.Getter;

@Getter
public enum ItemsType {

    ACCESSORY("accessory"),
    WITH_COMMAND_ITEM("withCommandItem"),
    NOT_COMMAND_ITEM("notCommandItem");

    private final String type;

    ItemsType(String type) {
        this.type = type;
    }

}
