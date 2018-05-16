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

public class Customer_page extends Application{
	String cust_info;
	static Customer_login c;
	public Customer_page (String cust_info,Customer_login c){
		this.cust_info=cust_info;
		this.c=c;
	}


    @Override
    public void start(Stage primaryStage) {
     primaryStage.setTitle("Hello User!!!");
        Text Welcome = new Text("WELCOME");
        Welcome.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 40));
        Text Details = new Text(cust_info);
        Details.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        Button back=new Button("BACK");
        back.setOnMouseClicked(new EventHandler<MouseEvent>(){
        	public void handle (MouseEvent event)
        	{
                 try{
                        c.c=c;
        		c.start(primaryStage);
                }
                catch(SQLException ex){

                }
        	}
        });
        GridPane root = new GridPane(); 
        root.setPadding(new Insets(20, 20, 15, 15));
        root.setVgap(5); 
        root.setHgap(5);    
        root.add(Welcome,1,2);
        root.add(Details,1,3);
        root.add(back,2,4);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root,800,350);
        
        primaryStage.setScene(scene);
        primaryStage.setResizable(true);
        primaryStage.show();
    }

    }

