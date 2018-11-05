package PhoneDisplay;

import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class PhoneView extends FlowPane {
    TextField phone_display;
    PhoneViewDelegate delegate;

    public PhoneView(Orientation orientation) {
        super(orientation);
    }

    public GridPane drawPhoneDial(){
        GridPane layout = new GridPane();

        int current_key = 1;
        for(int row=0; row<4; row++){
            for(int col=0; col<3; col++){
                String msg = String.format(" %s ",
                        String.valueOf(current_key));

                switch (current_key){
                    case 10:
                        msg = "*";
                        break;

                    case 11:
                        msg ="0";
                        break;

                    case 12:
                        msg = "#";
                    default:
                        break;

                }

                Button l = new Button( msg);

                l.addEventHandler(MouseEvent.MOUSE_CLICKED, (event)->{
                    if(this.delegate != null){
                        this.delegate.handleEvent(event);
                    }
                });
                l.setFont(new Font(20));
                l.setMaxWidth(55);
                l.setMinWidth(55);

                DropShadow dshadow = new DropShadow();
                dshadow.setOffsetX(2.0);
                dshadow.setOffsetY(2.0);
                dshadow.setRadius(4.0);
                l.setEffect(dshadow);

                layout.add(l, col, row);
                current_key +=1;
            }
        }
        return layout;
    }

    public void setPhoneDisplay(String phone){
        this.phone_display.setText(phone);
    }

    public void build(){
        phone_display = new TextField();
        Label phone_label = new Label("Phone:");

        phone_label.setStyle("-fx-font-family: Arial; " +
                "               -fx-font-weight: bold; " +
                "               -fx-font-size: 15; " +
                "               -fx-padding: 10px;");
        DropShadow dshadow = new DropShadow();
        dshadow.setOffsetX(2.0);
        dshadow.setOffsetY(2.0);
        dshadow.setRadius(4.0);
        dshadow.setColor(Color.GRAY);

        phone_label.setEffect(dshadow);
        this.getChildren().add(phone_label);

        Separator s1 = new Separator();
        s1.setPrefHeight(20);
        this.getChildren().add(s1);

        this.getChildren().add(phone_display);

        Separator sep = new Separator();
        sep.setPrefHeight(20);
        this.getChildren().add(sep);

        GridPane layout = this.drawPhoneDial();
        this.getChildren().add(layout);
    }
}
