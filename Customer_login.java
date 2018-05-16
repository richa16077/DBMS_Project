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
import javafx.scene.control.Alert.AlertType;

public class Customer_login extends Application  {
	signup_page p;
    static Main_page m;
    static Customer_login c;
    static Customer_page cust;
    int flag=0;
    public Customer_login(Main_page m){
        this.m=m;
    }
    String EnrID;
    @Override
    public void start(Stage primaryStage) throws SQLException {
        
        Connection conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/GYMMANAGEMENT", "root", "suyashsingh27");
        Statement stmnt=conn.createStatement();
         primaryStage.setTitle("Hello Customer");	
        Text Welcome = new Text("WELCOME USER");
        Welcome.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        Text ID = new Text("Login ID : ");
        TextField login_ID=new TextField();
        login_ID.setPromptText("Enter Your ID here");
        //Text Pass = new Text("Password : ");
        //PasswordField passwd=new PasswordField();
        //passwd.setPromptText("Enter Your Password here");
        Button Submit=new Button("SUBMIT");
        Submit.setOnMouseClicked(new EventHandler<MouseEvent>(){
        	public void handle (MouseEvent event) 
        	{
                try{
        			EnrID=(login_ID.getText());
                    System.out.println(EnrID);
                    if (!EnrID.substring(0,1).equals("1")) {
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Information Dialog");
                        alert.setHeaderText(null);
                        alert.setContentText("Wrong Login ID");
                        alert.showAndWait();
                    }
                    else{

                    String qry="select C.Name,C.EnrollmentID,C.StartDate,P.Type from customer C,has_opted H,Package P where C.EnrollmentID=H.EnrollmentID and H.PackID=P.PackID and C.EnrollmentID = ";
                    qry=qry+EnrID + ";";
                    ResultSet rset = stmnt.executeQuery(qry);
                    while(rset.next()) {
                        String name=rset.getString("Name");
                        String EnrollmentID=rset.getString("EnrollmentID");
                        String StartDate=rset.getString("StartDate");
                        String Type=rset.getString("Type");
                        String otpt=("NAME OF USER: "+name+"\n EnrollmentID: "+EnrollmentID+"\n StartDate: "+StartDate+"\n Package Type : "+Type);
                        cust=new Customer_page(otpt,c);
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
         Button nuser=new Button("Sign up");
        nuser.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle (MouseEvent event)
            {
              try{
                p = new signup_page(c);
                
                p.start(primaryStage);
            }
            catch(SQLException e){
                
            }
            }
        });
        GridPane root = new GridPane(); 
        root.setPadding(new Insets(20, 20, 15, 15));
        root.setVgap(5); 
        root.setHgap(5);    
        root.add(Welcome,1,2);
        root.add(ID,1,3);
        root.add(login_ID,2,3);
        //root.add(Pass,1,4);
        //root.add(passwd,2,4);
        root.add(Submit,1,5);
        root.add(back,2,5);
        root.add(nuser,3,5);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root,500,200);
        
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
   
    	c = new Customer_login(m);
        launch(args);
    }
    
}
