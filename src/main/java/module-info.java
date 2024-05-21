module com.lifecanvas.lifecanvas {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires org.mariadb.jdbc;
    requires org.checkerframework.checker.qual;

    opens com.lifecanvas.lifecanvas to javafx.fxml;
    exports com.lifecanvas.lifecanvas;
}