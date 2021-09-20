module com.splyndidxyz.job.opening.tracker {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;
    requires java.sql;
    requires java.sql.rowset;
    requires org.hibernate.orm.core;
    requires org.hibernate.validator;
    opens com.splyndidxyz.jobopeningtracker.data to org.hibernate.orm.core;

    exports com.splyndidxyz.jobopeningtracker;
    requires javafx.graphicsEmpty;
}
