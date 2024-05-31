package bg.softuni.mobilele.model;

import bg.softuni.mobilele.model.enums.EngineType;

public class AddOfferDTO {
    private String description;
    private Integer mileage;
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
