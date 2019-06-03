package GUI;

import com.medical.models.Doctor;
import com.medical.models.Patient;
import com.medical.models.Treatment;
import com.medical.service.LocalService;
import com.medical.service.DBService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.EventHandler;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class UIService {

    private JTabbedPane tabbedPane;
    private JPanel localStorage;
    private JPanel dbStorage;
    private JPanel mainPanel;
    private JPanel Find;
    private JTextField textFieldCNP;
    private JScrollPane mainJScrollPane;
    private JTable userTable;
    private JButton cancerPatient;
    private JButton heartriskPatients;
    private JButton sickestPatient;
    private JButton childPatients;
    private JButton experiencedDoctor;
    private JButton findPrescriptionsButton;
    private JTextField editText;
    private JLabel CNP;
    private JTextField textFieldBloodType;
    private JTextField textFieldName;
    private JButton UPDATETelFromNameButton;
    private JButton INSERTButton;
    private JTextField textFieldAge;
    private JButton DELETEFromNameButton;
    private JButton SELECTFromAgeButton;

    public UIService() {
        sickestPatient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingWorker<List<Patient>, String> stringSwingWorker = new SwingWorker<List<Patient>, String>() {
                    @Override
                    protected List<Patient> doInBackground() throws Exception {

                        return LocalService.getInstance().patientWithLongestDiagnosisList();
                    }

                    @Override
                    protected void done() {

                        try {
                            List<Patient> result = get();

                            SwingUtilities.invokeLater(new Runnable() {
                                @Override
                                public void run() {
                                    DefaultTableModel defaultTableModel = new DefaultTableModel() {
                                        @Override
                                        public boolean isCellEditable(int row, int column) {
                                            return false; //super.isCellEditable(row, column);
                                        }
                                    };

                                    defaultTableModel.addColumn("Id");
                                    defaultTableModel.addColumn("CNP");
                                    defaultTableModel.addColumn("FirstName");
                                    defaultTableModel.addColumn("LastName");
                                    defaultTableModel.addColumn("BloodType");
                                    defaultTableModel.addColumn("Email");
                                    defaultTableModel.addColumn("Age");
                                    defaultTableModel.addColumn("Sex");
                                    defaultTableModel.addColumn("Medical File");


                                    for (Patient patient : result) {
                                        defaultTableModel.addRow(new Object[]{patient.getId(), patient.getCNP(), patient.getFirstName(), patient.getLastName(),
                                                patient.getBloodType(), patient.getEmail(), patient.getAge(), patient.getSex(), patient.getFile()});
                                    }

                                    userTable.setModel(defaultTableModel);
                                }
                            });


                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        } catch (ExecutionException ex) {
                            ex.printStackTrace();
                        }

                    }
                };

                stringSwingWorker.execute();

            }
        });


        cancerPatient.addActionListener(e -> {
            SwingWorker<List<Patient>, String> stringSwingWorker = new SwingWorker<List<Patient>, String>() {
                @Override
                protected List<Patient> doInBackground() throws Exception {

                    return LocalService.getInstance().patientWithCancer();
                }

                @Override
                protected void done() {

                    try {
                        List<Patient> result = get();

                        SwingUtilities.invokeLater(new Runnable() {
                            @Override
                            public void run() {
                                DefaultTableModel defaultTableModel = new DefaultTableModel() {
                                    @Override
                                    public boolean isCellEditable(int row, int column) {
                                        return false; //super.isCellEditable(row, column);
                                    }
                                };

                                defaultTableModel.addColumn("Id");
                                defaultTableModel.addColumn("CNP");
                                defaultTableModel.addColumn("FirstName");
                                defaultTableModel.addColumn("LastName");
                                defaultTableModel.addColumn("Blood Type");
                                defaultTableModel.addColumn("Email");
                                defaultTableModel.addColumn("Age");
                                defaultTableModel.addColumn("Sex");
                                defaultTableModel.addColumn("Medical File");


                                for (Patient patient : result) {
                                    defaultTableModel.addRow(new Object[]{patient.getId(), patient.getCNP(), patient.getFirstName(), patient.getLastName(),
                                            patient.getBloodType(), patient.getEmail(), patient.getAge(), patient.getSex(), patient.getFile()});
                                }

                                userTable.setModel(defaultTableModel);
                            }
                        });


                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    } catch (ExecutionException ex) {
                        ex.printStackTrace();
                    }

                }
            };

            stringSwingWorker.execute();

        });

        heartriskPatients.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingWorker<List<Patient>, String> stringSwingWorker = new SwingWorker<List<Patient>, String>() {
                    @Override
                    protected List<Patient> doInBackground() throws Exception {

                        return LocalService.getInstance().patientsWithAllergies();
                    }

                    @Override
                    protected void done() {

                        try {
                            List<Patient> result = get();

                            SwingUtilities.invokeLater(new Runnable() {
                                @Override
                                public void run() {
                                    DefaultTableModel defaultTableModel = new DefaultTableModel() {
                                        @Override
                                        public boolean isCellEditable(int row, int column) {
                                            return false; //super.isCellEditable(row, column);
                                        }
                                    };

                                    defaultTableModel.addColumn("Id");
                                    defaultTableModel.addColumn("CNP");
                                    defaultTableModel.addColumn("FirstName");
                                    defaultTableModel.addColumn("LastName");
                                    defaultTableModel.addColumn("Blood Type");
                                    defaultTableModel.addColumn("Email");
                                    defaultTableModel.addColumn("Age");
                                    defaultTableModel.addColumn("Sex");
                                    defaultTableModel.addColumn("Medical File");


                                    for (Patient patient : result) {
                                        defaultTableModel.addRow(new Object[]{patient.getId(), patient.getCNP(), patient.getFirstName(), patient.getLastName(),
                                                patient.getBloodType(), patient.getEmail(), patient.getAge(), patient.getSex(), patient.getFile()});

                                    }

                                    userTable.setModel(defaultTableModel);
                                }
                            });


                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        } catch (ExecutionException ex) {
                            ex.printStackTrace();
                        }

                    }
                };

                stringSwingWorker.execute();

            }
        });


        childPatients.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingWorker<List<Patient>, String> stringSwingWorker = new SwingWorker<List<Patient>, String>() {
                    @Override
                    protected List<Patient> doInBackground() throws Exception {

                        return LocalService.getInstance().childPatients();
                    }

                    @Override
                    protected void done() {

                        try {
                            List<Patient> result = get();

                            SwingUtilities.invokeLater(new Runnable() {
                                @Override
                                public void run() {
                                    DefaultTableModel defaultTableModel = new DefaultTableModel() {
                                        @Override
                                        public boolean isCellEditable(int row, int column) {
                                            return false; //super.isCellEditable(row, column);
                                        }
                                    };

                                    defaultTableModel.addColumn("Id");
                                    defaultTableModel.addColumn("CNP");
                                    defaultTableModel.addColumn("FirstName");
                                    defaultTableModel.addColumn("LastName");
                                    defaultTableModel.addColumn("Blood Type");
                                    defaultTableModel.addColumn("Email");
                                    defaultTableModel.addColumn("Age");
                                    defaultTableModel.addColumn("Sex");
                                    defaultTableModel.addColumn("Medical File");


                                    for (Patient patient : result) {
                                        defaultTableModel.addRow(new Object[]{patient.getId(), patient.getCNP(), patient.getFirstName(), patient.getLastName(),
                                                patient.getBloodType(), patient.getEmail(), patient.getAge(), patient.getSex(), patient.getFile()});
                                    }

                                    userTable.setModel(defaultTableModel);
                                }
                            });


                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        } catch (ExecutionException ex) {
                            ex.printStackTrace();
                        }

                    }
                };

                stringSwingWorker.execute();

            }
        });


        experiencedDoctor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingWorker<List<Doctor>, String> stringSwingWorker = new SwingWorker<List<Doctor>, String>() {
                    @Override
                    protected List<Doctor> doInBackground() throws Exception {

                        return LocalService.getInstance().getTheMostSpecialisedDoctor();
                    }

                    @Override
                    protected void done() {

                        try {
                            List<Doctor> result = get();

                            SwingUtilities.invokeLater(new Runnable() {
                                @Override
                                public void run() {
                                    DefaultTableModel defaultTableModel = new DefaultTableModel() {
                                        @Override
                                        public boolean isCellEditable(int row, int column) {
                                            return false; //super.isCellEditable(row, column);
                                        }
                                    };

                                    defaultTableModel.addColumn("Id");
                                    defaultTableModel.addColumn("FirstName");
                                    defaultTableModel.addColumn("LastName");
                                    defaultTableModel.addColumn("Specialization");
                                    defaultTableModel.addColumn("Level of training");

                                    for (Doctor doctor : result) {
                                        defaultTableModel.addRow(new Object[]{doctor.getId(), doctor.getFirstName(), doctor.getLastName(),
                                                doctor.getSpecialisation(), doctor.getLevelTraining()});
                                    }

                                    userTable.setModel(defaultTableModel);
                                }
                            });


                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        } catch (ExecutionException ex) {
                            ex.printStackTrace();
                        }

                    }
                };

                stringSwingWorker.execute();

            }
        });




