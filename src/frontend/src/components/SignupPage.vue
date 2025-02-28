<template>
  <div class="signup-page">
    <nav class="navbar">
      <div class="logo-container">
        <img src="@/assets/logo.png" alt="Logo" class="logo" />
      </div>
      <div class="nav-links">
        <a href="#">Home</a>
        <a href="#">Contact Us</a>
      </div>
    </nav>

    <div class="form-container">
      <form @submit.prevent="signup">
        <div class="input-group">
          <input type="text" v-model="firstName" placeholder="First name" required />
          <input type="text" v-model="middleName" placeholder="Middle name" />
        </div>
        <div class="input-group">
          <input type="text" v-model="lastName" placeholder="Last name" required />
          <input type="text" v-model="phoneNumber" placeholder="Cell number" required />
        </div>
        <div class="input-group">
          <input type="email" v-model="email" placeholder="Email" required />
          <input type="date" v-model="dateOfBirth" required />
        </div>
        <div class="address-section">
          <label>Address:</label>
          <div class="input-group">
            <input type="text" v-model="street" placeholder="Street" required />
            <input type="text" v-model="suburb" placeholder="Suburb" v-if="userRole === 'landlord'" />
          </div>
          <div class="input-group">
            <input type="text" v-model="city" placeholder="City" required />
            <input type="text" v-model="postalCode" placeholder="Postal code" required />
          </div>
        </div>
        <div class="input-group">
          <select v-model="userRole" required @change="updateTerms">
            <option value="" disabled selected>Select role</option>
            <option value="student">Student</option>
            <option value="landlord">Landlord</option>
          </select>
          <select v-model="gender" required>
            <option value="" disabled selected>Select gender</option>
            <option value="male">Male</option>
            <option value="female">Female</option>
            <option value="other">Other</option>
          </select>
        </div>
        <div class="input-group">
          <input type="password" v-model="password" placeholder="Create password" required />
          <input type="password" v-model="confirmPassword" placeholder="Confirm password" required />
        </div>
        <div class="terms">
          <input type="checkbox" id="terms" v-model="agreeToTerms" :checked="cameFromTerms" />
          <label for="terms">
            I read and agree to the
            <a href="#" @click.prevent="showTerms">{{ termsLink }}</a>
          </label>
        </div>
        <button type="submit" class="signup-btn">Sign up</button>
        <div class="login-link">
          Already have an account? <a href="/loginPage">Login</a>
        </div>
      </form>
    </div>

    <!-- Terms and Conditions Modal -->
    <div v-if="showModal" class="modal">
      <div class="modal-content">
        <span class="close" @click="showModal = false">&times;</span>
        <h2>Terms and Conditions for {{ userRole.charAt(0).toUpperCase() + userRole.slice(1) }}</h2>
        <p v-if="userRole === 'student'">
          These are the terms and conditions for students...
        </p>
        <p v-if="userRole === 'landlord'">
          These are the terms and conditions for landlords...
        </p>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'SignupPage',
  data() {
    return {
      firstName: '',
      middleName: '',
      lastName: '',
      phoneNumber: '',
      email: '',
      dateOfBirth: '',
      street: '',
      suburb: '',
      city: '',
      postalCode: '',
      gender: '',
      password: '',
      confirmPassword: '',
      agreeToTerms: false,
      userRole: '',
      showModal: false,
      termsLink: 'Terms and conditions',
      cameFromTerms: false, // New property to track if user came from terms page
    };
  },
  methods: {
    async signup() {
      // Set agreeToTerms based on navigation
      if (this.cameFromTerms) {
        this.agreeToTerms = true;
        this.cameFromTerms = false; // Reset after using
      }

      if (this.password !== this.confirmPassword) {
        alert('Passwords do not match');
        return;
      }

      if (!this.agreeToTerms) {
        alert('You must agree to the terms and conditions');
        return;
      }

      const user = {
        name: {
          firstName: this.firstName,
          middleName: this.middleName,
          lastName: this.lastName,
        },
        gender: this.gender.charAt(0).toUpperCase() + this.gender.slice(1),
        dateOfBirth: this.dateOfBirth,
        password: this.password,
        contact: {
          phoneNumber: this.phoneNumber,
          email: this.email,
          address: {
            street: this.street,
            city: this.city,
            suburb: this.suburb, // Ensure suburb is sent for landlords
            postalCode: this.postalCode,
          }
        }
      };

      let url = '';

      if (this.userRole === 'student') {
        url = 'http://localhost:8080/StudentHomeBas/student/save';
      }if (this.userRole === 'landlord') {
        url = 'http://localhost:8080/StudentHomeBas/landlord/save';
      }


      try {
        const response = await fetch(url, {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json',
          },
          body: JSON.stringify(user),
        });

        if (!response.ok) {
          const errorData = await response.json();
          throw new Error(errorData.message || 'Network response was not ok');
        }

        const data = await response.json();
        console.log('Saved user:', data);
        alert('Signup successful!');
        this.$router.push('/loginPage');
      } catch (error) {
        console.error('There was an error during signup:', error);
        alert(`Signup failed: ${error.message}`);
      }
    },
    showTerms() {
      // Set flag to true when navigating to terms page
      this.cameFromTerms = true;
      if (this.userRole === 'landlord') {
        this.$router.push('/landlordTerms');
      } else if (this.userRole === 'student') {
        this.$router.push('/studentTerms');
      }
    },
  }
};
</script>

<style scoped>
.signup-page {
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
  justify-content: space-between;
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
  display: flex;
  justify-content: flex-end;
  gap: 10px;
}

.nav-links a {
  text-decoration: none;
  color: #333;
  font-weight: bold;
}

.form-container {
  background-color: rgba(255, 255, 255, 0.9);
  padding: 20px;
  border-radius: 8px;
  width: 60%;
  max-width: 600px;
  margin: 200px auto 0;
}

.input-group {
  display: flex;
  justify-content: space-between;
  margin-bottom: 15px;
}

input[type="text"],
input[type="email"],
input[type="password"],
input[type="date"],
select {
  width: 48%;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 4px;
}

.terms {
  margin: 15px 0;
}

.signup-btn {
  width: 100%;
  padding: 12px;
  background-color: #008080;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

.signup-btn:hover {
  background-color: #006666;
}

.login-link {
  text-align: center;
  margin-top: 15px;
}

.modal {
  position: fixed;
  z-index: 1001;
  left: 0;
  top: 0;
  width: 100%;
  height: 100%;
  overflow: auto;
  background-color: rgba(0, 0, 0, 0.5);
}

.modal-content {
  background-color: #fefefe;
  margin: 15% auto;
  padding: 20px;
  border: 1px solid #888;
  width: 80%;
  max-width: 600px;
}

.close {
  color: #aaa;
  float: right;
  font-size: 28px;
  font-weight: bold;
}

.close:hover,
.close:focus {
  color: black;
  text-decoration: none;
  cursor: pointer;
}
</style>
