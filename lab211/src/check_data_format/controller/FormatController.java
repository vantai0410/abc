package check_data_format.controller;

import check_data_format.model.Format;
import check_data_format.view.FormatView;

public class FormatController {
    private FormatView view;
    private Format format;

    public FormatController(FormatView view, Format format) {
        this.view = view;
        this.format = format;
    }
    public void checkFormat() {
        String phone, email, date;
        String message;
        do{
            phone = view.getNumber();
            message = format.checkPhone(phone);
            if(!message.isEmpty()){
                view.showErrorMessage(message);
            }
        } while (!message.isEmpty());
        do {
            email = view.getEmail();
            message = format.checkEmail(email);
            if(!message.isEmpty()){
                view.showErrorMessage(message);
            }
        }while (!message.isEmpty());
        do {
            date = view.getDate();
            message = format.checkDate(date);
            if(!message.isEmpty()){
                view.showErrorMessage(message);
            }
        }while (!message.isEmpty());
    }

    public static void main(String[] args) {
        FormatView view = new FormatView();
       Format format1 = new Format();
        FormatController controller = new FormatController(view, format1);
        controller.checkFormat();
    }
}
