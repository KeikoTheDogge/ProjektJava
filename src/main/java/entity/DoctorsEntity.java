package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "doctors", schema = "nfz")
public class DoctorsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "doctorID")
    private int doctorId;
    @Basic
    @Column(name = "specialization")
    private String specialization;

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DoctorsEntity that = (DoctorsEntity) o;

        if (doctorId != that.doctorId) return false;
        if (specialization != null ? !specialization.equals(that.specialization) : that.specialization != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = doctorId;
        result = 31 * result + (specialization != null ? specialization.hashCode() : 0);
        return result;
    }
}
