<template>
  <div class="property-details">
    <h2>Property Details</h2>
    <div v-for="property in properties" :key="property.id" class="property-card">
      <h3>{{ property.name }}</h3>
      <p>{{ property.address }}</p>
      <p>{{ property.description }}</p>
    </div>
    <router-link to="/" class="back-button">Back to Dashboard</router-link>
  </div>
</template>

<script>
export default {
  name: 'PropertyDetails',
  data() {
    return {
      properties: [
        { id: 1, name: 'Property 1', address: '123 Main St', description: 'A nice property.' },
        { id: 2, name: 'Property 2', address: '456 Oak Ave', description: 'A cozy place.' },
        { id: 3, name: 'Property 3', address: '789 Pine Rd', description: 'A spacious home.' },
      ]
    };
  }
};
</script>

<style scoped>
.property-details {
  padding: 20px;
}

.property-card {
  background-color: #f8f8f8;
  padding: 15px;
  margin-bottom: 10px;
  border-radius: 8px;
}

.back-button {
  display: inline-block;
  margin-top: 20px;
  padding: 10px 15px;
  background-color: #004080;
  color: white;
  text-decoration: none;
  border-radius: 5px;
}

.back-button:hover {
  background-color: #00264d;
}
</style>