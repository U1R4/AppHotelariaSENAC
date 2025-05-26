package view.components;

import com.sun.javafx.stage.EmbeddedWindow;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import view.CadCliente;
import view.CadFuncionario;
import view.CadQuarto;

public class Sidebar extends VBox {
    public Button btnCliente = new Button("Clientes");
    public Button btnFuncionario = new Button("Funcionarios");
    public Button btnQuarto = new Button("Quartos");
    public Button btnReserva = new Button("Reservas");
    public Button btnRelatorio = new Button("Relatorio");

    public Sidebar() {
        Font fontRegular = Font.loadFont(getClass().getResourceAsStream("/view/resources/fonts/DmSansRegular.ttf"), 12);
        Font fontSemiBold = Font.loadFont(getClass().getResourceAsStream("/view/resources/fonts/DmSansSemiBold.ttf"), 12);

        btnCliente.setFont(Font.font(fontRegular.getFamily(), 20));
        btnCliente.setStyle("-fx-border-radius: 15px;-fx-background-radius: 15px");

        btnFuncionario.setFont(Font.font(fontRegular.getFamily(), 20));
        btnFuncionario.setStyle("-fx-border-radius: 15px;-fx-background-radius: 15px");

        btnQuarto.setFont(Font.font(fontRegular.getFamily(), 20));
        btnQuarto.setStyle("-fx-border-radius: 15px;-fx-background-radius: 15px");

        btnReserva.setFont(Font.font(fontRegular.getFamily(), 20));
        btnReserva.setStyle("-fx-border-radius: 15px;-fx-background-radius: 15px");

        btnRelatorio.setFont(Font.font(fontRegular.getFamily(), 20));
        btnRelatorio.setStyle("-fx-border-radius: 15px;-fx-background-radius: 15px");

        String styleButton = "-fx-background-color: transparent;"+
                             "-fx-border-color: transparent;"+
                             "-fx-graphic-text-gap: 10px;"+
                             "-fx-cursor: hand;" +
                             "-fx-text-fill: #000000;" +
                             "-fx-font-size: 14;" +
                             "-fx-font-family: '" + fontRegular.getFamily() + "';"+"-fx-border-radius: 15px;-fx-background-radius: 15px";
        btnCliente.setStyle(styleButton);
        btnFuncionario.setStyle(styleButton);
        btnQuarto.setStyle(styleButton);
        btnReserva.setStyle(styleButton);
        btnRelatorio.setStyle(styleButton);

        btnCliente.setOnMouseEntered(evento ->
                btnCliente.setStyle(styleButton.replace("transparent", "#7e8b93")));
        btnCliente.setOnMouseExited(evento -> btnCliente.setStyle(styleButton));

        btnFuncionario.setOnMouseEntered(evento ->
                btnFuncionario.setStyle(styleButton.replace("transparent", "#7e8b93")));
        btnFuncionario.setOnMouseExited(evento -> btnFuncionario.setStyle(styleButton));

        btnQuarto.setOnMouseEntered(evento ->
                btnQuarto.setStyle(styleButton.replace("transparent", "#7e8b93")));
        btnQuarto.setOnMouseExited(evento -> btnQuarto.setStyle(styleButton));

        btnReserva.setOnMouseEntered(evento ->
                btnReserva.setStyle(styleButton.replace("transparent", "#7e8b93")));
        btnReserva.setOnMouseExited(evento -> btnReserva.setStyle(styleButton));

        btnRelatorio.setOnMouseEntered(evento ->
                btnRelatorio.setStyle(styleButton.replace("transparent", "#7e8b93")));
        btnRelatorio.setOnMouseExited(evento -> btnRelatorio.setStyle(styleButton));
;
        Image iconBtnCliente = new Image(getClass().getResourceAsStream("/view/resources/img/Cliente.png"));
        Image iconBtnFuncionario = new Image(getClass().getResourceAsStream("/view/resources/img/Funcionario.png"));
        Image iconBtnQuarto = new Image(getClass().getResourceAsStream("/view/resources/img/Quarto.png"));
        Image iconBtnReserva = new Image(getClass().getResourceAsStream("/view/resources/img/Reserva.png"));
        Image iconBtnRelatorio = new Image(getClass().getResourceAsStream("/view/resources/img/Relatorio.png"));

        Image minimalHotel = new Image(getClass().getResourceAsStream("/view/resources/img/raccoonIcon.png"));
        ImageView vMinimalHotel = new ImageView(minimalHotel);
        vMinimalHotel.setFitHeight(80);
        vMinimalHotel.setFitWidth(80);
        VBox image = new VBox(vMinimalHotel);
        image.setAlignment(Pos.BOTTOM_CENTER);

        ImageView viewIconCliente = new ImageView(iconBtnCliente);
        viewIconCliente.setFitWidth(30);
        viewIconCliente.setFitHeight(30);

        ImageView viewIconFuncionario = new ImageView(iconBtnFuncionario);
        viewIconFuncionario.setFitWidth(30);
        viewIconFuncionario.setFitHeight(30);

        ImageView viewIconQuarto = new ImageView(iconBtnQuarto);
        viewIconQuarto.setFitWidth(30);
        viewIconQuarto.setFitHeight(30);

        ImageView viewIconReserva = new ImageView(iconBtnReserva);
        viewIconReserva.setFitWidth(30);
        viewIconReserva.setFitHeight(30);

        ImageView viewIconRelatorio = new ImageView(iconBtnRelatorio);
        viewIconRelatorio.setFitWidth(30);
        viewIconRelatorio.setFitHeight(30);

        btnCliente.setGraphic(viewIconCliente);
        btnFuncionario.setGraphic(viewIconFuncionario);
        btnQuarto.setGraphic(viewIconQuarto);
        btnReserva.setGraphic(viewIconReserva);
        btnRelatorio.setGraphic(viewIconRelatorio);

        setSpacing(15);
        setPadding(new Insets(20));
        Label lblMenu = new Label("Raccoon Hotel");
        lblMenu.setStyle("-fx-text-fill: #000000;");
        lblMenu.setFont(Font.font(fontSemiBold.getFamily(), 20));
        setMargin(lblMenu, new Insets(0, 0, 20, 0));

        setStyle("-fx-background-color: #8D9BA4;");
        getChildren().addAll(lblMenu, btnCliente, btnFuncionario, btnQuarto, btnReserva, btnRelatorio, vMinimalHotel);
    }
}