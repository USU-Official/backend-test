package com.example.demobackend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;

@Document(collection = "students")
public class Student {
    @Id
    private String id;
    private String nim;
    private String name;

    @Field("entry_status")
    private String entryStatus;     // pindahan atau baru

    @Field("entry_year")
    private String entryYear;

    private String period;

    @Field("is_linear")
    private boolean isLinear = true;

    @Field("usu_alumnus")
    private Boolean usuAlumnus;

    @Field("education_level")
    private String educationLevel;

    @Field("major_code")
    private String majorCode;

    @Field("major_name")
    private String majorName;

    @Field("faculty_id")
    private String facultyId;

    @Field("faculty_name")
    private String facultyName;

    private String nationality;

    @Field("identity_number")
    private String identityNumber;

    @Field("identity_type")
    private String identityType;

    @Field("identity_file")
    private String identityFile;

    private String npwp;

    @Field("domicile_status")
    private String domicileStatus; // kos

    private String transportation;
    private String telephone;
    private String hp;
    private String email;

    @Field("is_kps")
    private boolean isKps;

    @Field("kps_number")
    private String kpsNumber;

    @Field("curriculum_id")
    private String curriculumId;    // get from sia

    @Field("curriculum_name")
    private String curriculumName;

    @Field("blood_type")
    private String bloodType;

    @Field("birth_date")
    private LocalDate birthDate;

    @Field("birth_place")
    private String birthPlace;
    private String gender;

    @Field("family_card_number")
    private String familyCardNumber;
    private String religion;
    private String disabilities;

    @Field("scholarship_name")
    private String scholarshipName;
    private String admission;

    @Field("class_type")
    private String classType; // reguler, paralel

    @Field("ukt_level")
    private String uktLevel;

    @Field("registration_date")
    private LocalDate registrationDate;

    @Field("registration_number")
    private String registrationNumber;

    @Field("registration_period_id")
    private String registrationPeriodId;

    private int siblings;
    private int dependents;

    @Field("marital_status")
    private String maritalStatus;

    @Field("parent_marital_status")
    private String parentMaritalStatus;

    private String hobby;
    private String photo;

    @Field("elearning_id")
    private String elearningId;

    @Field("have_mail_student")
    private boolean haveMailStudent;

    @Field("mail_student")
    private String mailStudent;

    @Field("mail_recovery")
    private String mailRecovery;

    @Field("mail_password")
    private String mailPassword;

    @Field("is_deleted")
    private boolean isDeleted;

    public Student() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEntryStatus() {
        return entryStatus;
    }

    public void setEntryStatus(String entryStatus) {
        this.entryStatus = entryStatus;
    }

    public String getEntryYear() {
        return entryYear;
    }

    public void setEntryYear(String entryYear) {
        this.entryYear = entryYear;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public boolean isLinear() {
        return isLinear;
    }

    public void setLinear(boolean linear) {
        isLinear = linear;
    }

    public Boolean getUsuAlumnus() {
        return usuAlumnus;
    }

    public void setUsuAlumnus(Boolean usuAlumnus) {
        this.usuAlumnus = usuAlumnus;
    }

    public String getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }

    public String getMajorCode() {
        return majorCode;
    }

