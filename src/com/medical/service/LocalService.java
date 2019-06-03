package com.medical.service;

import com.medical.models.*;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.*;

public class LocalService {
    private static List<Pill> pillList = new ArrayList<>();
    private static List<Pill> pillList2 = new ArrayList();
    private static List<Pill> pillList3 = new ArrayList();
    private static List<Treatment> treatmentList = new ArrayList();
    private static List<MedicalHistory> medicalHistoryList = new ArrayList();
    private static List<MedicalHistory> diagnosis1 = new ArrayList();
    private static List<MedicalHistory> diagnosis2 = new ArrayList();
    private static List<MedicalHistory> diagnosis3 = new ArrayList();
    private static List<MedicalHistory> diagnosis4 = new ArrayList();
    private static PatientFile[] medicalFiles = new PatientFile[5];
    private static List<Patient> patientList = new ArrayList();
    private static List<Doctor> doctors = new ArrayList();
    private static MedicalClinic medicalClinic = new MedicalClinic();
    private static Map<Long, Appointment> appointmentMap = new HashMap();
    private static List<Appointment> appointmentList = new ArrayList();
    private static List<Doctor> doctorsFromCSV = new ArrayList();
    private static List<MedicalClinic> medicalClinicList = new ArrayList();
    private static List<Pill> pillsFromCSV = new ArrayList();
    private static final LocalService instance = new LocalService();

    public static LocalService getInstance(){
        return instance;
    }

