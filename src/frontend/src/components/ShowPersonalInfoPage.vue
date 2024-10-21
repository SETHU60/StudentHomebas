
<template>
  <div class="personal-info-page">
    <h1 class="page-title">Personal Information</h1>

    <div class="info-section">
      <div class="info-item">
        <strong>First Name:</strong> Will
      </div>
      <div class="info-item">
        <strong>Middle Name:</strong> Michael
      </div>
      <div class="info-item">
        <strong>Last Name:</strong> Stevens
      </div>
      <div class="info-item">
        <strong>Date Of Birth:</strong> 2000-05-15
      </div>
      <div class="info-item">
        <strong>Gender:</strong> Male
      </div>
      <div class="info-item">
        <strong>Email:</strong> WStevens@gmail.com
      </div>
      <div class="info-item">
        <strong>Phone Number:</strong> 0785546871
      </div>
    </div>

    <!-- Buttons for Back and Edit -->
    <div class="button-section">
      <button class="back-button" @click="goBack">Back</button>
      <button class="edit-button" @click="goEdit">Edit</button>
    </div>
  </div>
</template>

<script>
export default {
  methods: {
    goBack() {
      this.$router.push('/user-account'); // Redirect to User Account Page
    },
    goEdit() {
      this.$router.push('/personal-info'); // Redirect to Personal Info Edit Page
    }
  }
};
</script>

<style scoped>
.personal-info-page {
  text-align: center;
  margin-top: 50px;
}

.page-title {
  font-size: 28px;
  font-family: 'IBM Plex Sans', sans-serif;
  color: #2A9D8F;
}

.info-section {
  margin-top: 20px;
  margin-bottom: 30px;
  display: flex;
  flex-direction: column;
  align-items: center;
}

.info-item {
  margin: 10px 0;
  font-family: 'IBM Plex Sans', sans-serif;
  font-size: 18px;
  color: #333;
}

.button-section {
  display: flex;
  justify-content: center;
  gap: 20px;
}

.back-button {
  background-color: #d9534f;
  color: white;
  padding: 10px 20px;
  font-size: 16px;
  border-radius: 8px;
  border: none;
  cursor: pointer;
}

.back-button:hover {
  background-color: #c9302c;
}

.edit-button {
  background-color: #5cb85c;
  color: white;
  padding: 10px 20px;
  font-size: 16px;
  border-radius: 8px;
  border: none;
  cursor: pointer;
}

.edit-button:hover {
  background-color: #4cae4c;
}
</style>
