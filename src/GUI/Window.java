package GUI;


import GUI.*;

import java.awt.Label;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Window extends Application implements Runnable {

    private Thread thread;
    private Pane pane;
    private Scene scene;
    private Canvas canvas;
    private Image fondo;
    private HBox hbox;
    private VBox vbox;
    private javafx.scene.control.Label lblType;
    private javafx.scene.control.Label lblQuantity;
    
    private Image ring, emerald;
    private Button btnSet;
    private Button btnPause;
    private Button btnStop;
    private TextField tfdSize; 
    private TextField tfdType;
    

    private GraphicsContext gc;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("The maze of Threads");
        initComponents(primaryStage);
        primaryStage.setOnCloseRequest(exit);
        primaryStage.show();
    } // start

    private void initComponents(Stage primaryStage) {
        
            try {
                this.hbox=new HBox(10);
                this.vbox=new VBox(10);
                hbox.setSpacing(10);
                vbox.setSpacing(10);
                btnSet=new Button("Start Simulation");
                btnStop=new Button("Stop Threads");
                btnPause= new Button("Pause Characters");
                tfdSize= new TextField();
                tfdType=new TextField();
                tfdSize=new TextField();
                this.lblType=new javafx.scene.control.Label();
                this.lblQuantity=new javafx.scene.control.Label("Choose the quantity of characters");
                ObservableList<String> items = FXCollections.observableArrayList();//para el combobox
                items.addAll("Fast", "Furious", "Smart");//opciones del combobox
                ComboBox<String> cbx = new ComboBox<>(items);//
                cbx.setPromptText("Choose the type of character");
        
                this.pane = new Pane();
                
                this.scene = new Scene(hbox, 1200, 700);
                this.canvas = new javafx.scene.canvas.Canvas(600, 600);
                this.gc = this.canvas.getGraphicsContext2D();
                this.fondo = new Image(new FileInputStream("src/assets/r6tulurfk2.bmp"));
                this.pane.getChildren().add(this.canvas);
                this.vbox.getChildren().addAll(this.lblQuantity, tfdSize, cbx, this.lblType, this.btnSet, this.btnStop);
                this.hbox.getChildren().add(this.pane);
                this.hbox.getChildren().add(this.vbox);
                
                this.thread = new Thread(this);
                primaryStage.setScene(this.scene);
                btnSet.setOnAction((ActionEvent t) -> {
                    
                    this.thread.start();
                });
                btnStop.setOnAction((ActionEvent t) -> {
                    this.thread.interrupt();
                });
                cbx.setOnAction((ActionEvent e) -> { 

                    if(cbx.getValue().equalsIgnoreCase("Fast")){
                        this.lblType.setText("Fast");
                    }
                    else if(cbx.getValue().equalsIgnoreCase("Furious")){
                        this.lblType.setText("Furious");
                    } else{
                        this.lblType.setText("Smart");
                    }
                    
                });
                

                
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    } // initComponents

    EventHandler<WindowEvent> exit = new EventHandler<WindowEvent>() {
        @Override
        public void handle(WindowEvent event) {
            System.exit(0);
        }
    };

    @Override
    public void run() {
        long start;
        long elapsed;
        long wait=10;
        int fps = 30;
        long time = 0;
        
        while (true) {
            try {
                start = System.nanoTime();
                
                elapsed = System.nanoTime() - start;
                wait = 1000;
                Thread.sleep(wait);
                draw(this.gc);
                System.out.println(time);
                time++;
            } catch (InterruptedException ex) {
                Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
    } // run
    

    private void draw(GraphicsContext gc) {
        
        gc.clearRect(0, 0, 1200, 500);
        gc.drawImage(this.fondo, 0, 0, 1200, 500);
        
         
        
        
        
        
        //gc.drawImage(this.emeralda, 545, 445, 35, 35);
    
    } // draw
    

} // fin de la clase