    private LocalService(){
        doctors.add(new Doctor(123L,"Costin","Dragomir","ORL",2,"medicina"));
        doctors.add(new Doctor(123L,"Alexandra","Morariu","intern",1,"medicina"));
        medicalClinic = new MedicalClinic(231L, "Bucuresti", 2, "Iuliu Maniu", "12");
        pillList.add(new Pill(120L, "Paracetamol", "administrare orala"));
        pillList.add(new Pill(220L, "Septosol", "administrare orala"));
        pillList.add(new Pill(450L, "Biorinil", "administrare nazala"));
        pillList.add(new Pill(1560L, "Trachisept", "administrare orala"));
        pillList.add(new Pill(12900L, "Nurofen Forte", "administrare orala"));
        pillList2.add(new Pill(450L, "Biorinil", "administrare nazala"));
        pillList2.add(new Pill(1560L, "Trachisept", "administrare orala"));
        pillList3.add(new Pill(12900L, "Nurofen Forte", "administrare orala"));
        treatmentList.add(new Treatment(200L, "cancer", pillList, 30));
        treatmentList.add(new Treatment(201L, "cancer", pillList2, 15));
        treatmentList.add(new Treatment(202L, "cancer", pillList3, 20));
        medicalHistoryList.add(new MedicalHistory(2323L, (Treatment) treatmentList.get(0), "cancer", false));
        medicalHistoryList.add(new MedicalHistory(234L, (Treatment) treatmentList.get(1), "Gripa", true));
        medicalHistoryList.add(new MedicalHistory(233L, (Treatment) treatmentList.get(2), "Varicela", false));
        medicalHistoryList.add(new MedicalHistory(2423L, (Treatment) treatmentList.get(1), "Urticare", true));
        diagnosis1.add((MedicalHistory) medicalHistoryList.get(0));
        diagnosis2.add((MedicalHistory) medicalHistoryList.get(1));
        diagnosis3.add((MedicalHistory) medicalHistoryList.get(2));
        diagnosis4.add((MedicalHistory) medicalHistoryList.get(3));
        medicalFiles[4] = new PatientFile(50L,LocalDate.parse("2019-02-05"),diagnosis4,"oborul nou 13");
        medicalFiles[0] = new PatientFile(50L,LocalDate.parse("2019-02-06"),diagnosis1,"oborul nou 13");
        medicalFiles[1] = new PatientFile(50L,LocalDate.parse("2019-02-02"),diagnosis2,"oborul nou 13");
        medicalFiles[2] = new PatientFile(50L,LocalDate.parse("2019-02-05"),diagnosis3,"oborul nou 13");
       medicalFiles[3] = new PatientFile(50L,LocalDate.parse("2019-02-01"), medicalHistoryList.subList(0, 1),"oborul nou 13");
        patientList.add(new PatientChild(405L, "ana", "cercel", "anamaria2410@gmail.com", "2981024410013", "B+", 18, "femeie", medicalFiles[0],"praf",false));
        patientList.add(new PatientChild(4052L, "ilinca", "priboi", "priboiilinca@yahoo.com", "298294020", "0", 10, "femeie", medicalFiles[1],"nimic",true));
        patientList.add(new PatientAdult(4053L, "mircea", "anghel", "mirceaanghel@gmail.com", "0724346692", "A", 23, "barbat", medicalFiles[2], "puf", false));
        patientList.add(new PatientAdult(4054L, "ioana", "albu", "ioanaalbu@gmail.com", "0724378392", "B", 25, "femeie", medicalFiles[3], "nimic",false));
        appointmentMap.put(1L, new Appointment(1L, LocalDate.parse("2019-09-09"), "12:00", (Doctor)doctors.get(0), (Patient)patientList.get(0), medicalClinic));
        appointmentMap.put(2L, new Appointment(2L, LocalDate.parse("2019-10-09"), "15:00", (Doctor)doctors.get(1), (Patient)patientList.get(2), medicalClinic));
        appointmentMap.put(3L, new Appointment(3L, LocalDate.parse("2019-11-09"), "17:00", (Doctor)doctors.get(1), (Patient)patientList.get(3), medicalClinic));
        appointmentList.add(new Appointment(1L, LocalDate.parse("2019-09-09"), "12:00", (Doctor)doctors.get(0), (Patient)patientList.get(0), medicalClinic));
        appointmentList.add(new Appointment(2L, LocalDate.parse("2019-10-09"), "15:00", (Doctor)doctors.get(1), (Patient)patientList.get(2), medicalClinic));
        appointmentList.add(new Appointment(2L, LocalDate.parse("2019-10-09"), "15:00", (Doctor)doctors.get(1), (Patient)patientList.get(2), medicalClinic));
        pillsFromCSV = FileService.getInstance().readPillsFromCSV("files/pill.csv");
        doctorsFromCSV = FileService.getInstance().readDoctorsFromCSV("files/doctor.csv");
        medicalClinicList = FileService.getInstance().readMedicalCentresFromCSV("files/medicalcentre.csv");
    }

    public List<Patient> patientsWithAllergies() {
        System.out.println("-------------Patients with allergies");
        List<Patient> patients = new ArrayList();
        Iterator var2 = patientList.iterator();

        while(var2.hasNext()) {
            Patient patient = (Patient)var2.next();
            if (patient.hasAllergies()) {
                System.out.println(patient);
                patients.add(patient);
            }
        }

        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append((new Object() {
        }).getClass().getEnclosingMethod().getName()).append(",").append(new Timestamp(System.currentTimeMillis()));
        FileTextService.getInstance().writeTextToFile(stringBuilder.toString(), "files/audit.csv");
        return patients;
    }

    public List<Patient> childPatients() {
        System.out.println("-------------------Child patients");
        List<Patient> childPatient = new ArrayList();
        Iterator var2 = patientList.iterator();

        while(var2.hasNext()) {
            Patient patient = (Patient)var2.next();
            if (patient.getClass() == PatientChild.class) {
                childPatient.add(patient);
            }
        }

        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append((new Object() {
        }).getClass().getEnclosingMethod().getName()).append(",").append(new Timestamp(System.currentTimeMillis()));
        FileTextService.getInstance().writeTextToFile(stringBuilder.toString(), "files/audit.csv");
        return childPatient;
    }
    public float getAppointment1Cost() {
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append((new Object() {
        }).getClass().getEnclosingMethod().getName()).append(",").append(new Timestamp(System.currentTimeMillis()));
        FileTextService.getInstance().writeTextToFile(stringBuilder.toString(), "files/audit.csv");
        return ((Appointment)appointmentMap.get(1L)).getDoctor().getSpecialisation().equals("Medic de Familie") ? 200.0F : 300.0F;
    }

