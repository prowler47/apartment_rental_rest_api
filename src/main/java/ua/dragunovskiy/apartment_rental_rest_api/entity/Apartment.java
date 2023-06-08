package ua.dragunovskiy.apartment_rental_rest_api.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "apartment")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "apartmentInfoStruct")
public class Apartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "price")
    private int price;

    @Column(name = "city")
    @JsonProperty("city")
    private String city;

    @Column(name = "address")
    private String address;

    @Column(name = "pet_friendly")
    private boolean petFriendly;

    @OneToOne(mappedBy = "apartment", cascade = CascadeType.ALL)
    @JsonIgnore
    private ApartmentInfoStruct apartmentInfoStruct;

}
