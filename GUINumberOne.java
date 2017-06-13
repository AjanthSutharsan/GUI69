import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
public class GUINumberOne
{
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

    public static void initialiseGUI()
    {
        Stage stage = new Stage();
        Pane rootPane = new Pane();
        stage.setScene(new Scene(rootPane));   
     
        stage.show();
    }

}
