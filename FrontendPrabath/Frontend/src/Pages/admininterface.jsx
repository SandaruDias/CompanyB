import React, { useState } from 'react';
import './../Styles/admininterface.css';
import ProgressBar from './ProgressBar';

function admininterface() {
  const [workstations, setWorkstations] = useState([
    { id: 1, name: 'Workstation 01', noOfItems: 10, completedItems: 5, remainingItems: 5, errors: 0 },
    { id: 2, name: 'Workstation 02', noOfItems: 10, completedItems: 5, remainingItems: 5, errors: 0 },
    { id: 3, name: 'Workstation 03', noOfItems: 10, completedItems: 5, remainingItems: 5, errors: 0 },
  ]);

  const handleStart = (id) => {
    setWorkstations(
      workstations.map((workstation) =>
        workstation.id === id ? { ...workstation, completedItems: workstation.completedItems + 1 } : workstation
      )
    );
  };

  const handleProcess = (id) => {
    setWorkstations(
      workstations.map((workstation) =>
        workstation.id === id ? { ...workstation, remainingItems: workstation.remainingItems - 1 } : workstation
      )
    );
  };

  return (
    <div className="assembly-line"  > 
      <h1>Company B</h1>
      <h2>Assembly line</h2>
      <label htmlFor="First name">order ID:</label>
      <input type="string" id="First name" name="First name" />
      <button type="Register">Submit</button>
      <br />
      <br />
      <div style={{ position: 'absolute', top: '20px', right: '20px' }}>
        <button style={{ marginRight: '10px' }}>Home Page</button>
        <button>worker details</button>
      </div>

      <table style={{ borderCollapse: 'collapse', border: '1px solid black', justifyContent: 'center' }}>
        <thead>
          <tr>
            <th>workstation 01</th>
            <th>workstation 02</th>
            <th>workstation 03</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td >
            <div className="rectangle-container"> 
                <div className="rectangle-content">
                <div>
                    <h3>Number of Items: {}</h3>
                    <h3>Completed Items: {}</h3>
                    <h3>Remaining Items: {}</h3>
                    <h3>Errors: {}</h3>
                </div>
                </div>
            </div>
            </td>
            <td >
            <div className="rectangle-container"> 
                <div className="rectangle-content"> {/* Wrapper for the rectangle */}
                    <div>
                        <h3>Number of Items: {}</h3>
                        <h3>Completed Items: {}</h3>
                        <h3>Remaining Items: {}</h3>
                        <h3>Errors: {}</h3>
                    </div>
                </div>
            </div>
            </td>
            <td >
            <div className="rectangle-container"> 
                <div className="rectangle-content"> {/* Wrapper for the rectangle */}
                    <div>
                        <h3>Number of Items: {}</h3>
                        <h3>Completed Items: {}</h3>
                        <h3>Remaining Items: {}</h3>
                        <h3>Errors: {}</h3>
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
          <h2>Progress Bar</h2>
          <ProgressBar progress={90} />
        </div>
      </div>
        <div className="input-container"> 
        <div className="app">
          <h2>Progress Bar</h2>
          <ProgressBar progress={80} />
        </div>
      </div>
        <div className="input-container"> 
        <div className="app">
          <h2>Progress Bar</h2>
          <ProgressBar progress={90} />
        </div>
        
        
      </div>
      
        
      </div>
     <br />
     <br />
     <h2 htmlFor="First name">overall progress</h2>
     <ProgressBar progress={90} />
    </div>
    
  );
}

export default admininterface;
