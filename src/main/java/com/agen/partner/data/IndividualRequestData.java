package com.agen.partner.data;

import com.agen.idGenerator.IPartnerIdGenerator;
import com.agen.idGenerator.IdGenerator;

public class IndividualRequestData {
    private String partnerID;
    private String name;
    private String email;
    private String phoneNumber;

    /**
     * @return the partnerID
     */
    public String getPartnerID() {
	IdGenerator iPartner = new IPartnerIdGenerator();
	String partnerID = iPartner.generate().toString();
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

}
