/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ["./src/**/*.{js,jsx,ts,tsx}"],
  theme: {
    extend: {
      colors: {
        customBg: "#212121",
        customHeaderBg: "#262523",
        customFooterBg: "#262523",
        customInputBg1: "#303034",
        customTypeEdition: "#868080",
      },
    },
  },
  plugins: [],
};
