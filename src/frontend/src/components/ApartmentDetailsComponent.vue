<template>
  <div class="apartment-details">
    <h1>Stylish Apartments in Newlands (All Inclusive)</h1>
    <h2>Apartment</h2>
    <p class="sub-description">Stylish, Great community & Unique</p>
    <p class="location">Newlands</p>
    <div class="details-icons">

      <span> <font-awesome-icon icon="wifi"/> Room by room leases</span>
      <span> <font-awesome-icon icon="couch"/> Furnished</span>
      <span> <font-awesome-icon icon="restroom"/> Max occupants: 244</span>
    </div>
    <p class="description">
      Fully furnished, all inclusive co-living suites in Newlands, at upcoming Neighbourgood Newlands! Whether you are
      seeking a fully furnished accommodation or an all inclusive workspace...
    </p>
    <button class="read-more-btn">Read full description</button>
  </div>
</template>
<script>
export default {
  name: "ApartmentDetailsComponent",
};
</script>
<style scoped>
.apartment-details {
  padding: 20px;
  background-color: #fff;
  border-radius: 10px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

h1 {
  font-size: 24px;
  font-weight: bold;
}

h2 {
  font-size: 18px;
  color: #666;
}

.sub-description {
  color: #ff4081;
  font-weight: bold;
  margin-top: 10px;
}

.location {
  margin-top: 10px;
  font-size: 16px;
  color: #333;
}

.details-icons {
  margin: 20px 0;
  display: flex;
  gap: 20px;
}

.details-icons span {
  display: flex;
  align-items: center;
  font-size: 14px;
  color: #333;
  margin-right: 20px;
}

.description {
  color: #666;
}

.read-more-btn {
  padding: 10px 20px;
  background-color: #ff4081;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  transition: background-color 0.3s ease;
}

.read-more-btn:hover {
  background-color: #e91e63;
}
</style>
