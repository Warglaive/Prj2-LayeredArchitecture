package com.flighttickets.GUI.Roles;

import javafx.beans.NamedArg;
import javafx.scene.control.ChoiceBox;

public class EnumChoiceBox<E extends Enum<E>> extends ChoiceBox<E> {
    public EnumChoiceBox(@NamedArg("UserRoles") String userRoles) throws ClassNotFoundException {
        Class<E> enumClass = (Class<E>) Class.forName(userRoles);
        getItems().setAll(enumClass.getEnumConstants());
    }
}
