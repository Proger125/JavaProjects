package edu.bsu.ds_02.util;

import edu.bsu.ds_02.model.User;

public final class UsersUtil {

    private UsersUtil(){}

    public static String getFullName(User user){
        return user.getName() + " " + user.getSurname();
    }

    public static String getStringAge(User user){
        return Integer.toString(user.getAge());
    }

    public static String getStringHeight(User user){
        return Integer.toString(user.getAppearance().getHeight());
    }

    public static String getStringWeight(User user){
        return Integer.toString(user.getAppearance().getWeight());
    }

    public static String getStringHair(User user){
        return user.getAppearance().getHairColor().getValue();
    }

    public static String getStringEye(User user){
        return user.getAppearance().getEyeColor().getValue();
    }

    public static String getStringIncome(User user){
        return Integer.toString(user.getFinanceInfo().getIncome());
    }

    public static String getStringAccommodation(User user){
        return user.getFinanceInfo().getAccommodation().getValue();
    }

    public static String getStringIsDivorced(User user){
        return user.getOtherInfo().isDivorced() ? "Да" : "Нет";
    }

    public static String getStringChildren(User user){
        return Integer.toString(user.getOtherInfo().getChildrenAmount());
    }
}
