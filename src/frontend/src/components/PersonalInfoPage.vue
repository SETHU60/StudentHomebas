
<!--<template>-->
<!--  <div class="personal-info-container">-->
<!--    &lt;!&ndash; Navigation Bar &ndash;&gt;-->
<!--    <nav class="navbar">-->
<!--      <img :src="logo" alt="Logo" class="logo" />-->
<!--      <ul class="nav-links">-->
<!--        <li>-->
<!--          <router-link to="/" class="nav-button">Home</router-link>-->
<!--        </li>-->
<!--        <li>-->
<!--          <router-link to="/listed-properties" class="nav-button">-->
<!--            View Listed Properties-->
<!--          </router-link>-->
<!--        </li>-->
<!--        <li>-->
<!--          <router-link to="/contact-us" class="nav-button">Contact Us</router-link>-->
<!--        </li>-->
<!--        <li>-->
<!--          <img :src="userProfile" alt="User Profile" class="user-profile" />-->
<!--        </li>-->
<!--      </ul>-->
<!--    </nav>-->

<!--    <h2 class="form-title">Personal Information</h2>-->

<!--    &lt;!&ndash; Success Message &ndash;&gt;-->
<!--    <div v-if="successMessage" class="success-message">{{ successMessage }}</div>-->

<!--    <form class="personal-info-form" @submit.prevent="saveInfo">-->
<!--      <label for="first-name">First Name</label>-->
<!--      <input id="first-name" type="text" v-model="firstName" />-->

<!--      <label for="middle-name">Middle Name</label>-->
<!--      <input id="middle-name" type="text" v-model="middleName" />-->

<!--      <label for="last-name">Last Name</label>-->
<!--      <input id="last-name" type="text" v-model="lastName" />-->

<!--      <label for="dob">Date Of Birth</label>-->
<!--      <input id="dob" type="date" v-model="dob" :max="currentDate" />-->

<!--      <label for="gender">Gender</label>-->
<!--      <select id="gender" v-model="gender">-->
<!--        <option value="Male">Male</option>-->
<!--        <option value="Female">Female</option>-->
<!--        <option value="Other">Other</option>-->
<!--      </select>-->

<!--      <label for="email">Email</label>-->
<!--      <input id="email" type="email" v-model="email" />-->

<!--      <label for="phone">Phone Number</label>-->
<!--      <input id="phone" type="text" v-model="phoneNumber" />-->

<!--      <div class="button-container">-->
<!--        <button @click.prevent="goBack" class="btn back-btn">Back</button>-->
<!--        <button @click.prevent="saveInfo" class="btn save-btn">Save</button>-->
<!--      </div>-->
<!--    </form>-->
<!--  </div>-->
<!--</template>-->

<!--<script>-->
<!--import axios from 'axios';-->
<!--import logoImage from '@/assets/AppLogo.png';-->
<!--import userProfileImage from '@/assets/user-profile.jpg';-->

<!--export default {-->
<!--  data() {-->
<!--    return {-->
<!--      logo: logoImage,-->
<!--      userProfile: userProfileImage,-->
<!--      firstName: '',-->
<!--      middleName: '',-->
<!--      lastName: '',-->
<!--      dob: '',-->
<!--      gender: '',-->
<!--      email: '',-->
<!--      phoneNumber: '',-->
<!--      currentDate: new Date().toISOString().split('T')[0], // Limits DOB to past dates-->
<!--      successMessage: '',-->
<!--    };-->
<!--  },-->
<!--  methods: {-->
<!--    goBack() {-->
<!--      this.$router.push('/show-personal-info');-->
<!--    },-->
<!--    async saveInfo() {-->
<!--      try {-->
<!--        const updatedUser = {-->
<!--          firstName: this.firstName,-->
<!--          middleName: this.middleName,-->
<!--          lastName: this.lastName,-->
<!--          dob: this.dob,-->
<!--          gender: this.gender,-->
<!--          email: this.email,-->
<!--          phoneNumber: this.phoneNumber,-->
<!--        };-->

<!--        // Use the user ID if applicable; otherwise, ensure the backend can handle this-->
<!--        await axios.post('http://localhost:3000/student/update', updatedUser);-->

<!--        // Display success message after saving-->
<!--        this.successMessage = 'Personal information saved successfully!';-->

<!--        // After saving, navigate back after a short delay-->
<!--        setTimeout(() => {-->
<!--          this.$router.push('/show-personal-info'); // Redirect to ShowPersonalInfoPage-->
<!--        }, 2000); // 2 second delay to show the message before redirecting-->
<!--      } catch (error) {-->
<!--        console.error('Error saving personal information:', error);-->
<!--      }-->
<!--    },-->
<!--    async fetchUserData() {-->
<!--      try {-->
<!--        // Fetch user data by ID (ensure you replace `userId` with the actual user ID)-->
<!--        const response = await axios.get(`/user/read/{userId}`);-->
<!--        const user = response.data;-->
<!--        this.firstName = user.firstName;-->
<!--        this.middleName = user.middleName;-->
<!--        this.lastName = user.lastName;-->
<!--        this.dob = user.dob;-->
<!--        this.gender = user.gender;-->
<!--        this.email = user.email;-->
<!--        this.phoneNumber = user.phoneNumber;-->
<!--      } catch (error) {-->
<!--        console.error('Error fetching user data:', error);-->
<!--      }-->
<!--    },-->
<!--  },-->
<!--  created() {-->
<!--    // Fetch the user data when the component is created-->
<!--    this.fetchUserData();-->
<!--  },-->
<!--};-->
<!--</script>-->

