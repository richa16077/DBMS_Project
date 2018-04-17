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

public class Main_page extends Application  {
Customer_login cust;
Trainer_login train;
Manager_login manage;
static Main_page m;
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("GYM Manager");	
        Text Welcome = new Text("WELCOME!!");
        Welcome.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 40));
        Button Customer=new Button("Customer");
        Customer.setOnMouseClicked(new EventHandler<MouseEvent>(){
        	public void handle (MouseEvent event)
        	{
        			cust=new Customer_login(m);
        			cust.start(primaryStage);
        	}
        });
        Button Manager=new Button("MANAGER");
        Manager.setOnMouseClicked(new EventHandler<MouseEvent>(){
        	public void handle (MouseEvent event)
        	{
        		manage=new Manager_login(m);
        		manage.start(primaryStage);
        	}
        });
        Button Trainer=new Button("TRAINER");
        Trainer.setOnMouseClicked(new EventHandler<MouseEvent>(){
        	public void handle (MouseEvent event)
        	{
        			train=new Trainer_login(m);
        			train.start(primaryStage);
        	}
        });
        GridPane root = new GridPane(); 
        root.setPadding(new Insets(10, 10, 5, 5));
        root.setVgap(5); 
        root.setHgap(5);    
        root.add(Welcome,1,2);
        root.add(Customer,1,3);
        root.add(Manager,2,3);
        root.add(Trainer,1,4);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root,450,200);
        
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