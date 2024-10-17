package anaylyze_the_user_input_string.controller;

import anaylyze_the_user_input_string.model.AnalysisString;
import anaylyze_the_user_input_string.view.AnalysisView;

import java.util.HashMap;
import java.util.List;

public class AnalysisController {
     private  AnalysisView view;
     private AnalysisString model;

    public AnalysisController(AnalysisView view, AnalysisString model) {
        this.view = view;
        this.model = model;
    }
    public void analyzeString(){
        String input = view.getInput();
        HashMap<String, List<Integer>> numberResult = model.getNumber(input);
        HashMap<String, StringBuilder> characterResult = model.getCharacter(input);
        view.displayNumber(numberResult);
        view.displayCharacter(characterResult);
    }

    public static void main(String[] args) {
        AnalysisView view = new AnalysisView();
        AnalysisString model = new AnalysisString();
        AnalysisController controller = new AnalysisController(view, model);
        controller.analyzeString();
    }
}
