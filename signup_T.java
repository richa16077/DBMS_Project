
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

public class signup_T extends Application{

	static Trainer_login t;
	Button button1;
	Button button2;
	
	public signup_T(Trainer_login t) {
		
		this.t = t;
	}
	@Override
	public void start(Stage primaryStage) {
		
		primaryStage.setTitle("Create New Account");
		Text Welcome = new Text("WELCOME");
        Welcome.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        
        Text Name = new Text("NAME : ");
        TextField NAME=new TextField();
        NAME.setPromptText("Enter Your name here");
        
        final ToggleGroup group1 = new ToggleGroup();

        RadioButton rb1 = new RadioButton("Package 1");
        rb1.setToggleGroup(group1);
        rb1.setSelected(true);

        RadioButton rb2 = new RadioButton("Package 2");
        rb2.setToggleGroup(group1);

        RadioButton rb3 = new RadioButton("Package 3");
        rb3.setToggleGroup(group1);
        
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
        		t.start(primaryStage);
        	}
        });
        
        GridPane root = new GridPane(); 
        root.setPadding(new Insets(20, 20, 15, 15));
        root.setVgap(5); 
        root.setHgap(5);    
        root.add(Welcome,1,2);
        root.add(Name,1,3);
        root.add(NAME,2,3);
      
        root.add(button1,1,8);
        root.add(button2,2,8);
        
        root.add(rb1, 1, 5);
        root.add(rb2, 1, 6);
        root.add(rb3, 1, 7);
        
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root,500,200);
        
        primaryStage.setScene(scene);
        primaryStage.setResizable(true);
        primaryStage.show();
        

	}
	 public static void main(String[] args) {
		   
		  
	        launch(args);
	    }
	
	
}



