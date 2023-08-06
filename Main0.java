import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import java.awt.Font;

public class Main0 {
    public static void main(String[] args) {
        // Запускаем Swing в безопасном потоке диспетчеризации событий
        SwingUtilities.invokeLater(() -> {
            // Создаем и настраиваем окно
            JFrame frame = new JFrame("Simple Example of Swing App");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(480, 320);

            // Добавляем метку с текстом
            JLabel label = new JLabel("JAVA on Manjaro Linux", JLabel.CENTER);
            label.setFont(new Font("Serif", Font.PLAIN, 24)); // Устанавливаем шрифт
            frame.getContentPane().add(label);

            // Отображаем окно
            frame.setVisible(true);
        });
    }
}
