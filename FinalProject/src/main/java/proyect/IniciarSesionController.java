package proyect;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class IniciarSesionController {
    public TextField txtUsu;
    public TextField txtContra;

    public void topantallaprincipal(ActionEvent actionEvent) throws IOException {

        boolean usucorrecto=false;

            if(txtUsu.getText().equals("") ||
                    txtContra.getText().equals(""))
            {
                Alert dialog = new Alert(Alert.AlertType.ERROR);
                dialog.setTitle("Error");
                dialog.setHeaderText("Error adding data");
                dialog.setContentText("No field can be empty");
                dialog.showAndWait();
            }
            else
            {
            String infousu= txtUsu.getText()+";"+txtContra.getText();

            try (BufferedReader inputFile = new BufferedReader(
                    new FileReader(new File("usuarios.txt"))))
            {

                String line = null;
                while ((line = inputFile.readLine()) != null)
                {
                    if(line.equals(infousu))
                    {
                        usucorrecto=true;

                    }

                }
            }
            catch (IOException fileError)
            {
                System.err.println(
                        "Error reading file: " +
                                fileError.getMessage() );
            }
            if(usucorrecto==true)
            {
                SceneLoader.loadScene("PantallaPrincipal.fxml",
                        (Stage) ((Node) actionEvent.getSource()).getScene().getWindow());
            }
            else {
                System.out.println("Los datos no son correctos");
                Alert dialog = new Alert(Alert.AlertType.ERROR);
                dialog.setTitle("Error, los datos no coinciden");
            }

        }
    }

    public void registro(ActionEvent actionEvent) throws IOException {
        SceneLoader.loadScene("RegistroUsu.fxml",
                (Stage) ((Node) actionEvent.getSource()).getScene().getWindow());
    }
}
