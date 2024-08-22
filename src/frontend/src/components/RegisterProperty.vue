<template>
  <div class="container custom-background">
    <h2 class="mb-4">Register Property</h2>
    <form>
      <!-- Property Name and Number of Rooms -->
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

      <!-- Street Name and Suburb -->
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

      <!-- Additional Street Name and Postal Code -->
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

      <!-- Document Upload Section -->
      <div class="mb-3">
        <h4 class="mb-3">Upload Documents</h4>
        <button type="button" class="btn btn-secondary mb-3" @click="toggleDocumentForm">Add Document</button>

        <!-- Dynamic Document Upload Form -->
        <div v-if="showDocumentForm" class="document-form-popup p-3 mb-3">
          <div class="row">
            <div class="col-md-6">
              <label for="documentName" class="form-label">Document Name</label>
              <input type="text" class="form-control" v-model="newDocument.documentName" placeholder="Document name">
            </div>
            <div class="col-md-6">
              <label for="fileContents" class="form-label">Upload Document</label>
              <input type="file" class="form-control" @change="handleFileUpload">
            </div>
          </div>
          <div v-if="formError" class="text-danger mt-2">{{ formError }}</div>
          <button type="button" class="btn btn-primary mt-3" @click="addDocument">Save Document</button>
        </div>

        <!-- Display Uploaded Documents -->
        <div class="uploaded-documents">
          <h5>Uploaded Documents</h5>
          <div class="d-flex flex-wrap">
            <div v-for="(document, index) in documents" :key="index" class="document-thumbnail position-relative me-2 mb-2">
              <img :src="document.thumbnail" alt="Document Thumbnail" class="img-thumbnail" width="100" height="100">
              <p class="text-center small">{{ document.documentName }}</p>
              <button type="button" class="btn-close remove-icon" aria-label="Close" @click="removeDocument(index)"></button>
            </div>
          </div>
        </div>
      </div>

      <!-- Terms and Submit Button -->
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
  data() {
    return {
      showDocumentForm: false,
      newDocument: {
        documentName: '',
        fileContents: null,
        thumbnail: ''
      },
      documents: [],
      formError: ''
    };
  },
  methods: {
    toggleDocumentForm() {
      // Toggle the form visibility and reset new document fields and errors
      this.showDocumentForm = !this.showDocumentForm;
      this.newDocument = { documentName: '', fileContents: null, thumbnail: '' };
      this.formError = '';
    },
    handleFileUpload(event) {
      const file = event.target.files[0];

      // Check for duplicate files
      if (this.documents.some(doc => doc.fileContents && doc.fileContents.name === file.name)) {
        this.formError = 'This file has already been uploaded.';
        this.newDocument.fileContents = null;
        return;
      }

      this.newDocument.fileContents = file;
      this.newDocument.thumbnail = URL.createObjectURL(file);
      this.formError = ''; // Clear any previous error
    },
    addDocument() {
      // Validate the form fields
      if (!this.newDocument.documentName || !this.newDocument.fileContents) {
        this.formError = 'Both document name and file are required.';
        return;
      }
      // Add document to the list and reset the form
      this.documents.push({ ...this.newDocument });
      this.newDocument = { documentName: '', fileContents: null, thumbnail: '' };
      this.showDocumentForm = false;
      this.formError = '';
    },
    removeDocument(index) {
      this.documents.splice(index, 1);
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

.document-form-popup {
  background-color: #f8f9fa;
  border: 1px solid #ccc;
  border-radius: 8px;
}

.uploaded-documents .document-thumbnail {
  display: flex;
  flex-direction: column;
  align-items: center;
  position: relative;
}

.uploaded-documents .remove-icon {
  position: absolute;
  top: -5px;
  right: -5px;
  background-color: rgba(255, 255, 255, 0.8);
  border-radius: 50%;
  color: red; /* Red color for the "X" icon */
  border: none;
  opacity: 1;
}

.uploaded-documents .remove-icon:hover {
  color: white; /* Change the icon color on hover */
  background-color: red; /* Change background color on hover */
}
</style>
