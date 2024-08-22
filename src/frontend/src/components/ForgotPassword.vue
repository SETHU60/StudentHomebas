<template>
  <div class="forgot-password-page">
    <nav class="navbar">
      <div class="logo-container">
        <img src="@/assets/logo.png" alt="Logo" class="logo" />
      </div>
      <div class="nav-content">
        <div class="nav-links">
          <a href="#">Home</a>
          <a href="#">Contact Us</a>
        </div>
        <div class="profile-container">

        </div>
      </div>
    </nav>

    <div class="form-container">
      <form class="forgot-password-form" @submit.prevent="resetPassword">
        <div class="form-group">
          <label for="email">Email</label>
          <div class="input-container">
            <input
                type="email"
                id="email"
                v-model="email"
                placeholder="Email"
                required
            />
            <i class="icon-envelope"></i>
          </div>
        </div>
        <button type="submit" class="btn-reset">Reset Password</button>
        <p class="login-link">Remembered your password? <a href="#">Login</a></p>
      </form>
    </div>
  </div>
</template>

<script>
export default {
  name: "ForgotPassword",
  data() {
    return {
      email: "",
    };
  },
  methods: {
    resetPassword() {
      console.log("Password reset requested for", {
        email: this.email,
      });
    },
  },
};
</script>

<style scoped>
.forgot-password-page {
  height: 100vh;
  margin: 0;
  padding: 0;
  background: url('@/assets/bedroom.png') no-repeat center center;
  background-size: cover;
  display: flex;
  flex-direction: column;
}

.navbar {
  display: flex;
  align-items: center;
  padding: 10px 20px;
  background-color: white;
  border-bottom: 1px solid #ccc;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  width: 100%;
  position: fixed;
  top: 0;
  left: 0;
  z-index: 1000;
}

.logo-container {
  flex-shrink: 0;
}

.logo {
  width: auto;
  height: 50px;
}

.nav-content {
  display: flex;
  flex-grow: 1;
  justify-content: flex-end;
  align-items: center;
  gap: 80px;
}

.nav-links {
  display: flex;
  gap: 20px;
}

.nav-links a {
  text-decoration: none;
  color: #333;
  font-weight: bold;
}

.profile-container {
  flex-shrink: 0;
  margin-right: 80px;
}

.profile-pic {
  width: 60px;
  height: 60px;
  border-radius: 50%;
}

.form-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  width: 100%;
  height: calc(100vh - 80px); /* Adjust for navbar height */
  padding: 20px;
  margin: 0 auto;
}

.forgot-password-form {
  background-color: rgba(255, 255, 255, 0.9);
  padding: 40px;
  border-radius: 8px;
  width: 100%;
  max-width: 550px; /* Adjust as needed */
}

.form-group {
  margin-bottom: 20px;
}

.input-container {
  position: relative;
}

.input-container input {
  width: 100%;
  padding: 15px;
  padding-right: 30px;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

.input-container i {
  position: absolute;
  top: 10px;
  right: 10px;
  color: #888;
}

.btn-reset {
  width: 100%;
  padding: 15px;
  background-color: #009688;
  border: none;
  color: white;
  border-radius: 4px;
  cursor: pointer;
}

.btn-reset:hover {
  background-color: #00796b;
}

.login-link {
  margin-top: 20px;
  text-align: center;
}

.login-link a {
  color: #009688;
}
</style>
