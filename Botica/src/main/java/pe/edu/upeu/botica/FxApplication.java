package pe.edu.upeu.botica;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class FxApplication extends Application {

    private ConfigurableApplicationContext context;

    @Override
    public void init() {
        context = new SpringApplicationBuilder(BoticaApplication.class).run();
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CitaView.fxml"));
        loader.setControllerFactory(context::getBean); // 👈 Ahora Spring maneja los controllers
        Parent root = loader.load();

        stage.setTitle("Sistema de Citas - Botica");
        stage.setScene(new Scene(root));
        stage.show();
    }

    @Override
    public void stop() {
        context.close();
    }
}
