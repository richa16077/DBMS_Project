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
public class Manage1 extends Application{
	
	static Main_page m;
	static Manage1 M1;
	static ViewRequest V_R;
	static ViewEquip V_E;
	static ViewTrainer V_T;
	static ViewCustomer V_C;
	static Modify MY;
	
    public Manage1(Main_page m){
        this.m=m;
    }
    
    @Override
    
    public void start(Stage primaryStage) {
    	 GridPane root = new GridPane(); 
         root.setPadding(new Insets(20, 20, 15, 15));
         root.setVgap(5); 
         root.setHgap(5); 
        primaryStage.setTitle("Managing Portal");	
        Text Welcome = new Text("WELCOME MANAGER");
        Welcome.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        
//        Text ID = new Text("Trainer ID : ");
//        TextField login_ID=new TextField();
//        login_ID.setPromptText("Enter Your ID here");
//        
//        Text Pass = new Text("Password : ");
//        PasswordField passwd=new PasswordField();
//        passwd.setPromptText("Enter Your Password here");
        
        Button VR = new Button("View Requests");
        Button VE = new Button("View Equipments");
        Button VT = new Button("View Trainers");
        Button VC = new Button("View Customers");
        Button modify = new Button("Modify");
        
        
        
        VR.setOnMouseClicked(new EventHandler<MouseEvent>(){
        	public void handle (MouseEvent event)
        	{
	        		
        		V_R = new ViewRequest(M1);
        		V_R.R = V_R;
        		V_R.start(primaryStage);
        		
        			
        	}
        });
        
        VE.setOnMouseClicked(new EventHandler<MouseEvent>(){
        	public void handle (MouseEvent event)
        	{
        		V_E = new ViewEquip(M1);
        		V_E.E = V_E;
        		V_E.start(primaryStage);
        		
        			
        	}
        });
        
        VT.setOnMouseClicked(new EventHandler<MouseEvent>(){
        	public void handle (MouseEvent event)
        	{
        		V_T = new ViewTrainer(M1);
        		V_T.T= V_T;
        		V_T.start(primaryStage);
        	}
        });
        
        VC.setOnMouseClicked(new EventHandler<MouseEvent>(){
        	public void handle (MouseEvent event)
        	{
        		V_C = new ViewCustomer(M1);
        		V_C.C = V_C;
        		V_C.start(primaryStage);
        	}
        });
        
        modify.setOnMouseClicked(new EventHandler<MouseEvent>(){
        	public void handle (MouseEvent event)
        	{
        		MY = new Modify(M1);
        		MY.my = MY;
        		MY.start(primaryStage);
        			
        	}
        });
        
        
        Button logout=new Button("Logout");
        logout.setOnMouseClicked(new EventHandler<MouseEvent>(){
        	public void handle (MouseEvent event)
        	{
        		m.start(primaryStage);
        	}
        });
//         Button nuser=new Button("Sign up");
//        nuser.setOnMouseClicked(new EventHandler<MouseEvent>(){
//            public void handle (MouseEvent event)
//            {
//            	 p = new signup_T(t);
//                 p.start(primaryStage);
//            }
//        });
          
        root.add(Welcome,1,3);
        root.add(VR,1,4);
        root.add(VE,1,5);
        root.add(VT,1,6);
        root.add(VC,1,7);
        root.add(modify,1,8);
        root.add(logout, 1, 11);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root,600,400);
        
        
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
   
    	M1 = new Manage1(m);
        launch(args);
    }
    
}