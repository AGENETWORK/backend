package com.example.agen;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.agen.partner.data.IndividualRequestData;
import com.agen.partner.data.IndividualResponseData;
import com.agen.partner.data.OrganisationRequestData;
import com.agen.partner.data.OrganisationResponseData;
import com.agen.utilities.Utilities;
import com.example.agen.service.IPartnerService;
import com.example.agen.service.OPartnerService;
import com.example.agen.service.PatientService;

@RestController

public class AgenController {

    @Autowired
    PatientService patientService;
    @Autowired
    IPartnerService iPartnerService;
    @Autowired
    OPartnerService oPartnerService;

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/sample")
    public Sample greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
	return new Sample(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("/getPatientDetails")
    public Patient getPatient(@RequestParam String name) throws InterruptedException, ExecutionException {
	return patientService.getPatientDetails(name);
    }

    @PostMapping("/createPatient")
    public String createPatient(@RequestBody Patient patient) throws InterruptedException, ExecutionException {
	return patientService.savePatientDetails(patient);
    }

    @PutMapping("/updatePatient")
    public String updatePatient(@RequestBody Patient patient) throws InterruptedException, ExecutionException {
	return patientService.updatePatientDetails(patient);
    }

    @DeleteMapping("/deletePatient")
    public String deletePatient(@RequestParam String name) {
	return patientService.deletePatient(name);
    }

    @PostMapping("/addIndividualPartner")
    public String addIndividualPartner(@RequestBody IndividualRequestData individualRequestData)
	    throws InterruptedException, ExecutionException {
	Utilities util = new Utilities();
	IndividualResponseData response = iPartnerService.addIndividualPartnerToDB(individualRequestData);
	return util.objectToJson(response);
    }

    @PostMapping("/addOrganisationPartner")
    public OrganisationResponseData addOrganisationPartner(@RequestBody OrganisationRequestData organisationRequestData)
	    throws InterruptedException, ExecutionException {
	return oPartnerService.addOrganisationPartnerToDB(organisationRequestData);
    }

    @GetMapping("/getOrganisation")
    public OrganisationResponseData getOrganisation(@RequestParam String id)
	    throws InterruptedException, ExecutionException {
	return oPartnerService.getOrganisation(id);
    }

}
