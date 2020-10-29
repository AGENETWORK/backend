package com.agen.partner.data;

import com.agen.idGenerator.IdGenerator;
import com.agen.idGenerator.OPartnerIdGenerator;

public class OrganisationRequestData {
    private String partnerID;
    private String name;
    private String email;
    private String phoneNumber;
    private String representativeName;
    private String representativeEmail;
    private String details;

    /**
     * @return the partnerID
     */
    public String getPartnerID() {
	IdGenerator oPartner = new OPartnerIdGenerator();
	String partnerID = oPartner.generate().toString();
	return partnerID;
    }

    /**
     * @param partnerID
     *            the partnerID to set
     */
    public void setPartnerID(String partnerID) {
	this.partnerID = partnerID;
    }

    /**
     * @return the name
     */
    public String getName() {
	return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
	this.name = name;
    }

    /**
     * @return the email
     */
    public String getEmail() {
	return email;
    }

    /**
     * @param email
     *            the email to set
     */
    public void setEmail(String email) {
	this.email = email;
    }

    /**
     * @return the phoneNumber
     */
    public String getPhoneNumber() {
	return phoneNumber;
    }

    /**
     * @param phoneNumber
     *            the phoneNumber to set
     */
    public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
    }

    /**
     * @return the representativeName
     */
    public String getRepresentativeName() {
	return representativeName;
    }

    /**
     * @param representativeName
     *            the representativeName to set
     */
    public void setRepresentativeName(String representativeName) {
	this.representativeName = representativeName;
    }

    /**
     * @return the representativeEmail
     */
    public String getRepresentativeEmail() {
	return representativeEmail;
    }

    /**
     * @param representativeEmail
     *            the representativeEmail to set
     */
    public void setRepresentativeEmail(String representativeEmail) {
	this.representativeEmail = representativeEmail;
    }

    /**
     * @return the details
     */
    public String getDetails() {
	return details;
    }

    /**
     * @param details
     *            the details to set
     */
    public void setDetails(String details) {
	this.details = details;
    }

}
