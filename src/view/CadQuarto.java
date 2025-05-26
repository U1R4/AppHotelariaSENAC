package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import view.components.Buttons;
import view.components.Sidebar;
import javafx.application.Application;

public class CadQuarto extends Application{

    public void start(Stage stage) throws Exception {

        Image logo = new Image(getClass().getResourceAsStream("/view/resources/img/raccoonIcon.png"));

        Image iconBtnQuarto = new Image(getClass().getResourceAsStream("/view/resources/img/Quarto.png"));
        ImageView imageViewQuarto = new ImageView(iconBtnQuarto);
        imageViewQuarto.setFitHeight(25);
        imageViewQuarto.setFitWidth(25);

        Font fontRegular = Font.loadFont(getClass().getResourceAsStream("/view/resources/fonts/DmSansRegular.ttf"), 12);
        Font fontSemiBold = Font.loadFont(getClass().getResourceAsStream("/view/resources/fonts/DmSansSemiBold.ttf"), 12);

        String styleSemiBold = "-fx-text-fill: #000000;" +
                "-fx-font-size: 18;" +
                "-fx-font-family: '" + fontSemiBold.getFamily() + "';";

        String styleRegular = "-fx-text-fill: #000000;" +
                "-fx-font-size: 12;" +
                "-fx-font-family: '" + fontRegular.getFamily() + "';";

        BorderPane mainPane = new BorderPane();
        mainPane.setStyle("-fx-background-image: url(/view/resources/img/BackGroundMainPane.jpg);");


        Buttons buttons = new Buttons();
        buttons.setAlignment(Pos.CENTER);
        buttons.setPadding(new Insets(20,20,20,20));

        Sidebar sidebar = new Sidebar();
        mainPane.setLeft(sidebar);

        Label lblTitulo = new Label("Cadastro de Quarto");
        lblTitulo.setStyle(styleSemiBold);
        lblTitulo.setAlignment(Pos.CENTER);
        HBox tituloBox = new HBox(imageViewQuarto, lblTitulo);
        tituloBox.setPadding(new Insets(20,20,20,20));
        tituloBox.setAlignment(Pos.CENTER);

        Label lblNome = new Label("Nome");
        lblNome.setStyle(styleRegular);
        TextField txtNome = new TextField();
        txtNome.setMaxWidth(250);

        Label lblNUmero = new Label("Numero do Quarto");
        lblNUmero.setStyle(styleRegular);
        TextField txtNumero = createMaskField("###");
        txtNumero.setMaxWidth(250);

        Label lblPreco = new Label("Preço do Quarto");
        lblPreco.setStyle(styleRegular);
        TextField txtPreco = createMaskField("R$: ###,##");
        txtPreco.setMaxWidth(250);

        Label lblCamaCasal = new Label("Camas de Casal");
        Spinner<Integer> qtdCamaCasal = new Spinner<>(0,2,0);
        qtdCamaCasal.setMaxWidth(250);

        Label lblCamaSolteiro = new Label("Camas de Solteiro");
        Spinner<Integer> qtdCamaSolteiro = new Spinner<>(0,6,0);
        qtdCamaSolteiro.setMaxWidth(250);

        ComboBox dispQuartoOpt = new ComboBox();
        dispQuartoOpt.getItems().addAll("Disponivel","Indisponivel");
        dispQuartoOpt.setMinWidth(250);

        GridPane fromGrid = new GridPane();
        fromGrid.setAlignment(Pos.CENTER);
        fromGrid.add(lblNome,0, 0);
        fromGrid.add(txtNome, 1, 0);
        fromGrid.add(lblNUmero, 0, 1);
        fromGrid.add(txtNumero, 1, 1);
        fromGrid.add(lblPreco, 0, 2);
        fromGrid.add(txtPreco, 1, 2);
        fromGrid.add(lblCamaCasal,0,3);
        fromGrid.add(qtdCamaCasal, 1, 3);
        fromGrid.add(lblCamaSolteiro,0,4);
        fromGrid.add(qtdCamaSolteiro,1,4);
        fromGrid.add(dispQuartoOpt,1,5);
        fromGrid.setHgap(10);
        fromGrid.setVgap(10);

        VBox layout = new VBox(tituloBox, fromGrid,buttons);
        layout.setAlignment(Pos.CENTER);
        mainPane.setCenter(layout);

        Scene scene = new Scene(mainPane, 800,600);
        stage.getIcons().add(logo);
        stage.setTitle("Raccoon Hotel");
        stage.setScene (scene);
        stage.setResizable(false);
        stage.show();
    }

    private TextField createMaskField(String mask) {
        TextField txtMask = new TextField();
        txtMask.textProperty().addListener((observable, oldValue, newValue) -> {
            String value = newValue.replaceAll("[^0-9]", "");
            StringBuilder formatField = new StringBuilder();
            int index = 0;
            for (char caracter : mask.toCharArray()) {
                if (caracter == '#') {
                    if (index < value.length()) {
                        formatField.append(value.charAt(index));
                        index++;
                    } else {
                        break;
                    }
                } else {
                    formatField.append(caracter);
                }
            }
            txtMask.setText(formatField.toString());
        });
        return txtMask;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
