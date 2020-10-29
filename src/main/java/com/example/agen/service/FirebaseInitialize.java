package com.example.agen.service;

import java.io.*;
import javax.annotation.*;
import org.springframework.stereotype.*;
import com.google.auth.oauth2.*;
import com.google.firebase.*;

@Service  
public class FirebaseInitialize {  
@PostConstruct  
public void initializeDB() {  
	
try {  	
InputStream serviceAccount =  
this.getClass().getClassLoader().getResourceAsStream("./age-network-firebase-adminsdk-h7ck7-5f6dcb225e.json");  

FirebaseOptions options = new FirebaseOptions.Builder()
.setCredentials(GoogleCredentials.fromStream(serviceAccount))
.setDatabaseUrl("https://age-network.firebaseio.com")
.build();

FirebaseApp.initializeApp(options);  

} catch (Exception e) {  
e.printStackTrace();  
}}}  
