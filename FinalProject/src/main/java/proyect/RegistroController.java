package proyect;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class RegistroController {

    public TextField txtUsu;
    public TextField txtContra1;
    public TextField txtContra2;

    public void volversinguardar(ActionEvent actionEvent) throws IOException {
        SceneLoader.loadScene("iniciarsesion.fxml",
                (Stage) ((Node) actionEvent.getSource()).getScene().getWindow());
    }

    public void volver(ActionEvent actionEvent) throws IOException{

        if(txtUsu.getText().equals("") ||
                txtContra1.getText().equals("") || txtContra2.getText().equals(""))
        {
            Alert dialog = new Alert(Alert.AlertType.ERROR);
            dialog.setTitle("Error");
            dialog.setHeaderText("Error adding data");
            dialog.setContentText("No field can be empty");
            dialog.showAndWait();
        }
        else if(!txtContra1.getText().equals(txtContra2.getText())) {
            Alert dialog = new Alert(Alert.AlertType.ERROR);
            dialog.setTitle("Error, las contraseñas no coinciden");
         }
        else {
            PrintWriter printWriter = null;
            String validacion= txtUsu.getText()+";"+txtContra1.getText();
            try
            {
                printWriter = new PrintWriter(new BufferedWriter(
                        new FileWriter("usuarios.txt", true)));

                printWriter.println (validacion);
                printWriter.close();
            }
            catch (IOException e)
            {
                System.err.println("Error writing file: " + e.getMessage());
            }
            SceneLoader.loadScene("iniciarsesion.fxml",
                    (Stage) ((Node) actionEvent.getSource()).getScene().getWindow());
        }


    }
}
