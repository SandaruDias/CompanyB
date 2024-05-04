import React from "react";
import ReactDOM from "react-dom/client";
import App from "./App.jsx";
import LoginPage from "./Pages/LoginPage";
import StockManag from "./Pages/StockManag.jsx";

import AddItem from "./Pages/AddItem.jsx";
import { BrowserRouter } from "react-router-dom/cjs/react-router-dom.js";

ReactDOM.createRoot(document.getElementById("root")).render(
  <BrowserRouter>
    <React.StrictMode>
      <App />
    </React.StrictMode>
  </BrowserRouter>
);
