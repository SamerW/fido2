/**
 * Copyright StrongAuth, Inc. All Rights Reserved.
 *
 * Use of this source code is governed by the Gnu Lesser General Public License 2.3.
 * The license can be found at https://github.com/StrongKey/fido2/LICENSE
 */

package com.strongkey.skce.pojos;

import com.strongkey.skce.utilities.skceConstants;
import java.io.Serializable;
import javax.json.JsonObject;

/**
 *
 * A POJO to hold the metadata of an LDAP user present in an LDAP based 
 * authentication & authorization system.
 * 
 */
public class LDAPUserMetadata implements Serializable {

    /**
     * Variables that define meta data of an ldap user
     */
    private String username = null;
    private String userdn = null;
    private String firstname = null;
    private String lastname = null;
    private String uid = null;
    private String emailaddresses = null;
    private String primaryemail = null;
    private String phonenumbers = null;
    private String primaryphone = null;
    private String defaultcommunication = null;
    private String fidokeysenabled = null;
    private String twostepverification = null;
    private Long did;

    /**
     * Constructor of this class.
     * 
     * @param username          - name of the user
     * @param userdn            - user full dn in the ldap schema
     * @param firstname         - first name of the user
     * @param lastname          - last name of the user
     * @param emailaddresses    - list of comma separated email addresses
     * @param primaryemail      - one email address that is used as primary
     * @param phonenumbers      - list of comma separated phone numbers 
     * @param primaryphone      - one phone number that is used as primary 
     * @param defaultcomm       - default communication channel for 2 step
     *                      verification. Possible values are 'phone' or 'email'
     * @param twostepverification - Attribute with name 'twostepverification' that 
     *                      signifies whether the user has enabled fido (2 factor) 
     *                      based authentication on his/her account. Possible answers
     *                      are 'yes' or 'no'.
     * @param fidokeysenabled   - Attribute with name 'fidokeysenabled' that 
     *                      signifies whether there are any fido based authenticators
     *                      already registered for the account. Possible answers
     *                      are 'yes' or 'no'.
     */
    public LDAPUserMetadata(String username,
            String userdn,
            String firstname,
            String lastname,
            String uid,
            String emailaddresses,
            String primaryemail,
            String phonenumbers,
            String primaryphone,
            String defaultcomm,
            String fidokeysenabled,
            String twostepverification,
            Long did) {
        this.username = username;
        this.userdn = userdn;
        this.uid = uid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.emailaddresses = emailaddresses;
        this.primaryemail = primaryemail;
        this.phonenumbers = phonenumbers;
        this.primaryphone = primaryphone;
        this.defaultcommunication = defaultcomm;
        this.fidokeysenabled = fidokeysenabled;
        this.twostepverification = twostepverification;
        this.did = did;
    } 

    public LDAPUserMetadata(String commonname, String principal, String fname, String surname, String uid) {
        this.username = commonname;
        this.userdn = principal;
        this.uid = uid;
        this.firstname = fname;
        this.lastname = surname;
    }

    /**
     * Converts this POJO into a JsonObject and returns the same.
     * @return JsonObject
     */
    public JsonObject getJSONObject() {

        if(defaultcommunication == null){
            defaultcommunication ="";
        }
        // Build the output json object
        JsonObject metadataJSON = javax.json.Json.createObjectBuilder()
                .add(skceConstants.LDAP_ATTR_KEY_COMMONNAME, username)
                .add(skceConstants.LDAP_ATTR_KEY_DN, userdn)
                .add(skceConstants.LDAP_ATTR_KEY_UID, uid)
                .add(skceConstants.LDAP_ATTR_KEY_FNAME, firstname)
                .add(skceConstants.LDAP_ATTR_KEY_SURNAME, lastname)
                .add(skceConstants.LDAP_ATTR_KEY_EMAILADDRESSES, emailaddresses)
                .add(skceConstants.LDAP_ATTR_KEY_PRIMARYEMAIL, primaryemail)
                .add(skceConstants.LDAP_ATTR_KEY_PHONENUMBERS, phonenumbers)
                .add(skceConstants.LDAP_ATTR_KEY_PRIMARYPHONE, primaryphone)
                .add(skceConstants.LDAP_ATTR_KEY_DEFAULTTARGET, defaultcommunication)
                .add(skceConstants.LDAP_ATTR_KEY_FIDOENABLED, fidokeysenabled)
                .add(skceConstants.LDAP_ATTR_KEY_2STEPVERIFY, twostepverification)
                .add(skceConstants.LDAP_ATTR_KEY_DOMAINID, did).
                build();

        return metadataJSON;
    }
    
    /**
     * Converts this POJO into a JsonObject and returns the String form of it.
     * @return String containing the Json representation of this POJO.
     */
    public String getJSONString() {
        return getJSONObject().toString();
    }

    /**
    * Get-Set methods to access the challenge parameters
     * @return 
    */
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserdn() {
        return userdn;
    }

    public void setUserdn(String userdn) {
        this.userdn = userdn;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmailaddresses() {
        return emailaddresses;
    }

    public void setEmailaddresses(String emailaddresses) {
        this.emailaddresses = emailaddresses;
    }

    public String getPrimaryemail() {
        return primaryemail;
    }

    public void setPrimaryemail(String primaryemail) {
        this.primaryemail = primaryemail;
    }

    public String getPhonenumbers() {
        return phonenumbers;
    }

    public void setPhonenumbers(String phonenumbers) {
        this.phonenumbers = phonenumbers;
    }

    public String getPrimaryphone() {
        return primaryphone;
    }

    public void setPrimaryphone(String primaryphone) {
        this.primaryphone = primaryphone;
    }

    public String getDefaultcommunication() {
        return defaultcommunication;
    }

    public void setDefaultcommunication(String defaultcommunication) {
        this.defaultcommunication = defaultcommunication;
    }

    public String getFidokeysenabled() {
        return fidokeysenabled;
    }

    public void setFidokeysenabled(String fidokeysenabled) {
        this.fidokeysenabled = fidokeysenabled;
    }

    public String getTwostepverification() {
        return twostepverification;
    }

    public void setTwostepverification(String twostepverification) {
        this.twostepverification = twostepverification;
    }

    public Long getDid() {
        return did;
    }

    public void setDid(Long did) {
        this.did = did;
    }
    
    /**
     * Over-ridden toString method to print the object content in a readable 
     * manner
     * @return  String with object content laid in a readable manner.
     */
    @Override
    public String toString() {
        return    "\n    username = " + this.username
                + "\n    userdn = " + this.userdn
                + "\n    firstname = " + this.firstname
                + "\n    lastname = " + this.lastname
                + "\n    uid = " + this.uid
                + "\n    emailaddresses = " + this.emailaddresses
                + "\n    primaryemail = " + this.primaryemail
                + "\n    phonenumbers = " + this.phonenumbers
                + "\n    defaulttarget = " + this.defaultcommunication
                + "\n    fidokeysenabled = " + this.fidokeysenabled
                + "\n    twostepverification = " + this.twostepverification
                + "\n    did = " + this.did;
    }
}