    public List<Patient> patientWithLongestDiagnosisList() {
        System.out.println("------------Patient with longest Diagnosis List");
        int maximum = 0;
        Boolean i = false;
        Boolean j = false;
        List<Patient> sikestpatients = new ArrayList();
        Iterator var6 = patientList.iterator();

        Patient patient;
        while(var6.hasNext()) {
            patient = (Patient)var6.next();
            if (patient.getFile().getMedicalHistory().size() > maximum) {
                maximum = patient.getFile().getMedicalHistory().size();
            }
        }

        var6 = patientList.iterator();

        while(var6.hasNext()) {
            patient = (Patient)var6.next();
            if (patient.getFile().getMedicalHistory().size() == maximum) {
                sikestpatients.add(patient);
            }
        }

        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append((new Object() {
        }).getClass().getEnclosingMethod().getName()).append(",").append(new Timestamp(System.currentTimeMillis())).append(Thread.currentThread().getName());
        FileTextService.getInstance().writeTextToFile(stringBuilder.toString(), "files/audit.csv");
        return sikestpatients;
    }

    public void orderPatients() {
        System.out.println("---------------Patients Ordered");
        Collections.sort(patientList);
        Iterator var1 = patientList.iterator();

        while(var1.hasNext()) {
            Patient patient = (Patient)var1.next();
            System.out.println(patient);
        }

        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append((new Object() {
        }).getClass().getEnclosingMethod().getName()).append(",").append(new Timestamp(System.currentTimeMillis())).append(Thread.currentThread().getName());
        FileTextService.getInstance().writeTextToFile(stringBuilder.toString(), "files/audit.csv");
    }

    public List<Doctor> getTheMostSpecialisedDoctor() {
        System.out.println("--------------The most experienced doctor");
        Collections.sort(doctors);
        System.out.println(doctors.get(1));
        List<Doctor> expDoctors = new ArrayList();
        expDoctors.add((Doctor)doctors.get(1));
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append((new Object() {
        }).getClass().getEnclosingMethod().getName()).append(",").append(new Timestamp(System.currentTimeMillis())).append(Thread.currentThread().getName());
        FileTextService.getInstance().writeTextToFile(stringBuilder.toString(), "files/audit.csv");
        return expDoctors;
    }

    public void getAllAppointmentsFrom2019(LocalDate mydate) {
        System.out.println("--------------Appointments from 2019");
        long i = 0L;
        Iterator var4 = appointmentMap.keySet().iterator();

        while(var4.hasNext()) {
            Long key = (Long)var4.next();
            if (mydate == ((Appointment)appointmentMap.get(key)).getDate()) {
                System.out.println(appointmentMap.get(key));
            }
        }

        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append((new Object() {
        }).getClass().getEnclosingMethod().getName()).append(",").append(new Timestamp(System.currentTimeMillis())).append(Thread.currentThread().getName());
        FileTextService.getInstance().writeTextToFile(stringBuilder.toString(), "files/audit.csv");
    }

    public List<Patient> patientWithCancer() {
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append((new Object() {
        }).getClass().getEnclosingMethod().getName()).append(",").append(new Timestamp(System.currentTimeMillis())).append(Thread.currentThread().getName());
        FileTextService.getInstance().writeTextToFile(stringBuilder.toString(), "files/audit.csv");
        List<Patient> cancerPatients = new ArrayList();
        Iterator var3 = patientList.iterator();

        while(var3.hasNext()) {
            Patient patient = (Patient)var3.next();
            Iterator var5 = patient.getFile().getMedicalHistory().iterator();

            while(var5.hasNext()) {
                MedicalHistory diagnosis = (MedicalHistory) var5.next();
                if (diagnosis.getDisease() == "cancer") {
                    cancerPatients.add(patient);
                }
            }
        }

        return cancerPatients;
    }

