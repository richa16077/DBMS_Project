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


public class ViewEquip extends Application{
	
	static Manage1 M1;
	static ViewEquip E;
	static submitE SE;
	
	public ViewEquip(Manage1 M1)
	{
		this.M1 = M1;
	}
	
	@Override
    public void start(Stage primaryStage) {
    	 GridPane root = new GridPane(); 
         root.setPadding(new Insets(20, 20, 15, 15));
         root.setVgap(5); 
         root.setHgap(5); 
        primaryStage.setTitle("View Equipments");	
        Text Welcome = new Text("Equipment Details: ");
        Welcome.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        

        Button Submit = new Button("SUBMIT");
        Button Back = new Button("BACK");
        Submit.setOnMouseClicked(new EventHandler<MouseEvent>(){
        	public void handle (MouseEvent event)
        	{
	        		SE = new submitE(E);
	        		SE.se = SE;
	        		SE.start(primaryStage);

        	}
        });
        
        Back.setOnMouseClicked(new EventHandler<MouseEvent>(){
        	public void handle (MouseEvent event)
        	{
        		M1.start(primaryStage);
        			
        	}
        });
          
        
        Button EID = new Button("Enter EID");
        TextField eid = new TextField();
        eid.setPromptText("Enter E_ID");
        
        Button printall = new Button("PrintAll");
        
        Button Type = new Button("Type");
        
        Button NotWorking = new Button("Not Working");
        
        
      
        EID.setOnMouseClicked(new EventHandler<MouseEvent>(){
        	public void handle (MouseEvent event)
        	{
	        		

        	}
        });
        
        printall.setOnMouseClicked(new EventHandler<MouseEvent>(){
        	public void handle (MouseEvent event)
        	{
        		
        			
        	}
        });
        
        Type.setOnMouseClicked(new EventHandler<MouseEvent>(){
        	public void handle (MouseEvent event)
        	{
        		
        			
        	}
        });
          
        NotWorking.setOnMouseClicked(new EventHandler<MouseEvent>(){
        	public void handle (MouseEvent event)
        	{
        		
        			
        	}
        });
        root.add(Welcome,1,3);
        root.add(Submit,1,8);
        root.add(Back,2,8);
        root.add(EID,1,4);
        root.add(eid,2,4);
        root.add(printall,1,5);
        root.add(Type,1,6);
        root.add(NotWorking,1,7);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root,600,400);
        
        
        primaryStage.setScene(scene);
        primaryStage.setResizable(true);
        primaryStage.show();
    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		E = new ViewEquip(M1);
        launch(args);
	}

}
