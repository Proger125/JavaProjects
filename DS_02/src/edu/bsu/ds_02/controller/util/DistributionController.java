package edu.bsu.ds_02.controller.util;

import edu.bsu.ds_02.controller.MainController;
import edu.bsu.ds_02.model.User;
import edu.bsu.ds_02.model.Users;
import edu.bsu.ds_02.model.UtilModel;
import edu.bsu.ds_02.util.UsersUtil;
import edu.bsu.ds_02.view.main.CustomFrame;
import edu.bsu.ds_02.view.main.UserPanel;

public class DistributionController extends MainController {

    public DistributionController(Users users, UtilModel utilModel){
        super(users, utilModel);
    }
    public void distributeUsers(User[] users){
        this.users.clearMales();
        this.users.clearFemales();
        for (var user : users){
            if (user.getGender() == User.Gender.FEMALE){
                this.users.addFemale(user);
            }else{
                this.users.addMale(user);
            }
        }
    }
    public void setCurrentUsers(CustomFrame frame){
        UserPanel.InfoWrapperPanel.InfoPanel maleInfoPanel = frame.getMalePanel().getInfoPanel().getInfoPanel();
        UserPanel.InfoWrapperPanel.InfoPanel femaleInfoPanel = frame.getFemalePanel().getInfoPanel().getInfoPanel();

        if (users.getMales().size() > 1){
            frame.getMalePanel().getInfoPanel().setNextButtonEnabled(true);
        }
        if (users.getFemales().size() > 1){
            frame.getFemalePanel().getInfoPanel().setNextButtonEnabled(true);
        }

        User male = users.getMale();
        User female = users.getFemale();

        setCurrentUser(maleInfoPanel, male);
        setCurrentUser(femaleInfoPanel, female);
    }

    public void setCurrentUser(UserPanel.InfoWrapperPanel.InfoPanel infoPanel, User user){
        infoPanel.setName(UsersUtil.getFullName(user));
        infoPanel.setAge(UsersUtil.getStringAge(user));
        infoPanel.setHeight(UsersUtil.getStringHeight(user));
        infoPanel.setWeight(UsersUtil.getStringWeight(user));
        infoPanel.setHairColor(UsersUtil.getStringHair(user));
        infoPanel.setEyeColor((UsersUtil.getStringEye(user)));
        infoPanel.setIncome(UsersUtil.getStringIncome(user));
        infoPanel.setAccommodation(UsersUtil.getStringAccommodation(user));
        infoPanel.setIsDivorced(UsersUtil.getStringIsDivorced(user));
        infoPanel.setChildrenLabel(UsersUtil.getStringChildren(user));
    }
}
