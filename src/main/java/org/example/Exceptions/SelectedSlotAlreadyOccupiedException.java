package org.example.Exceptions;

public class SelectedSlotAlreadyOccupiedException extends Exception {

    public SelectedSlotAlreadyOccupiedException () {
        super("Выбранный слот уже занят");
    }
}
