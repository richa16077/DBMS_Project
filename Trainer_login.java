import java.sql.*;
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
import javafx.scene.control.Alert.AlertType;

public class Trainer_login extends Application  {
    static Main_page m;
    static Trainer_login t;
    static Trainer_page cust;
    int flag=0;
    public Trainer_login(Main_page m){
        this.m=m;
    }
    String EnrID;
    @Override
    public void start(Stage primaryStage) throws SQLException {
        primaryStage.setTitle("Hello Trainer");	
        Text Welcome = new Text("WELCOME Trainer");
        Welcome.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        Connection conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/GYMMANAGEMENT", "root", "suyashsingh27");
        Statement stmnt=conn.createStatement();
        Text ID = new Text("Trainer ID : ");
        TextField login_ID=new TextField();
        login_ID.setPromptText("Enter Your ID here");
        
//        Text Pass = new Text("Password : ");
//        PasswordField passwd=new PasswordField();
//        passwd.setPromptText("Enter Your Password here");
        
        Button Submit=new Button("SUBMIT");
        Submit.setOnMouseClicked(new EventHandler<MouseEvent>(){
        	public void handle (MouseEvent event)
        	{
        			try{
                    EnrID=(login_ID.getText());
                    if (!EnrID.substring(0,1).equals("4")) {
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Information Dialog");
                        alert.setHeaderText(null);
                        alert.setContentText("Wrong Login ID");
                        alert.showAndWait();
                    }
                    else{
                    String qry="select T.Name,T.trainerID,T.salary,P.Type from Trainer T,handles H,Package P where T.trainerID=H.trainerID and H.PackID=P.PackID and T.trainerID = ";
                    qry=qry+EnrID + ";";
                    ResultSet rset = stmnt.executeQuery(qry);
                    while(rset.next()) {
                        String name=rset.getString("Name");
                        String trainerID=rset.getString("trainerID");
                        String Salary=rset.getString("salary");
                        String Type=rset.getString("Type");
                        String otpt=("NAME OF USER: "+name+"\n EnrollmentID: "+trainerID+"\n StartDate: "+Salary+"\n Package Type : "+Type);
                        cust=new Trainer_page(otpt,t);
                        cust.start(primaryStage);
                        flag=1;
                    }
                     if (flag==0) {
                                                Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Information Dialog");
                        alert.setHeaderText(null);
                        alert.setContentText("Wrong Login ID");
                        alert.showAndWait();
                    }
                }
              } 
                catch(SQLException ex) {
         ex.printStackTrace();
      }   
        	}
        });
        Button back=new Button("BACK");
        back.setOnMouseClicked(new EventHandler<MouseEvent>(){
        	public void handle (MouseEvent event)
        	{
        		m.start(primaryStage);
        	}
        });
         
        GridPane root = new GridPane(); 
        root.setPadding(new Insets(20, 20, 15, 15));
        root.setVgap(5); 
        root.setHgap(5);    
        root.add(Welcome,1,2);
        root.add(ID,1,3);
        root.add(login_ID,2,3);
//        root.add(Pass,1,4);
//        root.add(passwd,2,4);
        root.add(Submit,1,5);
        root.add(back,2,5);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root,600,200);
        
        primaryStage.setScene(scene);
        primaryStage.setResizable(true);
        primaryStage.show();
    }

    /**
   * This is the main method launching the start method
   *@param args Unused.
   *
   */ 
    public static void main(String[] args) {
   
    	t = new Trainer_login(m);
        launch(args);
    }
    
}