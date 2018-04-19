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


public class equip1 extends Application{

	static Modify My;
	static equip1 e1;
	
	public equip1(Modify My){
		this.My = My;
	}
	
	@Override
	public void start(Stage primaryStage) {
   	 	
		GridPane root = new GridPane(); 
        root.setPadding(new Insets(20, 20, 15, 15));
        root.setVgap(5); 
        root.setHgap(5); 
        
       //final ToggleGroup group1 = new ToggleGroup();
       primaryStage.setTitle("View Equipments:");	
       Text Welcome = new Text("Equipment Details: ");
       Welcome.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
       
       
       Label eid = new Label("E_ID");
       Label name = new Label("Name");
       Label price = new Label("Price");
       Label date = new Label("Maintenance Date");
       Label status = new Label("Working Status");
       
       
       
       TextField Eid = new TextField();
       TextField Name = new TextField();
       TextField Price = new TextField();
       TextField Date = new TextField();
       TextField Status = new TextField();
       
       
       Eid.setPromptText("Enter E_ID");
       Name.setPromptText("Enter Name");
       Price.setPromptText("Enter Price");
       Date.setPromptText("Enter Maintenance Date");
       Status.setPromptText("Enter Working Status");
       

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
       root.add(eid,1,2);
       root.add(name,1,3);
       root.add(price,1,4);
       root.add(date,1,5);
       root.add(status,1,6);
       
       root.add(Eid,2,2);
       root.add(Name,2,3);
       root.add(Price,2,4);
       root.add(Date,2,5);
       root.add(Status,2,6);
       root.setAlignment(Pos.CENTER);
       Scene scene = new Scene(root,600,400);
       
       
       primaryStage.setScene(scene);
       primaryStage.setResizable(true);
       primaryStage.show();
   }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			e1 = new equip1(My);
			launch(args);
	}

}