    public String stringprescriptionsContainingPill(String pillName) {
        System.out.println("------------Toate retetele care contin Paracetamol");
        StringBuilder str = new StringBuilder();
        Iterator var3 = treatmentList.iterator();

        while(var3.hasNext()) {
            Treatment prescription = (Treatment) var3.next();
            Iterator var5 = prescription.getPills().iterator();

            while(var5.hasNext()) {
                Pill pill = (Pill)var5.next();
                if (pill.getName() == pillName) {
                    str.append(prescription.toString());
                    str.append("\n");
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append((new Object() {
        }).getClass().getEnclosingMethod().getName()).append(",").append(new Timestamp(System.currentTimeMillis())).append(Thread.currentThread().getName());
        FileTextService.getInstance().writeTextToFile(stringBuilder.toString(), "files/audit.csv");
        return str.toString();
    }

    public List<Treatment> prescriptionsContainingPill(String pillName) {
        System.out.println("------------Toate retetele care contin Paracetamol");
        List<Treatment> prescriptions = new ArrayList();
        Iterator var3 = treatmentList.iterator();

        while(var3.hasNext()) {
            Treatment prescription = (Treatment) var3.next();
            Iterator var5 = prescription.getPills().iterator();

            while(var5.hasNext()) {
                Pill pill = (Pill)var5.next();
                if (pill.getName() == pillName) {
                    System.out.println(prescription);
                    prescriptions.add(prescription);
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append((new Object() {
        }).getClass().getEnclosingMethod().getName()).append(",").append(new Timestamp(System.currentTimeMillis())).append(Thread.currentThread().getName());
        FileTextService.getInstance().writeTextToFile(stringBuilder.toString(), "files/audit.csv");
        return prescriptions;
    }

    public void prescriptionsContainingParacetamol() {
        System.out.println("------------Toate retetele care contin Paracetamol");
        Iterator var1 = treatmentList.iterator();

        while(var1.hasNext()) {
            Treatment prescription = (Treatment) var1.next();
            Iterator var3 = prescription.getPills().iterator();

            while(var3.hasNext()) {
                Pill pill = (Pill)var3.next();
                if (pill.getName() == "Paracetamol") {
                    System.out.println(prescription);
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append((new Object() {
        }).getClass().getEnclosingMethod().getName()).append(",").append(new Timestamp(System.currentTimeMillis())).append(Thread.currentThread().getName());
        FileTextService.getInstance().writeTextToFile(stringBuilder.toString(), "files/audit.csv");
    }

    public int nrOfAppointmentsMadeByAGivenPatient(String firstName, String lastName) {
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append((new Object() {
        }).getClass().getEnclosingMethod().getName()).append(",").append(new Timestamp(System.currentTimeMillis())).append(Thread.currentThread().getName());
        FileTextService.getInstance().writeTextToFile(stringBuilder.toString(), "files/audit.csv");
        int index = -1;
        int nr = 0;
        Iterator var6 = patientList.iterator();

        while(var6.hasNext()) {
            Patient patient = (Patient)var6.next();
            if (patient.getLastName() == lastName && patient.getFirstName() == firstName) {
                index = patientList.indexOf(patient);
            }
        }

        if (index != -1) {
            var6 = appointmentList.iterator();

            while(var6.hasNext()) {
                Appointment appointment = (Appointment)var6.next();
                if (appointment.getPatient().getFirstName() == firstName && appointment.getPatient().getLastName() == lastName) {
                    ++nr;
                }
            }

            return nr;
        } else {
            return 0;
        }
    }

    public void getPillsFromCSV() {
        System.out.println(pillsFromCSV);
    }

    public void getDoctorsFromCSV() {
        System.out.println(doctorsFromCSV);
    }

    public void getMedicalCentresFromCSV() {
        System.out.println(medicalClinicList);
    }
}
