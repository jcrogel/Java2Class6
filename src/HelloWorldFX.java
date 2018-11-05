import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class HelloWorldFX extends Application {
    TextField phone_display;

    public HelloWorldFX(){
        this.phone_display = new TextField();
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
                    Button b = (Button) event.getSource();
                    String new_msg = this.phone_display.getText() + b.getText();
                    this.phone_display.setText(new_msg);
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

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Phone Dial");
        FlowPane root = new FlowPane(Orientation.VERTICAL);
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
        root.getChildren().add(phone_label);
        
        Separator s1 = new Separator();
        s1.setPrefHeight(20);
        root.getChildren().add(s1);

        root.getChildren().add(phone_display);

        Separator sep = new Separator();
        sep.setPrefHeight(20);
        root.getChildren().add(sep);

        GridPane layout = this.drawPhoneDial();
        root.getChildren().add(layout);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);

        primaryStage.show();

    }

    public static void main(String args[]){
        launch(args);
        System.out.println("Launched!");
    }
}
