package bg.softuni.mobilele.web;

import bg.softuni.mobilele.model.AddOfferDTO;
import bg.softuni.mobilele.model.enums.EngineType;
import bg.softuni.mobilele.service.OfferService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/offers")
public class OfferController {

    private final OfferService offerService;

    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @GetMapping("/add")
    public String addOffer(Model model) {

        model.addAttribute("engineTypes", EngineType.values());

        if (!model.containsAttribute("addOfferDTO")) {
            model.addAttribute("addOfferDTO", new AddOfferDTO());
        }

        return "offer-add";
    }

    @PostMapping("/add")
    public String addOffer(@Valid AddOfferDTO addOfferDTO, BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addOfferDTO", addOfferDTO);
            redirectAttributes
                    .addFlashAttribute("org.springframework.validation.BindingResult.addOfferDTO", bindingResult);

            return "redirect:/offers/add";
        }

        offerService.addOffer(addOfferDTO);

        return "offer-add";
    }

    @GetMapping("/{id}")
    public String offerDetails(@PathVariable("id") Long id,
                               Model model) {

        model.addAttribute("offerDetails", offerService.getDetails(id));

        return "details";
    }
}
