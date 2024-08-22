<template>
  <div class="terms-container">
    <h1>Terms and Conditions for Students</h1>
    <p>
      These terms and conditions ("Terms") govern the relationship between students seeking accommodation
      ("Students" or "Tenants") and landlords offering properties ("Landlords" or "Providers") through
      the Student Accommodation platform ("Platform"). By accessing or using the Platform, Students agree
      to be bound by these Terms.
    </p>

    <h2>1. Application Process</h2>
    <p>
      <strong>1.1</strong> Students shall submit accurate and complete applications through the Platform to express interest in renting a property.<br>
      <strong>1.2</strong> Students understand that the selection of Tenants is at the sole discretion of the Landlord.
    </p>

    <h2>2. Rental Payments</h2>
    <p>
      <strong>2.1</strong> Students shall pay rental fees in accordance with the terms specified in the tenancy agreement.<br>
      <strong>2.2</strong> Students shall adhere to the payment schedule provided by the Landlord and make payments on time.
    </p>

    <h2>3. Property Usage</h2>
    <p>
      <strong>3.1</strong> Students shall use the rented property responsibly and shall not engage in any activities that may cause damage or disturbance to the property or neighboring premises.<br>
      <strong>3.2</strong> Students shall comply with all applicable laws, regulations, and rules governing the use of the rented property.
    </p>

    <h2>4. Termination of Tenancy</h2>
    <p>
      <strong>4.1</strong> Students understand that the tenancy may be terminated by either party in accordance with the terms specified in the tenancy agreement.<br>
      <strong>4.2</strong> In the event of early termination, Students shall provide reasonable notice to the Landlord as per the terms of the tenancy agreement.
    </p>

    <h2>5. Dispute Resolution</h2>
    <p>
      <strong>5.1</strong> Any disputes arising between the Student and the Landlord shall be resolved amicably through negotiation and mediation.<br>
      <strong>5.2</strong> If a resolution cannot be reached through negotiation or mediation, the parties may seek legal recourse as per the applicable laws and jurisdiction.
    </p>

    <h2>6. Bursary Fulfillment</h2>
    <p>
      <strong>6.1</strong> In the event that a Student receives a bursary or financial aid package that fully covers the cost of their accommodation, the Student shall be responsible for payment of their accommodation fees as per the terms specified in the tenancy agreement.<br>
      <strong>6.2</strong> The Student shall promptly inform the Landlord if their financial circumstances change, affecting their ability to make rental payments.<br>
      <strong>6.3</strong> Failure to fulfill rental payments despite receiving a full bursary may result in consequences outlined in the tenancy agreement, including but not limited to late fees, termination of the tenancy, or legal action.
    </p>

    <div class="agree-container">
      <input type="checkbox" id="agree" v-model="agreed" />
      <label for="agree">I have read and accept the terms and conditions</label>
    </div>

    <button :disabled="!agreed">Submit</button>
  </div>
</template>

<script>
export default {
  name: 'TermsAndConditions',
  data() {
    return {
      agreed: false
    };
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

.agree-container {
  margin-top: 20px;
  display: flex;
  align-items: center;
}

label {
  margin-left: 10px;
  font-size: 14px;
}

button {
  margin-top: 20px;
  padding: 15px 30px;
  background-color: #009688;
  color: white;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  font-size: 25px;
}

button:disabled {
  background-color: #ccc;
  cursor: not-allowed;
}
</style>
