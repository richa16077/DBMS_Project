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
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Button; 
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField; 
import javafx.scene.layout.GridPane; 
import javafx.scene.text.Text; 
import javafx.scene.control.TextField; 
import javafx.stage.Stage;
import javafx.scene.control.*; 
import javafx.scene.input.MouseEvent;
import java.io.*;
import java.sql.*;


public class signup_page extends Application{
	
	static Customer_login c;
	Button button1;
	Button button2;
	
	public signup_page(Customer_login c) {
		
		this.c = c;
	}
	String request="";
        int Eid;
	
	@Override
	public void start(Stage primaryStage) throws SQLException{
                Connection conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/GYMMANAGEMENT", "root", "suyashsingh27");
                Statement stmnt=conn.createStatement();
		ResultSet rset = stmnt.executeQuery("select Max(EnrollmentID) from customer;");
                rset.next();
                Eid=rset.getInt("Max(EnrollmentID)");
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
        		++Eid;
                        if (rb1.isSelected()) {
                                request=NAME.getText()+" "+Eid+" "+java.time.LocalDate.now()+"  Package 1";
                        }
                        else if (rb2.isSelected()) {
                                request=NAME.getText()+" "+Eid+" "+java.time.LocalDate.now()+"  Package 1";
                         }
                        else{
                                request=NAME.getText()+" "+Eid+ " "+java.time.LocalDate.now()+"  Package 1";
                        }
                        
                        c.m.request=request;
                        c.m.start(primaryStage);

        	}
        });
        
        button2 = new Button("BACK");
        button2.setOnMouseClicked(new EventHandler<MouseEvent>(){
        	public void handle (MouseEvent event)
        	{
                        try{
                        c.c=c;
        		c.start(primaryStage);
                }
                catch(SQLException ex){

                }
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
        //root.add(nuser,3,5);
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


























