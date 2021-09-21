package edu.bsu.ds_02.model;

import java.io.Serializable;
import java.util.Map;

public class User implements Serializable {
    private String name;
    private String surname;
    private int age;
    private Gender gender;
    private Appearance appearance;
    private FinanceInfo financeInfo;
    private OtherInfo otherInfo;
    private Map<String, String> requirements;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Appearance getAppearance() {
        return appearance;
    }

    public void setAppearance(Appearance appearance) {
        this.appearance = appearance;
    }

    public FinanceInfo getFinanceInfo() {
        return financeInfo;
    }

    public void setFinanceInfo(FinanceInfo financeInfo) {
        this.financeInfo = financeInfo;
    }

    public OtherInfo getOtherInfo() {
        return otherInfo;
    }

    public void setOtherInfo(OtherInfo otherInfo) {
        this.otherInfo = otherInfo;
    }

    public Map<String, String> getRequirements() {
        return requirements;
    }

    public void setRequirements(Map<String, String> requirements) {
        this.requirements = requirements;
    }

    public enum Gender{
        MALE, FEMALE
    }
    public static class Appearance implements Serializable{
        private int height;
        private int weight;
        private HairColor hairColor;
        private EyeColor eyeColor;

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public HairColor getHairColor() {
            return hairColor;
        }

        public void setHairColor(HairColor hairColor) {
            this.hairColor = hairColor;
        }

        public EyeColor getEyeColor() {
            return eyeColor;
        }

        public void setEyeColor(EyeColor eyeColor) {
            this.eyeColor = eyeColor;
        }

        public enum HairColor implements Serializable{
            BLOND("Блонд"), BROWN("Шатен"), RED("Рыжий"), DARK("Тёмный"), GRAY("Седой");
            private final String value;

            HairColor(String value){
                this.value = value;
            }

            public String getValue(){
                return value;
            }
        }
        public enum EyeColor{
            BLUE("Голубой"), BROWN("Карий"), GREEN("Зелёный"), GRAY("Серый");
            private final String value;

            EyeColor(String value){
                this.value = value;
            }

            public String getValue(){
                return value;
            }
        }
    }
    public static class FinanceInfo implements Serializable{
        private int income;
        private Accommodation accommodation;

        public int getIncome() {
            return income;
        }

        public void setIncome(int income) {
            this.income = income;
        }

        public Accommodation getAccommodation() {
            return accommodation;
        }

        public void setAccommodation(Accommodation accommodation) {
            this.accommodation = accommodation;
        }

        public enum Accommodation{
            FLAT("Квартира"), HOUSE("Дом"), NONE("Нет");
            private final String value;

            Accommodation(String value){
                this.value = value;
            }

            public String getValue(){
                return value;
            }
        }
    }
    public static class OtherInfo implements Serializable{
        private boolean isDivorced;
        private int childrenAmount;

        public boolean isDivorced() {
            return isDivorced;
        }

        public void setDivorced(boolean divorced) {
            isDivorced = divorced;
        }

        public int getChildrenAmount() {
            return childrenAmount;
        }

        public void setChildrenAmount(int childrenAmount) {
            this.childrenAmount = childrenAmount;
        }
    }
}
