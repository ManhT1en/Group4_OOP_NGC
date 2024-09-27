import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class Patient {
    String name;
    int id;
    String history;
    String status;

    public Patient(String name, int id, String history, String status) {
        this.name = name;
        this.id = id;
        this.history = history;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Patient ID: " + id + ", Name: " + name + ", History: " + history + ", Status: " + status;
    }
}

public class PatientManagement extends Frame {
    private ArrayList<Patient> patients = new ArrayList<>();  // Danh sách bệnh nhân
    private TextArea patientList;  // Để hiển thị danh sách bệnh nhân
    private TextField nameField, dobField, searchField, deleteField;

    public PatientManagement() {
        setTitle("Patient Management");
        setSize(500, 400);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);  // Khoảng cách giữa các thành phần
        gbc.fill = GridBagConstraints.HORIZONTAL; // Đảm bảo các thành phần mở rộng theo chiều ngang
        gbc.weightx = 1.0;  // Trọng số để các thành phần phân bổ đều

        // Tạo nhãn và ô nhập liệu cho tạo bệnh nhân
        Label nameLabel = new Label("Patient Name:");
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        nameField = new TextField(20);
        nameField.setBackground(Color.LIGHT_GRAY);

        Label dobLabel = new Label("Date of Birth:");
        dobLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        dobField = new TextField(20);
        dobField.setBackground(Color.LIGHT_GRAY);

        Button createButton = new Button("Create");
        createButton.setBackground(Color.GREEN);
        createButton.setForeground(Color.WHITE);

        // Thêm các thành phần vào Frame
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;  // Mỗi thành phần chiếm 1 ô
        add(nameLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2;  // Ô nhập liệu chiếm 2 cột để rộng hơn
        add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        add(dobLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        add(dobField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;  // Nút bấm nằm ở giữa
        add(createButton, gbc);

        // Tạo danh sách bệnh nhân
        patientList = new TextArea(10, 40);
        patientList.setEditable(false);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        add(patientList, gbc);

        // Ô tìm kiếm bệnh nhân
        Label searchLabel = new Label("Search Patient by Name/ID:");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        add(searchLabel, gbc);

        searchField = new TextField(20);
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        add(searchField, gbc);

        Button searchButton = new Button("Search");
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        add(searchButton, gbc);

        // Ô xóa bệnh nhân
        Label deleteLabel = new Label("Delete Patient by ID:");
        gbc.gridx = 0;
        gbc.gridy = 6;
        add(deleteLabel, gbc);

        deleteField = new TextField(20);
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        add(deleteField, gbc);

        Button deleteButton = new Button("Delete");
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        add(deleteButton, gbc);

        // Xử lý sự kiện khi nhấn nút Create
        createButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createPatient();
            }
        });

        // Xử lý sự kiện tìm kiếm bệnh nhân
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                searchPatient();
            }
        });

        // Xử lý sự kiện xóa bệnh nhân
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deletePatient();
            }
        });

        // Xử lý sự kiện đóng cửa sổ
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    // Tạo mới bệnh nhân
    private void createPatient() {
        String name = nameField.getText();
        String dob = dobField.getText();
        int id = patients.size() + 1;  // Tạo ID mới dựa trên kích thước danh sách
        Patient newPatient = new Patient(name, id, "History Placeholder", "Status Placeholder");
        patients.add(newPatient);
        updatePatientList();  // Cập nhật danh sách bệnh nhân hiển thị
        System.out.println("Patient Created: " + newPatient);
        nameField.setText("");  // Xóa nội dung nhập liệu
        dobField.setText("");
    }

    // Tìm kiếm bệnh nhân
    private void searchPatient() {
        String query = searchField.getText();
        boolean found = false;

        for (Patient patient : patients) {
            if (patient.name.equalsIgnoreCase(query) || Integer.toString(patient.id).equals(query)) {
                patientList.setText("Patient found: " + patient);
                found = true;
                break;
            }
        }

        if (!found) {
            patientList.setText("Patient not found.");
        }
    }

    // Xóa bệnh nhân
    private void deletePatient() {
        int id = Integer.parseInt(deleteField.getText());
        boolean removed = false;

        for (int i = 0; i < patients.size(); i++) {
            if (patients.get(i).id == id) {
                patients.remove(i);
                removed = true;
                updatePatientList();  // Cập nhật danh sách bệnh nhân hiển thị
                break;
            }
        }

        if (removed) {
            System.out.println("Patient deleted.");
        } else {
            System.out.println("Patient not found with ID: " + id);
        }
        deleteField.setText("");
    }

    // Cập nhật danh sách bệnh nhân
    private void updatePatientList() {
        patientList.setText("");
        for (Patient patient : patients) {
            patientList.append(patient + "\n");
        }
    }

    public static void main(String[] args) {
        PatientManagement pm = new PatientManagement();
        pm.setVisible(true);
    }
}
