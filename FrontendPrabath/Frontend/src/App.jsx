import React from "react";
import LoginPage from "./Pages/LoginPage";
import StockManag from "./Pages/StockManag";
import AddItem from "./Pages/AddItem";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import GenerateReport from "./Pages/GenerateReport";
import UpdateStock from "./Pages/UpdateStock";
import SelectionPage from "./Pages/SelectionPage";
import WorkerPortal from "./Pages/WorkerPortal";
import Select from "react-dropdown-select";
import work_station_1 from "./Pages/WorkerInterfaceOne";
import WorkerInterfaceOne from "./Pages/WorkerInterfaceOne";
import WorkerInterfaceTwo from "./Pages/WorkerInterfaceTwo";
import WorkerInterfaceThree from "./Pages/WorkerInterfaceThree";

function App() {
  return (
    <Router>
      <Switch>
      
        <Route path="/" exact component={SelectionPage} />
        <Route path="/adminPortal" component={LoginPage} />
        <Route path="/workerPortal" component={WorkerPortal} />
        <Route path="/StockManag" component={StockManag} />
        <Route path="/AddItem" component={AddItem} />
        <Route path="/generatereport" component={GenerateReport} />
        <Route path="/updatestock" component={UpdateStock} />
        <Route path="/WorkStationOne" component={WorkerInterfaceOne} />
        <Route path="/WorkStationTwo" component={WorkerInterfaceTwo} />
        <Route path="/WorkStationThree" component={WorkerInterfaceThree} />
      </Switch>
    </Router>
  );
}

export default App;
