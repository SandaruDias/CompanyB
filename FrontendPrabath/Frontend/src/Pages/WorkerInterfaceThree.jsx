import React, { useState, useEffect } from "react";
import "./../Styles/WorkerInterfaceThree.css";
import ProgressBar from './ProgressBar';

function WorkerInterfaceThree() {
  const [details, setDetails] = useState({ orderid: "", noofitems: "" });
  const [progress] = useState(0);
  const [numberOfItems, setNumberOfItems] = useState(0);
  const [completedItems, setCompletedItems] = useState(0);
  const [remainingItems, setRemainingItems] = useState(0);
  const [errors, setErrors] = useState(0);

  useEffect(() => {
    // Fetch data from the backend
    fetch("backend-url")
      .then((response) => response.json())
      .then((data) => {
        // Update the state with data from the backend
        setNumberOfItems(data.numberOfItems);
        setCompletedItems(data.completedItems);
        setRemainingItems(data.remainingItems);
        setErrors(data.errors);
      })
      .catch((error) => {
        console.error("Error fetching data:", error);
      });
  }, []);

  const handleChange = (event) => {
    setDetails((prev) => ({
      ...prev,
      [event.target.name]: event.target.value,
    }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log(details);
    setDetails({ orderid: "", noofitems: "" });
  };

  return (
    <div className="worker-interface-one">
      <div className="details">
        <h1 className="login-title" style={{ textAlign: 'center' }}>Workstation 01</h1>
      </div>

      <div className="input-container">
        <div className="left-container">
          <input
            type="text"
            placeholder="Order Id"
            name="orderid"
            onChange={handleChange}
            value={details.orderid}
          />
          <button className="login-button" onClick={handleSubmit}>
            Submit
          </button>
        </div>
        
        <div className="right-container">
          <input
            type="text"
            placeholder="Order Id"
            name="orderid" // Corrected the property name
            onChange={handleChange}
            value={details.orderid} // Use the same state for both inputs
          />
          <button className="login-button" onClick={handleSubmit}>
            Add
          </button>
        </div>
      </div>

      <div className="input-container"> 
        <div className="app">
          <h1>Progress Bar</h1>
          <ProgressBar progress={progress} />
        </div>
      </div>
      <div className="vertical-space">  </div>

      <div className="rectangle-container"> {/* Wrapper for the rectangle */}
        <div className="rectangle-content">
          <div>
            <h3>Number of Items: {numberOfItems}</h3>
            <h3>Completed Items: {completedItems}</h3>
            <h3>Remaining Items: {remainingItems}</h3>
            <h3>Errors: {errors}</h3>
          </div>
        </div>
      </div>

      <div className="vertical-space">  </div>
      
      

      <div className="input-container">
        <div className="left-container">
          <input
            type="text"
            placeholder="No of Items"
            name="noofitems"
            onChange={handleChange}
            value={details.noofitems}
          />
          <button className="login-button" onClick={handleSubmit}>
            Pass
          </button>
        </div>
        
        <div className="right-container">
          <input
            type="text"
            placeholder="No of Items"
            name="noofitems" // Corrected the property name
            onChange={handleChange}
            value={details.noofitems} // Use the same state for both inputs
          />
          <button className="login-button" onClick={handleSubmit}>
            Add
          </button>
        </div>
      </div>
    </div>
  );
}

export default WorkerInterfaceThree;
