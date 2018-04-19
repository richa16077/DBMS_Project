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


public class trainer1 extends Application{

	static Modify My;
	static trainer1 t1;
	
	public trainer1(Modify My){
		this.My = My;
	}
	
	@Override
	public void start(Stage primaryStage) {
   	 	
		GridPane root = new GridPane(); 
        root.setPadding(new Insets(20, 20, 15, 15));
        root.setVgap(5); 
        root.setHgap(5); 
        
       //final ToggleGroup group1 = new ToggleGroup();
       primaryStage.setTitle("View Trainers:");	
       Text Welcome = new Text("Trainer Details: ");
       Welcome.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
       
       
       Label tid = new Label("T_ID");
       Label name = new Label("Name");
       Label salary = new Label("Salary");
       Label pack = new Label("Package");
       
       
       TextField Tid = new TextField();
       TextField Name = new TextField();
       TextField Salary = new TextField();
       TextField Pack = new TextField();
       
       
       Tid.setPromptText("Enter C_ID");
       Name.setPromptText("Enter Name");
       Salary.setPromptText("Enter start date");
       Pack.setPromptText("Enter Package");
       

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
       		My.start(primaryStage);
       			
       	}
       });
       
       
       root.add(Welcome,1,1);
       root.add(Submit, 1,8);
       root.add(Back,2,8);
       root.add(tid,1,2);
       root.add(name,1,3);
       root.add(salary,1,4);
       root.add(pack,1,5);
       
       root.add(Tid,2,2);
       root.add(Name,2,3);
       root.add(Salary,2,4);
       root.add(Pack,2,5);
       root.setAlignment(Pos.CENTER);
       Scene scene = new Scene(root,600,400);
       
       
       primaryStage.setScene(scene);
       primaryStage.setResizable(true);
       primaryStage.show();
   }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			t1 = new trainer1(My);
			launch(args);
	}

}
