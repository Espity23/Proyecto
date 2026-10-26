import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class FoodFlow {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignorada) { }
        SwingUtilities.invokeLater(() -> new VentanaPrincipal(new Restaurante()).setVisible(true));
    }
}
