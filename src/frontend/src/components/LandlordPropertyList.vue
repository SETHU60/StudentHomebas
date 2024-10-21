<template>
    <div class="container">
        <div class="sidebar">
            <div class="logo">
                <img src="@/assets/logo.jpg" alt="StudentSpaceSolutions" class="logo" />
            </div>
            <ul>
                <li v-for="item in sidebarItems" :key="item" :style="{ backgroundColor: activeSidebarItem === item ? '#004d40' : '' }" @click="setActive(item)">
                    {{ item }}
                </li>
            </ul>
        </div>
        <div class="main-content">
            <div class="header">
                <div class="nav-links">
                    <a href="#">Home</a>
                    <a href="#">Student Accommodation</a>
                    <a href="#">Contact Us</a>
                    <a href="#">FAQ</a>
                </div>
                <div class="user-icon"></div>
            </div>
            <h1 class="main-title">My Properties</h1>
            <div class="property-list" v-if="properties.length">
                <div class="property-card" v-for="property in properties" :key="property.propertyID">
                    <div class="property-name">{{ property.propertyName }}</div>
                    <div class="property-details">
                        <p>{{ property.address }}</p>
                        <p>{{ property.numberOfRooms }} Rooms</p>
                        <p>Price: ${{ property.price }}</p>
                    </div>
                    <span class="property-status" :class="getStatusClass(property.status)">
                        {{ property.status || 'No Status Available'}}
                    </span>
                </div>
            </div>
            <div v-else>
                <p>No properties available.</p>
            </div>
        </div>
    </div>
</template>

<script>
import axios from 'axios';

export default {
    data() {
        return {
            activeSidebarItem: null,
            sidebarItems: ['Dashboard', 'Profile', 'FAQ', 'Properties', 'Contact Us'],
            properties: [] // Initially an empty array for the properties
        };
    },
    methods: {
        setActive(item) {
            this.activeSidebarItem = item;
        },
        getStatusClass(status) {
            return {
                'status-pending': status === 'Pending',
                'status-accepted': status === 'Accepted',
                'status-rejected': status === 'Rejected',
            };
        },
        async fetchProperties() {
            try {
                const response = await axios.get('http://localhost:8080/StudentHomeBas/Property/getAll'); // Update with your API endpoint
                this.properties = response.data;
            } catch (error) {
                console.error('Error fetching properties:', error);
            }
        }
    },
    mounted() {
        this.fetchProperties(); // Fetch properties when the component is mounted
    }
};
</script>

<style scoped>
    body, html {
        margin: 0;
        padding: 0;
        font-family: Arial, sans-serif;
        height: 100%;
    }
    .logo {
        color: #00695c;
        font-weight: bold;
        font-size: 1.2em;
        width: 200px;
        height: 80px;
    }
    .container {
        display: flex;
        height: 100%;
    }
    .sidebar {
        width: 200px;
        background-color: #00695c;
        color: white;
        padding: 20px 0;
    }
    .sidebar .logo {
        text-align: center;
        padding-bottom: 20px;
    }
    .sidebar ul {
        list-style-type: none;
        padding: 0;
        margin: 0;
    }
    .sidebar li {
        padding: 10px 20px;
    }
    .sidebar li:hover {
        background-color: #004d40;
        cursor: pointer;
    }
    .main-content {
        flex-grow: 1;
        padding: 20px;
        background-color: #f5f5f5;
    }
    .header {
        background-color: white;
        padding: 10px 20px;
        display: flex;
        justify-content: space-between;
        align-items: center;
        box-shadow: 0 2px 4px rgba(0,0,0,0.1);
    }
    .nav-links a {
        color: #00695c;
        text-decoration: none;
        margin-left: 20px;
    }
    .nav-links {
        display: flex;
        justify-content: flex-start;
        gap: 20px;
        flex-grow: 1;
    }
    .user-icon {
        width: 30px;
        height: 30px;
        background-color: #ccc;
        border-radius: 50%;
    }
    .main-title {
        text-align: left;
        font-size: 2em;
        margin: 20px 0;
    }
    .property-list {
        display: grid;
        grid-template-columns: repeat(auto-fill, minmax(300px, 1fr));
        gap: 20px;
        margin-top: 20px;
    }
    .property-card {
        background-color: white;
        border-radius: 8px;
        box-shadow: 0 2px 4px rgba(0,0,0,0.1);
        padding: 20px;
        display: flex;
        flex-direction: column;
    }
    .property-name {
        font-weight: bold;
        font-size: 1.1em;
        margin-bottom: 10px;
    }
    .property-details {
        margin-bottom: 10px;
    }
    .property-status {
        align-self: flex-end;
        padding: 5px 10px;
        border-radius: 20px;
        font-size: 0.9em;
        font-weight: bold;
    }
    .status-pending {
        background-color: #ffd54f;
        color: #000;
    }
    .status-accepted {
        background-color: #81c784;
        color: #fff;
    }
    .status-rejected {
        background-color: #e57373;
        color: #fff;
    }
</style>
