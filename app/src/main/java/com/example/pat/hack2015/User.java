package com.example.pat.hack2015;

/**
 * Created by Pat on 11/7/2015.
 */
public class User {

        private int birthYear;
        private String fullName;
        public User() {}
        public User(String fullName, int birthYear) {
            this.fullName = fullName;
            this.birthYear = birthYear;
        }
        public long getBirthYear() {
            return birthYear;
        }
        public String getFullName() {
            return fullName;
        }



}
