package bg.softuni.mobilele.model;

import bg.softuni.mobilele.model.enums.EngineType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class AddOfferDTO {
    @Size(min = 5, max = 500, message = "Description must be between 5 and 500 characters.")
    private String description;
    @Positive(message = "Mileage must be greater than zero.")
    private Integer mileage;
    @NotNull
    private EngineType engineType;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EngineType getEngineType() {
        return engineType;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public void setEngineType(EngineType engineType) {
        this.engineType = engineType;
    }
}
