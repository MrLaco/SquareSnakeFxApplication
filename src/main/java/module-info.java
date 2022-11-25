module ru.kpfu.itis.terletskiy.squaresnakeproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens ru.kpfu.itis.terletskiy.squaresnakeproject to javafx.fxml;
    exports ru.kpfu.itis.terletskiy.squaresnakeproject;
}