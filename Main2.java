import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Main2 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("My Image Viewer");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(500, 500);

            // Создаем панель для кнопок
            JPanel panel = new JPanel();
            frame.add(panel, BorderLayout.SOUTH);

            // Создаем метку для изображения
            JLabel imageLabel = new JLabel();
            frame.add(imageLabel, BorderLayout.CENTER);

            // Создаем две кнопки
            JButton button1 = new JButton("Load Image 1");
            JButton button2 = new JButton("Load Image 2");
            JButton button3 = new JButton("Choose Image to Load");
            panel.add(button1);
            panel.add(button2);
            panel.add(button3);

            // Обработчик нажатия кнопок для первого изображения
            ActionListener buttonListener1 = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    File file = new File("./images/01.jpg");
                    // Загружаем изображение и отображаем его в метке
                    imageLabel.setIcon(new ImageIcon(file.getPath()));
                    frame.pack();
                }
            };

            // Обработчик нажатия кнопок для второго изображения
            ActionListener buttonListener2 = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    File file = new File("./images/02.jpg");
                    // Загружаем изображение и отображаем его в метке
                    imageLabel.setIcon(new ImageIcon(file.getPath()));
                    frame.pack();
                }
            };

            // Обработчик нажатия кнопки 3
            ActionListener buttonListener3 = new ActionListener() {
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

            // Привязываем обработчик к кнопкам
            button1.addActionListener(buttonListener1);
            button2.addActionListener(buttonListener2);
            button3.addActionListener(buttonListener3);

            // Отображаем окно
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
