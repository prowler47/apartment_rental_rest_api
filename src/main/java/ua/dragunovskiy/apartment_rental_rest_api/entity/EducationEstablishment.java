package ua.dragunovskiy.apartment_rental_rest_api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "educational_establishments")
@Data
@ToString(exclude = "apartmentInfoStructEduc")
public class EducationEstablishment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "time")
    private int time;

    @ManyToOne
    @JoinColumn(name = "local_educ_id")
    @JsonIgnore
    private ApartmentInfoStruct apartmentInfoStructEduc;

}