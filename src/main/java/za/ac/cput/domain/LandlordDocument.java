package za.ac.cput.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class LandlordDocument {

    private String landlordDocumentId;
    private Landlord landlord;
    private LocalDateTime dateUploaded;

    public LandlordDocument(Builder builder) {
        this.landlordDocumentId=builder.landlordDocumentId;
        this.landlord= builder.landlord;
        this.dateUploaded=builder.dateUploaded;
    }

    public void setLandlordDocumentId(String landlordDocumentId) {
        this.landlordDocumentId = landlordDocumentId;
    }

    public void setLandlord(Landlord landlord) {
        this.landlord = landlord;
    }

    public void setDateUploaded(LocalDateTime dateUploaded) {
        this.dateUploaded = dateUploaded;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LandlordDocument that)) return false;
        return Objects.equals(landlordDocumentId, that.landlordDocumentId) && Objects.equals(landlord, that.landlord) && Objects.equals(dateUploaded, that.dateUploaded);
    }

    @Override
    public int hashCode() {
        return Objects.hash(landlordDocumentId, landlord, dateUploaded);
    }

    @Override
    public String toString() {
        return "LandlordDocument{" +
                "landlordDocumentId='" + landlordDocumentId + '\'' +
                ", landlord=" + landlord +
                ", dateUploaded=" + dateUploaded +
                '}';
    }

    public static class Builder{
        private String landlordDocumentId;
        private Landlord landlord;
        private LocalDateTime dateUploaded;

        public Builder setLandlordDocumentId(String landlordDocumentId) {
            this.landlordDocumentId = landlordDocumentId;
            return this;
        }

        public Builder setLandlord(Landlord landlord) {
            this.landlord = landlord;
            return this;
        }

        public Builder setDateUploaded(LocalDateTime dateUploaded) {
            this.dateUploaded = dateUploaded;
            return this;
        }
        public Builder copy(LandlordDocument landlordDocument){
            this.landlordDocumentId=landlordDocument.landlordDocumentId;
            this.landlord= landlordDocument.landlord;
            this.dateUploaded=landlordDocument.dateUploaded;
            return this;
        }
        public LandlordDocument build(){return new LandlordDocument(this);}
    }
}

