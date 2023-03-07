/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binding;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author ahaye
 */
public class TestBinding extends Application {
    
    
        TextField A = new TextField();
        TextField B = new TextField();
        TextField C = new TextField();
        TextField D = new TextField("D chef ou futur\n" +"chef");
        TextField E = new TextField( "c'est E ici");
        
        Label A_label = new Label();
        Label B_label = new Label();
        Label C_label = new Label();
        Label D_label = new Label();
        Label E_label = new Label();
        
    
    @Override
    public void start(Stage primaryStage) {
        Button btn1 = new Button();
        btn1.setText("Reset E");
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Reset E");
                E.setText("ici c'est E");
            }
            
            
            
        });
        
        Button btn2 = new Button();
        btn2.setLayoutX(200);
        btn2.setText("D -> E");
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                E.textProperty().bind(D.textProperty());
            }
        });
        
        
        
       
        
        
        A.textProperty().bindBidirectional(E.textProperty());
        A.setLayoutX(10);
        A.setLayoutY(40);
        
        B.textProperty().bindBidirectional(E.textProperty());
        B.setLayoutX(200);
        B.setLayoutY(40);
        
        C.textProperty().bindBidirectional(E.textProperty());
        C.setLayoutX(10);
        C.setLayoutY(120);
        
        
        D.setLayoutX(200);
        D.setLayoutY(120);
        
        E.setLayoutX(10);
        E.setLayoutY(160);
        
        
        
        
        
        
        Pane root = new Pane();
        root.getChildren().add(btn1);
        root.getChildren().addAll(A,B,C,D,E,btn2);
        root.getChildren().addAll(A_label,B_label,C_label,D_label,E_label);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
