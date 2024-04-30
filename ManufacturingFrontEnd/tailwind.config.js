module.exports = {
  mode: "jit",
  content: ["./src/**/**/*.{js,ts,jsx,tsx,html,mdx}", "./src/**/*.{js,ts,jsx,tsx,html,mdx}"],
  darkMode: "class",
  theme: {
    screens: { md: { max: "1050px" }, sm: { max: "550px" } },
    extend: {
      colors: {
        black: { "900_7f_01": "#0000007f", "900_82": "#02020282", "900_01": "#000000", "900_7f": "#0e0e0e7f" },
        white: { A700: "#ffffff" },
        blue_gray: { 100: "#d9d9d9", "100_33": "#d9d9d933" },
        gray: { "400_70": "#aeaeae70", "400_70_01": "#afafaf70" },
      },
      boxShadow: {},
      fontFamily: { inter: "Inter", bebasneue: "Bebas Neue" },
    },
  },
  plugins: [require("@tailwindcss/forms")],
};
