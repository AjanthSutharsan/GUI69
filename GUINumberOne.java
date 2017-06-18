import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.stage.WindowEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.ListView;
import java.util.ArrayList;
import javafx.scene.input.MouseEvent;
public class GUINumberOne
{
    private static TextField textFieldMessage1;
    private static TextField textFieldMessage2;
    private static TextField textFieldMessage3;
    private static ListView<University> uniListView;
    private static ArrayList<University> uniArrList = new ArrayList<University>();
    private static University currentlySelectedUniversity = null;
    
    public static void main(String[] args) {
        launchFX();
    }

    private static void launchFX()
    {
        // Initialises JavaFX
        new JFXPanel();
        // Runs initialisation on the JavaFX thread
        Platform.runLater(() -> initialiseGUI());
    }

    private static void initialiseGUI()
    {
        Stage stage = new Stage(); //defines the stage object
        stage.setTitle("Top Universities by Ajanth"); //creates the title for the stage which is shown at the top of the stage
        stage.setResizable(false); //decides whether or not the user can make the stage bigger or not
        Pane rootPane = new Pane(); //defines the pane object
        stage.setScene(new Scene(rootPane)); //defines the scene object
        stage.setWidth(1024); //sets the initial width of the stage
        stage.setHeight(768); //sets the initial height of the stage
        stage.show(); //makes sure the stage is shown to the user
        stage.setOnCloseRequest((WindowEvent we) -> terminate()); //alows the user to properly terminate the GUI without having to terminate the program using the debugger
        
        Label label1 = new Label("Enter details of top university"); //defines the text within the label
        label1.setLayoutX(20); //assigns the horizontal position of the top left hand section of the label
        label1.setLayoutY(60); //asigns the vertical position of the top left hand section of the label
        rootPane.getChildren().add(label1); //makes the label appear in the pane

        textFieldMessage1 = new TextField();
        textFieldMessage1.setLayoutX(20); //assigns the horizontal position of the top left hand section of the textfield
        textFieldMessage1.setLayoutY(100); //asigns the vertical position of the top left hand section of the textfield
        textFieldMessage1.setPrefWidth(220); //defines the width of the Textfield that is shown in the GUI
        textFieldMessage1.setPromptText("Enter ranking"); //defines the text within the textfield when the cursor is off the GUI
        rootPane.getChildren().add(textFieldMessage1); //makes the textfield appear in the pane

        textFieldMessage2 = new TextField();
        textFieldMessage2.setLayoutX(20); //assigns the horizontal position of the top left hand section of the textfield
        textFieldMessage2.setLayoutY(140); //asigns the vertical position of the top left hand section of the textfield
        textFieldMessage2.setPrefWidth(220); //defines the width of the Textfield that is shown in the GUI
        textFieldMessage2.setPromptText("Enter name"); //defines the text within the textfield when the cursor is off the GUI
        rootPane.getChildren().add(textFieldMessage2); //makes the textfield appear in the pane

        textFieldMessage3 = new TextField();
        textFieldMessage3.setLayoutX(20); //assigns the horizontal position of the top left hand section of the textfield
        textFieldMessage3.setLayoutY(180); //asigns the vertical position of the top left hand section of the textfield
        textFieldMessage3.setPrefWidth(220); //defines the width of the Textfield that is shown in the GUI
        textFieldMessage3.setPromptText("Enter country"); //defines the text within the textfield when the cursor is off the GUI
        rootPane.getChildren().add(textFieldMessage3); //makes the textfield appear in the pane
        
        uniListView = new ListView<University>();
        uniListView.setLayoutX(700); //assigns the horizontal position of the top left hand section of the ListView
        uniListView.setLayoutY(50); //asigns the vertical position of the top left hand section of the ListView
        uniListView.setOnMouseClicked((MouseEvent me) -> {
            currentlySelectedUniversity = uniListView.getSelectionModel().getSelectedItem();
        }); //when one of the objects in the ListView is clicked on, that specific object becomes the currentlySelectedUniversity
        rootPane.getChildren().add(uniListView); //makes the ListView appear in the pane
        updateListView(); //calls the updateListView() method
        
        Button btn = new Button();
        btn.setText("Add"); //defines the text within the button
        btn.setLayoutX(20); //assigns the horizontal position of the top left hand section of the button
        btn.setLayoutY(220); //asigns the vertical position of the top left hand section of the button
        btn.setOnAction((ActionEvent ae) -> addNewItem()); //when the button is click, the addNewItem() method is called
        rootPane.getChildren().add(btn); //makes the button appear in the pane
        
        Button btn1 = new Button();
        btn1.setText("Delete"); //defines the text within the button
        btn1.setLayoutX(20); //assigns the horizontal position of the top left hand section of the button
        btn1.setLayoutY(260); //asigns the vertical position of the top left hand section of the button
        btn1.setOnAction((ActionEvent ae) -> deleteItem()); //when the button is click, the deleteItem() method is called
        rootPane.getChildren().add(btn1); //makes the button appear in the pane
        
        // load the image
        Image image = new Image("CompleteUniversityGuideLogo.png");
        ImageView iv1 = new ImageView();
        iv1.setImage(image); //the Image to be painted by this ImageView
        iv1.setLayoutX(20); //assigns the horizontal position of the top left hand section of the image
        iv1.setLayoutY(360); //asigns the vertical position of the top left hand section of the image
        iv1.setFitWidth(500); //the width of the bounding box within which the source image is resized as necessary to fit
        iv1.setPreserveRatio(true); //indicates whether to preserve the aspect ratio of the source image when scaling to fit the image within the fitting bounding box, and as it is true and FitWidth is set, the height is scaled to preserve the ratio
        rootPane.getChildren().add(iv1); //makes the image appear in the pane
    }

    private static void printYouAreCool() {
        System.out.println("You are cool!"); //prints "You are cool!" to the terminal window
    }

    private static void printMessage() {
        String message = Integer.parseInt(textFieldMessage1.getText()) +"," + textFieldMessage2.getText() + "," + textFieldMessage3.getText(); //Concatenates all of the inputs from the textfields into one 
        System.out.println(message); //prints the message to the terminal window
    }
    
    private static void addNewItem() {
        int ranking = Integer.parseInt(textFieldMessage1.getText()); //casts the input into this textField to integer as rankings are of the integer type
        String name = textFieldMessage2.getText(); //takes the input of this textfield
        String country = textFieldMessage3.getText(); //takes the input of this textfield
        uniArrList.add(new University(ranking, name, country)); //creates a University object from the three attributes
        updateListView(); //calls the updateListView() method
    }
    
    private static void deleteItem() {
        uniArrList.remove(currentlySelectedUniversity); //removes the object that is clicked on from uniArrList
        updateListView(); //calls the updateListView() method
 
    }
    
    private static void updateListView() {
        uniListView.getItems().clear(); //deletes everything in the ListView
        for(University uni: uniArrList) { //for every University object in uniArrList
            uniListView.getItems().add(uni); //put each University object into the ListView
        }
    }
    
    private static void terminate()
    {
        System.out.println("bye bye!"); //prints "bye bye" to the terminal window
        System.exit(0); //the program is fully terminated
    }

}
