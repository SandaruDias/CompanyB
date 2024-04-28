import React from "react";
import "./../Styles/StockManag.css";
import { Link } from "react-router-dom";
function StockManag() {
  return (
    <div className="stock-container">
      <div className="header">
        <h1>Stock Managment System.</h1>
        <div className="buttons">
          <Link to="/generatereport">
            <button>Generate Report</button>
          </Link>
          <Link to="/AddItem">
            <button>Add Item</button>
          </Link>
          <Link to="/updatestock">
            <button>Update Stock</button>
          </Link>
        </div>
      </div>
    </div>
  );
}

export default StockManag;
