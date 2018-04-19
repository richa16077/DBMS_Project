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

public class submitE extends Application{
	
	static submitE se;
	//static ViewCustomer C;
	//static ViewTrainer T;
	static ViewEquip E;
	
	
	public submitE(ViewEquip E) {
		this.E= E;
		
	}
	
	
	@Override
	public void start(Stage primaryStage) {
   	 	
		GridPane root = new GridPane(); 
        root.setPadding(new Insets(20, 20, 15, 15));
        root.setVgap(5); 
        root.setHgap(5); 
        
        primaryStage.setTitle("Details:");	
        Text Welcome = new Text("Details: ");
        Welcome.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        
        
        Button Back = new Button("BACK");
        
        Back.setOnMouseClicked(new EventHandler<MouseEvent>(){
           	public void handle (MouseEvent event)
           	{
           		E.start(primaryStage);
           			
           	}
           });
        
        root.add(Welcome,1,1);
        root.add(Back,4,4);
        
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root,600,400);
        
        
        primaryStage.setScene(scene);
        primaryStage.setResizable(true);
        primaryStage.show();
        
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			//s = new submit(C);
			//st = new submitT(T);
			se = new submitE(E);
			
			launch(args);
	}

}

