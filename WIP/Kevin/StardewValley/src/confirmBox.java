import java.awt.Image;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.geometry.*;


public class confirmBox {



    static boolean answer;




    public static boolean display(String title, String msg){
        Stage stage= new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle(title);
        stage.setMinWidth(256);
        stage.setMinHeight(192);
        Text text = new Text(msg);

        Button yes = new Button();
        Button no = new Button();
        yes.setText("Yes");
        no.setText("No");

        yes.setOnAction( event -> {
            answer =true;
            stage.close();
        });

        no.setOnAction(event -> {
            answer =false;
            stage.close();
        });
        VBox layout = new VBox(10);
        layout.getChildren().addAll(text, yes, no);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.showAndWait();
        return answer;
    }


}