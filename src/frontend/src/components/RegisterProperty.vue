<template>
  <div class="container custom-background">
    <h2 class="mb-4">Register Property</h2>
    <form @submit.prevent="submitProperty">
      <div class="row mb-3">
        <div class="col-md-6">
          <label for="propertyName" class="form-label">Property Name</label>
          <input type="text" class="form-control custom-border" v-model="property.propertyName" id="propertyName" placeholder="Property name">
        </div>
        <div class="col-md-6">
          <label for="numRooms" class="form-label">Number Of Rooms</label>
          <input type="number" class="form-control custom-border" v-model.number="property.numberOfRooms" id="numRooms" placeholder="Number of Rooms">
        </div>
      </div>

      <!-- Address Section -->
      <h4 class="mb-3">Address</h4>
      <div class="row mb-3">
        <div class="col-md-6">
          <label for="street" class="form-label">Street</label>
          <input type="text" class="form-control custom-border" v-model="property.address.street" id="street" placeholder="Street name">
        </div>
        <div class="col-md-6">
          <label for="suburb" class="form-label">Suburb</label>
          <input type="text" class="form-control custom-border" v-model="property.address.suburb" id="suburb" placeholder="Suburb">
        </div>
      </div>
      <div class="row mb-3">
        <div class="col-md-6">
          <label for="city" class="form-label">City</label>
          <input type="text" class="form-control custom-border" v-model="property.address.city" id="city" placeholder="City">
        </div>
        <div class="col-md-6">
          <label for="postalCode" class="form-label">Postal Code</label>
          <input type="text" class="form-control custom-border" v-model="property.address.postalCode" id="postalCode" placeholder="Postal code">
        </div>
      </div>

      <!-- Landlord Section -->
      <h4 class="mb-3">Landlord</h4>
      <div class="row mb-3">
        <div class="col-md-6">
          <label for="landlordName" class="form-label">Landlord Name</label>
          <input type="text" class="form-control custom-border" v-model="property.landlord.name" id="landlordName" placeholder="Landlord name">
        </div>
        <div class="col-md-6">
          <label for="gender" class="form-label">Gender</label>
          <select class="form-control custom-border" v-model="property.landlord.gender" id="gender">
            <option>Male</option>
            <option>Female</option>
            <option>Other</option>
          </select>
        </div>
      </div>
      <div class="row mb-3">
        <div class="col-md-6">
          <label for="dob" class="form-label">Date of Birth</label>
          <input type="date" class="form-control custom-border" v-model="property.landlord.dateOfBirth" id="dob">
        </div>
        <div class="col-md-6">
          <label for="numOfPropertiesOwned" class="form-label">Number of Properties Owned</label>
          <input type="number" class="form-control custom-border" v-model.number="property.landlord.numOfPropertiesOwned" id="numOfPropertiesOwned" placeholder="Number of Properties Owned">
        </div>
      </div>
      <div class="row mb-3">
        <div class="col-md-12">
          <label for="contact" class="form-label">Contact</label>
          <input type="text" class="form-control custom-border" v-model="property.landlord.contact" id="contact" placeholder="Contact information">
        </div>
      </div>

      <div class="form-check mb-4">
        <input class="form-check-input custom-border" v-model="agreedToTerms" type="checkbox" id="termsAndConditions">
        <label class="form-check-label" for="termsAndConditions">
          I read and agree to the <a href="#">Terms and conditions</a>
        </label>
      </div>

      <button type="submit" class="btn text-white custom-button">Submit</button>
    </form>
  </div>
</template>

<script>
import PropertyService from '@/service/PropertyService';

export default {
  name: 'RegisterProperty',
  data() {
    return {
      property: {
        propertyName: '',
        numberOfRooms: 0,
        address: {
          street: '',
          suburb: '',
          city: '',
          postalCode: ''
        },
        landlord: {
          userId: null,  // Assuming this is auto-generated or managed elsewhere
          name: '',
          gender: '',
          dateOfBirth: '',
          password: '',  // Assuming password management is handled separately
          contact: '',
          documents: [], // Assuming this will be an array of file paths or objects
          numOfPropertiesOwned: 0
        },
        pictures: [], // Assuming this will be an array of file paths or objects
        price: 0.0    // Assuming you'll capture the price as well
      },
      agreedToTerms: false
    };
  },
  methods: {
    async submitProperty() {
      if (!this.agreedToTerms) {
        alert('You must agree to the terms and conditions.');
        return;
      }

      try {
        const response = await PropertyService.saveProperty(this.property);
        console.log('Property saved successfully:', response);
        alert('Property saved successfully!');
        // Optionally, reset the form or navigate to another page
      } catch (error) {
        console.error('Error saving property:', error);
        alert('There was an error saving the property.');
      }
    }
  }
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
