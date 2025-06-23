
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ParkingSystem {
    private JFrame frame;
    private JTextField licensePlateField;
    private JTextArea displayArea;
    private ArrayList<Car> parkedCars;

    public ParkingSystem() {
        parkedCars = new ArrayList<>();
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Car Parking System");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JLabel label = new JLabel("Enter License Plate:");
        licensePlateField = new JTextField(15);
        JButton parkButton = new JButton("Park Car");
        JButton removeButton = new JButton("Remove Car");
        JButton viewButton = new JButton("View Parked Cars");
        JButton exitButton = new JButton("Exit");
        displayArea = new JTextArea(10, 30);
        displayArea.setEditable(false);

        parkButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                parkCar();
            }
        });

        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                removeCar();
            }
        });

        viewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                viewParkedCars();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        frame.add(label);
        frame.add(licensePlateField);
        frame.add(parkButton);
        frame.add(removeButton);
        frame.add(viewButton);
        frame.add(exitButton);
        frame.add(new JScrollPane(displayArea));

        frame.setVisible(true);
    }

    private void parkCar() {
        String licensePlate = licensePlateField.getText();
        if (!licensePlate.isEmpty()) {
            parkedCars.add(new Car(licensePlate));
            displayArea.append("Car parked: " + licensePlate + "\n");
            licensePlateField.setText("");
        } else {
            JOptionPane.showMessageDialog(frame, "Please enter a license plate.");
        }
    }

    private void removeCar() {
        String licensePlate = licensePlateField.getText();
        boolean removed = parkedCars.removeIf(car -> car.getLicensePlate().equals(licensePlate));
        if (removed) {
            displayArea.append("Car removed: " + licensePlate + "\n");
            licensePlateField.setText("");
        } else {
            JOptionPane.showMessageDialog(frame, "Car not found.");
        }
    }

    private void viewParkedCars() {
        displayArea.setText("Parked Cars:\n");
        for (Car car : parkedCars) {
            displayArea.append(car.getLicensePlate() + "\n");
        }
    }

    public static void main(String[] args) {
        new ParkingSystem();
    }
}
