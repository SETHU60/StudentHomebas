package za.ac.cput.factory;

import za.ac.cput.domain.Landlord;
import za.ac.cput.domain.LandlordDocument;
import za.ac.cput.util.LandlordDocumentHelper;
import java.time.LocalDateTime;

public class LandlordDocumentFactory {
    public static LandlordDocument buildLandlordDocument(String landlordDocumentId, Landlord landlord, LocalDateTime dateTimeUploaded) {

        if (LandlordDocumentHelper.isNullOrEmpty(landlordDocumentId) ||
                LandlordDocumentHelper.isLandlordNull(landlord) ||
                LandlordDocumentHelper.isValidDate(dateTimeUploaded)) {
            return null;
        }

        return new LandlordDocument.Builder()
                .setLandlordDocumentId(landlordDocumentId)
                .setLandlord(landlord)
                .setDateUploaded(dateTimeUploaded)
                .build();
    }
}