//------------------ FIND TAB
        //            @Override
//            public void actionPerformed(ActionEvent e) {
//                SwingWorker<List<Treatment>, String> stringSwingWorker = new SwingWorker<List<Treatment>, String>() {
//                    @Override
//                    protected List<Treatment> doInBackground() throws Exception {
//
//                        String pillName = editText.getText();
//                        if (pillName.length() >= 5)
//                            return LocalService.getInstance().prescriptionsContainingPill(pillName);
//                        else {
//                            JOptionPane.showMessageDialog(null, "Nume invalid!", "Atenție", JOptionPane.ERROR_MESSAGE);
//                            List<Treatment> emp = new ArrayList<>();
//                            return emp;
//                        }
//                    }
//
//                    @Override
//                    protected void done() {
//
//                        try {
//                            List<Treatment> result = get();
//
//                            SwingUtilities.invokeLater(new Runnable() {
//                                @Override
//                                public void run() {
//
//                                    StringBuilder s = new StringBuilder();
//                                    for (Treatment prescription : result) {
//                                        s.append(Long.toString(prescription.getId())).append(" ").append(prescription.getPills()).append(prescription.getStartDate()).append(prescription.getEndDate())
//                                                .append("\n");
//                                    }
//                                    s.append("found");
//                                    JOptionPane.showMessageDialog(null, s.toString(), "Atenție", JOptionPane.INFORMATION_MESSAGE);
//
//                                }
//                            });
//
//
//                        } catch (InterruptedException ex) {
//                            ex.printStackTrace();
//                        } catch (ExecutionException ex) {
//                            ex.printStackTrace();
//                        }
//
//                    }
//                };
//
//                stringSwingWorker.execute();
//
//            }
        findPrescriptionsButton.addActionListener(e -> {
            String pillName = editText.getText();
            String string = new String();
            string = LocalService.getInstance().stringprescriptionsContainingPill(pillName);
            JOptionPane.showMessageDialog(null, string, "Atenție", JOptionPane.INFORMATION_MESSAGE);
        });





        //----------------------------------DB Storage
        INSERTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    DBService.getInstance().insertPatientDB(textFieldCNP.getText(), textFieldName.getText(),
                            textFieldBloodType.getText(), Integer.parseInt(textFieldAge.getText()));
                    JOptionPane.showMessageDialog(null, "Patient successfully inserted !", "Atenție", JOptionPane.INFORMATION_MESSAGE);

                    textFieldCNP.setText("");
                    textFieldName.setText("");
                    textFieldBloodType.setText("");
                    textFieldAge.setText("");

                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        DELETEFromNameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = textFieldName.getText();
                if (name.length() >= 5) {
                    try {
                        DBService.getInstance().deletePatientBD_byName(name);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    JOptionPane.showMessageDialog(null, "Patient successfully deleted !", "Atenție", JOptionPane.INFORMATION_MESSAGE);

                    textFieldCNP.setText("");
                    textFieldName.setText("");
                    textFieldBloodType.setText("");
                    textFieldAge.setText("");
                }
            }
        });
        UPDATETelFromNameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = textFieldName.getText();
                String bloodtype = textFieldBloodType.getText();
                if (name.length() >= 5 && bloodtype.length() <= 2) {
                    try {
                        DBService.getInstance().updatePatientBD_byName(name, bloodtype);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    JOptionPane.showMessageDialog(null, "Patient successfully deleted !", "Atenție", JOptionPane.INFORMATION_MESSAGE);

                    textFieldCNP.setText("");
                    textFieldName.setText("");
                    textFieldBloodType.setText("");
                    textFieldAge.setText("");
                }
            }

        });

        SELECTFromAgeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


    }
        public void initGUI () {
            JFrame jFrame = new JFrame("Medical Office");
            jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jFrame.setPreferredSize(new Dimension(800, 600));
            jFrame.setContentPane(this.mainPanel);
            // set prefered size, otherwise your jFrame is going to be something small in a corner
            jFrame.setPreferredSize(new Dimension(800, 600));

            // make the jFrame visible
            jFrame.pack();
            jFrame.setVisible(true);
        }


        public static void main (String args[]){
            UIService mainFrame = new UIService();

            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    mainFrame.initGUI();
                }
            });

        }

        private void createUIComponents () {
            JButton oneButton = new JButton("do something!!!!");
            oneButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("button 'do something!!!!' was pressed!");
                }
            });
            // create manually a new panel, like we already said, this is custom
            Find = new JPanel();
            Find.add(oneButton);
        }

    }
