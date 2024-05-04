import React, { useState, useEffect } from "react";
import "./../Styles/WorkerInterfaceOne.css";
import ProgressBar from './ProgressBar';
import axios from "axios"
import { useHistory } from "react-router-dom";

const apiPlaceOrder = "http://localhost:8090/FetchOrders/";
const apiGetOrderToWorkStation = "http://localhost:8090/OnGoingOrder/GetOrderToWorkStation/";

function WorkerInterfaceTwo() {

  const history = useHistory();

  const [orderId1, setOrderId1] = useState('');
  const [orderId2, setOrderId2] = useState('');
  const [onGoingItems, setOnGoingItems] = useState(0);
  const [completedItems, setCompletedItems] = useState(0);
  const [remainingItems, setRemainingItems] = useState(0);
  const [errors, setErrors] = useState(0);
  const [progress, setProgress] = useState(0);
  const [numberOfItemsAdd, setNumberOfItemsAdd] = useState('');
  const [numberOfItemsPass, setNumberOfItemsPass] = useState('');

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
      fetch(apiPlaceOrder + orderId2)
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
          setErrors(0);
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
  
  const GetOrderToWorkStation = () => {
    try {
      fetch(apiGetOrderToWorkStation + orderId1)
        .then((response) => {
          if (!response.ok) {
            alert('Enter Correct Order Id')
            throw new Error('Network response was not ok');
          }
          return response.json();
        })
        .then((data) => {
          if (!data) {
            throw new Error('No data received from the backend');
          }
          alert("Continue to the Order.");
          setOnGoingItems(data.onGoingStationTwo);
          setCompletedItems(data.onGoingStationThree+data.waitToThree+data.completedNum)
          setRemainingItems(data.waitToTwo);
          setErrors(data.errorTwo);
          setProgress((((data.onGoingStationThree+data.waitToThree+data.completedNum)/data.totalNumber)*100).toFixed(1));

        })
        .catch((error) => {
          console.error("Error fetching data:", error);
        });
    } catch (e) {
      console.log(e);
    }
  };
  
  const handleChange = (event) => {
    if (event.target.name === 'orderid1') {
      setOrderId1(event.target.value);
    } else if (event.target.name === 'orderid2') {
      setOrderId2(event.target.value);
    }
    else if (event.target.name === 'noOfItemsAdd') {
      setNumberOfItemsAdd(event.target.value);
    }
    else if (event.target.name === 'noOFItemsPass') {
      setNumberOfItemsPass(event.target.value);
    }
  };

  
  const handleAddOrder = async () => {
    try{
      const response = await axios.put('http://localhost:8090/OnGoingOrder/WorkstationTwoFetch/'+ orderId1 +'/'+ numberOfItemsAdd)
    }
    catch(error){
        alert("Enter Valid Amount");
    }
    // Handle adding order logic here
    console.log("Add Order");
    GetOrderToWorkStation();
  };

  const handleSubmitPass =async (e) => {
    try{
      const response = await axios.put('http://localhost:8090/OnGoingOrder/WorkstationTwoPass/'+ orderId1 +'/'+ numberOfItemsPass)
    }
    catch(error){
        alert("Enter Valid Amount");
    }
    // Handle adding order logic here
    console.log("Add Order");
    GetOrderToWorkStation();
  };

  const handleSubmit = () =>{
    GetOrderToWorkStation();
  }
  const handleSignOut =async () => {
    try{const response =await axios.put("http://localhost:8090/User/workStation/signout/2")
      history.push("/")
      console.log("Sign Out");
  
  }catch(error){
    console.log(error)
  }
  }
  const handleAddError = async (e) => {
    
    setErrors(errors+1);
    try {
      const response = await axios.put('http://localhost:8090/OnGoingOrder/WorkstationTwoError/' + orderId1 + '/' + (1))
    }
    catch (error) {
      alert("Enter Valid Amount");
    }
    // Handle adding order logic here
  
    GetOrderToWorkStation();
    console.log("Add Error Item",errors+1);
    
  };

  return (
    <div className="worker-interface-one">
          <div className="top-right">
        <button className="login-button" onClick={handleSignOut}>Sign Out</button>
      </div>
      <div className="details">
        <h1 className="login-title" style={{ textAlign: 'center' }}>Workstation 02</h1>
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
            Submit 
          </button>
        </div>
        
        
      </div>

      <div className="input-container"> 
        <div className="app" style={{textAlign: 'center'}}> {/* Centering the progress bar */}
          <h1>Progress Bar</h1>
          <ProgressBar progress={progress} />
        </div>
      </div>
      <div className="vertical-space">  </div>

      <div className="rectangle-container"> {/* Wrapper for the rectangle */}
        <div className="rectangle-content">
          <div>
            <h3>On-Going Items: {onGoingItems}</h3>
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
            name="noOFItemsPass"
            onChange={handleChange}
            value={numberOfItemsPass}
          />
          <button className="login-button" onClick={handleSubmitPass}>
            Pass
          </button>
        </div>
        
        <div className="right-container">
          <input
            type="text"
            placeholder="No of Items"
            name="noOfItemsAdd"
            onChange={handleChange}
            value={numberOfItemsAdd}
          />
          <button className="login-button" onClick={handleAddOrder}>
            Add
          </button>
        </div>
      </div>
      <button className="error-button" onClick={handleAddError}>Add Error Item</button>
    </div>
  );
}

export default WorkerInterfaceTwo;

