<template>
  <div class="student-list custom-background">
    <h1 class="title">Student List</h1>
    <p v-if="error" class="error">{{ error }}</p>
    <table v-if="students.length" class="student-table">
      <thead>
      <tr>
        <th>Name</th>
        <th>Gender</th>
        <th>Date of Birth</th>
        <th>Email</th>
        <th>Phone</th>
        <th>Academic Institute</th>
        <th>Program of Study</th>
        <th>Details</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="student in students" :key="student.userId">
        <td>{{ student.name ? student.name.firstName + ' ' + student.name.lastName : 'No name available' }}</td>
        <td>{{ student.gender || 'No gender available' }}</td>
        <td>{{ student.dateOfBirth || 'No date available' }}</td>
        <td>{{ student.contact ? student.contact.email : 'No email available' }}</td>
        <td>{{ student.contact ? student.contact.phoneNumber : 'No phone number available' }}</td>
        <td>{{ student.academicDetails ? student.academicDetails.instituteName : 'No institute available' }}</td>
        <td>{{ student.academicDetails ? student.academicDetails.programOfStudy : 'No program available' }}</td>
        <td>
          <router-link :to="'/student/' + student.userId" class="details-link">View Details</router-link>
        </td>
      </tr>
      </tbody>
    </table>
    <p v-else>No students available.</p>
  </div>
</template>

<script>
export default {
  name: 'StudentList',
  data() {
    return {
      students: [],
      error: null
    };
  },
  mounted() {
    this.fetchStudents();
  },
  methods: {
    async fetchStudents() {
      try {
        const response = await fetch("api/StudentHomeBas/student/getall");
        if (!response.ok) {
          throw new Error('Network response was not ok');
        }
        this.students = await response.json();
      } catch (error) {
        this.error = 'Error fetching data';
        console.error('There was a problem with the fetch operation:', error);
      }
    }
  }
}
</script>

<style scoped>
.custom-background {
  background-color: #F9F9F9; /* Light grey background for the container */
  padding: 20px;
  border-radius: 8px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

.title {
  font-size: 24px;
  font-weight: bold;
  margin-bottom: 20px;
}

.error {
  color: red;
  margin-bottom: 20px;
}

.student-table {
  width: 100%;
  border-collapse: collapse;
}

.student-table th, .student-table td {
  padding: 12px;
  text-align: left;
  border: 1px solid #ddd;
}

.student-table th {
  background-color: #127670;
  color: white;
}

.student-table tr:nth-child(even) {
  background-color: #f2f2f2;
}

.details-link {
  color: #127670;
  text-decoration: none;
}

.details-link:hover {
  text-decoration: underline;
}
</style>
