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


public class Modify extends Application{

	static Manage1 M1;
	static Modify my;
	static trainer1 T;
	static customer1 C;
	static equip1 E;
	
	public Modify(Manage1 M1) {
		this.M1 = M1;
	}
	
	@Override
	public void start(Stage primaryStage) {
   	 GridPane root = new GridPane(); 
        root.setPadding(new Insets(20, 20, 15, 15));
        root.setVgap(5); 
        root.setHgap(5); 
        
        final ToggleGroup group1 = new ToggleGroup();
       primaryStage.setTitle("View Customers:");	
       Text Welcome = new Text("Customer Details: ");
       Welcome.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
       
       RadioButton rb1 = new RadioButton("Insert");
       rb1.setToggleGroup(group1);
       rb1.setSelected(true);
       
       RadioButton rb2 = new RadioButton("Update");
       rb2.setToggleGroup(group1);
       rb2.setSelected(true);
       
       Button trainer = new Button("Trainer");
       Button customer = new Button("Customer");
       Button equip = new Button("Equipment");

      // Button Submit = new Button("SUBMIT");
       Button Back = new Button("BACK");
//       Submit.setOnMouseClicked(new EventHandler<MouseEvent>(){
//       	public void handle (MouseEvent event)
//       	{
//	        		
//
//       	}
//       });
       
       
//       
       Back.setOnMouseClicked(new EventHandler<MouseEvent>(){
       	public void handle (MouseEvent event)
       	{
       		M1.start(primaryStage);
       			
       	}
       });
       
       trainer.setOnMouseClicked(new EventHandler<MouseEvent>(){
          	public void handle (MouseEvent event)
          	{
          		T = new trainer1(my);
          		T.t1 = T;
          		T.start(primaryStage);
          			
          	}
          });
       
       customer.setOnMouseClicked(new EventHandler<MouseEvent>(){
          	public void handle (MouseEvent event)
          	{
          		C = new customer1(my);
          		C.c1 = C;
          		C.start(primaryStage);
          			
          	}
          });
         
       equip.setOnMouseClicked(new EventHandler<MouseEvent>(){
          	public void handle (MouseEvent event)
          	{
          		E = new equip1(my);
          		E.e1 = E;
          		E.start(primaryStage);
          			
          	}
          });
  
       root.add(Welcome,1,3);
       root.add(Back,2,8);
       root.add(rb1,1,4);
       root.add(rb2,2,4);
       root.add(trainer,1,5);
       root.add(customer,1,6);
       root.add(equip,1,7);
       root.setAlignment(Pos.CENTER);
       Scene scene = new Scene(root,600,400);
       
       
       primaryStage.setScene(scene);
       primaryStage.setResizable(true);
       primaryStage.show();
   }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			my = new Modify(M1);
			launch(args);
	}

}
