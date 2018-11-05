package PhoneDisplay;

import javafx.event.Event;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class PhoneController implements PhoneViewDelegate{
    public PhoneView view;
    public PhoneModel model;

    public PhoneController(){
        this.model = new PhoneModel();
    }

    public void buildView(Stage stage){
        stage.setTitle("Phone Dial");

        PhoneView root = new PhoneView(Orientation.VERTICAL);
        this.view = root;
        root.build();
        root.delegate = this;

        Scene scene = new Scene(root);
        stage.setScene(scene);

        stage.show();
    }

    @Override
    public void handleEvent(Event event) {
        Button b = (Button) event.getSource();
        model.appendToPhone(b.getText());
        this.view.setPhoneDisplay(model.getPhone());
    }
}