<!--<style scoped>-->
<!--@import url('https://fonts.googleapis.com/css2?family=IBM+Plex+Sans:wght@400;500&display=swap');-->

<!--* {-->
<!--  margin: 0;-->
<!--  padding: 0;-->
<!--  box-sizing: border-box;-->
<!--}-->

<!--body {-->
<!--  font-family: 'IBM Plex Sans', sans-serif;-->
<!--}-->

<!--.personal-info-container {-->
<!--  padding: 20px;-->
<!--  display: flex;-->
<!--  flex-direction: column;-->
<!--  align-items: center;-->
<!--}-->

<!--.navbar {-->
<!--  display: flex;-->
<!--  justify-content: space-between;-->
<!--  align-items: center;-->
<!--  background-color: #d46a6a;-->
<!--  padding: 10px 20px;-->
<!--}-->

<!--.logo {-->
<!--  height: 50px;-->
<!--}-->

<!--.user-profile {-->
<!--  height: 40px;-->
<!--  width: 40px;-->
<!--  border-radius: 50%;-->
<!--}-->

<!--.nav-links {-->
<!--  display: flex;-->
<!--  list-style: none;-->
<!--}-->

<!--.nav-button {-->
<!--  background-color: #127670;-->
<!--  border: none;-->
<!--  color: white;-->
<!--  padding: 10px 20px;-->
<!--  font-size: 16px;-->
<!--  border-radius: 10px;-->
<!--  text-decoration: none;-->
<!--}-->

<!--.nav-button:hover {-->
<!--  background-color: #b55555;-->
<!--}-->

<!--.form-title {-->
<!--  font-size: 32px;-->
<!--  font-weight: 500;-->
<!--  margin: 20px 0;-->
<!--  color: #127670;-->
<!--}-->

<!--.personal-info-form {-->
<!--  display: flex;-->
<!--  flex-direction: column;-->
<!--  width: 50%;-->
<!--}-->

<!--.personal-info-form label {-->
<!--  font-weight: 500;-->
<!--  margin: 10px 0 5px;-->
<!--}-->

<!--.personal-info-form input,-->
<!--.personal-info-form select {-->
<!--  padding: 10px;-->
<!--  border-radius: 5px;-->
<!--  border: 1px solid #127670;-->
<!--  margin-bottom: 15px;-->
<!--}-->

<!--.button-container {-->
<!--  display: flex;-->
<!--  justify-content: space-between;-->
<!--}-->

<!--.btn {-->
<!--  padding: 10px 20px;-->
<!--  border-radius: 5px;-->
<!--  border: none;-->
<!--  font-size: 16px;-->
<!--}-->

<!--.back-btn {-->
<!--  background-color: #d46a6a;-->
<!--  color: white;-->
<!--}-->

<!--.save-btn {-->
<!--  background-color: #127670;-->
<!--  color: white;-->
<!--}-->

<!--.success-message {-->
<!--  color: green;-->
<!--  font-size: 18px;-->
<!--  margin-bottom: 15px;-->
<!--}-->
<!--</style>-->
<template>
  <div class="personal-info-container">
    <!-- Navigation Bar -->
    <nav class="navbar">
      <img :src="logo" alt="Logo" class="logo" />
      <ul class="nav-links">
        <li>
          <router-link to="/" class="nav-button">Home</router-link>
        </li>
        <li>
          <router-link to="/listed-properties" class="nav-button">
            View Listed Properties
          </router-link>
        </li>
        <li>
          <router-link to="/contact-us" class="nav-button">Contact Us</router-link>
        </li>
        <li>
          <img :src="userProfile" alt="User Profile" class="user-profile" />
        </li>
      </ul>
    </nav>

    <h2 class="form-title">Personal Information</h2>

    <!-- Success Message -->
    <div v-if="successMessage" class="success-message">{{ successMessage }}</div>

    <form class="personal-info-form" @submit.prevent="saveInfo">
      <label for="first-name">First Name</label>
      <input id="first-name" type="text" v-model="firstName" />

      <label for="middle-name">Middle Name</label>
      <input id="middle-name" type="text" v-model="middleName" />

      <label for="last-name">Last Name</label>
      <input id="last-name" type="text" v-model="lastName" />

      <label for="dob">Date Of Birth</label>
      <input id="dob" type="date" v-model="dob" :max="currentDate" />

      <label for="gender">Gender</label>
      <select id="gender" v-model="gender">
        <option value="Male">Male</option>
        <option value="Female">Female</option>
        <option value="Other">Other</option>
      </select>

      <label for="email">Email</label>
      <input id="email" type="email" v-model="email" />

      <label for="phone">Phone Number</label>
      <input id="phone" type="text" v-model="phoneNumber" />

      <div class="button-container">
        <button @click.prevent="goBack" class="btn back-btn">Back</button>
        <button @click.prevent="saveInfo" class="btn save-btn">Save</button>
      </div>
    </form>
  </div>
