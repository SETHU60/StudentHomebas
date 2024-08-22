<template>
  <div class="admin-dashboard custom-background">
    <div class="header">
      <h1 class="greeting">Hello, {{ adminName }}!</h1>
      <p class="welcome-message">Welcome back to your admin dashboard. Here’s a quick overview of your key metrics.</p>
    </div>
    <div class="cards-container">
      <router-link to="/students" class="card custom-card">
        <div class="card-content">
          <h3>Students</h3>
          <p>100 added</p>
          <p>50 to be reviewed</p>
        </div>
      </router-link>
      <router-link to="/student/1" class="card custom-card">
        <div class="card-content">
          <h3>Properties</h3>
          <p>50 added</p>
          <p>20 to be reviewed</p>
        </div>
      </router-link>
      <router-link to="/landlords" class="card custom-card">
        <div class="card-content">
          <h3>Landlords</h3>
          <p>25 added</p>
          <p>10 to be reviewed</p>
        </div>
      </router-link>
      <router-link to="/communication" class="card custom-card">
        <div class="card-content">
          <h3>Communication Management</h3>
        </div>
      </router-link>
    </div>
    <div class="charts-container">
      <div class="chart-card">
        <h3>Student Metrics</h3>
        <bar-chart :data="studentData" :options="studentOptions" />
      </div>
      <div class="chart-card">
        <h3>Property Overview</h3>
        <pie-chart :data="propertyData" :options="propertyOptions" />
      </div>
    </div>
  </div>
</template>

<script>
import { Bar, Pie } from 'vue-chartjs';
import { Chart as ChartJS, Title, Tooltip, Legend, BarElement, CategoryScale, LinearScale, ArcElement } from 'chart.js';

ChartJS.register(Title, Tooltip, Legend, BarElement, CategoryScale, LinearScale, ArcElement);

export default {
  name: 'AdminDashboard',
  components: {
    BarChart: Bar,
    PieChart: Pie
  },
  data() {
    return {
      adminName: 'Mbasa',
      studentData: {
        labels: ['Reviewed', 'Pending', 'Total'],
        datasets: [
          {
            label: 'Students',
            backgroundColor: '#127670',
            data: [50, 50, 100]
          }
        ]
      },
      studentOptions: {
        responsive: true,
        plugins: {
          legend: {
            position: 'top'
          },
          tooltip: {
            callbacks: {
              label: function (tooltipItem) {
                return tooltipItem.label + ': ' + tooltipItem.raw;
              }
            }
          }
        }
      },
      propertyData: {
        labels: ['Available', 'Under Review'],
        datasets: [
          {
            label: 'Properties',
            backgroundColor: ['#127670', '#0f5c5b'],
            data: [50, 20]
          }
        ]
      },
      propertyOptions: {
        responsive: true,
        plugins: {
          legend: {
            position: 'top'
          },
          tooltip: {
            callbacks: {
              label: function (tooltipItem) {
                return tooltipItem.label + ': ' + tooltipItem.raw + '%';
              }
            }
          }
        }
      }
    };
  },
  mounted() {
    this.fetchAdminName();
  },
  methods: {
    async fetchAdminName() {
      try {
        const response = await fetch('api/admin/getName');
        if (!response.ok) {
          throw new Error('Network response was not ok');
        }
        const data = await response.json();
        this.adminName = data.name;
      } catch (error) {
        console.error('Error fetching admin name:', error);
      }
    }
  }
}
</script>

<style scoped>
.custom-background {
  background-color: #F4F4F9;
  padding: 40px;
  border-radius: 12px;
  box-shadow: 0 6px 12px rgba(0, 0, 0, 0.15);
}

.header {
  margin-bottom: 30px;
}

.greeting {
  font-size: 28px;
  font-weight: 700;
  color: #127670;
}

.welcome-message {
  font-size: 16px;
  color: #555;
  margin-top: 10px;
}

.cards-container {
  display: grid;
  grid-template-columns: repeat(2, 1fr);
  gap: 1.5rem;
  padding: 1rem;
}

.custom-card {
  background-color: #127670;
  color: white;
  padding: 1.5rem;
  border-radius: 8px;
  text-align: center;
  font-size: 1.125rem;
  text-decoration: none;
  transition: background-color 0.3s, transform 0.3s, box-shadow 0.3s;
  border: 2px solid #127670;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

.custom-card:hover {
  background-color: #0f5c5b;
  transform: scale(1.05);
  box-shadow: 0 6px 12px rgba(0, 0, 0, 0.2);
}

.card-content h3 {
  margin-bottom: 0.5rem;
}

.card-content p {
  margin: 0;
}

.charts-container {
  display: grid;
  grid-template-columns: repeat(2, 1fr);
  gap: 1.5rem;
  margin-top: 30px;
}

.chart-card {
  background-color: #ffffff;
  padding: 1.5rem;
  border-radius: 8px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  text-align: center;
}

.chart-card h3 {
  margin-bottom: 1rem;
}
</style>
