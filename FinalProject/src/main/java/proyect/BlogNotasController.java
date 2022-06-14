package proyect;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BlogNotasController {
    public TextField txtfecha;
    public TextField txtdes;
    public TextField txtnombre;

    public List<Notas> notas = new ArrayList<>();

    public void anyadir(ActionEvent actionEvent) {

        boolean comprobar=true;
        LocalDate userDate = null;

        if(txtnombre.getText().equals("") ||
                txtdes.getText().equals("") || txtfecha.getText().equals(""))
        {
            Alert dialog = new Alert(Alert.AlertType.ERROR);
            dialog.setTitle("Error");
            dialog.setHeaderText("Error adding data");
            dialog.setContentText("No field can be empty");
            dialog.showAndWait();
        }
        try
        {

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-dd-MM");

            userDate = LocalDate.parse(txtfecha.getText(), formatter);
            System.out.println(userDate);
        }
        catch (Exception e)
        {
            Alert dialog = new Alert(Alert.AlertType.ERROR);
            dialog.setTitle("Error");
            dialog.setHeaderText("Error al introducir la fecha");
            comprobar=false;
        }

       if(comprobar==true) {

           notas.add(new Notas(txtnombre.getText(),txtdes.getText(),userDate));




        }
    }

    public void ver(ActionEvent actionEvent) throws IOException{

        try
        {
            PrintWriter printWriter = new PrintWriter(new BufferedWriter(
                    new FileWriter("notas.txt", true)));
            for(int i=0; i < notas.size(); i++){
                printWriter.println (notas.get(i));
            }

            printWriter.close();
        }
        catch (IOException e)
        {
            System.err.println("Error writing file: " + e.getMessage());
        }
         SceneLoader.loadScene("vernotas.fxml",
                    (Stage) ((Node) actionEvent.getSource()).getScene().getWindow());
    }
}
