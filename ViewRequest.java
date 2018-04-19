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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import java.io.*;
import java.util.Optional;
public class ViewRequest extends Application{
		public ViewRequest()
		{

		}
    public void start(Stage primaryStage) {
    	 GridPane root = new GridPane(); 
         root.setPadding(new Insets(20, 20, 15, 15));
         root.setVgap(5); 
         root.setHgap(5); 
        primaryStage.setTitle("View Request");	
        Text Welcome = new Text("Customer Requests : ");
        Welcome.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        

        Button Submit = new Button("SUBMIT");
        Button Back = new Button("BACK");
        Submit.setOnMouseClicked(new EventHandler<MouseEvent>(){
        	public void handle (MouseEvent event)
        	{
	        		

        	}
        });
        
        Back.setOnMouseClicked(new EventHandler<MouseEvent>(){
        	public void handle (MouseEvent event)
        	{
        		
        			
        	}
        });
          
        root.add(Welcome,1,3);
        root.add(Submit,1,4);
        root.add(Back,1,5);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root,600,400);
        
        
        primaryStage.setScene(scene);
        primaryStage.setResizable(true);
        primaryStage.show();
    }
	}