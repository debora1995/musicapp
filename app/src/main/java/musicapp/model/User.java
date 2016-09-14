package musicapp.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by ausias on 27/04/16.
 */

@DatabaseTable(tableName = "UserInfo")
public class User {

    @DatabaseField(id = true)
    private int id;

     @DatabaseField
    private String name;

     @DatabaseField
    private String lastname;

    @DatabaseField
    private String password;

    @DatabaseField
    private String sex;

    @DatabaseField
    private String birthday;


    @DatabaseField
    private String telephone;

     @DatabaseField
    private String email;

     @DatabaseField
    private String URLImage;

     @DatabaseField
    private String information;




    public  User() {
        // all persisted classes must define a no-arg constructor with at least package visibility

    }



    /**
     * Returns the User's name
     * @return the User's name
     * @author Débora López, Pili Bielsa, David Ferrer
     */
    public String getName() {
        return name;
    }

    /**
     * Set the User's name
     * @param name Is the user's name
     * @author Débora López, Pili Bielsa, David Ferrer
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the User's lastname
     * @return the User's lastname
     * @author Débora López, Pili Bielsa, David Ferrer
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Set the User's lastname
     * @param lastname  the User's name
     * @author Débora López, Pili Bielsa, David Ferrer
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * Returns the User's birthday
     * @return the user's birthday
     * @author Débora López, Pili Bielsa, David Ferrer
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * Set the User's age
     * @param birthday the user's birthday
     * @author Débora López, Pili Bielsa, David Ferrer
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    /**
     * Returns the User's number phone
     * @return  the number of user's phone
     * @author Débora López, Pili Bielsa, David Ferrer
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * Set the User's telephone number
     * @param telephone Is the user's telephone number
     * @author Débora López, Pili Bielsa, David Ferrer
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * Returns the User's email
     * @return  the user email
     * @author Débora López, Pili Bielsa, David Ferrer
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the User's email
     * @param email the user's email
     * @author Débora López, Pili Bielsa, David Ferrer
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns the User's id
     * @return the user's id
     * @author Débora López, Pili Bielsa, David Ferrer
     */
    public int getId() {
        return id;
    }

    /**
     * Set the User's id
     * @param id Is the user's id
     * @author Débora López, Pili Bielsa, David Ferrer
     */
    public void setId(int id) {
        this.id = id;
    }


    /**
     * Returns the User's password
     * @return the user's password
     * @author Débora López, Pili Bielsa, David Ferrer
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the User's password
     * @param password Is the user's password
     * @author Débora López, Pili Bielsa, David Ferrer
     */
    public void setPassword(String password) {
        this.password = password;
    }


    /**
     * Return the url's path to the User's image
     * @retunr the url's path
     * @author Débora López, Pili Bielsa, David Ferrer
     */
    public String getURLImage() {
        return URLImage;
    }

    /**
     * Set the url's path to the User's image
     * @param uRLImage Is the url's path
     * @author Débora López, Pili Bielsa, David Ferrer
     */
    public void setURLImage(String uRLImage) {
        URLImage = uRLImage;
    }

    /**
     * Set the User's sex
     * @return Is the user's sex
     * @author Débora López, Pili Bielsa, David Ferrer
     */
    public String getSex() {
        return sex;
    }

    /**
     * Set the User's sex
     * @param sex Is the user's sex
     * @author Débora López, Pili Bielsa, David Ferrer
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * Return more information about the user's
     * @return the User's information
     * @author Débora López, Pili Bielsa, David Ferrer
     */
    public String getInformation() {
        return information;
    }

    /**
     * Set  more information about the user's
     * @param information tell you about User's information
     * @author Débora López, Pili Bielsa, David Ferrer
     */
    public void setInformation(String information) {
        this.information = information;
    }

}