    public void setMajorCode(String majorCode) {
        this.majorCode = majorCode;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public String getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(String facultyId) {
        this.facultyId = facultyId;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public String getIdentityType() {
        return identityType;
    }

    public void setIdentityType(String identityType) {
        this.identityType = identityType;
    }

    public String getIdentityFile() {
        return identityFile;
    }

    public void setIdentityFile(String identityFile) {
        this.identityFile = identityFile;
    }

    public String getNpwp() {
        return npwp;
    }

    public void setNpwp(String npwp) {
        this.npwp = npwp;
    }

    public String getDomicileStatus() {
        return domicileStatus;
    }

    public void setDomicileStatus(String domicileStatus) {
        this.domicileStatus = domicileStatus;
    }

    public String getTransportation() {
        return transportation;
    }

    public void setTransportation(String transportation) {
        this.transportation = transportation;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isKps() {
        return isKps;
    }

    public void setKps(boolean kps) {
        isKps = kps;
    }

    public String getKpsNumber() {
        return kpsNumber;
    }

    public void setKpsNumber(String kpsNumber) {
        this.kpsNumber = kpsNumber;
    }

    public String getCurriculumId() {
        return curriculumId;
    }

    public void setCurriculumId(String curriculumId) {
        this.curriculumId = curriculumId;
    }

    public String getCurriculumName() {
        return curriculumName;
    }

    public void setCurriculumName(String curriculumName) {
        this.curriculumName = curriculumName;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFamilyCardNumber() {
        return familyCardNumber;
    }

    public void setFamilyCardNumber(String familyCardNumber) {
        this.familyCardNumber = familyCardNumber;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getDisabilities() {
        return disabilities;
    }

    public void setDisabilities(String disabilities) {
        this.disabilities = disabilities;
    }

    public String getScholarshipName() {
        return scholarshipName;
    }

    public void setScholarshipName(String scholarshipName) {
        this.scholarshipName = scholarshipName;
    }

    public String getAdmission() {
        return admission;
    }

    public void setAdmission(String admission) {
        this.admission = admission;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public String getUktLevel() {
        return uktLevel;
    }

    public void setUktLevel(String uktLevel) {
        this.uktLevel = uktLevel;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getRegistrationPeriodId() {
        return registrationPeriodId;
    }

    public void setRegistrationPeriodId(String registrationPeriodId) {
        this.registrationPeriodId = registrationPeriodId;
    }

    public int getSiblings() {
        return siblings;
    }

    public void setSiblings(int siblings) {
        this.siblings = siblings;
    }

    public int getDependents() {
        return dependents;
    }

    public void setDependents(int dependents) {
        this.dependents = dependents;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getParentMaritalStatus() {
        return parentMaritalStatus;
    }

    public void setParentMaritalStatus(String parentMaritalStatus) {
        this.parentMaritalStatus = parentMaritalStatus;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getElearningId() {
        return elearningId;
    }

    public void setElearningId(String elearningId) {
        this.elearningId = elearningId;
    }

    public boolean isHaveMailStudent() {
        return haveMailStudent;
    }

    public void setHaveMailStudent(boolean haveMailStudent) {
        this.haveMailStudent = haveMailStudent;
    }

    public String getMailStudent() {
        return mailStudent;
    }

    public void setMailStudent(String mailStudent) {
        this.mailStudent = mailStudent;
    }

    public String getMailRecovery() {
        return mailRecovery;
    }

    public void setMailRecovery(String mailRecovery) {
        this.mailRecovery = mailRecovery;
    }

    public String getMailPassword() {
        return mailPassword;
    }

    public void setMailPassword(String mailPassword) {
        this.mailPassword = mailPassword;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", nim='" + nim + '\'' +
                ", name='" + name + '\'' +
                ", entryStatus='" + entryStatus + '\'' +
                ", entryYear='" + entryYear + '\'' +
                ", period='" + period + '\'' +
                ", isLinear=" + isLinear +
                ", usuAlumnus=" + usuAlumnus +
                ", educationLevel='" + educationLevel + '\'' +
                ", majorCode='" + majorCode + '\'' +
                ", majorName='" + majorName + '\'' +
                ", facultyId='" + facultyId + '\'' +
                ", facultyName='" + facultyName + '\'' +
                ", nationality='" + nationality + '\'' +
                ", identityNumber='" + identityNumber + '\'' +
                ", identityType='" + identityType + '\'' +
                ", identityFile='" + identityFile + '\'' +
                ", npwp='" + npwp + '\'' +
                ", domicileStatus='" + domicileStatus + '\'' +
                ", transportation='" + transportation + '\'' +
                ", telephone='" + telephone + '\'' +
                ", hp='" + hp + '\'' +
                ", email='" + email + '\'' +
                ", isKps=" + isKps +
                ", kpsNumber='" + kpsNumber + '\'' +
                ", curriculumId='" + curriculumId + '\'' +
                ", curriculumName='" + curriculumName + '\'' +
                ", bloodType='" + bloodType + '\'' +
                ", birthDate=" + birthDate +
                ", birthPlace='" + birthPlace + '\'' +
                ", gender='" + gender + '\'' +
                ", familyCardNumber='" + familyCardNumber + '\'' +
                ", religion='" + religion + '\'' +
                ", disabilities='" + disabilities + '\'' +
                ", scholarshipName='" + scholarshipName + '\'' +
                ", admission='" + admission + '\'' +
                ", classType='" + classType + '\'' +
                ", uktLevel='" + uktLevel + '\'' +
                ", registrationDate=" + registrationDate +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", registrationPeriodId='" + registrationPeriodId + '\'' +
                ", siblings=" + siblings +
                ", dependents=" + dependents +
                ", maritalStatus='" + maritalStatus + '\'' +
                ", parentMaritalStatus='" + parentMaritalStatus + '\'' +
                ", hobby='" + hobby + '\'' +
                ", photo='" + photo + '\'' +
                ", elearningId='" + elearningId + '\'' +
                ", haveMailStudent=" + haveMailStudent +
                ", mailStudent='" + mailStudent + '\'' +
                ", mailRecovery='" + mailRecovery + '\'' +
                ", mailPassword='" + mailPassword + '\'' +
                ", isDeleted=" + isDeleted +
                '}';
    }
}