
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
import javafx.scene.layout.GridPane; 
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.*; 
import javafx.scene.input.MouseEvent;
import java.io.*;


public class signup_M extends Application {

	static Manager_login M;
	
	Button button1;
	Button button2;
	
	public signup_M(Manager_login M) {
			
			this.M = M;
		}
	
	@Override
	public void start(Stage primaryStage) {
		
		primaryStage.setTitle("Create New Account");
		Text Welcome = new Text("WELCOME");
        Welcome.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        
        Text Name = new Text("NAME : ");
        TextField NAME=new TextField();
        NAME.setPromptText("Enter Your name here");
       
	    Text Pass = new Text("Password : ");
	    PasswordField passwd=new PasswordField();
	    passwd.setPromptText("Enter Your Password here");
        
     
        
        button1 = new Button("SUBMIT");
        button1.setOnMouseClicked(new EventHandler<MouseEvent>(){
        	public void handle (MouseEvent event)
        	{
        		System.out.println(NAME.getText());
        	}
        });
        
        button2 = new Button("BACK");
        button2.setOnMouseClicked(new EventHandler<MouseEvent>(){
        	public void handle (MouseEvent event)
        	{
        		M.start(primaryStage);
        	}
        });
        
        GridPane root = new GridPane(); 
        root.setPadding(new Insets(20, 20, 15, 15));
        root.setVgap(5); 
        root.setHgap(5);    
        root.add(Welcome,1,2);
        root.add(Name,1,3);
        root.add(NAME,2,3);
        
        root.add(Pass,1,4);
        root.add(passwd,2,4);
      
        root.add(button1,1,8);
        root.add(button2,2,8);
        
       
        
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root,500,200);
        
        primaryStage.setScene(scene);
        primaryStage.setResizable(true);
        primaryStage.show();
        

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		launch(args);
	}

}
