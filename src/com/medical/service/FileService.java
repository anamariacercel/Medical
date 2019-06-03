package com.medical.service;

import com.medical.models.Doctor;
import com.medical.models.MedicalClinic;
import com.medical.models.Pill;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileService {
    private static FileService ourInstance = new FileService();

    public static FileService getInstance() {
        return ourInstance;
    }

    private FileService(){}

    public List<Pill> readPillsFromCSV(String fileNamePath) {
        ArrayList pills = new ArrayList();

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileNamePath));

            String line;
            while((line = br.readLine()) != null) {
                String[] entries = line.split(",");
                pills.add(new Pill(Long.parseLong(entries[0].trim()), entries[1], entries[2]));
            }
        } catch (FileNotFoundException var6) {
            var6.printStackTrace();
        } catch (IOException var7) {
            var7.printStackTrace();
        }

        return pills;
    }

    public List<Doctor> readDoctorsFromCSV(String fileNamePath) {
        ArrayList doctors = new ArrayList();

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileNamePath));

            String line;
            while((line = br.readLine()) != null) {
                String[] entries = line.split(",");
                doctors.add(new Doctor(Long.parseLong(entries[0].trim()), entries[1], entries[2], entries[3],Integer.parseInt(entries[4].trim()),entries[4]));
            }
        } catch (FileNotFoundException var6) {
            var6.printStackTrace();
        } catch (IOException var7) {
            var7.printStackTrace();
        }

        return doctors;
    }

    public List<MedicalClinic> readMedicalCentresFromCSV(String fileNamePath) {
        ArrayList medicalCentres = new ArrayList();

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileNamePath));

            String line;
            while((line = br.readLine()) != null) {
                String[] entries = line.split(",");
                medicalCentres.add(new MedicalClinic(Long.parseLong(entries[0].trim()), entries[1], Integer.parseInt(entries[2].trim()), entries[3], entries[4]));
            }
        } catch (FileNotFoundException var6) {
            var6.printStackTrace();
        } catch (IOException var7) {
            var7.printStackTrace();
        }

        return medicalCentres;
    }

}
