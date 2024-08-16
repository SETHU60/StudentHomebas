class PropertyService {
    constructor() {
        this.apiUrl = '/api/StudentHomeBas/Property'; // Base URL for the API, assuming you're using a proxy
    }

    // Helper method to handle fetch requests
    async request(url, options) {
        try {
            const response = await fetch(url, options);
            if (!response.ok) {
                throw new Error(`Network response was not ok: ${response.statusText}`);
            }
            return options.method === 'DELETE' ? response.text() : response.json();
        } catch (error) {
            console.error('Fetch error:', error);
            throw error;
        }
    }

    // Delete a Property by ID
    async deleteProperty(propertyID) {
        const url = `${this.apiUrl}/delete/${propertyID}`;
        await this.request(url, { method: 'DELETE' });
        return propertyID; // Return the book ID so the caller can update state
    }

    // Read a Property by ID
    async readProperty(propertyID) {
        const url = `${this.apiUrl}/read/${propertyID}`;
        return await this.request(url, { method: 'GET' });
    }

    // Saves a new Property
    async saveProperty(comicBook) {
        const url = `${this.apiUrl}/create`;
        return await this.request(url, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(comicBook),
        });
    }

    // Update an existing Property
    async updateProperty(comicBook) {
        const url = `${this.apiUrl}/update`;
        return await this.request(url, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(comicBook),
        });
    }

    // Fetch all comic books
    async fetchAllProperties() {
        const url = `${this.apiUrl}/getAll`;
        return await this.request(url, { method: 'GET' });
    }
}

// Export an instance of the service class for reuse
export default new PropertyService();
