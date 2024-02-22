
// import java.util.*;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;
// import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.Font;
// import java.io.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ImageOperation {

    public static void operate(int key) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(null);
        File file = fileChooser.getSelectedFile();

        // file fileinputstream by javascript

        try {
            FileInputStream arr = new FileInputStream(file);
            byte[] data = new byte[arr.available()];
            arr.read(data);

            // encryption

            int i = 0;

            for (byte b : data) {
                System.out.println(b);
                int r = data[i] = (byte) (b ^ key);
                i++;
            }

            FileOutputStream fos = new FileOutputStream(file);
            fos.write(data);
            fos.close();
            arr.close();
            JOptionPane.showMessageDialog(null, "Done");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {

        JFrame f = new JFrame();
        f.setTitle("Imaage Operation");
        f.setSize(400, 400);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        Font font = new Font("Roboto", Font.BOLD, 25);

        // creating button

        JButton button = new JButton();
        button.setText("Open Image");
        button.setFont(font);

        // creating Text field

        JTextField textFienld = new JTextField(10);
        textFienld.setFont(font);

        button.addActionListener(e -> {
            System.out.println("button cliked");
            String text = textFienld.getText();
            int temp = Integer.parseInt(text);
            operate(temp);
        });

        f.setLayout(new FlowLayout());
        f.add(button);
        f.add(textFienld);

        f.setVisible(true);

    }

}
