import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.application.Application; 
import static javafx.application.Application.launch; 
import javafx.geometry.Insets; 
import javafx.geometry.Pos; 
import javafx.scene.text.Font; 
import javafx.scene.text.FontPosture; 
import javafx.scene.text.FontWeight; 
import javafx.scene.Scene; 
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Button; 
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField; 
import javafx.scene.layout.GridPane; 
import javafx.scene.text.Text; 
import javafx.scene.control.TextField; 
import javafx.stage.Stage;
import javafx.scene.control.*; 
import javafx.scene.input.MouseEvent;
import java.io.*;
import java.sql.*;

public class Main_page extends Application  {
Customer_login cust;
Trainer_login train;
Manager_login manage;
String request;
static Main_page m;
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("GYM Manager");	
        Text Welcome = new Text("WELCOME!!");
        Welcome.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 40));
        Button Customer=new Button("CUSTOMER");
        Customer.setOnMouseClicked(new EventHandler<MouseEvent>(){
        	public void handle (MouseEvent event)
        	{
                try{
        			cust=new Customer_login(m);
        			cust.c = cust;
        			cust.start(primaryStage);
                }
               catch(SQLException ex) {
         ex.printStackTrace();
      }
        	}
        });
        System.out.println(request);
        Button Manager=new Button("MANAGER");
        Manager.setOnMouseClicked(new EventHandler<MouseEvent>(){
        	public void handle (MouseEvent event)
        	{
        		manage=new Manager_login(m,request);
        		manage.M = manage;
        		manage.start(primaryStage);
        	}
        });
        Button Trainer=new Button("TRAINER");
        Trainer.setOnMouseClicked(new EventHandler<MouseEvent>(){
        	public void handle (MouseEvent event)
        	{  
                try{
        			train=new Trainer_login(m);
        			train.t = train;
        			train.start(primaryStage);
                }
                catch(SQLException ex){}
        	}
        });
        GridPane root = new GridPane(); 
        root.setPadding(new Insets(10, 10, 5, 5));
        root.setVgap(1); 
        root.setHgap(8);    
        root.add(Welcome,2,0);
        root.add(Customer,1,1);
        root.add(Manager,2,1);
        root.add(Trainer,3,1);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root,550,150);
        
        primaryStage.setScene(scene);
        primaryStage.setResizable(true);
        primaryStage.show();
    }

    /**
   * This is the main method launching the start method
   *@param args Unused.
   *
   */ 
    public static void main(String[] args) {
   
  	 m=new Main_page();

        launch(args);
    }
    
}
