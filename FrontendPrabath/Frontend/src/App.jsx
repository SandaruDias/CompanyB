import React from "react";
import LoginPage from "./Pages/LoginPage";
import StockManag from "./Pages/StockManag";
import AddItem from "./Pages/AddItem";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import GenerateReport from "./Pages/GenerateReport";
import UpdateStock from "./Pages/UpdateStock";
import SelectionPage from "./Pages/SelectionPage";
import WorkerPortal from "./Pages/WorkerPortal";
import admininterface from "./Pages/admininterface";
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
        <Route path="/companyB/manufacturing/adminPortal" component={LoginPage} />
        <Route path="/companyB/manufacturing/workerPortal" component={WorkerPortal} />
        <Route path="/companyB/manufacturing/StockManag" component={StockManag} />
        <Route path="/companyB/manufacturing/AddItem" component={AddItem} />
        <Route path="/companyB/manufacturing/generatereport" component={GenerateReport} />
        <Route path="/companyB/manufacturing/updatestock" component={UpdateStock} />
        <Route path="/companyB/manufacturing/AdminInterface" component={admininterface}/>
        <Route path="/companyB/manufacturing/WorkStationOne" component={WorkerInterfaceOne} />
        <Route path="/companyB/manufacturing/WorkStationTwo" component={WorkerInterfaceTwo} />
        <Route path="/companyB/manufacturing/WorkStationThree" component={WorkerInterfaceThree} />

      </Switch>
    </Router>
  );
}

export default App;
