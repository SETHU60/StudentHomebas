<template>
  <div class="property-list custom-background">
    <h1 class="title">Property List</h1>
    <p v-if="error" class="error">{{ error }}</p>
    <table v-if="properties.length" class="property-table">
      <thead>
      <tr>
        <th>Property Name</th>
        <th>Number of Rooms</th>
        <th>Price</th>
        <th>Status</th>
        <th>Landlord</th>
        <th>Address</th>
        <th>Actions</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="property in properties" :key="property.propertyID">
        <td>{{ property.propertyName || 'No name available' }}</td>
        <td>{{ property.numberOfRooms || 'No data' }}</td>
        <td>{{ property.price || 'No price available' }}</td>
        <td>{{ property.status ? property.status.statusName : 'No status' }}</td>
        <td>{{ property.landlord ? property.landlord.name : 'No landlord' }}</td>
        <td>{{ property.address ? property.address.fullAddress : 'No address' }}</td>
        <td class="action-buttons">
          <button @click="openEditDialog(property)" class="edit-button">Edit</button>
          <button @click="deleteProperty(property.propertyID)" class="delete-button">Delete</button>
        </td>
      </tr>
      </tbody>
    </table>
    <p v-else>No properties available.</p>

    <!-- Edit Dialog -->
    <div v-if="showEditDialog" class="edit-dialog">
      <div class="dialog-content">
        <h2>Edit Property</h2>
        <form @submit.prevent="updateProperty">
          <label>
            Property Name:
            <input v-model="editedProperty.propertyName" required />
          </label>
          <label>
            Number of Rooms:
            <input type="number" v-model="editedProperty.numberOfRooms" required />
          </label>
          <label>
            Price:
            <input type="number" v-model="editedProperty.price" required />
          </label>
          <label>
            Status:
            <input v-model="editedProperty.status.statusName" required />
          </label>
          <label>
            Landlord:
            <input v-model="editedProperty.landlord.name" required />
          </label>
          <label>
            Address:
            <input v-model="editedProperty.address.fullAddress" required />
          </label>
          <button type="submit" class="save-button">Save</button>
          <button type="button" @click="closeEditDialog" class="cancel-button">Cancel</button>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'PropertyList',
  data() {
    return {
      properties: [],
      error: null,
      showEditDialog: false,
      editedProperty: null,
    };
  },
  mounted() {
    this.fetchProperties();
  },
  methods: {
    async fetchProperties() {
      try {
        const response = await fetch("api/StudentHomeBas/Property/getAll");
        if (!response.ok) {
          throw new Error('Network response was not ok');
        }
        this.properties = await response.json();
      } catch (error) {
        this.error = 'Error fetching data';
        console.error('There was a problem with the fetch operation:', error);
      }
    },
    openEditDialog(property) {
      this.editedProperty = { ...property };
      this.showEditDialog = true;
    },
    closeEditDialog() {
      this.showEditDialog = false;
      this.editedProperty = null;
    },
    async updateProperty() {
      try {

        const updatedProperty = {
          ...this.editedProperty,
          address: {
            addressID: this.editedProperty.address.addressID,
            street: this.editedProperty.address.street,
            suburb: this.editedProperty.address.suburb,
            city: this.editedProperty.address.city,
            postalCode: this.editedProperty.address.postalCode,
          },
          landlord: {
            id: this.editedProperty.landlord.id
          },
          pictures: this.editedProperty.pictures || [], // Include pictures if applicable
        };

        const response = await fetch(`api/StudentHomeBas/Property/update`, {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json',
          },
          body: JSON.stringify(updatedProperty),
        });

        if (!response.ok) {
          throw new Error('Network response was not ok');
        }

        // Refresh properties list after update
        await this.fetchProperties();
        this.closeEditDialog();
      } catch (error) {
        this.error = `Error updating property: ${error.message}`;
        console.error('There was a problem with the update operation:', error);
      }
    },

    async deleteProperty(propertyID) {
      if (confirm(`Are you sure you want to delete this property? ${propertyID}`)) {
        try {
          const response = await fetch(`api/StudentHomeBas/Property/delete/${propertyID}`, {
            method: 'DELETE',
          });
          if (!response.ok) {
            throw new Error('Network response was not ok');
          }
          await this.fetchProperties();
        } catch (error) {
          this.error = `Error deleting property: ${error.message}`;
          console.error('There was a problem with the delete operation:', error);
        }
      }
    },
  },
};
</script>

<style scoped>
/* Reuse the same styles you have for the student list */
.custom-background {
  background-color: #F9F9F9;
  padding: 20px;
  border-radius: 8px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

.title {
  font-size: 24px;
  font-weight: bold;
  margin-bottom: 20px;
}

.error {
  color: red;
  margin-bottom: 20px;
}

.property-table {
  width: 100%;
  border-collapse: collapse;
}

.property-table th, .property-table td {
  padding: 12px;
  text-align: left;
  border: 1px solid #ddd;
}

.property-table th {
  background-color: #127670;
  color: white;
}

.property-table tr:nth-child(even) {
  background-color: #f2f2f2;
}

.action-buttons {
  display: flex;
  gap: 10px;
}

.edit-button, .delete-button {
  background: none;
  border: none;
  cursor: pointer;
  font-weight: bold;
}

.edit-button {
  color: #127670;
}

.delete-button {
  color: red;
}

/* Edit Dialog Styles */
.edit-dialog {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: rgba(0, 0, 0, 0.5);
  display: flex;
  justify-content: center;
  align-items: center;
}

.dialog-content {
  background: white;
  padding: 20px;
  border-radius: 8px;
  width: 80%;
  max-width: 600px;
}

.save-button {
  background-color: #127670;
  color: white;
  border: none;
  padding: 10px;
  border-radius: 4px;
  cursor: pointer;
}

.cancel-button {
  background-color: #f44336;
  color: white;
  border: none;
  padding: 10px;
  border-radius: 4px;
  cursor: pointer;
}
</style>
