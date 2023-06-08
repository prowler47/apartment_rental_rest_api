package ua.dragunovskiy.apartment_rental_rest_api.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import java.util.List;

@Entity
@Table(name = "apartment_infostruct")
@Data
@ToString(exclude = {"apartment", "educationEstablishmentList", "hospitalList", "parkingList", "roadJunctionList", "storeList"})
public class ApartmentInfoStruct {

    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "educ_id")
    private Long educId;

    @Column(name = "hospital_id")
    private Long hospitalId;

    @Column(name = "store_id")
    private Long storeId;

    @Column(name = "parking_id")
    private Long parkingId;

    @Column(name = "road_junction_id")
    private Long road_junction_id;

    @OneToOne
    @JoinColumn(name = "apartment_id")
    private Apartment apartment;

    @OneToMany(mappedBy = "apartmentInfoStructEduc", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<EducationEstablishment> educationEstablishmentList;

    @OneToMany(mappedBy = "apartmentInfoStructHospitals", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Hospital> hospitalList;

    @OneToMany(mappedBy = "apartmentInfoStructParking", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Parking> parkingList;

    @OneToMany(mappedBy = "apartmentInfoStructRoadJunction", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<RoadJunction> roadJunctionList;

    @OneToMany(mappedBy = "apartmentInfoStructStore", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Store> storeList;

}
