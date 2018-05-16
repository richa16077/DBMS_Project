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

public class submit extends Application{
	
	static submit s;
	static ViewCustomer C;
	static ViewTrainer T;
	static ViewEquip E;
	String eid="em";
	public submit(ViewCustomer C) {
		this.C= C;
	}
	public submit(ViewCustomer C,String eid) {
		this.C= C;
		this.eid=eid;
	}
	
	
	
	@Override
	public void start(Stage primaryStage) throws SQLException{
   	 	Connection conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/GYMMANAGEMENT", "root", "suyashsingh27");
         Statement stmnt=conn.createStatement();
		GridPane root = new GridPane(); 
        root.setPadding(new Insets(20, 20, 15, 15));
        root.setVgap(5); 
        root.setHgap(5); 
        String otpt="";
        System.out.println(eid);
        primaryStage.setTitle("Details:");	
        Text Welcome = new Text("Details: ");
        Welcome.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
         Text value = new Text();
         if (eid.equals("month")) {
         	ResultSet rset = stmnt.executeQuery("select Count(*) from customer;");
         	while(rset.next()){
         	value.setText("Total customer : "+rset.getString("Count(*)"));
         	}
         }
         else if (eid.equals("em")) {
         	ResultSet rset = stmnt.executeQuery("select * from customer ;");
         	while(rset.next()){
         		String name=rset.getString("Name");
                String EnrollmentID=rset.getString("EnrollmentID");
                String StartDate=rset.getString("StartDate");
                otpt=otpt+("NAME OF USER: "+name+"\n EnrollmentID: "+EnrollmentID+"\n StartDate: "+StartDate+"\n ");

                value.setText(otpt);
         	}
         }
         else{
         	System.out.println(32);
         	ResultSet rset = stmnt.executeQuery("select C.Name,C.EnrollmentID,C.StartDate,P.Type from customer C,has_opted H,Package P where C.EnrollmentID=H.EnrollmentID and H.PackID=P.PackID and C.EnrollmentID= "+eid+";");
        	while(rset.next()){
        	String name=rset.getString("Name");
            String EnrollmentID=rset.getString("EnrollmentID");
            String StartDate=rset.getString("StartDate");
            String Type=rset.getString("Type");
            otpt=("NAME OF USER: "+name+"\n EnrollmentID: "+EnrollmentID+"\n StartDate: "+StartDate+"\n Package Type : "+Type+"\n ");
            value.setText(otpt);
}
         }
        
        Button Back = new Button("BACK");
        
        Back.setOnMouseClicked(new EventHandler<MouseEvent>(){
           	public void handle (MouseEvent event)
           	{
           		C.start(primaryStage);
           			
           	}
           });
        root.add(Welcome,1,1);
        root.add(Back,4,4);
        root.add(value,1,2);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root,400,300);
        
        
        primaryStage.setScene(scene);
        primaryStage.setResizable(true);
        primaryStage.show();
        
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			
			launch(args);
	}

}
