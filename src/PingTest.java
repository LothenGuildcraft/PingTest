import Window.MainFrame;

import javax.swing.UIManager;
import java.awt.EventQueue;

public class PingTest {
    public static void main(String[] args) throws Exception {
        UIManager.LookAndFeelInfo[] looks = UIManager.getInstalledLookAndFeels();
        for (UIManager.LookAndFeelInfo look : looks) {
            if ("Nimbus".equals(look.getName())) {
                UIManager.setLookAndFeel(look.getClassName());
                break;
            }
        }
        
        EventQueue.invokeLater(() -> {
            new MainFrame().setVisible(true);
        });
    }
}
