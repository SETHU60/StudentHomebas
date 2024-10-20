<template>
  <div class="terms-container">
    <h1>Terms and Conditions for Landlords</h1>
    <p>
      These terms and conditions ("Terms") govern the relationship between landlords offering properties ("Landlords" or "Providers")
      and students seeking accommodation ("Students" or "Tenants") through the Student Accommodation platform ("Platform").
      By accessing or using the Platform, Landlords agree to be bound by these Terms.
    </p>

    <h2>1. Property Listing</h2>
    <p>
      <strong>1.1</strong> Landlords shall provide detailed and accurate information about their properties listed on the Platform,
      including rental rates, amenities, and any additional terms.<br>
      <strong>1.2</strong> Landlords understand that the selection of Tenants is at their sole discretion.
    </p>

    <h2>2. Property Maintenance</h2>
    <p>
      <strong>2.1</strong> Landlords shall ensure that the rented property is maintained in a safe and habitable condition throughout the tenancy.<br>
      <strong>2.2</strong> Landlords shall address any maintenance issues reported by the Tenants in a timely and professional manner.
    </p>

    <h2>3. Termination of Tenancy</h2>
    <p>
      <strong>3.1</strong> Landlords may terminate the tenancy in accordance with the terms specified in the tenancy agreement.<br>
      <strong>3.2</strong> In the event of early termination, Landlords shall provide reasonable notice to the Tenants as per the terms of the tenancy agreement.
    </p>

    <h2>4. Dispute Resolution</h2>
    <p>
      <strong>4.1</strong> Any disputes arising between the Landlord and the Tenant shall be resolved amicably through negotiation and mediation.<br>
      <strong>4.2</strong> If a resolution cannot be reached through negotiation or mediation, the parties may seek legal recourse as per the applicable laws and jurisdiction.
    </p>

    <p>
      By using the Platform, Landlords acknowledge that they have read, understood, and agreed to these Terms and Conditions.
    </p>

    <!-- Back Button -->
    <button @click="goBack">Back</button>
  </div>
</template>
<script>
export default {
  name: 'LandlordTerms',
  methods: {
    goBack() {
      this.$router.push('/signupPage');  // Redirect to the signup page
    }
  }
};
</script>
<style scoped>
.terms-container {
  padding: 20px;
  max-width: 800px;
  margin: 0 auto;
  font-family: Avenir, Helvetica, Arial, sans-serif;
  line-height: 1.6;
  color: #2c3e50;
}

h1 {
  text-align: center;
  color: #009688;
  margin-bottom: 20px;
}

h2 {
  color: #009688;
  margin-top: 20px;
}

p {
  margin-bottom: 15px;
}

strong {
  color: #333;
}

button {
  margin-top: 20px;
  padding: 15px 30px;
  background-color: #009688;
  color: white;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  font-size: 18px;
}
</style>


