package proyect;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class VerNotasController {

    public List<Notas> notas = new ArrayList<>();
    public ListView vistaNotas;
    public boolean vernotas1=false;
    public boolean vernotas2=false;


    public void notasLista(List<Notas> notas)
    {

        try (BufferedReader inputFile = new BufferedReader(
                new FileReader(new File("notas.txt"))))
        {

            String line = null;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            while ((line = inputFile.readLine()) != null)
            {
                String[] parts = line.split(";");
                notas.add(new Notas(parts[0], parts[1],LocalDate.parse(parts[2],formatter)));


            }
        }
        catch (IOException fileError)
        {
            System.err.println(
                    "Error reading file: " +
                            fileError.getMessage() );
        }
    }

    public void veralf(ActionEvent actionEvent) {
        vernotas2=false;
        notasLista(notas);

        if(vernotas1==false) {

            for (int i = 0; i < notas.size(); i++) {
                vistaNotas.getItems().addAll(notas.get(i));
            }
        }
        vernotas1=true;
    }

    public void borrar(ActionEvent actionEvent) {
        System.out.println(vistaNotas.getFocusModel().getFocusedIndex());
        vistaNotas.getItems().remove(vistaNotas.getFocusModel().getFocusedIndex());
    }

    public void verfecha(ActionEvent actionEvent) {
        vernotas1=false;
        notasLista(notas);

        if(vernotas1==false) {

            for (int i = 0; i < notas.size(); i++) {
                vistaNotas.getItems().addAll(notas.get(i));
            }
        }
        vernotas2=true;
    }

    public void volver(ActionEvent actionEvent) throws IOException{
        vernotas1=false;
        vernotas2=false;
        SceneLoader.loadScene("BlogNotas.fxml",
                (Stage) ((Node) actionEvent.getSource()).getScene().getWindow());
    }
}
