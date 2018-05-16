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

public class submitT extends Application{
	
	static submitT st;
	//static ViewCustomer C;
	static ViewTrainer T;
	//static ViewEquip E;
	String tid="al";
	
	public submitT(ViewTrainer T) {
		this.T= T;
		
	}
	public submitT(ViewTrainer T, String tid) {
		this.T= T;
		this.tid=tid;
		
	}
	
	@Override
	public void start(Stage primaryStage)throws SQLException {
   	 	
		GridPane root = new GridPane(); 
        root.setPadding(new Insets(20, 20, 15, 15));
        root.setVgap(5); 
        root.setHgap(5); 
       String otpt="";
        Connection conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/GYMMANAGEMENT", "root", "suyashsingh27");
         Statement stmnt=conn.createStatement();
        primaryStage.setTitle("Details:");	
        Text Welcome = new Text("Details: ");
        Welcome.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        Text value = new Text();
        
        Button Back = new Button("BACK");
        if (tid.equals("al")) {
        	ResultSet rset= stmnt.executeQuery("select * from Trainer ;");
        	while(rset.next()){
        		String name=rset.getString("Name");
                String EnrollmentID=rset.getString("trainerID");
                String StartDate=rset.getString("salary");
                otpt=otpt+("NAME OF USER: "+name+"\n EnrollmentID: "+EnrollmentID+"\n StartDate: "+StartDate+"\n ");

                value.setText(otpt);
        	}
        }
        else if (tid.equals("pkg")) {
        	ResultSet rset= stmnt.executeQuery("select SUM(T.salary) from Trainer T,handles H,Package P where T.trainerID=H.trainerID and H.PackID=P.PackID group by Type;");
        	while(rset.next()){
        		String name=rset.getString("SUM(T.salary)");
        		otpt=otpt+"Package wise salary : "+name+"\n";
        		 value.setText(otpt);
        	}
        }
        else{
        	ResultSet rset= stmnt.executeQuery("select T.Name,T.trainerID,T.salary,P.Type from Trainer T,handles H,Package P where T.trainerID=H.trainerID and H.PackID=P.PackID and T.trainerID = "+tid);
        	while(rset.next()){
        		String name=rset.getString("Name");
                        String trainerID=rset.getString("trainerID");
                        String Salary=rset.getString("salary");
                        String Type=rset.getString("Type");
                        otpt=("NAME OF USER: "+name+"\n EnrollmentID: "+trainerID+"\n StartDate: "+Salary+"\n Package Type : "+Type);
                         value.setText(otpt);
        	}
        }
        
        Back.setOnMouseClicked(new EventHandler<MouseEvent>(){
           	public void handle (MouseEvent event)
           	{
           		try{
           		T.start(primaryStage);
           	}
           	 catch(SQLException e){

                  }	
           	}
           });
        
        root.add(Welcome,1,1);

        root.add(Back,4,4);
        
        root.add(value,1,2);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root,600,400);
        
        
        primaryStage.setScene(scene);
        primaryStage.setResizable(true);
        primaryStage.show();
        
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			//s = new submit(C);
			st = new submitT(T);
			//s = new submit(E);
			
			launch(args);
	}

}

