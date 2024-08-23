<template>
  <header class="header">
    <div class="logo">
      <router-link to="/"><img src="@/assets/logo.jpg" alt="StudentSpaceSolutions"/></router-link>
    </div>
    <input type="text" class="search-bar" placeholder="Search by city, suburb or university..." />
    <nav class="nav-links">
      <a href="#">Becoming a landlord</a>
      <a href="#">Inbox</a>
      <div class="profile-icon">
        <img src="@/assets/me.jpg" alt="Profile" />
      </div>
    </nav>
  </header>
</template>
<script>
export default {
  name: "HeaderComponent2",
};
</script>
<style scoped>
.header {
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding: 20px;
  background-color: white;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

.logo {
  font-size: 24px;
  font-weight: bold;
}

.search-bar {
  flex: 1;
  margin: 0 20px;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 4px;
}

.nav-links {
  display: flex;
  align-items: center;
}

.nav-links a {
  margin-right: 15px;
  color: #333;
  text-decoration: none;
}

.profile-icon img {
  width: 40px;
  height: 40px;
  border-radius: 50%;
}
</style>
