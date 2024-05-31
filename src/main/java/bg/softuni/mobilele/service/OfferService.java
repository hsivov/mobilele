package bg.softuni.mobilele.service;

import bg.softuni.mobilele.model.AddOfferDTO;
import bg.softuni.mobilele.model.OfferDetailsDTO;

public interface OfferService {
    void addOffer(AddOfferDTO addOfferDTO);

    OfferDetailsDTO getDetails(Long id);
}
