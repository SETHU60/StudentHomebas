<template>
  <div class="communication-management custom-background">
    <h1 class="title">Communication Management</h1>

    <div class="metrics-overview">
      <div class="metric-card">
        <h3>Total Messages Sent</h3>
        <p>{{ totalMessagesSent }}</p>
      </div>
      <div class="metric-card">
        <h3>Total Messages Received</h3>
        <p>{{ totalMessagesReceived }}</p>
      </div>
      <div class="metric-card">
        <h3>Pending Messages</h3>
        <p>{{ pendingMessages }}</p>
      </div>
    </div>

    <div class="recent-activity">
      <h2>Recent Communication Activity</h2>
      <ul>
        <li v-for="activity in recentActivities" :key="activity.id">
          <p><strong>{{ activity.date }}</strong> - {{ activity.message }}</p>
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
export default {
  name: 'CommunicationManagement',
  data() {
    return {
      totalMessagesSent: 20,
      totalMessagesReceived: 15,
      pendingMessages: 5,
      recentActivities: [],
      error: null
    };
  },
  mounted() {
    this.fetchCommunicationMetrics();
    this.fetchRecentActivities();
  },
  methods: {
    async fetchCommunicationMetrics() {
      try {
        const response = await fetch("api/Communication/metrics");
        if (!response.ok) {
          throw new Error('Network response was not ok');
        }
        const data = await response.json();
        this.totalMessagesSent = data.totalMessagesSent;
        this.totalMessagesReceived = data.totalMessagesReceived;
        this.pendingMessages = data.pendingMessages;
      } catch (error) {
        this.error = 'Error fetching metrics';
        console.error('There was a problem with the fetch operation:', error);
      }
    },
    async fetchRecentActivities() {
      try {
        const response = await fetch("api/Communication/recent-activities");
        if (!response.ok) {
          throw new Error('Network response was not ok');
        }
        this.recentActivities = await response.json();
      } catch (error) {
        this.error = 'Error fetching recent activities';
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

.metrics-overview {
  display: flex;
  justify-content: space-between;
  gap: 1rem;
  margin-bottom: 20px;
}

.metric-card {
  background-color: #127670;
  color: white;
  padding: 1rem;
  border-radius: 8px;
  text-align: center;
  flex: 1;
}

.metric-card h3 {
  margin-bottom: 0.5rem;
}

.metric-card p {
  font-size: 1.5rem;
}

.recent-activity ul {
  list-style: none;
  padding: 0;
}

.recent-activity li {
  padding: 10px;
  border-bottom: 1px solid #ddd;
}

.recent-activity p {
  margin: 0;
}
</style>
