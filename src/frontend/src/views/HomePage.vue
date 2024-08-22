<template>
  <div class="home">

    <div class="search-section">
      <SearchBar />
    </div>
    <PropertyList />

  </div>
</template>

<script>

import SearchBar from "@/components/SearchBar.vue";
import PropertyList from "@/components/PropertyList.vue";


export default {
  name: "HomePage",
  components: {
    SearchBar,
    PropertyList,

  }
};
</script>

<style scoped>
.home {
  background-color: white;
}

.search-section {
  background:
      linear-gradient(
          rgba(0, 0, 0, 0.5), /* Dark overlay with 50% opacity */
          rgba(0, 0, 0, 0.5)  /* Same color for a uniform overlay */
      ),
      url('@/assets/property1.jpg'); /* Background image */
  background-color: black;
  background-size: cover; /* Ensure the image covers the section */
  background-position: center; /* Center the background image */
  padding: 50px 0;
}
</style>
