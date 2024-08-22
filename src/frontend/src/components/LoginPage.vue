<template>
  <div class="login-page">
    <nav class="navbar">
      <div class="logo-container">
        <img src="@/assets/logo.png" alt="Logo" class="logo" />
      </div>
      <div class="nav-links">
        <a href="#">Home</a>
        <a href="#">About Us</a>
      </div>
      <div class="profile-container">
      </div>
    </nav>

    <div class="login-container">
      <form class="login-form" @submit.prevent="login">
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
        <div class="form-group">
          <label for="password">Password</label>
          <div class="input-container">
            <input
                type="password"
                id="password"
                v-model="password"
                placeholder="Password"
                required
            />
            <i class="icon-eye"></i>
          </div>
        </div>
        <div class="form-group form-group-remember">
          <div class="remember-me-container">
            <input
                type="checkbox"
                id="remember"
                v-model="rememberMe"
            />
            <label for="remember">Remember me</label>
          </div>
          <a href="#" class="forgot-password">Forgot Password?</a>
        </div>
        <button type="submit" class="btn-login">Login</button>
        <p class="signup-link">Don't have an account? <a href="#">Sign up</a></p>
      </form>
    </div>
  </div>
</template>

<script>
import { useRouter } from 'vue-router';

export default {
  name: "LoginPage",
  data() {
    return {
      email: "",
      password: "",
      rememberMe: false,
    };
  },
  setup() {
    const router = useRouter();
    return { router };
  },

  methods: {
    async login() {
      const url = 'api/StudentHomeBas/student/login/' + this.email + "/" + this.password;

      try {
        const response = await fetch(url, {
          method: 'GET',
          headers: {
            'Content-Type': 'application/json'
          },
        });

        if (response.ok) {
          const data = await response.text(); // Assuming the response is a text message
          alert("Login successful: " + data);
          console.log('Login successful:', data);
          await this.$router.push('/admin-layout');
          // Handle successful login (e.g., store token, redirect user, etc.)
        } else {
          const errorMessage = await response.text();
          alert("Login failed: " + errorMessage);
          console.error('Login failed:', errorMessage);
          // Handle login failure (e.g., show error message to user)
        }
      } catch (error) {
        alert("Error during login: " + error.message);
        console.error('Error during login:', error);
        // Handle network or other errors
      }
    },
    // login() {
    //   fetch("api/StudentHomeBas/student/login", { // Adjust the URL as needed
    //     method: 'POST',
    //     headers: {
    //       'Content-Type': 'application/json',
    //     },
    //     body: JSON.stringify({
    //       email: this.email,   // Assuming the backend expects 'email'
    //       password: this.password  // Assuming the backend expects 'password'
    //     })
    //   })
    //       .then((response) => {
    //         if (response.ok) {
    //           return response.text(); // Parse the response as text
    //         } else if (response.status === 403) {
    //           throw new Error('Invalid Email or Password.' + this.email + this.password);
    //         } else {
    //           throw new Error('Error during login.');
    //         }
    //       })
    //       .then((data) => {
    //         alert(data); // This will display the message from the server
    //         // Redirect or handle successful login
    //       })
    //       .catch((error) => {
    //         this.loginError = error.message;
    //         alert(this.loginError); // This will show the error message
    //         console.error('There was a problem with the fetch operation:', error);
    //       });
    // }
  },
};
</script>

<style scoped>
.login-page {
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
  flex-grow: 0;
}

.logo {
  width: auto;
  height: 50px;
}

.nav-links {
  flex-grow: 2;
  display: flex;
  justify-content: flex-end;
  gap: 10px;

}

.nav-links a {
  text-decoration: none;
  color: black;
  font-weight: bold;
}

.profile-container {
  flex-grow: 1;
  text-align: right;
}

.profile-pic {
  width: 60px;
  height: 60px;
  border-radius: 50%;
  padding-right: 60px;
}

.login-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: flex-start; /* Move the container towards the top */
  padding-top: 200px; /* Adjust this value to move the container up or down */
  width: 30%;
  margin: 0 auto;
}

.login-form {
  background-color: rgba(255, 255, 255, 0.9);
  padding: 40px;
  border-radius: 8px;
  width: 100%;
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

.form-group-remember {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.remember-me-container {
  display: flex;
  align-items: center;
}

.remember-me-container input {
  margin-right: 5px;
}

.btn-login {
  width: 100%;
  padding: 15px;
  background-color: #009688;
  border: none;
  color: white;
  border-radius: 4px;
  cursor: pointer;
}

.btn-login:hover {
  background-color: #00796b;
}

.signup-link {
  margin-top: 20px;
  text-align: center;
  color: black;
}

.signup-link a {
  color: lightgreen;
}

.forgot-password {
  color: darkgreen;
  text-align: left;
}
</style>
