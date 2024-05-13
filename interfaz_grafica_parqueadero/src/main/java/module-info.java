module co.edu.uniquindio.poo.interfaz_grafica_parqueadero {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.poo.interfaz_grafica_parqueadero to javafx.fxml;
    exports co.edu.uniquindio.poo.interfaz_grafica_parqueadero;
}