<template>
  <div class="container custom-background">
    <h2 class="mb-4">Register Property</h2>
    <form>
      <div class="row mb-3">
        <div class="col-md-6">
          <label for="propertyName" class="form-label">Property Name</label>
          <input type="text" class="form-control custom-border" id="propertyName" placeholder="Property name">
        </div>
        <div class="col-md-6">
          <label for="numRooms" class="form-label">Number Of Rooms</label>
          <input type="number" class="form-control custom-border" id="numRooms" placeholder="Number of Rooms">
        </div>
      </div>

      <div class="row mb-3">
        <div class="col-md-6">
          <label for="streetName1" class="form-label">Street Name</label>
          <input type="text" class="form-control custom-border" id="streetName1" placeholder="Street name">
        </div>
        <div class="col-md-6">
          <label for="suburb" class="form-label">Suburb</label>
          <input type="text" class="form-control custom-border" id="suburb" placeholder="Suburb">
        </div>
      </div>

      <div class="row mb-3">
        <div class="col-md-6">
          <label for="streetName2" class="form-label">Street Name</label>
          <input type="text" class="form-control custom-border" id="streetName2" placeholder="Street name">
        </div>
        <div class="col-md-6">
          <label for="postalCode" class="form-label">Postal Code</label>
          <input type="text" class="form-control custom-border" id="postalCode" placeholder="Postal code">
        </div>
      </div>

      <div class="mb-3">
        <label for="fileUpload" class="form-label">Upload Documents</label>
        <div class="border p-4 text-center custom-border" style="border-style: dashed;">
          <input type="file" class="form-control d-none" id="fileUpload">
          <label for="fileUpload" class="text-muted">Drag and Drop here or <a href="#">Browse files</a></label>
          <p class="text-muted">Accepted files: pdf, doc and docx only*</p>
        </div>
      </div>

      <div class="form-check mb-4">
        <input class="form-check-input custom-border" type="checkbox" id="termsAndConditions">
        <label class="form-check-label" for="termsAndConditions">
          I read and agree to the <a href="#">Terms and conditions</a>
        </label>
      </div>

      <button type="submit" class="btn text-white custom-button">Submit</button>
    </form>
  </div>
</template>

<script>
export default {
  name: 'RegisterProperty',
};
</script>

<style scoped>
.custom-background {
  background-color: #E3E0E0; /* Background color for the form container */
  padding: 20px; /* Add some padding for better spacing */
  border-radius: 8px; /* Optional: Add rounded corners */
}

.custom-border {
  border-color: #127670 !important;
}

.custom-button {
  background-color: #127670 !important;
}
</style>
