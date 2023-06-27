module fr.net.asclepiosh.outilcalculgreve {
    requires javafx.controls;
    requires javafx.fxml;
            
        requires org.controlsfx.controls;
                    requires org.kordamp.ikonli.javafx;
                
    opens fr.net.asclepiosh.outilcalculgreve to javafx.fxml;
    exports fr.net.asclepiosh.outilcalculgreve;
}