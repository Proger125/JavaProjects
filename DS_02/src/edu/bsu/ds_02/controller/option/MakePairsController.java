package edu.bsu.ds_02.controller.option;

import edu.bsu.ds_02.controller.MainController;
import edu.bsu.ds_02.model.Pair;
import edu.bsu.ds_02.model.User;
import edu.bsu.ds_02.model.Users;
import edu.bsu.ds_02.model.UtilModel;
import edu.bsu.ds_02.view.main.PairsPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MakePairsController extends MainController implements ActionListener {

    private final PairsPanel pairsPanel;

    public MakePairsController(Users users, UtilModel utilModel, PairsPanel pairsPanel) {
        super(users, utilModel);
        this.pairsPanel = pairsPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        List<User> males = users.getMales();
        List<User> females = users.getFemales();
        List<Pair> pairs = new ArrayList<>();

        List<double[]> malesResults = new ArrayList<>();
        List<double[]> femalesResults = new ArrayList<>();

        for (var male : males){
            double[] result = findIdealPartner(male, females);
            malesResults.add(result);
        }

        for (var female : females){
            double[] result = findIdealPartner(female, males);
            femalesResults.add(result);
        }

        for (int k = 0; k < malesResults.size(); k++){
            for (int i = 0; i < malesResults.get(k).length; i++){
                double compatibility = ((malesResults.get(k)[i] + femalesResults.get(i)[k]) / 2) * 100;
                pairs.add(new Pair(males.get(k), females.get(i), compatibility));
            }
        }
        users.setPairs(pairs);
        pairsPanel.setModel(users.createListModel());
    }
    private double[] findIdealPartner(User partner1, List<User> partners){
        Map<String, String> requirements = partner1.getRequirements();
        double[] result = new double[partners.size()];

        int requirementsAmount = requirements.size();

        for (var req : requirements.entrySet()) {
            String key = req.getKey();
            String value = req.getValue();
            boolean isSplitable = false;
            switch (key) {
                case "age", "weight", "income", "children", "height" ->
                    isSplitable = isSplitable(value);
            }
            int index = 0;
            for (var partner : partners){
                double coincidences = 0;
                switch (key) {
                    case "name" -> {
                        if (value.toUpperCase().equals(partner.getName().toUpperCase())) {
                            coincidences++;
                        }
                    }
                    case "surname" -> {
                        if (value.toUpperCase().equals(partner.getSurname().toUpperCase())) {
                            coincidences++;
                        }
                    }
                    case "age" -> {
                        if (isOk(isSplitable, value, partner.getAge())) {
                            coincidences++;
                        }
                    }
                    case "height" -> {
                        if (isOk(isSplitable, value, partner.getAppearance().getHeight())) {
                            coincidences++;
                        }
                    }
                    case "weight" -> {
                        if (isOk(isSplitable, value, partner.getAppearance().getWeight())) {
                            coincidences++;
                        }
                    }
                    case "hairColor" -> {
                        if (User.Appearance.HairColor.valueOf(value) == partner.getAppearance().getHairColor()) {
                            coincidences++;
                        }
                    }
                    case "eyeColor" -> {
                        if (User.Appearance.EyeColor.valueOf(value) == partner.getAppearance().getEyeColor()) {
                            coincidences++;
                        }
                    }
                    case "income" -> {
                        if (isOk(isSplitable, value, partner.getFinanceInfo().getIncome())) {
                            coincidences++;
                        }
                    }
                    case "accommodation" -> {
                        if (User.FinanceInfo.Accommodation.valueOf(value) == partner.getFinanceInfo().getAccommodation()) {
                            coincidences++;
                        }
                    }
                    case "isDivorced" -> {
                        if (Boolean.parseBoolean(value) == partner.getOtherInfo().isDivorced()) {
                            coincidences++;
                        }
                    }
                    case "children" -> {
                        if (isOk(isSplitable, value, partner.getOtherInfo().getChildrenAmount())) {
                            coincidences++;
                        }
                    }
                }
                result[index] += coincidences;
                index++;
            }
        }
        for (int i = 0; i < result.length; i++){
            result[i] /= requirementsAmount;
        }
        return result;
    }
    private boolean isSplitable(String value){
        return value.contains("-");
    }
    private boolean isOk(boolean isSplitable, String stringValue, int value){
        if (isSplitable){
            int indexOfDash = stringValue.indexOf("-");
            int firstValue = Integer.parseInt(stringValue.substring(0, indexOfDash));
            int secondValue = Integer.parseInt(stringValue.substring(indexOfDash + 1));
            return value >= firstValue && value <= secondValue;
        }else{
            return Integer.parseInt(stringValue) == value;
        }
    }
}
