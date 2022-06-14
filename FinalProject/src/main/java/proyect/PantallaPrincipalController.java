package proyect;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

import java.io.IOException;

public class PantallaPrincipalController {
    public void ToCalculator(ActionEvent actionEvent)  throws IOException {
        SceneLoader.loadScene("calculator.fxml",
                (Stage) ((Node) actionEvent.getSource()).getScene().getWindow());
    }

    public void ToBlogNotas(ActionEvent actionEvent)  throws IOException{
        SceneLoader.loadScene("BlogNotas.fxml",
                (Stage) ((Node) actionEvent.getSource()).getScene().getWindow());
    }

}
