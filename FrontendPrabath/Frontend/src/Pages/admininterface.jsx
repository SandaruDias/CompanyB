import React, { useState } from 'react';
import './../Styles/admininterface.css';

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
    
    <div className="assembly-line">
      <h1>Company B</h1>
      <h2>Assembly line</h2>
        <label htmlFor="First name">order ID:=</label>
        <input type="string" id="First name" name="First name"/>
        <button type="Register">Submit</button>
        <br/> 
        <br />
        <div style={{ position: 'absolute', top: '20px', right: '20px' }}>
          <button style={{ marginRight: '10px' }}>Home Page</button>
          <button>worker details</button>
        </div>
        
      <table  style={{ borderCollapse: 'collapse', border: '1px solid black', justifyContent: 'center' }} >
      <thead>
          <tr>
            <th style={{ border: '1px solid black', padding: '8px' }}>workstation 01</th>
            <th style={{ border: '1px solid black', padding: '8px' }}>workstation 02</th>
            <th style={{ border: '1px solid black', padding: '8px' }}>workstation 03</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td style={{ border: '1px solid black', padding: '8px' }}><label htmlFor="First name">No of items:-</label>
        <input type="string" id="First name" name="First name"/></td>
            <td style={{ border: '1px solid black', padding: '8px' }}><label htmlFor="First name">No of items:-</label>
        <input type="string" id="First name" name="First name"/></td>
            <td style={{ border: '1px solid black', padding: '8px' }}><label htmlFor="First name">No of items:-</label>
        <input type="string" id="First name" name="First name"/></td>
          </tr>
          <tr>
            <td style={{ border: '1px solid black', padding: '8px' }}><label htmlFor="First name">completed items;-</label>
        <input type="string" id="First name" name="First name"/></td>
            <td style={{ border: '1px solid black', padding: '8px' }}><label htmlFor="First name">completed items;-</label>
        <input type="string" id="First name" name="First name"/></td>
            <td style={{ border: '1px solid black', padding: '8px' }}><label htmlFor="First name">completed items;-</label>
        <input type="string" id="First name" name="First name"/></td>
          </tr>
          <tr>
            <td style={{ border: '1px solid black', padding: '8px' }}><label htmlFor="First name">remaining items:-</label>
        <input type="string" id="First name" name="First name"/></td>
            <td style={{ border: '1px solid black', padding: '8px' }}><label htmlFor="First name">remaining items:-</label>
        <input type="string" id="First name" name="First name"/></td>
            <td style={{ border: '1px solid black', padding: '8px' }}><label htmlFor="First name">remaining items:-</label>
        <input type="string" id="First name" name="First name"/></td>
          </tr>
          <tr>
            <td style={{ border: '1px solid black', padding: '8px' }}><label htmlFor="First name">Errors:-</label>
        <input type="string" id="First name" name="First name"/></td>
            <td style={{ border: '1px solid black', padding: '8px' }}><label htmlFor="First name">Errors:-</label>
        <input type="string" id="First name" name="First name"/></td>
            <td style={{ border: '1px solid black', padding: '8px' }}><label htmlFor="First name">Errors:-</label>
        <input type="string" id="First name" name="First name"/></td>
          </tr>
          
        </tbody>
      </table>
      <br />
      <br />
      <label htmlFor="First name">overall progress:=</label>
        <input type="string" id="First name" name="First name"/> 
    </div>

    
  );
}

export default admininterface;