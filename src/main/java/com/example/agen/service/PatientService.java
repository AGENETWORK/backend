package com.example.agen.service;

import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.example.agen.Patient;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;

@Service
public class PatientService {
    public static final String COL_NAME = "users";

    public String savePatientDetails(Patient patient) throws InterruptedException, ExecutionException {
	Firestore dbFirestore = FirestoreClient.getFirestore();
	DocumentReference db = dbFirestore.collection(COL_NAME).document(patient.getName());
	ApiFuture<WriteResult> collectionsApiFuture = db.set(patient);
	return collectionsApiFuture.get().toString();
    }

    public Patient getPatientDetails(String name) throws InterruptedException, ExecutionException {
	Firestore dbFirestore = FirestoreClient.getFirestore();
	DocumentReference documentReference = dbFirestore.collection(COL_NAME).document(name);
	ApiFuture<DocumentSnapshot> future = documentReference.get();
	DocumentSnapshot document = future.get();
	Patient patient = null;
	if (document.exists()) {
	    patient = document.toObject(Patient.class);
	    return patient;
	} else {
	    return null;
	}
    }

    public String updatePatientDetails(Patient person) throws InterruptedException, ExecutionException {
	Firestore dbFirestore = FirestoreClient.getFirestore();
	ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_NAME).document(person.getName())
		.set(person);
	return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public String deletePatient(String name) {
	Firestore dbFirestore = FirestoreClient.getFirestore();
	ApiFuture<WriteResult> writeResult = dbFirestore.collection(COL_NAME).document(name).delete();
	return "Document with Patient ID " + name + " has been deleted";
    }

}
