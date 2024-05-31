package bg.softuni.mobilele.service.impl;

import bg.softuni.mobilele.model.AddOfferDTO;
import bg.softuni.mobilele.model.OfferDetailsDTO;
import bg.softuni.mobilele.model.entity.Offer;
import bg.softuni.mobilele.repository.OfferRepository;
import bg.softuni.mobilele.service.OfferService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class OfferServiceImpl implements OfferService {
    private final OfferRepository offerRepository;
    private final ModelMapper modelMapper;

    public OfferServiceImpl(OfferRepository offerRepository, ModelMapper modelMapper) {
        this.offerRepository = offerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addOffer(AddOfferDTO addOfferDTO) {
        Offer offer = modelMapper.map(addOfferDTO, Offer.class);

        offerRepository.save(offer);
    }

    @Override
    public OfferDetailsDTO getDetails(Long id) {
        Offer offer = offerRepository.findById(id).orElseThrow();

        return modelMapper.map(offer, OfferDetailsDTO.class);
    }
}
