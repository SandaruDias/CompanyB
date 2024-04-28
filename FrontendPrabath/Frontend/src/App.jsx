import React from "react";
import LoginPage from "./Pages/LoginPage";
import StockManag from "./Pages/StockManag";
import AddItem from "./Pages/AddItem";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import GenerateReport from "./Pages/GenerateReport";
import UpdateStock from "./Pages/UpdateStock";
import SelectionPage from "./Pages/SelectionPage";
import WorkerPortal from "./Pages/WorkerPortal";

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
      </Switch>
    </Router>
  );
}

export default App;
