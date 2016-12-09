package co.sprayable.sleep.data;

import qa.util.Constants;
import qa.util.Random;

public class QuizData {

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    private String gender;
    private int zipCode;
    private int age;
    private String email;
    private String name;


    public QuizData generateQuizData() {
        this.setAge(Constants.QUIZ_AGE);
        this.setGender(Random.genGender());
        this.setEmail(Constants.QUIZ_EMAIL);
        this.setName(Constants.ORDER_NAME);
        this.setZipCode(Integer.parseInt(Constants.POSTAL_CODE));
        return this;
    }
}