</template>

<script>
import axios from 'axios';
import logoImage from '@/assets/AppLogo.png';
import userProfileImage from '@/assets/user-profile.jpg';

export default {
  data() {
    return {
      logo: logoImage,
      userProfile: userProfileImage,
      firstName: '',
      middleName: '',
      lastName: '',
      dob: '',
      gender: '',
      email: '',
      phoneNumber: '',
      currentDate: new Date().toISOString().split('T')[0], // Limits DOB to past dates
      successMessage: '', // Message to show after saving
    };
  },
  methods: {
    goBack() {
      this.$router.push('/show-personal-info'); // Navigate back to ShowPersonalInfoPage
    },
    async saveInfo() {
      try {
        const updatedStudent = {
          firstName: this.firstName,
          middleName: this.middleName,
          lastName: this.lastName,
          dob: this.dob,
          gender: this.gender,
          email: this.email,
          phoneNumber: this.phoneNumber,
        };

        // Replace 'studentId' with the correct student ID if needed
        await axios.post('http://localhost:3000/student/update', updatedStudent);

        // Display success message after saving
        this.successMessage = 'Personal information saved successfully!';

        // After saving, navigate back after a short delay
        setTimeout(() => {
          this.$router.push('/show-personal-info'); // Redirect to ShowPersonalInfoPage
        }, 2000); // 2 second delay to show the message before redirecting
      } catch (error) {
        console.error('Error saving personal information:', error);
      }
    },
    async fetchStudentData() {
      try {
        // Replace 'studentId' with the correct student ID if needed
        const response = await axios.get(`/student/read/{studentId}`);
        const student = response.data;
        this.firstName = student.firstName;
        this.middleName = student.middleName;
        this.lastName = student.lastName;
        this.dob = student.dob;
        this.gender = student.gender;
        this.email = student.email;
        this.phoneNumber = student.phoneNumber;
      } catch (error) {
        console.error('Error fetching student data:', error);
      }
    },
  },
  created() {
    // Fetch the student data when the component is created
    this.fetchStudentData();
  },
};
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=IBM+Plex+Sans:wght@400;500&display=swap');

* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

body {
  font-family: 'IBM Plex Sans', sans-serif;
}

.personal-info-container {
  padding: 20px;
  display: flex;
  flex-direction: column;
  align-items: center;
}

.navbar {
  display: flex;
  justify-content: space-between;
  align-items: center;
  background-color: #d46a6a;
  padding: 10px 20px;
}

.logo {
  height: 50px;
}

.user-profile {
  height: 40px;
  width: 40px;
  border-radius: 50%;
}

.nav-links {
  display: flex;
  list-style: none;
}

.nav-button {
  background-color: #127670;
  border: none;
  color: white;
  padding: 10px 20px;
  font-size: 16px;
  border-radius: 10px;
  text-decoration: none;
}

.nav-button:hover {
  background-color: #b55555;
}

.form-title {
  font-size: 32px;
  font-weight: 500;
  margin: 20px 0;
  color: #127670;
}

.personal-info-form {
  display: flex;
  flex-direction: column;
  width: 50%;
}

.personal-info-form label {
  font-weight: 500;
  margin: 10px 0 5px;
}

.personal-info-form input,
.personal-info-form select {
  padding: 10px;
  border-radius: 5px;
  border: 1px solid #127670;
  margin-bottom: 15px;
}

.button-container {
  display: flex;
  justify-content: space-between;
}

.btn {
  padding: 10px 20px;
  border-radius: 5px;
  border: none;
  font-size: 16px;
}

.back-btn {
  background-color: #d46a6a;
  color: white;
}

.save-btn {
  background-color: #127670;
  color: white;
}

.success-message {
  color: green;
  font-size: 18px;
  margin-bottom: 15px;
}
</style>
