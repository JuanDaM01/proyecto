package co.edu.uniquindio.poo.interfaz_grafica_parqueadero;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController {
    @FXML private TextField txtPlaca, txtModelo, txtPropietario, txtTipoMoto, txtVelocidadMaxima;
    @FXML private ComboBox<String> comboTipo;
    @FXML private ListView<Vehiculo> listVehiculos;

    @FXML
    private void initialize() {
        comboTipo.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            boolean isMoto = "Moto".equals(newVal);
            txtTipoMoto.setVisible(isMoto);
            txtVelocidadMaxima.setVisible(isMoto);
        });
    }

    @FXML
    protected void handleRegistrarEntrada() {
        String placa = txtPlaca.getText();
        String modelo = txtModelo.getText();
        String propietario = txtPropietario.getText();
        String tipo = comboTipo.getValue();
        Vehiculo vehiculo = null;
        if ("Carro".equals(tipo)) {
            vehiculo = new Carro(placa, modelo, propietario);
        } else if ("Moto".equals(tipo)) {
            String tipoMoto = txtTipoMoto.getText();
            int velocidadMaxima = Integer.parseInt(txtVelocidadMaxima.getText());
            vehiculo = new Moto(placa, modelo, propietario, tipoMoto, velocidadMaxima);
        }
        listVehiculos.getItems().add(vehiculo);
        txtPlaca.clear();
        txtModelo.clear();
        txtPropietario.clear();
        txtTipoMoto.clear();
        txtVelocidadMaxima.clear();
        comboTipo.getSelectionModel().clearSelection();
    }

    @FXML
    protected void handleRegistrarSalida() {
        Vehiculo vehiculo = listVehiculos.getSelectionModel().getSelectedItem();
        if (vehiculo != null) {
            listVehiculos.getItems().remove(vehiculo);
        }
    }
}


