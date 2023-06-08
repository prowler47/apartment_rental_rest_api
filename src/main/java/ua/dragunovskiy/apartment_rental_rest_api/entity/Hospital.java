package ua.dragunovskiy.apartment_rental_rest_api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "hospitals")
@Data
@ToString(exclude = "apartmentInfoStructHospitals")
public class Hospital {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "time")
    private int time;

    @ManyToOne
    @JoinColumn(name = "local_hospital_id")
    @JsonIgnore
    private ApartmentInfoStruct apartmentInfoStructHospitals;
}
