package com.agen.idGenerator;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.ExecutionException;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.cloud.FirestoreClient;

public class IPartnerIdGenerator implements IdGenerator {
    public static final String COL_NAME = "individualPartner";

    @Override
    public Serializable generate() {
	String prefix = "IPTR";

	Firestore db = FirestoreClient.getFirestore();
	ApiFuture<QuerySnapshot> future = db.collection(COL_NAME).get();
	// future.get() blocks on response
	int id = 0;
	String generatedId = "error";
	List<QueryDocumentSnapshot> documents;
	try {
	    documents = future.get().getDocuments();
	    for (QueryDocumentSnapshot document : documents) {
		id++;
	    }
	    id = id + 101;
	    generatedId = prefix + new Integer(id).toString();

	} catch (InterruptedException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (ExecutionException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	return generatedId;

    }
}
