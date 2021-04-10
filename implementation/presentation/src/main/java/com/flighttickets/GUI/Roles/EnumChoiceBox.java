package com.flighttickets.GUI.Roles;

import javafx.beans.NamedArg;
import javafx.scene.control.ChoiceBox;

public class EnumChoiceBox<E extends Enum<UserRoles>> extends ChoiceBox<UserRoles> {
    public EnumChoiceBox(@NamedArg("UserRoles") String userRoles) throws ClassNotFoundException {
        Class<UserRoles> enumClass = (Class<UserRoles>) Class.forName(userRoles);
        getItems().setAll(enumClass.getEnumConstants());
    }
}
