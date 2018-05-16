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
public class ViewRequest extends Application{
	
		static Manage1 M1;
		static ViewRequest R;
        String Req;
        String [] attr;
		public ViewRequest(Manage1 M1, String Req)
		{
		    this.Req=Req;
        	this.M1 = M1;
		}
		@Override
    public void start(Stage primaryStage) throws SQLException{
    	 GridPane root = new GridPane(); 
         root.setPadding(new Insets(20, 20, 15, 15));
         root.setVgap(5); 
         root.setHgap(5); 
         System.out.println(Req);
        Connection conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/GYMMANAGEMENT", "root", "suyashsingh27");
        Statement stmnt=conn.createStatement();
        primaryStage.setTitle("View Request");	
        Text Welcome = new Text("Customer Requests : ");
        Welcome.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        Text rqst = new Text();
        rqst.setText(Req);
        rqst.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

        Button Submit = new Button("CONFIRM");
        Button Back = new Button("BACK");
        attr=Req.split(" ");
        System.out.println(attr[0]);
        String qry="insert into customer "+"values "+"("+attr[0]+","+attr[1]+","+attr[2]+");";
        Submit.setOnMouseClicked(new EventHandler<MouseEvent>(){
        	public void handle (MouseEvent event)
        	{  
                try{
	        		  stmnt.executeUpdate(qry);
                     Req="";
                     System.out.println(" working ");}
                     catch(SQLException e){
                        
                     }


        	}
        });
        
        Back.setOnMouseClicked(new EventHandler<MouseEvent>(){
        	public void handle (MouseEvent event)
        	{
        		M1.start(primaryStage);
        			
        	}
        });
          
        root.add(Welcome,1,3);
        root.add(rqst,1,4);
        root.add(Submit,1,5);
        root.add(Back,1,6);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root,600,400);
        
        
        primaryStage.setScene(scene);
        primaryStage.setResizable(true);
        primaryStage.show();
    }
		
		 public static void main(String[] args) {
			   
		        launch(args);
		    }
		    
	}