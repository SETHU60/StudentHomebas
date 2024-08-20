

<!--NEW CODE-->
<template>
  <div class="hello-world">
    <!-- Navbar -->
    <nav class="navbar">
      <div class="navbar-brand">
        <img src="@/assets/logo.png" alt="StudentSpaceSolutions" />
      </div>
      <div class="navbar-nav ml-auto">
        <router-link to="/" class="nav-link">Home</router-link>
        <router-link to="#" class="nav-link">Contact Us</router-link>
        <div class="profile-dropdown">
          <img src="@/assets/logo.png" alt="Profile" />
          <div class="dropdown-content">
            <router-link to="#" class="dropdown-link">Profile</router-link>
            <router-link to="#" class="dropdown-link">Logout</router-link>
          </div>
        </div>
      </div>
    </nav>

    <!-- Main Content -->
    <div class="main-content">
      <!-- Sidebar -->
      <div class="sidebar">
        <router-link to="/" class="sidebar-item">Dashboard</router-link>
        <router-link to="/property-details" class="sidebar-item">Property Details</router-link>
        <router-link to="#" class="sidebar-item">Landlord Details</router-link>
        <router-link to="#" class="sidebar-item">Student Details</router-link>
      </div>

      <!-- Dashboard Content -->
      <div class="dashboard-content">
        <div class="card-grid">
          <div class="dashboard-card" v-for="card in cards" :key="card.title">
            <h3>{{ card.title }}</h3>
            <p>{{ card.added }} added</p>
            <p>{{ card.review }} to be reviewed</p>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "HelloWorld",
  data() {
    return {
      cards: [
        { title: "Properties", added: 50, review: 20 },
        { title: "Landlords", added: 25, review: 10 },
        { title: "Students", added: 100, review: 50 },
        { title: "Communication Management", added: 0, review: 0 },
      ],
    };
  },
};
</script>

<style scoped>
.hello-world {
  display: flex;
  flex-direction: column;
  height: 100vh;
}

/* Navbar */
.navbar {
  display: flex;
  justify-content: space-between;
  align-items: center;
  background-color: #004080;
  padding: 10px 20px;
  color: white;
}

.navbar-brand img {
  height: 40px;
}

.navbar-nav {
  display: flex;
  align-items: center;
}

.nav-link {
  color: white;
  margin-left: 20px;
  text-decoration: none;
}

.profile-dropdown {
  position: relative;
  display: flex;
  align-items: center;
}

.profile-dropdown img {
  width: 30px;
  height: 30px;
  border-radius: 50%;
  margin-left: 20px;
  cursor: pointer;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: white;
  box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
  min-width: 160px;
  right: 0;
  top: 40px;
  z-index: 1;
}

.profile-dropdown:hover .dropdown-content {
  display: block;
}

.dropdown-link {
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
}

.dropdown-link:hover {
  background-color: #ddd;
}

/* Main Content */
.main-content {
  display: flex;
  flex-grow: 1;
}

/* Sidebar */
.sidebar {
  background-color: #00264d;
  color: white;
  width: 250px;
  padding: 20px;
  display: flex;
  flex-direction: column;
}

.sidebar-item {
  color: white;
  padding: 10px;
  text-decoration: none;
  margin-bottom: 10px;
  border-radius: 5px;
  transition: background-color 0.3s ease;
}

.sidebar-item:hover {
  background-color: #004080;
}

/* Dashboard Content */
.dashboard-content {
  flex-grow: 1;
  background-image: url("@/assets/logo.png"); /* Replace with your background image path */
  background-size: cover;
  background-position: center;
  padding: 20px;
  display: flex;
  justify-content: center;
  align-items: center;
}

.card-grid {
  display: grid;
  grid-template-columns: repeat(2, 1fr);
  gap: 20px;
}

.dashboard-card {
  background-color: #0080ff;
  color: white;
  padding: 20px;
  border-radius: 10px;
  text-align: center;
}

.dashboard-card h3 {
  margin-bottom: 10px;
}
</style>