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
public class GUINumberOne
{
    private static TextField textFieldMessage1;
    private static TextField textFieldMessage2;
    private static TextField textFieldMessage3;

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
        Stage stage = new Stage();
        stage.setTitle("Top Universities by Ajanth");
        stage.setResizable(false);
        Pane rootPane = new Pane();
        stage.setScene(new Scene(rootPane));
        stage.setWidth(1024);
        stage.setHeight(768);
        stage.show();
        stage.setOnCloseRequest((WindowEvent we) -> terminate());
        
        Label label1 = new Label("Enter details of top university");
        label1.setLayoutX(20);
        label1.setLayoutY(60);
        rootPane.getChildren().add(label1);
        
        textFieldMessage1 = new TextField();
        textFieldMessage1.setLayoutX(20);
        textFieldMessage1.setLayoutY(100);
        textFieldMessage1.setPrefWidth(220);
        textFieldMessage1.setPromptText("Enter ranking");
        rootPane.getChildren().add(textFieldMessage1);
        
        textFieldMessage2 = new TextField();
        textFieldMessage2.setLayoutX(20);
        textFieldMessage2.setLayoutY(140);
        textFieldMessage2.setPrefWidth(220);
        textFieldMessage2.setPromptText("Enter name");
        rootPane.getChildren().add(textFieldMessage2);
        
        textFieldMessage3 = new TextField();
        textFieldMessage3.setLayoutX(20);
        textFieldMessage3.setLayoutY(180);
        textFieldMessage3.setPrefWidth(220);
        textFieldMessage3.setPromptText("Enter country");
        rootPane.getChildren().add(textFieldMessage3);

        Button btn = new Button();
        btn.setText("Enter");
        btn.setLayoutX(20);
        btn.setLayoutY(220);
        btn.setOnAction((ActionEvent ae) -> printMessage());
        rootPane.getChildren().add(btn);
    }

    private static void printYouAreCool() {
        System.out.println("You are cool!");
    }

    private static void printMessage() {
        String message = textFieldMessage1.getText() +"," + textFieldMessage2.getText() + "," + textFieldMessage3.getText();
        System.out.println(message);
    }

    private static void terminate()
    {
        System.out.println("bye bye!");
        System.exit(0);
    }

}
