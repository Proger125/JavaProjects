package edu.bsu.ds_02.controller.option;

import edu.bsu.ds_02.controller.MainController;
import edu.bsu.ds_02.model.Users;
import edu.bsu.ds_02.model.UtilModel;
import edu.bsu.ds_02.view.main.CustomFrame;
import edu.bsu.ds_02.view.option.AddUserFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OpenAddUserDialogController extends MainController implements ActionListener {

    private final CustomFrame customFrame;

    public OpenAddUserDialogController(Users users, UtilModel utilModel, CustomFrame customFrame) {
        super(users, utilModel);
        this.customFrame = customFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        AddUserFrame userFrame = new AddUserFrame("Добавить пользователя", users, utilModel, customFrame);
    }
}
