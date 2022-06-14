package proyect;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class CalculatorController {

    public String[] partes = { "0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0"};


    public String resultado="";

    public int aux=0;
    public Label textosolu;
    public Label solucion;

    public void bt0(ActionEvent actionEvent) {

        resultado=resultado + "0";
        textosolu.setText(resultado);

    }

    public void bt1(ActionEvent actionEvent) {
        resultado=resultado + "1";
        textosolu.setText(resultado);

    }

    public void bt4(ActionEvent actionEvent) {
        resultado=resultado + "4";
        textosolu.setText(resultado);

    }

    public void bt7(ActionEvent actionEvent) {
        resultado=resultado + "7";
        textosolu.setText(resultado);

    }

    public void bt8(ActionEvent actionEvent) {
        resultado=resultado + "8";
        textosolu.setText(resultado);

    }

    public void bt5(ActionEvent actionEvent) {
        resultado=resultado + "5";
        textosolu.setText(resultado);

    }

    public void bt2(ActionEvent actionEvent) {
        resultado=resultado + "2";
        textosolu.setText(resultado);

    }

    public void btDot(ActionEvent actionEvent) {
        resultado=resultado + ".";
        textosolu.setText(resultado);

    }

    public void bt9(ActionEvent actionEvent) {
        resultado=resultado + "9";
        textosolu.setText(resultado);

    }

    public void bt6(ActionEvent actionEvent) {
        resultado=resultado + "6";
        textosolu.setText(resultado);

    }

    public void bt3(ActionEvent actionEvent) {
        resultado=resultado + "3";
        textosolu.setText(resultado);

    }

    public void btMulti(ActionEvent actionEvent) {
        partes[aux]=resultado;
        aux++;
        partes[aux]="*";
        aux++;
        textosolu.setText(resultado);
        resultado="";

    }

    public void btMas(ActionEvent actionEvent) {
        partes[aux]=resultado;
        aux++;
        partes[aux]="+";
        aux++;
        textosolu.setText(resultado);
        resultado="";

    }

    public void btDivi(ActionEvent actionEvent) {
        partes[aux]=resultado;
        aux++;
        partes[aux]="/";
        aux++;
        textosolu.setText(resultado);
        resultado="";

    }

    public void btMenos(ActionEvent actionEvent) {
        partes[aux]=resultado;
        aux++;
        partes[aux]="-";
        aux++;
        textosolu.setText(resultado);
        resultado="";

    }

    public void btIgual(ActionEvent actionEvent) {
        partes[aux]=resultado;
        float solaux, resultadofinal=0;
        boolean multaux = false, divaux = false, sumaux = false, restaux=false ;
        for(int i=0; i<partes.length; i++)
        {


            if (multaux == true)
            {
                if (i == 2)
                {
                    solaux = Float.parseFloat((partes[i - 2])) *
                            Float.parseFloat((partes[i]));
                    resultadofinal = solaux;

                }
                else
                {
                    resultadofinal *=  Float.parseFloat(partes[i]);
                }

                multaux = false;
            }
            if(divaux == true)
            {
                if (i == 2)
                {
                    solaux = Float.parseFloat((partes[i - 2])) /
                            Float.parseFloat((partes[i]));
                    resultadofinal = solaux;
                }
                else
                {
                    resultadofinal /= Float.parseFloat(partes[i]);
                }

                divaux = false;
            }
            if (sumaux == true)
            {

                if (i == 2)
                {
                    solaux = Float.parseFloat((partes[i - 2])) +
                            Float.parseFloat((partes[i]));
                    resultadofinal = solaux;
                }
                else
                {
                    resultadofinal += Float.parseFloat(partes[i]);
                }

                sumaux = false;
            }
            if(restaux == true)
            {
                if (i == 2)
                {
                    solaux = Float.parseFloat((partes[i - 2])) -
                            Float.parseFloat((partes[i]));
                    resultadofinal = solaux;
                }
                else
                {
                    resultadofinal -= Float.parseFloat(partes[i]);
                }
                restaux = false;
            }
            if (partes[i]== "*")
            {
                multaux = true;

            }
            else if(partes[i] == "/")
            {
                divaux = true;
            }
            else if(partes[i] == "+")
            {
                sumaux = true;
            }
            else if (partes[i] == "-")
            {
                restaux = true;
            }
        }

        solucion.setText(String.valueOf(resultadofinal));
        resultado="";
        resultadofinal=0;
        solaux=0;
        aux=0;
        for(int i=0; i < partes.length; i++)
        {

            partes[i] = "0";
        }
    }

    public void VolverInicio(ActionEvent actionEvent) throws IOException {


        SceneLoader.loadScene("PantallaPrincipal.fxml",
                (Stage) ((Node) actionEvent.getSource()).getScene().getWindow());
    }
}
