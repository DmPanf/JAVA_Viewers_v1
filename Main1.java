import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Main1 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("My Image and PDF Viewer");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(500, 500);

            // Создаем панель для кнопок
            JPanel panel = new JPanel();
            frame.add(panel, BorderLayout.SOUTH);

            // Создаем метку для изображения
            JLabel imageLabel = new JLabel();
            frame.add(imageLabel, BorderLayout.CENTER);

            // Создаем две кнопки
            JButton button1 = new JButton("Load Image");
            JButton button2 = new JButton("Open PDF");
            panel.add(button1);
            panel.add(button2);

            // Обработчик нажатия кнопок
            ActionListener buttonListener1 = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Создаем диалоговое окно для выбора файла
                    JFileChooser fileChooser = new JFileChooser();
                    fileChooser.setFileFilter(new FileNameExtensionFilter("Image files", "jpg", "png", "gif", "bmp"));
                    int returnValue = fileChooser.showOpenDialog(frame);
                    if (returnValue == JFileChooser.APPROVE_OPTION) {
                        File file = fileChooser.getSelectedFile();
                        // Загружаем изображение и отображаем его в метке
                        imageLabel.setIcon(new ImageIcon(file.getPath()));
                        frame.pack();
                    }
                }
            };

            ActionListener buttonListener2 = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFileChooser fileChooser = new JFileChooser();
                    fileChooser.setFileFilter(new FileNameExtensionFilter("PDF files", "pdf"));
                    int returnValue = fileChooser.showOpenDialog(frame);
                    if (returnValue == JFileChooser.APPROVE_OPTION) {
                        File file = fileChooser.getSelectedFile();
                        // Открываем PDF в стандартном приложении
                        try {
                            Desktop.getDesktop().open(file);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                    }
                }
            };

            // Привязываем обработчики к кнопкам
            button1.addActionListener(buttonListener1);
            button2.addActionListener(buttonListener2);

            // Отображаем окно
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
