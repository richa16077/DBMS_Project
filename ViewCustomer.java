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
import java.sql.*;

public class ViewCustomer extends Application{
	
	static Manage1 M1;
	static ViewCustomer C;
	static submit S;
	public ViewCustomer(Manage1 M1) {
		this.M1 = M1;
	}
	
	@Override
	public void start(Stage primaryStage) {
   	 GridPane root = new GridPane(); 
        root.setPadding(new Insets(20, 20, 15, 15));
        root.setVgap(5); 
        root.setHgap(5); 
       primaryStage.setTitle("View Customers:");	
       Text Welcome = new Text("Customer Details: ");
       Welcome.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
       

       Button Submit = new Button("SUBMIT");
       Button Back = new Button("BACK");
       Submit.setOnMouseClicked(new EventHandler<MouseEvent>(){
       	public void handle (MouseEvent event)
       	{
	        		
                  S = new submit(C);
                  S.s = S;
                  
       	}
       });
       
       Back.setOnMouseClicked(new EventHandler<MouseEvent>(){
       	public void handle (MouseEvent event)
       	{
       		M1.start(primaryStage);
       			
       	}
       });
         
       
       Button CID = new Button("Enter CID");
       TextField cid = new TextField();
       cid.setPromptText("Enter C_ID");
       
       Button printall = new Button("PrintAll");
       
       Button MonthWise = new Button("TOTAL");
       
       //Button NotWorking = new Button("Not Working");
       
       
     
       CID.setOnMouseClicked(new EventHandler<MouseEvent>(){
       	public void handle (MouseEvent event)
       	{   
                  try{
	        		
                  S = new submit(C,cid.getText());
                  S.s = S;
                  S.start(primaryStage);
                  }
                  catch(SQLException e){

                  }
       	}
       });
       
       printall.setOnMouseClicked(new EventHandler<MouseEvent>(){
       	public void handle (MouseEvent event)
       	{
                  try{
       		S = new submit(C);
                  S.s = S;
                  S.start(primaryStage);
            }
            catch(SQLException e){

                  }

       			
       	}
       });
       
       MonthWise.setOnMouseClicked(new EventHandler<MouseEvent>(){
       	public void handle (MouseEvent event)
       	{
                  try{
       		S = new submit(C,"month");
                  S.s = S;
                  S.start(primaryStage);
            }
            catch(SQLException e){

                  }
       			
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
       root.add(CID,1,4);
       root.add(cid,2,4);
       root.add(printall,1,5);
       root.add(MonthWise,1,6);
       //root.add(NotWorking,1,7);
       root.setAlignment(Pos.CENTER);
       Scene scene = new Scene(root,600,400);
       
       
       primaryStage.setScene(scene);
       primaryStage.setResizable(true);
       primaryStage.show();
   }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
			C = new ViewCustomer(M1);
			launch(args);
	}

}
