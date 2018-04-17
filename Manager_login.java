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

public class Manager_login extends Application  {
    Main_page m;
    public Manager_login(Main_page m){
        this.m=m;
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello Manager");	
        Text Welcome = new Text("WELCOME Manager");
        Welcome.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        Text ID = new Text("Login ID : ");
        TextField login_ID=new TextField();
        login_ID.setPromptText("Enter Your ID here");
        Text Pass = new Text("Password : ");
        PasswordField passwd=new PasswordField();
        passwd.setPromptText("Enter Your Password here");
        Button Submit=new Button("SUBMIT");
        Submit.setOnMouseClicked(new EventHandler<MouseEvent>(){
        	public void handle (MouseEvent event)
        	{
        			System.out.println(login_ID.getText());
                    System.out.println(passwd.getText());
        	}
        });
        Button back=new Button("BACK");
        back.setOnMouseClicked(new EventHandler<MouseEvent>(){
        	public void handle (MouseEvent event)
        	{
        		m.start(primaryStage);
        	}
        });
         Button nuser=new Button("Sign up");
        nuser.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle (MouseEvent event)
            {
                System.out.println("naya hai ye");
            }
        });
        GridPane root = new GridPane(); 
        root.setPadding(new Insets(20, 20, 15, 15));
        root.setVgap(5); 
        root.setHgap(5);    
        root.add(Welcome,1,2);
        root.add(ID,1,3);
        root.add(login_ID,2,3);
        root.add(Pass,1,4);
        root.add(passwd,2,4);
        root.add(Submit,1,5);
        root.add(back,2,5);
        root.add(nuser,3,5);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root,700,200);
        
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
   
  
        launch(args);
    }
    
}