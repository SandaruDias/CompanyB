import React from 'react'
import { Link } from 'react-router-dom'
import './../Styles/Selection.css'

function SelectionPage() {
  return (
    <div className="login-container">
      <div className="login">
        <div className="details">
          <h1 className="login-title">Select your role</h1>
          <Link to={"/adminPortal"} className="button-link">
  <h2><button className='admin-button'>Admin</button></h2>
</Link>
<Link to={"/workerportal"} className="button-link">
  <h2><button className='worker-button'>Worker</button></h2>
</Link>
        </div>  
      </div>
      </div>
  );
  
}

export default SelectionPage
