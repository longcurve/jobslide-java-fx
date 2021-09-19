module com.splyndidxyz.job.opening.tracker {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;
    requires java.sql;
    requires java.sql.rowset;
    requires hibernate.core;
    requires hibernate.validator;

    opens com.splyndidxyz.jobopeningtracker to javafx.fxml;
    exports com.splyndidxyz.jobopeningtracker;
    requires javafx.graphicsEmpty;
}
