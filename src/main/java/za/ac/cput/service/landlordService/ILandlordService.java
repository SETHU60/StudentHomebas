package za.ac.cput.service.landlordService;

import za.ac.cput.domain.Landlord;
import za.ac.cput.service.IService;

import java.util.List;

public interface ILandlordService extends IService<Landlord, Long> {
    List<Landlord> getall();
}
