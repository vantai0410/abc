package dictionary.controller;

import dictionary.model.DictionaryModel;
import dictionary.view.DictionaryView;

public class DictionaryController {
    private DictionaryModel model;
    private DictionaryView view;

    public DictionaryController(DictionaryModel model, DictionaryView view) {
        this.model = model;
        this.view = view;
    }

    public void run() {
        while (true) {
            view.showMenu();
            int choice = view.getChoice();
            chooseChoice(choice);
        }
    }

    private void chooseChoice(int choice) {
        switch (choice) {
            case 1:
                String eng = view.inputEnglishWord();
                String vi = view.inputViWord();
                if (model.addWord(eng, vi)) {
                    view.showMessage("word add successfully");
                } else {
                    view.showMessage("word add failed");
                }
                break;
            case 2:
                String engDel = view.inputEnglishWord();
                if (model.removeWord(engDel)) {
                    view.showMessage("word remove successfully");
                } else {
                    view.showMessage("word remove failed");
                }
                break;
            case 3:
                String engSearch = view.inputEnglishWord();
                String viTrans = model.translate(engSearch);
                view.displayResult("Vietnamese: " + viTrans);
                break;
            case 4:
                view.showMessage("exit");
                System.exit(0);
                break;
            default:
                view.showMessage("invalid choice");
        }

    }

    public static class Main {
        public static void main(String[] args) {
            DictionaryModel model = new DictionaryModel();
            DictionaryView view = new DictionaryView();
            DictionaryController controller = new DictionaryController(model, view);
            controller.run();

        }
    }
}
