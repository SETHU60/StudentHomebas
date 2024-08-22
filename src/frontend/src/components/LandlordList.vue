<template>
  <div class="landlord-list custom-background">
    <h1 class="title">Landlord List</h1>
    <p v-if="error" class="error">{{ error }}</p>
    <table v-if="landlords.length" class="landlord-table">
      <thead>
      <tr>
        <th>Name</th>
        <th>Gender</th>
        <th>Date of Birth</th>
        <th>Email</th>
        <th>Phone</th>
        <th>Property Count</th>
        <th>Details</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="landlord in landlords" :key="landlord.userId">
        <td>{{ landlord.name ? landlord.name.firstName + ' ' + landlord.name.lastName : 'No name available' }}</td>
        <td>{{ landlord.gender || 'No gender available' }}</td>
        <td>{{ landlord.dateOfBirth || 'No date available' }}</td>
        <td>{{ landlord.contact ? landlord.contact.email : 'No email available' }}</td>
        <td>{{ landlord.contact ? landlord.contact.phoneNumber : 'No phone number available' }}</td>
        <td>{{ landlord.propertyCount || 'No property count available' }}</td>
        <td>
          <router-link :to="'/landlord/' + landlord.userId" class="details-link">View Details</router-link>
        </td>
      </tr>
      </tbody>
    </table>
    <p v-else>No landlords available.</p>
  </div>
</template>

<script>
export default {
  name: 'LandlordList',
  data() {
    return {
      landlords: [],
      error: null
    };
  },
  mounted() {
    this.fetchLandlords();
  },
  methods: {
    async fetchLandlords() {
      try {
        const response = await fetch("api/StudentHomeBas/landlord/getall");
        if (!response.ok) {
          throw new Error('Network response was not ok');
        }
        this.landlords = await response.json();
      } catch (error) {
        this.error = 'Error fetching data';
        console.error('There was a problem with the fetch operation:', error);
      }
    }
  }
}
</script>

<style scoped>
.custom-background {
  background-color: #F9F9F9; /* Light grey background for the container */
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

.landlord-table {
  width: 100%;
  border-collapse: collapse;
}

.landlord-table th, .landlord-table td {
  padding: 12px;
  text-align: left;
  border: 1px solid #ddd;
}

.landlord-table th {
  background-color: #127670;
  color: white;
}

.landlord-table tr:nth-child(even) {
  background-color: #f2f2f2;
}

.details-link {
  color: #127670;
  text-decoration: none;
}

.details-link:hover {
  text-decoration: underline;
}
</style>
