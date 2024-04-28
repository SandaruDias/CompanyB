import React from "react";
import Routes from "./Routes";
import { BrowserRouter as Router } from "react-router-dom";
import AdminInterfaceOnePage from './src/pages/WorkersInterfaceone/index';
import Routes from './Routes';

function App() {
  return (
    <Router>
      <div>
        <Routes />
      
      </div>
    </Router>
  );
}

export default App;