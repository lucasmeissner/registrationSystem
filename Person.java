/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooprojectone;

import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author main
 */
public class Person {
    private String firstName, lastName, address, city, province, postalCode;
    LocalDate dateOfBirth;
    
    public Person(String firstName, String lastName, String address, String city, String province, String postalCode, LocalDate dateOfBirth){
        //Set instance variables.
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.province = province;
        
        //Throw exception if postal code is not 6 characters, also could have been done as postalCode.length() != 6 but I chose this one as its easier for me to read.
        if (postalCode.length() < 6 || postalCode.length() > 6){
            throw new IllegalArgumentException("Postal Code must be 6 characters exactly.");
        }else{
            postalCode = postalCode.toUpperCase();
            this.postalCode = postalCode;
        }
    }

    //Getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getProvince() {
        return province;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    
    public String getAge(){
        //Using java.time to calculate age.
        Period age = Period.between(dateOfBirth, LocalDate.now());
        return age.toString();
    }
    
    public void changeAddress(String newAddress, String newCity, String newProvince, String newPostalCode){
        //Replace the old variables with the new ones
        address = newAddress;
        city = newCity;
        province = newProvince;
        
        //Make sure the postal code is still 6 characters.
        if (newPostalCode.length() < 6 || newPostalCode.length() > 6){
            throw new IllegalArgumentException("Postal Code must be 6 characters exactly.");
        }else{
            newPostalCode = newPostalCode.toUpperCase();
            postalCode = newPostalCode;
        }
    }
    
    public String getFullAddress(){
        //Return the address variables in a readable form
        return address + ", " + city + ", " + province + ", " + postalCode;
    }
    
    public String toString(){
        //Simply returns "firstName lastName"
        return firstName + " " + lastName;
    }
}
