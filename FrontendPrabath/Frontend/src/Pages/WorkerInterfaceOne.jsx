import React, { useState, useEffect } from "react";
import "./../Styles/WorkerInterfaceOne.css";
import ProgressBar from './ProgressBar';

const apiPlaceOrder = "http://localhost:8090/FetchOrders/";

function WorkerInterfaceOne() {
  const [orderId1, setOrderId1] = useState('');
  const [orderId2, setOrderId2] = useState('');
  const [numberOfItems, setNumberOfItems] = useState(0);
  const [completedItems, setCompletedItems] = useState(0);
  const [remainingItems, setRemainingItems] = useState(0);
  const [errors, setErrors] = useState(0);
  const [progress, setProgress] = useState(0);

  useEffect(() => {
    // Fetch initial data from the backend
    fetchData();
  }, []);

  const fetchData = (orderId) => {
    
    if (!orderId) {
      // alert("Please enter an Order ID before adding.");
      return; // Stop execution if orderId is empty
    }
  
    try {
      fetch(apiPlaceOrder + orderId)
        .then((response) => {
          if (!response.ok) {
            throw new Error('Network response was not ok');
          }
          return response.json();
        })
        .then((data) => {
          if (!data) {
            throw new Error('No data received from the backend');
          }
          alert("Order Added!.");
          setNumberOfItems(data.totalNumber);
          setRemainingItems(data.waitToOne);
          setProgress(0);
          setOrderId2('');
          
        })
        .catch((error) => {
          console.error("Error fetching data:", error);
          alert("Already added!");
        });
    } catch (e) {
      console.log(e);
      alert("Already added!");
    }
    
  };
  
  
  const handleChange = (event) => {
    if (event.target.name === 'orderid1') {
      setOrderId1(event.target.value);
    } else if (event.target.name === 'orderid2') {
      setOrderId2(event.target.value);
    }
  };

  const handleAddOrder = () => {
    // Handle adding order logic here
    console.log("Add Order");
    fetchData(orderId2);
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    // Handle form submission logic here
    console.log("Pass Order");
    fetchData(orderId1);
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
            name="orderid1"
            onChange={handleChange}
            value={orderId1}
          />
          <button className="login-button" onClick={handleSubmit}>
            Submmit 
          </button>
        </div>
        
        <div className="right-container">
          <input
            type="text"
            placeholder="Order Id"
            name="orderid2"
            onChange={handleChange}
            value={orderId2}
          />
          <button className="login-button" onClick={handleAddOrder}>
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
            name="noofitems1"
            onChange={handleChange}
            value={orderId1}
          />
          <button className="login-button" onClick={handleSubmit}>
            Pass
          </button>
        </div>
        
        <div className="right-container">
          <input
            type="text"
            placeholder="No of Items"
            name="noofitems2"
            onChange={handleChange}
            value={orderId2}
          />
          <button className="login-button" onClick={handleAddOrder}>
            Add
          </button>
        </div>
      </div>
    </div>
  );
}

export default WorkerInterfaceOne;
