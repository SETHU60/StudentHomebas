module.exports = {
  devServer: {
    port: 3000,
    proxy: {
      '/api': {
        target: 'http://localhost:8080',
        changeOrigin: true,
        pathRewrite: { '^/api': '' }, // Remove /api prefix before forwarding
        logLevel: 'debug', // Optional: log details for debugging
      }
    }
  }
};
