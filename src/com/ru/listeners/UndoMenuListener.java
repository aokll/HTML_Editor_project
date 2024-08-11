package com.ru.listeners;

import com.ru.View;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

//Этот слушатель будет следить за меню, а если конкретнее, то за моментом,
// когда меню редактирования будет выбрано пользователем.
//В этот момент он будет запрашивать у представления можем ли мы сейчас
// отменить или вернуть какое-то действие, и в зависимости от этого
// делать доступными или не доступными пункты меню "Отменить" и "Вернуть".
public class UndoMenuListener implements MenuListener {

    private View view;
    private JMenuItem undoMenuItem;//"Отменить"
    private JMenuItem redoMenuItem;//"Вернуть"

    public UndoMenuListener(View view, JMenuItem undoMenuItem, JMenuItem redoMenuItem) {
        this.view = view;
        this.undoMenuItem = undoMenuItem;
        this.redoMenuItem = redoMenuItem;
    }

    //метод menuSelected будет вызываться перед показом меню.
    //что он делает:
    //1) Спрашивает у представления можем ли мы отменить действие с помощью метода boolean canUndo()/canRedo().
    //2) Делает доступным или не доступным пункт меню undoMenuItem/redoMenuItem в зависимости от того,
    // что нам вернуло представление.
    @Override
    public void menuSelected(MenuEvent e) {
        boolean undo = view.canUndo();
        boolean redo = view.canRedo();

        if (undo){undoMenuItem.setEnabled(true);}
        else undoMenuItem.setEnabled(false);

        if (redo){redoMenuItem.setEnabled(true);}
        else redoMenuItem.setEnabled(false);
    }

    @Override
    public void menuDeselected(MenuEvent e) {

    }

    @Override
    public void menuCanceled(MenuEvent e) {

    }
}

