<template>
  <div>
    <!-- Navbar -->
    <nav class="navbar">
      <div class="logo">
        <img src="@/assets/AppLogo.png" alt="StudentSpaceSolutions" />
      </div>
      <div class="nav-buttons">
        <router-link to="/home" class="nav-button">Home</router-link>
        <router-link to="/properties" class="nav-button">View Listed Properties</router-link>
        <router-link to="/contact" class="nav-button">Contact Us</router-link>
        <div class="profile">
          <img src="@/assets/user-profile.jpg" alt="User Profile" class="profile-pic" />
        </div>
      </div>
    </nav>

    <!-- Account Section -->
    <div class="account-section">
      <div class="profile-info">
        <div class="profile-pic-large">
          <img src="@/assets/user-profile.jpg" alt="User Profile" />
        </div>
        <p>Hi Siphosethu</p>
      </div>

      <div class="account-actions">
        <h2>Account</h2>
        <div class="buttons-grid">
          <router-link to="/show-personal-info" class="account-button">
            <i class="fas fa-user"></i> Personal Information
          </router-link>

          <router-link to="/properties-listed" class="account-button">
            <i class="fas fa-building"></i> Properties Listed
          </router-link>
          <router-link to="/inquiries" class="account-button">
            <i class="fas fa-envelope"></i> Inquires
          </router-link>
          <div class="account-button"></div> <!-- Empty button for symmetry -->
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'AccountPage',
};
</script>

<style scoped>
/* Navbar Styles */
.navbar {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 20px;
  background-color: white;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

.logo img {
  height: 50px;
}

.nav-buttons {
  display: flex;
  align-items: center;
}

.nav-button {
  margin: 0 10px;
  padding: 10px 20px;
  background-color: #D15D5D;
  color: white;
  border-radius: 8px;
  text-decoration: none;
}

.profile-pic {
  width: 50px;
  height: 50px;
  border-radius: 50%;
  margin-left: 20px;
}

/* Account Section */
.account-section {
  display: flex;
  justify-content: center;
  align-items: center;
  margin-top: 40px;
}

.profile-info {
  text-align: center;
  margin-right: 50px;
}

.profile-pic-large img {
  width: 150px;
  height: 150px;
  border: 2px solid black;
  border-radius: 50%;
}

.account-actions {
  text-align: center;
}

h2 {
  color: #127670;
}

.buttons-grid {
  display: grid;
  grid-template-columns: 1fr 1fr;
  gap: 20px;
  margin-top: 20px;
}

.account-button {
  display: flex;
  align-items: center;
  justify-content: center;
  padding: 20px;
  background-color: #127670;
  color: white;
  border-radius: 8px;
  text-decoration: none;
  font-size: 16px;
}

.account-button i {
  margin-right: 10px;
}
</style>
