<template>
  <img src="logo.png" alt="just a pic" height="90" width="90">

  <p>hellow<br>{{ msg }}</p>
</template>

<script>
export default {
  name: 'HelloWorld',
  data() {
    return {
      msg: 'Loading...'
    };
  },
  mounted() {
    fetch("api/StudentHomeBas/address/getall")
        .then((response) => {
          if (!response.ok) {
            throw new Error('Network response was not ok');
          }
          return response.json(); // Parse the JSON from the response
        })
        .then((data) => {
          this.msg = JSON.stringify(data); // You can format this as needed
        })
        .catch((error) => {
          this.msg = 'Error fetching data';
          console.error('There was a problem with the fetch operation:', error);
        });
  }
};
</script>