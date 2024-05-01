import React, { useState } from 'react';
import './../Styles/admininterface.css';
import ProgressBar from './ProgressBar';
import Pnew from './Pnew';

const apiOrderObject = "http://localhost:8090/OnGoingOrder/GetOrderToWorkStation/";

function AdminInterface() {
  const [onGoingItemsOne, setOnGoingItemsOne] = useState(0);
  const [onGoingItemsTwo, setOnGoingItemsTwo] = useState(0);
  const [onGoingItemsThree, setOnGoingItemsThree] = useState(0);
  const [completedItemsOne, setCompletedItemsOne] = useState(0);
  const [completedItemsTwo, setCompletedItemsTwo] = useState(0);
  const [completedItemsThree, setCompletedItemsThree] = useState(0);
  const [remainingItemsOne, setRemainingItemsOne] = useState(0);
  const [remainingItemsTwo, setRemainingItemsTwo] = useState(0);
  const [remainingItemsThree, setRemainingItemsThree] = useState(0);
  const [errorsOne, setErrorsOne] = useState(0);
  const [errorsTwo, setErrorsTwo] = useState(0);
  const [errorsThree, setErrorsThree] = useState(0);
  const [progressOne, setProgressOne] = useState(0);
  const [progressTwo, setProgressTwo] = useState(0);
  const [progressThree, setProgressThree] = useState(0);
  const [progressFour, setProgressFour] = useState(0); // Added missing state variable

  const handleSubmit = async (event) => {
    event.preventDefault();
    const orderId = event.target.elements.orderId.value;
    try {
      const response = await fetch(`${apiOrderObject}${orderId}`);
      const data = await response.json();
      // Update state variables with fetched data
      setOnGoingItemsOne(data.onGoingStationOne);
      setOnGoingItemsTwo(data.onGoingStationTwo);
      setOnGoingItemsThree(data.onGoingStationThree);

      setCompletedItemsOne(data.waitToThree+data.onGoingStationTwo+data.waitToTwo+data.completedNum);
      setCompletedItemsTwo(data.onGoingStationThree+data.waitToThree);
      setCompletedItemsThree(data.completedNum);

      setErrorsOne(data.errorOne);
      setErrorsTwo(data.errorTwo);
      setErrorsThree(data.errorThree);

      setRemainingItemsOne(data.waitToOne);
      setRemainingItemsTwo(data.waitToTwo);
      setRemainingItemsThree(data.waitToThree);
      // (((data.totalNumber-(data.onGoingStationTwo+data.onGoingStationThree+data.waitToTwo+data.waitToThree))/data.totalNumber)*100

      setProgressOne(((completedItemsOne)/data.totalNumber).toFixed(1)*100);
      setProgressTwo(((completedItemsTwo)/data.totalNumber).toFixed(1)*100);
      setProgressThree(((completedItemsThree)/data.totalNumber).toFixed(1)*100);
      setProgressFour(((progressOne+progressTwo+progressThree)/3).toFixed(1));

      // You can update other state variables as needed
    } catch (error) {
      console.error('Error fetching data:', error);
    }
  };

  return (
    <div className="assembly-line">
      <h1>Company B</h1>
      <h2>Assembly line</h2>
      <form onSubmit={handleSubmit}>
        <label htmlFor="orderId">Order ID:</label>
        <input type="text" id="orderId" name="orderId" />
        <button type="submit">Submit</button>
      </form>
      <br />
      <br />
      <div style={{ position: 'absolute', top: '20px', right: '20px' }}>
        <button style={{ marginRight: '10px' }}>Home Page</button>
        <button style={{ marginRight: '10px' }}>Worker Details</button>
        <button>Sign Out</button>
      </div>

      <table style={{ borderCollapse: 'collapse', border: '1px solid black', justifyContent: 'center' }}>
        <thead>
          <tr>
            <th>Workstation 01</th>
            <th>Workstation 02</th>
            <th>Workstation 03</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>
              <div className="rectangle-container">
                <div className="rectangle-content">
                  <div>
                    <h3>Ongoing Items: {onGoingItemsOne}</h3>
                    <h3>Completed Items: {completedItemsOne}</h3>
                    <h3>Remaining Items: {remainingItemsOne}</h3>
                    <h3>Errors: {errorsOne}</h3>
                  </div>
                </div>
              </div>
            </td>
            <td>
              <div className="rectangle-container">
                <div className="rectangle-content">
                  <div>
                    <h3>Ongoing Items: {onGoingItemsTwo}</h3>
                    <h3>Completed Items: {completedItemsTwo}</h3>
                    <h3>Remaining Items: {remainingItemsTwo}</h3>
                    <h3>Errors: {errorsTwo}</h3>
                  </div>
                </div>
              </div>
            </td>
            <td>
              <div className="rectangle-container">
                <div className="rectangle-content">
                  <div>
                    <h3>Ongoing Items: {onGoingItemsThree}</h3>
                    <h3>Completed Items: {completedItemsThree}</h3>
                    <h3>Remaining Items: {remainingItemsThree}</h3>
                    <h3>Errors: {errorsThree}</h3>
                  </div>
                </div>
              </div>
            </td>
          </tr>
        </tbody>
      </table>

      {/* Progress Bars */}
      <div className="progress-bars-container" style={{ display: 'flex', justifyContent: 'center' }}>
        <div className="input-container">
          <div className="app">
            <h1>Progress Bar</h1>
            <ProgressBar progress={progressOne} />
          </div>
        </div>

        <div className="input-container">
          <div className="app">
            <h1>Progress Bar</h1>
            <ProgressBar progress={progressTwo} />
          </div>
        </div>

        <div className="input-container">
          <div className="app">
            <h1>Progress Bar</h1>
            <ProgressBar progress={progressThree} />
          </div>
        </div>
      </div>

      <br />
      <br />

      {/* Overall Progress */}
      <div className="input-container">
        <div className="app">
          <h1>Overall Progress</h1>
          <ProgressBar progress={progressFour} />
        </div>
      </div>
    </div>
  );
}

export default AdminInterface;
