# Use Node.js as the base image
FROM node:24-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy package files first to leverage Docker's cache
COPY package.json package-lock.json* ./

# Install dependencies
RUN npm install

# Copy the rest of the application code
COPY . .

# Expose the port used by your dev server (usually 5173 for Vite or 3000 for CRA)
EXPOSE 5173

# Run the development command
CMD ["npm", "run", "dev", "--", "--host", "0.0.0.0"]