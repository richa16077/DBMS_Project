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


public class ViewTrainer extends Application{

	static Manage1 M1;
	static ViewTrainer T;
	static submitT ST;
	
	public ViewTrainer(Manage1 M1)
	{
		this.M1 = M1;
	}
	
	@Override
	public void start(Stage primaryStage) {
   	 GridPane root = new GridPane(); 
        root.setPadding(new Insets(20, 20, 15, 15));
        root.setVgap(5); 
        root.setHgap(5); 
       primaryStage.setTitle("View Trainers:");	
       Text Welcome = new Text("Trainer Details: ");
       Welcome.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
       

       Button Submit = new Button("SUBMIT");
       Button Back = new Button("BACK");
       Submit.setOnMouseClicked(new EventHandler<MouseEvent>(){
       	public void handle (MouseEvent event)
       	{
	        	ST = new submitT(T);
	        	ST.st = ST;
	        	ST.start(primaryStage);
       	}
       });
       
       Back.setOnMouseClicked(new EventHandler<MouseEvent>(){
       	public void handle (MouseEvent event)
       	{
       		M1.start(primaryStage);
       			
       	}
       });
         
       
       Button TID = new Button("Enter TID");
       TextField tid = new TextField();
       tid.setPromptText("Enter T_ID");
       
       Button printall = new Button("PrintAll");
       
       Button PackageWise = new Button("Package Wise");
       
       //Button NotWorking = new Button("Not Working");
       
       
     
       TID.setOnMouseClicked(new EventHandler<MouseEvent>(){
       	public void handle (MouseEvent event)
       	{
	        		

       	}
       });
       
       printall.setOnMouseClicked(new EventHandler<MouseEvent>(){
       	public void handle (MouseEvent event)
       	{
       		
       			
       	}
       });
       
       PackageWise.setOnMouseClicked(new EventHandler<MouseEvent>(){
       	public void handle (MouseEvent event)
       	{
       		
       			
       	}
       });
         
//       NotWorking.setOnMouseClicked(new EventHandler<MouseEvent>(){
//       	public void handle (MouseEvent event)
//       	{
//       		
//       			
//       	}
//       });
       root.add(Welcome,1,3);
       root.add(Submit,1,8);
       root.add(Back,2,8);
       root.add(TID,1,4);
       root.add(tid,2,4);
       root.add(printall,1,5);
       root.add(PackageWise,1,6);
       //root.add(NotWorking,1,7);
       root.setAlignment(Pos.CENTER);
       Scene scene = new Scene(root,600,400);
       
       
       primaryStage.setScene(scene);
       primaryStage.setResizable(true);
       primaryStage.show();
   }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			T = new ViewTrainer(M1);
			launch(args);
	}

}
